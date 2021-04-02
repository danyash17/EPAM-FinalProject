package com.epam.web.mapper;

import com.epam.web.entity.Entity;
import com.epam.web.entity.User;
import com.epam.web.entity.UserRole;
import com.epam.web.mapper.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper {
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        Integer id=resultSet.getInt("id");
        String username=resultSet.getString("name");
        String surname=resultSet.getString("surname");
        String login=resultSet.getString("login");
        String password=resultSet.getString("password");
        String userRoleValue=resultSet.getString("role");
        UserRole userRole=UserRole.valueOf(userRoleValue);
        return new User(id,username,surname,login,password,userRole);
    }
}
