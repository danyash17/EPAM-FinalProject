package com.epam.web.command;

import com.epam.web.beans.User;
import com.epam.web.service.ServiceException;
import com.epam.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command {
    private final UserService userService;

    public LoginCommand(UserService service) {
        this.userService = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, Exception {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Optional<User> user = userService.login(login, password);
        if (user.isPresent()) {
            User presentUser = user.get();
            request.getSession().setAttribute("id", presentUser.getId());
            request.getSession().setAttribute("name", presentUser.getName());
            request.getSession().setAttribute("surname", presentUser.getSurname());
            request.getSession().setAttribute("sex", presentUser.getSex());
            request.getSession().setAttribute("role", presentUser.getRole());
            return CommandResult.forward("/controller?command=mainPage");
        } else {
            request.getSession().setAttribute("errorMessage", "Login or password is incorrect");
            return CommandResult.forward("/controller?command=loginPage");
        }

    }
}
