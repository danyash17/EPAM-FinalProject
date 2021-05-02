package com.epam.web.command;

import com.epam.web.service.ApplicationService;
import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateSpecializationCommand implements Command {
    private final ApplicationService applicationService;
    public UpdateSpecializationCommand(ApplicationService service) {
        this.applicationService = service;
    }
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, Exception {
        Integer id= (Integer) request.getSession().getAttribute("id");
        Integer specializationId= Integer.parseInt(request.getParameter("registrationId"));
            applicationService.updateSpecialization(id, specializationId);
            return CommandResult.forward("/controller?command=accountData");
    }
}
