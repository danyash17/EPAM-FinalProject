package com.epam.web.mapper;

import com.epam.web.entity.Faculty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyMapper implements Mapper<Faculty> {
    @Override
    public Faculty map(ResultSet resultSet) throws SQLException {
        int facultyId = resultSet.getInt("faculty_id");
        String faculty = resultSet.getString("faculty");
        String first_exam = resultSet.getString("first_exam");
        String second_exam = resultSet.getString("second_exam");
        String third_exam = resultSet.getString("third_exam");
        String description = resultSet.getString("description");
        return new Faculty(facultyId, faculty, first_exam, second_exam, third_exam, description);
    }
}
