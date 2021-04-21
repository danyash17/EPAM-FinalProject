package com.epam.web.command;

import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.service.QueryService;
import com.epam.web.service.ReportService;
import com.epam.web.service.SpecializationService;
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
            case "accountPage":
                return new ShowPageCommand("/view/account.jsp");
            case "errorPage":
                return new ShowPageCommand("/view/error.jsp");
            case "accountData":
                return new ShowAccountDataCommand(new QueryService(new DaoHelperFactory()));
            case "reportPage":
                return new ShowPageCommand("/view/report.jsp");
            case "loginPage":
                return new ShowPageCommand("/index.jsp");
            case "registerJava":
                return new UpdateSpecializationCommand(new QueryService(new DaoHelperFactory()),1,"Java");
            case "registerC":
                return new UpdateSpecializationCommand(new QueryService(new DaoHelperFactory()),2,"C++");
            case "registerPython":
                return new UpdateSpecializationCommand(new QueryService(new DaoHelperFactory()),3,"Python");
            case "registerAllure":
                return new UpdateSpecializationCommand(new QueryService(new DaoHelperFactory()),4,"Allure");
            case "registerJUnit":
                return new UpdateSpecializationCommand(new QueryService(new DaoHelperFactory()),5,"JUnit");
            case "registerSelenium":
                return new UpdateSpecializationCommand(new QueryService(new DaoHelperFactory()),6,"Selenium");
            case "registerSEO":
                return new UpdateSpecializationCommand(new QueryService(new DaoHelperFactory()),7,"SEO");
            case "registerAdv":
                return new UpdateSpecializationCommand(new QueryService(new DaoHelperFactory()),8,"Adversiting");
            case "registerSoft":
                return new UpdateSpecializationCommand(new QueryService(new DaoHelperFactory()),9,"Soft skills");
            case "reportJava":
                return new FormSpecializationReportCommand(new ReportService(),new QueryService(new DaoHelperFactory()),new SpecializationService(new DaoHelperFactory()),1);
            case "reportC":
                return new FormSpecializationReportCommand(new ReportService(),new QueryService(new DaoHelperFactory()),new SpecializationService(new DaoHelperFactory()),2);
            case "reportPython":
                return new FormSpecializationReportCommand(new ReportService(),new QueryService(new DaoHelperFactory()),new SpecializationService(new DaoHelperFactory()),3);
            case "reportAllure":
                return new FormSpecializationReportCommand(new ReportService(),new QueryService(new DaoHelperFactory()),new SpecializationService(new DaoHelperFactory()),4);
            case "reportJUnit":
                return new FormSpecializationReportCommand(new ReportService(),new QueryService(new DaoHelperFactory()),new SpecializationService(new DaoHelperFactory()),5);
            case "reportSelenium":
                return new FormSpecializationReportCommand(new ReportService(),new QueryService(new DaoHelperFactory()),new SpecializationService(new DaoHelperFactory()),6);
            case "reportSEO":
                return new FormSpecializationReportCommand(new ReportService(),new QueryService(new DaoHelperFactory()),new SpecializationService(new DaoHelperFactory()),7);
            case "reportAdv":
                return new FormSpecializationReportCommand(new ReportService(),new QueryService(new DaoHelperFactory()),new SpecializationService(new DaoHelperFactory()),8);
            case "reportSoft":
                return new FormSpecializationReportCommand(new ReportService(),new QueryService(new DaoHelperFactory()),new SpecializationService(new DaoHelperFactory()),9);
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
