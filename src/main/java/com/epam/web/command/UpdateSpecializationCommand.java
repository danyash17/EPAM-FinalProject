package com.epam.web.command;

import com.epam.web.comparator.ApplicationComparator;
import com.epam.web.dto.ReportDto;
import com.epam.web.entity.Application;
import com.epam.web.entity.Specialization;
import com.epam.web.service.ApplicationService;
import com.epam.web.service.ReportService;
import com.epam.web.service.ServiceException;
import com.epam.web.service.SpecializationService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

public class UpdateSpecializationCommand implements Command {
    private final Logger LOGGER = LogManager.getLogger(UpdateSpecializationCommand.class);
    private final ApplicationService applicationService;
    private final ReportService reportService;
    private final SpecializationService specializationService;

    public UpdateSpecializationCommand(ApplicationService service, ReportService reportService, SpecializationService specializationService) {
        this.applicationService = service;
        this.reportService = reportService;
        this.specializationService = specializationService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Integer previousSpecializationId = (Integer) request.getSession().getAttribute("specialization_id");
        Integer newSpecializationId = Integer.parseInt(request.getParameter("registrationId"));
        Integer id = (Integer) request.getSession().getAttribute("id");
        applicationService.updateSpecialization(id, newSpecializationId);
        Optional<Specialization> newSpecialization = specializationService.getSpecialization(newSpecializationId);
        Optional<Specialization> previousSpecialization = specializationService.getSpecialization(previousSpecializationId);
        Integer planForNewSpecialization;
        Integer planForPreviousSpecialization;
        if (newSpecialization.isPresent() && previousSpecialization.isPresent()) {
            planForNewSpecialization = newSpecialization.get().getPlan();
            planForPreviousSpecialization = previousSpecialization.get().getPlan();
        } else {
            LOGGER.warn("Specialization is not found in DB");
            request.setAttribute("errorMessage", "There is no data about specialization in database");
            return CommandResult.redirect("/controller?command=errorPage");
        }
        update(previousSpecializationId, planForPreviousSpecialization);
        update(newSpecializationId, planForNewSpecialization);
        LOGGER.info("User " + request.getSession().getAttribute("name") +" "+ request.getSession().getAttribute("surname") +
                " changed specialization from " + previousSpecialization.get().getSpecialization() + " to "
                + newSpecialization.get().getSpecialization());
        return CommandResult.forward("/controller?command=accountData");
    }

    private void update(Integer specializationId, Integer plan) throws ServiceException {
        List<Application> fullList = applicationService.getFullSpecifiedApplicationList(specializationId);
        Optional<ReportDto> fullAppliedEnrolees = reportService.doCompetition(fullList, plan, 0, fullList.size(), new ApplicationComparator());
        fullAppliedEnrolees.get().getApplicationMap().forEach((key, value) -> {
            try {
                applicationService.updateStatus(key.getId(), value);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
    }
}
