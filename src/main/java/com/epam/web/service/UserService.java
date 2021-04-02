package com.epam.web.service;

import com.epam.web.dao.DaoException;
import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.dao.UserDaoImplement;
import com.epam.web.entity.User;

import java.util.Optional;

public class UserService {
    private final DaoHelperFactory factory;

    public UserService(DaoHelperFactory daoHelper) {
        this.factory = daoHelper;
    }

    public Optional<User> login (String login, String password) throws ServiceException, Exception {
        try(DaoHelper daoHelper=factory.create()){
            UserDaoImplement dao=daoHelper.createUserDao();
            return dao.findUserByLoginAndPassword(login,password);
        }
        catch (DaoException e){
            throw new ServiceException(e,e.getMessage());
        }
    }
}
