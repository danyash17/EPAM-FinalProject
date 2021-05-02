package com.epam.web.command;

import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.service.*;

public class CommandFactory {
    public Command create(String commandType) {
        switch (commandType) {
            case "mainPage":
                return new ShowPageCommand("/view/main.jsp");
            case "facultyPage":
                return new ShowPageCommand("/view/faculty.jsp");
            case "aboutPage":
                return new ShowPageCommand("/view/about.jsp");
            case "accountPage":
                return new ShowPageCommand("/view/account.jsp");
            case "errorPage":
                return new ShowPageCommand("/view/error.jsp");
            case "accountData":
                return new ShowAccountDataCommand(new ApplicationService(new DaoHelperFactory()), new SpecializationService(new DaoHelperFactory()));
            case "reportPage":
                return new ShowPageCommand("/view/report.jsp");
            case "loginPage":
                return new ShowPageCommand("/index.jsp");
            case "register":
                return new UpdateSpecializationCommand(new ApplicationService(new DaoHelperFactory()));
            case "loadMain":
                return new LoadFacultiesCommand(new FacultyService(new DaoHelperFactory()), new ImageService(new DaoHelperFactory()));
            case "loadFaculty":
                return new LoadSpecializationsCommand(new FacultyService(new DaoHelperFactory()), new SpecializationService(new DaoHelperFactory()), new ImageService(new DaoHelperFactory()));
            case "report":
                return new FormSpecializationReportCommand(new ReportService(),new ApplicationService(new DaoHelperFactory()),new SpecializationService(new DaoHelperFactory()));
            case "login":
                return new LoginCommand(new UserService(new DaoHelperFactory()));
            case "logout":
                return new LogoutCommand();
            case "localization":
                return new ChangeLocalizationCommand();
            default:
                throw new IllegalArgumentException("Unknown command type " + commandType);
        }
    }
}
