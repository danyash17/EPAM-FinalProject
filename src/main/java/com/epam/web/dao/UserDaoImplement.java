package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.User;
import com.epam.web.mapper.UserMapper;

import java.util.Optional;

public class UserDaoImplement extends AbstractDao<Integer,User> implements UserDao{
    private static final String tableName="user";
    public static final String SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD =
            "SELECT * FROM user WHERE login=? AND password=?;";
    public static final String SQL_SELECT_USER_BY_ID =
            "SELECT name FROM user WHERE id=?";
    public static final String SQL_CREATE_USER =
            "INSERT INTO user (username, password, role) VALUES (?, md5(?), ?)";
    public static final String SQL_UPDATE_USER =
            "UPDATE user SET username = ?, password = md5(?), role = ? WHERE id = ?";

    public UserDaoImplement(ProxyConnection connection) {
        super(connection, new UserMapper(), tableName);
    }

    @Override
    protected void create(User user) throws DaoException {
        executeUpdate(SQL_CREATE_USER, user.getUsername(), user.getPassword(), user.getRole().toString());
    }

    @Override
    protected void update(User user) throws DaoException {
        Optional<User> userOptional=findById(user.getId());
        if (!userOptional.isPresent()) {
            throw new DaoException("User doesn't exist in table. Id is invalid: " + user.getId());
        }
        executeUpdate(SQL_UPDATE_USER, user.getUsername(), user.getPassword(), user.getRole().toString(), user.getId());
    }


    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeSingleResultQuery(SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD,login,password);
    }
    public Optional<User> findUserByID(Integer id) throws DaoException {
        return executeSingleResultQuery(SQL_SELECT_USER_BY_ID,id);
    }
}
