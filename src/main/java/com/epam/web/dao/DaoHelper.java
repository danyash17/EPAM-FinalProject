package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {
    private final ProxyConnection connection;

    public DaoHelper(ProxyConnection connection) {
        this.connection = connection;
    }

    @Override
    public void close() throws Exception {
        connection.setAutoCommit(true);
        connection.close();
    }
    public UserDaoImplement createUserDao() {
        return new UserDaoImplement(connection);
    }
    public void beginTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }

    public void endTransaction() throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }
}
