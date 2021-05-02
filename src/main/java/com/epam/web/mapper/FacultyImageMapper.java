package com.epam.web.mapper;

import com.epam.web.entity.Entity;
import com.epam.web.image.FacultyImage;
import com.epam.web.image.Image;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyImageMapper implements Mapper<FacultyImage> {
    @Override
    public FacultyImage map(ResultSet resultSet) throws SQLException {
        int id=resultSet.getInt("id");
        String path=resultSet.getString("path");
        return new FacultyImage(path,id);
    }
}
