package com.epam.web.mapper;

import com.epam.web.entity.image.SpecializationImage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecializationImageMapper implements Mapper<SpecializationImage> {
    @Override
    public SpecializationImage map(ResultSet resultSet) throws SQLException {
        int id=resultSet.getInt("id");
        String path=resultSet.getString("path");
        return new SpecializationImage(path,id);
    }
}
