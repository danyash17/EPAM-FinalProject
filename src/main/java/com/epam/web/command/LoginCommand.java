package com.epam.web.command;

import com.epam.web.entity.User;
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Optional<User> user = userService.login(username, password);
        if (user.isPresent()) {
            User presentUser = user.get();
            request.getSession().setAttribute("name", presentUser.getUsername());
            return CommandResult.forward("/controller?command=mainPage");
        } else {
            request.getSession().setAttribute("errorMessage", "Login or password is incorrect");
            return CommandResult.forward("/controller?command=loginPage");
        }

    }
}
