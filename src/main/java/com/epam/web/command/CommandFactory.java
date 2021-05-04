package com.epam.web.command;

import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.service.*;
import com.epam.web.validator.AuthentificationValidator;

public class CommandFactory {
    public Command create(String commandType) {
        switch (commandType) {
            case Commands.MAIN_PAGE:
                return new ShowPageCommand("/view/main.jsp");
            case Commands.FACULTY_PAGE:
                return new ShowPageCommand("/view/faculty.jsp");
            case Commands.ABOUT_PAGE:
                return new ShowPageCommand("/view/about.jsp");
            case Commands.ACCOUNT_PAGE:
                return new ShowPageCommand("/view/account.jsp");
            case Commands.ERROR_PAGE:
                return new ShowPageCommand("/view/error.jsp");
            case Commands.LOAD_ACCOUNT:
                return new ShowAccountDataCommand(new ApplicationService(new DaoHelperFactory()), new SpecializationService(new DaoHelperFactory()));
            case Commands.LOAD_ADMIN_ACCOUNT:
                return new LoadFacultiesCommand(new FacultyService(new DaoHelperFactory()), new ImageService(new DaoHelperFactory()), "accountData");
            case Commands.REPORT_PAGE:
                return new ShowPageCommand("/view/report.jsp");
            case Commands.LOGIN_PAGE:
                return new ShowPageCommand("/index.jsp");
            case Commands.SPECIALIZATION_REGISTER:
                return new UpdateSpecializationCommand(new ApplicationService(new DaoHelperFactory()));
            case Commands.LOAD_MAIN:
                return new LoadFacultiesCommand(new FacultyService(new DaoHelperFactory()), new ImageService(new DaoHelperFactory()), "mainPage");
            case Commands.LOAD_FACULTY:
                return new LoadSpecializationsCommand(new FacultyService(new DaoHelperFactory()), new SpecializationService(new DaoHelperFactory()), new ImageService(new DaoHelperFactory()));
            case Commands.LOAD_REPORT:
                return new FormSpecializationReportCommand(new ReportService(),new ApplicationService(new DaoHelperFactory()),new SpecializationService(new DaoHelperFactory()));
            case Commands.LOGIN:
                return new LoginCommand(new UserService(new DaoHelperFactory()), new AuthentificationValidator());
            case Commands.LOGOUT:
                return new LogoutCommand();
            case Commands.CHANGE_LOCALIZATION:
                return new ChangeLocalizationCommand();
            default:
                throw new IllegalArgumentException("Unknown command type " + commandType);
        }
    }
}
