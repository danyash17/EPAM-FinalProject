package com.epam.web.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final AtomicReference<ConnectionPool> INSTANCE = new AtomicReference<>();

    private static final Lock INSTANCE_LOCK = new ReentrantLock();
    private static final ConnectionPoolFactory FACTORY = new ConnectionPoolFactory();

    private final Queue<Connection> AVAILABLE_CONNECTIONS = new ArrayDeque<>();
    private final Set<Connection> ACTIVE_CONNECTIONS = new HashSet<>();

    private final Lock LOCK = new ReentrantLock();
    private final Semaphore SEMAPHORE;

    private static final String PROPERTIES_FILENAME = "database.properties";

    private static int size;

    public static ConnectionPool getInstance() {

        if (INSTANCE.get() == null) {

            try {
                INSTANCE_LOCK.lock();
                if (INSTANCE.get() == null) {
                    ConnectionPool pool = null;
                    pool = init();
                    INSTANCE.getAndSet(pool);
                }

            } finally {
                INSTANCE_LOCK.unlock();
            }
        }

        return INSTANCE.get();
    }

    private static ConnectionPool init() {
        Properties properties = new Properties();
        try (InputStream inputStream = ConnectionPool.class.getClassLoader().getResourceAsStream(PROPERTIES_FILENAME)) {

            if (inputStream == null) {
                throw new IOException("No file found");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new ConnectionPoolException("Cannot get properties for database", e);
        }
        String databaseDriver = properties.getProperty("database.driver");
        try {
            Class.forName(databaseDriver);
        } catch (ClassNotFoundException e) {
            throw new ConnectionPoolException("Driver not found", e);
        }
        String databaseURL = properties.getProperty("database.url");
        String databaseUsername = properties.getProperty("database.username");
        String databasePassword = properties.getProperty("database.password");
        size = Integer.parseInt(properties.getProperty("database.connection.pool_size"));
        return FACTORY.create(databaseURL, databaseUsername, databasePassword, size);
    }

    ConnectionPool(int poolSize) {
        SEMAPHORE = new Semaphore(poolSize);
    }

    void addConnections(List<Connection> connections) {
        AVAILABLE_CONNECTIONS.addAll(connections);
    }

    public int getSize() {
        return size;
    }

    public ProxyConnection getConnection() {

        try {
            SEMAPHORE.acquire();
            LOCK.lock();
            Connection connection = AVAILABLE_CONNECTIONS.poll();
            ProxyConnection proxyConnection = new ProxyConnection(connection, this);
            ACTIVE_CONNECTIONS.add(proxyConnection);

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

            if (ACTIVE_CONNECTIONS.contains(connection)) {
                ACTIVE_CONNECTIONS.remove(connection);
                AVAILABLE_CONNECTIONS.add(connection);
                SEMAPHORE.release();
            }
        } finally {
            LOCK.unlock();
        }
    }
}
