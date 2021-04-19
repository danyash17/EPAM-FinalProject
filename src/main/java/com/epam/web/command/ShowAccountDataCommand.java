package com.epam.web.command;

import com.epam.web.entity.Query;
import com.epam.web.service.QueryService;
import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class ShowAccountDataCommand implements Command {
    private final QueryService queryService;

    public ShowAccountDataCommand(QueryService service) {
        this.queryService = service;
    }
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, Exception {
        Integer id= (Integer) request.getSession().getAttribute("id");
        Optional<Query> query = queryService.getQuery(id);
        if (query.isPresent()) {
            Query presentQuery = query.get();
            request.getSession().setAttribute("country", presentQuery.getCountry());
            request.getSession().setAttribute("city", presentQuery.getCity());
            request.getSession().setAttribute("birthday", presentQuery.getBirthday());
            request.getSession().setAttribute("school", presentQuery.getSchool());
            request.getSession().setAttribute("medal", presentQuery.getMedal());
            request.getSession().setAttribute("specialization_id", presentQuery.getSpecializationId());
            request.getSession().setAttribute("specialization", presentQuery.getSpecialization());
            request.getSession().setAttribute("school", presentQuery.getSchool());
            request.getSession().setAttribute("first_exam", presentQuery.getFirstExam());
            request.getSession().setAttribute("second_exam", presentQuery.getSecondExam());
            request.getSession().setAttribute("third_exam", presentQuery.getThirdExam());
            request.getSession().setAttribute("grade", presentQuery.getGrade());
            return CommandResult.forward("/controller?command=accountPage");
        } else {
            request.getSession().setAttribute("errorMessage", "Ooos...Something went wrong,please try again");
            return CommandResult.forward("/controller?command=errorPage");
        }
    }
}
