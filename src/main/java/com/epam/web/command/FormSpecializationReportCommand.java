package com.epam.web.command;

import com.epam.web.comparator.ApplicationComparator;
import com.epam.web.dto.ReportDto;
import com.epam.web.entity.Application;
import com.epam.web.entity.Specialization;
import com.epam.web.service.ApplicationService;
import com.epam.web.service.ReportService;
import com.epam.web.service.ServiceException;
import com.epam.web.service.SpecializationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

public class FormSpecializationReportCommand implements Command {
    private final Logger LOGGER = LogManager.getLogger(FormSpecializationReportCommand.class);
    private final ReportService reportService;
    private final ApplicationService applicationService;
    private final SpecializationService specializationService;

    public FormSpecializationReportCommand(ReportService reportService, ApplicationService applicationService, SpecializationService specializationService) {
        this.reportService = reportService;
        this.applicationService = applicationService;
        this.specializationService = specializationService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        int specializationId = Integer.parseInt(request.getParameter("reportingSpecializationId"));
        int page = Integer.parseInt(request.getParameter("page"));
        int total = Integer.parseInt(request.getParameter("applicantsPerPage"));
        Optional<Specialization> specialization=specializationService.getSpecialization(specializationId);
        Integer plan;
        if (specialization.isPresent()){
            plan=specialization.get().getPlan();
        }
        else {
            LOGGER.warn("Specialization is not found in DB");
            request.getSession().setAttribute("reportMessage", "There is no data about specialization in database");
            return CommandResult.forward("/controller?command=reportPage");
        }
        List<Application> fullList=applicationService.getFullSpecifiedApplicationList(specializationId);
        List<Application> nextApplicationsList = applicationService.getLimitedSpecifiedApplicationList(specializationId,page * total, total);
        Optional<ReportDto> fullAppliedEnrolees=reportService.doCompetition(fullList,plan,0, fullList.size(),new ApplicationComparator());
        Optional<ReportDto> appliedEnrolees=reportService.doCompetition(fullList,plan,(page - 1) * total, page*total,new ApplicationComparator());
        if (fullAppliedEnrolees.isPresent()) {
            fullAppliedEnrolees.get().getApplicationMap().forEach((key, value)-> {
                try {
                    applicationService.updateStatus(key.getId(),value);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
            });
            request.setAttribute("specializationName",specialization.get().getSpecialization());
            request.setAttribute("reportIsFormed",true);
            request.getSession().setAttribute("hasNext", !nextApplicationsList.isEmpty());
            request.setAttribute("appliedEnroleesMap", appliedEnrolees.get().getApplicationMap());
            return CommandResult.forward("/controller?command=reportPage");
        } else {
            LOGGER.info("Empty specialization");
            request.getSession().setAttribute("reportMessage", "This specialization\n has no registered enrolees yet!");
            return CommandResult.forward("/controller?command=reportPage");
        }
    }
}
