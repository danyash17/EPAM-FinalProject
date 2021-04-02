package com.epam.web.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPoolFactory {

    private static final String PROPERTIES_FILENAME = "database.properties";

    private String databaseURL;
    private String databaseUsername;
    private String databasePassword;
    private int connectionPoolSize;

    ConnectionPoolFactory() {
    }

    ConnectionPool create() {
        try {
            init();
            ConnectionPool connectionPool = new ConnectionPool(connectionPoolSize);
            initConnections(connectionPool);

            return connectionPool;

        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new ConnectionPoolException("Cannot create pool", e);
        }
    }

    private void init() throws IOException, ClassNotFoundException {

        Properties properties = new PropertiesLoader().loadProperties(PROPERTIES_FILENAME);

        String databaseDriver = properties.getProperty("database.driver");
        Class.forName(databaseDriver);

        databaseURL = properties.getProperty("database.url");
        databaseUsername = properties.getProperty("database.username");
        databasePassword = properties.getProperty("database.password");

        connectionPoolSize = Integer.parseInt(properties.getProperty("database.connection.pool_size"));
    }

    void initConnections(ConnectionPool pool) throws SQLException {

        List<ProxyConnection> connections = new ArrayList<>();

        for (int i = 0; i < connectionPoolSize; i++) {
            Connection connection = DriverManager.getConnection(
                    databaseURL, databaseUsername, databasePassword);

            ProxyConnection proxyConnection = new ProxyConnection(connection, pool);
            connections.add(proxyConnection);
        }
        pool.initializeConnections(connections);
    }

    public int getConnectionPoolSize() {
        return connectionPoolSize;
    }
}
