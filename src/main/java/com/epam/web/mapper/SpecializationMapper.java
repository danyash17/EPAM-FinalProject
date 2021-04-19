package com.epam.web.mapper;

import com.epam.web.entity.Specialization;
import com.epam.web.entity.User;
import com.epam.web.entity.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecializationMapper implements Mapper {
    @Override
    public Specialization map(ResultSet resultSet) throws SQLException {
        Integer id=resultSet.getInt("specialization_id");
        String specialization=resultSet.getString("specialization");
        Integer faculty_id=resultSet.getInt("faculty_id");
        Integer plan=resultSet.getInt("plan");
        return new Specialization(id,specialization,faculty_id,plan);
    }
}
