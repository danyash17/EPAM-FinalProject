package com.epam.web.command;

import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.service.UserService;

public class CommandFactory {
    public Command create(String commandType) {
        switch (commandType) {
            case "mainPage":
                return new ShowPageCommand("/view/main.jsp");
            case "login":
                return new LoginCommand(new UserService(new DaoHelperFactory()));
            case "error-login":
                return new ShowPageCommand("/index.jsp");
            default:
                throw new IllegalArgumentException("Unknown command type " + commandType);
        }
    }
}
