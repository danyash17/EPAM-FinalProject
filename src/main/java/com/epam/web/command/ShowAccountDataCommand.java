package com.epam.web.command;

import com.epam.web.entity.Application;
import com.epam.web.entity.Specialization;
import com.epam.web.entity.UserRole;
import com.epam.web.service.ApplicationService;
import com.epam.web.service.ServiceException;
import com.epam.web.service.SpecializationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class ShowAccountDataCommand implements Command {
    private final ApplicationService applicationService;
    private final SpecializationService specializationService;

    public ShowAccountDataCommand(ApplicationService service, SpecializationService specializationService) {
        this.applicationService = service;
        this.specializationService = specializationService;
    }
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, Exception {
        Integer id= (Integer) request.getSession().getAttribute("id");
        UserRole role= (UserRole) request.getSession().getAttribute("role");
        Optional<Application> application = applicationService.getApplication(id);
        Optional<Specialization> specialization=Optional.empty();
        if (application.isPresent()){
            specialization=specializationService.getSpecialization(application.get().getSpecializationId());
        }
        if (specialization.isPresent()) {
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
            return CommandResult.forward("/controller?command=accountPage");
        }
        if(role.name().toUpperCase().equals("ADMIN")) {
            return CommandResult.forward("/controller?command=accountPage");
        }
        else {
            request.getSession().setAttribute("errorMessage", "Ooos...Something went wrong,please try again");
            return CommandResult.redirect("/controller?command=errorPage");
        }
    }
}
