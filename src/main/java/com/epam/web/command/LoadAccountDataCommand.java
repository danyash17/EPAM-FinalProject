package com.epam.web.command;

import com.epam.web.comparator.ApplicationComparator;
import com.epam.web.entity.Application;
import com.epam.web.entity.Specialization;
import com.epam.web.entity.UserRole;
import com.epam.web.service.ApplicationService;
import com.epam.web.service.ServiceException;
import com.epam.web.service.SpecializationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LoadAccountDataCommand implements Command {
    private final Logger LOGGER = LogManager.getLogger(LoadAccountDataCommand.class);
    private final ApplicationService applicationService;
    private final ApplicationComparator comparator;
    private final SpecializationService specializationService;
    private final String loadAtPage;

    public LoadAccountDataCommand(ApplicationService service, ApplicationComparator comparator, SpecializationService specializationService, String loadAtPage) {
        this.applicationService = service;
        this.comparator = comparator;
        this.specializationService = specializationService;
        this.loadAtPage = loadAtPage;
    }
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Integer id= (Integer) request.getSession().getAttribute("id");
        UserRole role= (UserRole) request.getSession().getAttribute("role");
        Optional<Application> application = applicationService.getApplication(id);
        Optional<Specialization> specialization=Optional.empty();
        if (application.isPresent()){
            specialization=specializationService.getSpecialization(application.get().getSpecializationId());
        }
        if(role.name().toUpperCase().equals("ADMIN")) {
            return CommandResult.forward("/controller?command=accountPage");
        }
        if (specialization.isPresent()) {
            List<Application> competitionParticipants=applicationService.getFullSpecifiedApplicationList(specialization.get().getId());
            Collections.sort(competitionParticipants,comparator);
            Collections.reverse(competitionParticipants);
            Application presentApplication = application.get();
            Specialization presentSpecialization=specialization.get();
            request.getSession().setAttribute("country", presentApplication.getCountry());
            request.getSession().setAttribute("city", presentApplication.getCity());
            request.getSession().setAttribute("medal", presentApplication.getMedal());
            request.getSession().setAttribute("specialization_id", presentApplication.getSpecializationId());
            request.getSession().setAttribute("specialization", presentSpecialization.getSpecialization());
            request.getSession().setAttribute("first_exam", presentApplication.getFirstExam());
            request.getSession().setAttribute("second_exam", presentApplication.getSecondExam());
            request.getSession().setAttribute("third_exam", presentApplication.getThirdExam());
            request.getSession().setAttribute("grade", presentApplication.getGrade());
            request.getSession().setAttribute("listPosition",competitionParticipants.indexOf(presentApplication));
            request.getSession().setAttribute("competitionParticipants",competitionParticipants.size());
            request.getSession().setAttribute("specializationPlan",specialization.get().getPlan());
            return CommandResult.forward("/controller?command="+loadAtPage);
        }
        else {
            LOGGER.warn("Account data error");
            request.getSession().setAttribute("errorMessage", "Account data error");
            return CommandResult.redirect("/controller?command=errorPage");
        }
    }
}
