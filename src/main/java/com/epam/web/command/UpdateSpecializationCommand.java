package com.epam.web.command;

import com.epam.web.service.QueryService;
import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateSpecializationCommand implements Command {
    private final QueryService queryService;
    private final Integer specializationId;
    private final String specialization;
    public UpdateSpecializationCommand(QueryService service, Integer specializationId,String specialization) {
        this.queryService = service;
        this.specializationId = specializationId;
        this.specialization=specialization;
    }
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, Exception {
        Integer id= (Integer) request.getSession().getAttribute("id");
        queryService.updateSpecialization(id, specializationId);
        request.setAttribute("successMessage", "Updated:");
        request.setAttribute("newSpecialization", specialization);
        return CommandResult.forward("/controller?command=accountData");
    }
}
