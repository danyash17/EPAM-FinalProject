package com.epam.web.mapper;

import com.epam.web.beans.SexEnum;
import com.epam.web.beans.User;
import com.epam.web.beans.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper {
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        Integer id=resultSet.getInt("id");
        String name=resultSet.getString("name");
        String surname=resultSet.getString("surname");
        String sex=resultSet.getString("sex");
        String login=resultSet.getString("login");
        String password=resultSet.getString("password");
        String userRoleValue=resultSet.getString("role");
        UserRole userRole=UserRole.valueOf(userRoleValue);
        SexEnum sexEnum=SexEnum.valueOf(sex);
        return new User(id,login,password,name,surname,sexEnum,userRole);
    }
}
