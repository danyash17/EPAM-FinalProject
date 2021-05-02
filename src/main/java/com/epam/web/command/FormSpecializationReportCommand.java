package com.epam.web.command;

import com.epam.web.entity.Application;
import com.epam.web.dto.ReportDto;
import com.epam.web.entity.Specialization;
import com.epam.web.service.ApplicationService;
import com.epam.web.service.ReportService;
import com.epam.web.service.ServiceException;
import com.epam.web.service.SpecializationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

public class FormSpecializationReportCommand implements Command {
    private final ReportService reportService;
    private final ApplicationService applicationService;
    private final SpecializationService specializationService;

    public FormSpecializationReportCommand(ReportService reportService, ApplicationService applicationService, SpecializationService specializationService) {
        this.reportService = reportService;
        this.applicationService = applicationService;
        this.specializationService = specializationService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, Exception {
        int specializationId = Integer.parseInt(request.getParameter("reportingSpecializationId"));
        int page = Integer.parseInt(request.getParameter("page"));
        int total = Integer.parseInt(request.getParameter("applicantsPerPage"));
        Optional<Specialization> specialization=specializationService.getSpecialization(specializationId);
        Integer plan;
        if (specialization.isPresent()){
            plan=specialization.get().getPlan();
        }
        else {
            request.getSession().setAttribute("reportMessage", "There is no data about specialization in database");
            return CommandResult.forward("/controller?command=reportPage");
        }
        List<Application> applicationsList = applicationService.getSpecifiedApplicationList(specializationId,(page - 1) * total, total);
        List<Application> nextApplicationsList = applicationService.getSpecifiedApplicationList(specializationId,page * total, total);
        Optional<ReportDto> appliedEnrolees=reportService.doCompetition(applicationsList,plan);
        if (appliedEnrolees.isPresent()) {
            appliedEnrolees.get().getApplicationMap().forEach((key, value)-> {
                try {
                    applicationService.updateStatus(key.getId(),value);
                } catch (Exception | ServiceException e) {
                    e.printStackTrace();
                }
            });
            request.setAttribute("specializationName",specialization.get().getSpecialization());
            request.setAttribute("reportIsFormed",true);
            request.getSession().setAttribute("hasNext", !nextApplicationsList.isEmpty());
            request.setAttribute("appliedEnroleesMap", appliedEnrolees.get().getApplicationMap());
            return CommandResult.forward("/controller?command=reportPage");
        } else {
            request.getSession().setAttribute("reportMessage", "This specialization\n has no registered enrolees yet!");
            return CommandResult.forward("/controller?command=reportPage");
        }
    }
}
