package com.epam.web.mapper;

import com.epam.web.entity.Query;
import com.epam.web.entity.SexEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class QueryMapper implements Mapper {
    @Override
    public Query map(ResultSet resultSet) throws SQLException {
        int query_id=resultSet.getInt("query_id");
        String enrolee_name=resultSet.getString("name");
        String enrolee_surname=resultSet.getString("surname");
        String sex=resultSet.getString("sex");
        String country=resultSet.getString("country");
        String city=resultSet.getString("city");
        Date birthday=resultSet.getDate("birthday");
        String school=resultSet.getString("school");
        boolean medal=resultSet.getBoolean("medal");
        int specializationId=resultSet.getInt("specialization_id");
        String specialization=resultSet.getString("specialization");
        int firstExam=resultSet.getInt("first_exam");
        int secondExam=resultSet.getInt("second_exam");
        int thirdExam=resultSet.getInt("third_exam");
        int grade=resultSet.getInt("grade");
        SexEnum sexEnum=SexEnum.valueOf(sex);
        return new Query(query_id,enrolee_name,enrolee_surname,sexEnum,country,city,birthday,school,medal,specializationId,specialization,firstExam,secondExam,thirdExam,grade);
    }
}
