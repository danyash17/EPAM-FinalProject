package com.epam.web.command;

import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, Exception;
}
