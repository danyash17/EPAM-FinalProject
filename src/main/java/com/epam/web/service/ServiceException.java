package com.epam.web.service;

import com.epam.web.dao.DaoException;

public class ServiceException extends Throwable {
    public ServiceException(DaoException e, String message) {
    }
}
