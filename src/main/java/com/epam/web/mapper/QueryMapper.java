package com.epam.web.mapper;

import com.epam.web.entity.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class QueryMapper implements Mapper {
    @Override
    public Query map(ResultSet resultSet) throws SQLException {
        int query_id=resultSet.getInt("query_id");
        String city=resultSet.getString("city");
        Date birthday=resultSet.getDate("birthday");
        String school=resultSet.getString("school");
        boolean medal=resultSet.getBoolean("medal");
        int specializationId=resultSet.getInt("specialization_id");
        int firstExam=resultSet.getInt("first_exam");
        int secondExam=resultSet.getInt("second_exam");
        int thirdExam=resultSet.getInt("third_exam");
        int grade=resultSet.getInt("grade");
        return new Query(query_id,city,birthday,school,medal,specializationId,firstExam,secondExam,thirdExam,grade);
    }
}
