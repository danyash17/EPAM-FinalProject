package com.epam.web.mapper;

import com.epam.web.entity.Application;
import com.epam.web.entity.SexEnum;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationMapper implements Mapper {
    @Override
    public Application map(ResultSet resultSet) throws SQLException {
        int application_id=resultSet.getInt("application_id");
        String enrolee_name=resultSet.getString("name");
        String enrolee_surname=resultSet.getString("surname");
        String sex=resultSet.getString("sex");
        String country=resultSet.getString("country");
        String city=resultSet.getString("city");
        boolean medal=resultSet.getBoolean("medal");
        int specializationId=resultSet.getInt("specialization_id");
        int firstExam=resultSet.getInt("first_exam");
        int secondExam=resultSet.getInt("second_exam");
        int thirdExam=resultSet.getInt("third_exam");
        int grade=resultSet.getInt("grade");
        SexEnum sexEnum=SexEnum.valueOf(sex);
        return new Application(application_id,enrolee_name,enrolee_surname,sexEnum,country,city,medal,specializationId,firstExam,secondExam,thirdExam,grade);
    }
}
