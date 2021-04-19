package com.epam.web.command;

import com.epam.web.entity.Query;
import com.epam.web.entity.Report;
import com.epam.web.entity.Specialization;
import com.epam.web.service.QueryService;
import com.epam.web.service.ReportService;
import com.epam.web.service.ServiceException;
import com.epam.web.service.SpecializationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FormSpecializationReportCommand implements Command {
    private final Integer specializationId;
    private final ReportService reportService;
    private final QueryService  queryService;
    private final SpecializationService specializationService;

    public FormSpecializationReportCommand(ReportService reportService, QueryService queryService,SpecializationService specializationService,Integer specializationId) {
        this.specializationId = specializationId;
        this.reportService = reportService;
        this.queryService = queryService;
        this.specializationService = specializationService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, Exception {
        Optional<Specialization> specialization=specializationService.getSpecialization(specializationId);
        Integer plan;
        if (specialization.isPresent()){
            plan=specialization.get().getPlan();
        }
        else {
            request.getSession().setAttribute("reportMessage", "There is no data about specialization in database");
            return CommandResult.forward("/controller?command=reportPage");
        }
        List<Query> queryList = queryService.getSpecifiedQueryList(specializationId);
        Optional<Report> appliedEnrolees=reportService.doCompetition(queryList,plan);
        if (appliedEnrolees.isPresent()) {
            request.getSession().setAttribute("specializationName",specialization.get().getSpecialization());
            request.setAttribute("reportIsFormed",true);
            request.getSession().setAttribute("appliedEnroleesMap", appliedEnrolees.get().getQueryMap());
            return CommandResult.forward("/controller?command=reportPage");
        } else {
            request.getSession().setAttribute("reportMessage", "This specialization\n has no registered enrolees yet!");
            return CommandResult.forward("/controller?command=reportPage");
        }
    }
}
