package com.epam.web.controller;
import com.epam.web.command.Command;
import com.epam.web.command.CommandFactory;
import com.epam.web.command.CommandResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class Controller extends HttpServlet {
    private final CommandFactory commandFactory=new CommandFactory();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        process(req, resp);
    }
    private void forward(HttpServletRequest request,HttpServletResponse response,String page) throws ServletException, IOException {
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request,response);
    }
    private void redirect(HttpServletRequest request,HttpServletResponse response,String page) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath()+page);
    }
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String commandType=request.getParameter("command");
        Command action=commandFactory.create(commandType);
        String page;
        boolean isRedirect=false;
        try{
        CommandResult result=action.execute(request,response);
        page=result.getPage();
        isRedirect=result.isRedirect();
        }
        catch (Exception e){
            request.setAttribute("errorMessage",e.getMessage());
            page="/error-login.jsp";
        }
        if(!isRedirect){
            forward(request,response,page);
        } else {
            redirect(request,response,page);
        }
    }
}
