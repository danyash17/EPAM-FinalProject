package com.epam.web.command;

import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.service.UserService;

public class CommandFactory {
    public Command create(String commandType) {
        switch (commandType) {
            case "mainPage":
                return new ShowPageCommand("/view/main.jsp");
            case "devPage":
                return new ShowPageCommand("/view/dev.jsp");
            case "qaPage":
                return new ShowPageCommand("/view/qa.jsp");
            case "smmPage":
                return new ShowPageCommand("/view/smm.jsp");
            case "aboutPage":
                return new ShowPageCommand("/view/about.jsp");
            case "loginPage":
                return new ShowPageCommand("/index.jsp");
            case "login":
                return new LoginCommand(new UserService(new DaoHelperFactory()));
            case "logout":
                return new LogoutCommand();
            default:
                throw new IllegalArgumentException("Unknown command type " + commandType);
        }
    }
}
