package com.epam.web.dao;

import java.sql.SQLException;

public class DaoException extends Exception {

    public DaoException(SQLException e, String message) {
    }
    public DaoException(String message) {
    }
}
