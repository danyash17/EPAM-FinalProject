package com.epam.web.command;

import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeLocalizationCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, Exception {
        String language=request.getParameter("sessionLocale");
        request.getSession().setAttribute("lang",language);
        return CommandResult.redirect("/controller?command=mainPage");
    }
}
