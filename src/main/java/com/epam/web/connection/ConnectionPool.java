package com.epam.web.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final AtomicReference<ConnectionPool> INSTANCE = new AtomicReference<>();

    private static final Lock INSTANCE_LOCK = new ReentrantLock();

    private final Queue<Connection> availableConnections = new ArrayDeque<>();
    private final Set<Connection> activeConnections = new HashSet<>();

    private final Lock LOCK = new ReentrantLock();
    private final Semaphore connectionsSemaphore;

    private static final String PROPERTIES_FILENAME = "database.properties";

    private static String databaseURL;
    private static String databaseUsername;
    private static String databasePassword;
    private static int connectionPoolSize;

    public static ConnectionPool getInstance() {

        if (INSTANCE.get() == null) {

            try {
                INSTANCE_LOCK.lock();
                if (INSTANCE.get() == null) {
                    ConnectionPool pool = create();
                    INSTANCE.getAndSet(pool);
                }

            } finally {
                INSTANCE_LOCK.unlock();
            }
        }

        return INSTANCE.get();
    }

    private static ConnectionPool create() {
        try {
            init();
            ConnectionPool connectionPool = new ConnectionPool(connectionPoolSize);
            initConnections(connectionPool);

            return connectionPool;

        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new ConnectionPoolException("Cannot create pool", e);
        }
    }

    private static void init() throws IOException, ClassNotFoundException {

        Properties properties = new PropertiesLoader().loadProperties(PROPERTIES_FILENAME);

        String databaseDriver = properties.getProperty("database.driver");
        Class.forName(databaseDriver);

        databaseURL = properties.getProperty("database.url");
        databaseUsername = properties.getProperty("database.username");
        databasePassword = properties.getProperty("database.password");

        connectionPoolSize = Integer.parseInt(properties.getProperty("database.connection.pool_size"));
    }

    private static void initConnections(ConnectionPool pool) throws SQLException {

        List<Connection> connections = new ArrayList<>();

        for (int i = 0; i < connectionPoolSize; i++) {
            Connection connection = DriverManager.getConnection(
                    databaseURL, databaseUsername, databasePassword);
            connections.add(connection);
        }
        pool.initializeConnections(connections);
    }

    public int getConnectionPoolSize() {
        return connectionPoolSize;
    }

    private ConnectionPool(int poolSize) {
        connectionsSemaphore = new Semaphore(poolSize);
    }

    private void initializeConnections(List<Connection> connections) {
        availableConnections.addAll(connections);
    }

    public ProxyConnection getConnection() {

        try {
            connectionsSemaphore.acquire();
            LOCK.lock();
            Connection connection=availableConnections.poll();
            ProxyConnection proxyConnection = new ProxyConnection(connection,this);
            activeConnections.add(proxyConnection);

            return proxyConnection;

        } catch (InterruptedException e) {
            throw new ConnectionPoolException(e);

        } finally {
            LOCK.unlock();
        }
    }

    public void returnConnection(ProxyConnection connection) {

        try {
            LOCK.lock();

            if (activeConnections.contains(connection)) {
                activeConnections.remove(connection);
                availableConnections.add(connection);
                connectionsSemaphore.release();
            }
        } finally {
            LOCK.unlock();
        }
    }
}
