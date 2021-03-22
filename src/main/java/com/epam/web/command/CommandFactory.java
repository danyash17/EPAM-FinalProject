package com.epam.web.command;

import com.epam.web.service.UserService;

public class CommandFactory {
    public Command create(String commandType) {
        switch (commandType) {
            case "mainPage":
                return new ShowPageCommand("/WEB-INF/main.jsp");
            case "login":
                return new LoginCommand(new UserService());
            case "error-login":
                return new ShowPageCommand("/WEB-INF/error-login.jsp");
            default:
                throw new IllegalArgumentException("Unknown command type " + commandType);
        }
    }
}
