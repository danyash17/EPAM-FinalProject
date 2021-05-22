package com.epam.web.mapper;

import com.epam.web.entity.Specialization;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecializationMapper implements Mapper {
    @Override
    public Specialization map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("specialization_id");
        String specialization = resultSet.getString("specialization");
        String description = resultSet.getString("description");
        int faculty_id = resultSet.getInt("faculty_id");
        int plan = resultSet.getInt("plan");
        return new Specialization(id, specialization, faculty_id, plan, description);
    }
}
