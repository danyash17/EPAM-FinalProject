package com.epam.web.command;

import com.epam.web.comparator.ApplicationComparator;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.service.*;
import com.epam.web.validator.AuthentificationValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandFactory {
    private final Logger LOGGER = LogManager.getLogger(CommandFactory.class);
    public Command create(String commandType) {
        switch (commandType) {
            case Commands.MAIN_PAGE:
                return new ShowPageCommand(Paths.MAIN);
            case Commands.FACULTY_PAGE:
                return new ShowPageCommand(Paths.FACULTY);
            case Commands.ABOUT_PAGE:
                return new ShowPageCommand(Paths.ABOUT);
            case Commands.ACCOUNT_PAGE:
                return new ShowPageCommand(Paths.ACCOUNT);
            case Commands.ERROR_PAGE:
                return new ShowPageCommand(Paths.ERROR);
            case Commands.LOAD_ACCOUNT:
                return new LoadAccountDataCommand(new ApplicationService(new DaoHelperFactory()), new ApplicationComparator(), new SpecializationService(new DaoHelperFactory()));
            case Commands.LOAD_ADMIN_ACCOUNT:
                return new LoadFacultiesCommand(new FacultyService(new DaoHelperFactory()), new ImageService(new DaoHelperFactory()), "accountData");
            case Commands.REPORT_PAGE:
                return new ShowPageCommand(Paths.REPORT);
            case Commands.LOGIN_PAGE:
                return new ShowPageCommand(Paths.INDEX);
            case Commands.SPECIALIZATION_REGISTER:
                return new UpdateSpecializationCommand(new ApplicationService(new DaoHelperFactory()), new ReportService(), new SpecializationService(new DaoHelperFactory()));
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
            default: {
                LOGGER.warn("Unknown command type " + commandType);
                throw new IllegalArgumentException("Unknown command type " + commandType);
            }
        }
    }
}
