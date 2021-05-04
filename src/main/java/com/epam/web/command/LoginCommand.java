package com.epam.web.command;

import com.epam.web.entity.User;
import com.epam.web.service.ServiceException;
import com.epam.web.service.UserService;
import com.epam.web.validator.AuthentificationValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command {
    private final Logger LOGGER = LogManager.getLogger(LoginCommand.class);
    private final UserService userService;
    private final AuthentificationValidator validator;

    public LoginCommand(UserService service, AuthentificationValidator validator) {
        this.userService = service;
        this.validator = validator;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, Exception {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(!validator.validate(login)||!validator.validate(password)){
            request.getSession().setAttribute("errorMessage", "Login or password is invalid");
            return CommandResult.redirect("/controller?command=loginPage");
        }
        Optional<User> user = userService.login(login, password);
        if (user.isPresent()) {
            User presentUser = user.get();
            request.getSession().setAttribute("id", presentUser.getId());
            request.getSession().setAttribute("name", presentUser.getName());
            request.getSession().setAttribute("surname", presentUser.getSurname());
            request.getSession().setAttribute("sex", presentUser.getSex());
            request.getSession().setAttribute("role", presentUser.getRole());
            request.getSession().setAttribute("authorized",true);
            response.setHeader("Cache-Control","no -cache, no -store, must -revalidate");
            response.addHeader("Pragma","no -cache");
            response.setDateHeader ("Expires", 0) ;
            LOGGER.info("User "+presentUser.getName()+" "+presentUser.getSurname()+" logged in");
            return CommandResult.forward("/controller?command=loadMain&page=1&facultiesPerPage=3");
        } else {
            LOGGER.warn("User login error");
            request.getSession().setAttribute("errorMessage", "Login or password is incorrect");
            return CommandResult.redirect("/controller?command=loginPage");
        }

    }
}
