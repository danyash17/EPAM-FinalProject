package com.epam.web.command;

import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {
    public static final String LOGIN_PAGE = "?command=loginPage";
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, Exception {
        request.getSession().invalidate();
        return CommandResult.redirect(request.getRequestURI() + LOGIN_PAGE);
    }
}
