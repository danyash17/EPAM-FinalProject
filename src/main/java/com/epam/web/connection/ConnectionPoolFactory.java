package com.epam.web.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPoolFactory {

    private void initConnections(ConnectionPool pool, String databaseURL, String databaseUsername, String databasePassword) throws SQLException {

        List<Connection> connections = new ArrayList<>();
        int connectionPoolSize = pool.getSize();
        for (int i = 0; i < connectionPoolSize; i++) {
            Connection connection = DriverManager.getConnection(
                    databaseURL, databaseUsername, databasePassword);
            connections.add(connection);
        }
        pool.addConnections(connections);
    }

    public ConnectionPool create(String databaseURL, String databaseUsername, String databasePassword, int connectionPoolSize) {
        try {
            ConnectionPool connectionPool = new ConnectionPool(connectionPoolSize);
            initConnections(connectionPool, databaseURL, databaseUsername, databasePassword);

            return connectionPool;

        } catch (SQLException e) {
            throw new ConnectionPoolException("Cannot create pool", e);
        }
    }
}
