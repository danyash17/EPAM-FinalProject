package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.beans.Query;
import com.epam.web.mapper.QueryMapper;

import java.util.List;
import java.util.Optional;

public class QueryDaoImplement extends AbstractDao<Integer, Query> implements QueryDao {
    private static final String tableName = "query";

    public QueryDaoImplement(ProxyConnection connection) {
        super(connection, new QueryMapper(), tableName);
    }
    public static final String SQL_CREATE_QUERY =
            "INSERT INTO query (query_id,country, city, birthday,school,medal,specialization_id) VALUES (?,?, ?, ?,?,?,?)";
    public static final String SQL_UPDATE_QUERY =
            "UPDATE query SET country=?, city=?, birthday = ?, school=?, medal=? specialization_id=?  WHERE query_id = ?";
    public static final String SQL_UPDATE_SPECIALIZATION_QUERY =
            "UPDATE query SET specialization_id=?  WHERE query_id = ?";
    public static final String SQL_QUERY_WITH_GRADES ="SELECT name,surname,sex,role,query.query_id,country,city,birthday,school,medal,specialization.specialization_id,specialization.specialization,first_exam,second_exam,third_exam,grade\n" +
            "FROM user JOIN query ON user.id = query.query_id\n" +
            "LEFT JOIN grades ON query.query_id=grades.query_id\n" +
            "LEFT JOIN certificate ON grades.certificate_id=certificate.certificate_id\n" +
            "LEFT JOIN specialization ON query.specialization_id=specialization.specialization_id\n"+
            "WHERE id=?";
    public static final String SQL_SELECT_QUERY_WITH_GRADES_BY_SPECIALIZATION ="SELECT name,surname,sex,role,query.query_id,country,city,birthday,school,medal,specialization.specialization_id,specialization.specialization,first_exam,second_exam,third_exam,grade\n" +
            "FROM user JOIN query ON user.id = query.query_id\n" +
            "LEFT JOIN grades ON query.query_id=grades.query_id\n" +
            "LEFT JOIN certificate ON grades.certificate_id=certificate.certificate_id\n" +
            "LEFT JOIN specialization ON query.specialization_id=specialization.specialization_id\n"+
            "WHERE query.specialization_id=?";

    @Override
    protected void create(Query query) throws DaoException {
        executeUpdate(SQL_CREATE_QUERY, query.getId(),query.getCountry(), query.getCity(), query.getBirthday(), query.getSchool(), query.getMedal(), query.getSpecializationId());
    }

    @Override
    protected void update(Query query) throws DaoException {
        Optional<Query> queryOptional=findById(query.getId());
        if (!queryOptional.isPresent()) {
            throw new DaoException("Query doesn't exist in table. Id is invalid: " + query.getId());
        }
        executeUpdate(SQL_UPDATE_QUERY, query.getId(),query.getCountry(), query.getCity(), query.getBirthday(), query.getSchool(), query.getMedal(), query.getSpecializationId());
    }
    public Optional<Query> selectExtendedQueryById(int id) throws DaoException {
        return executeSingleResultQuery(SQL_QUERY_WITH_GRADES,id);
    }
    public List<Query> selectSpecifiedQueryListBySpecificationId(Integer specialization_id) throws DaoException {
        return executeQuery(SQL_SELECT_QUERY_WITH_GRADES_BY_SPECIALIZATION,specialization_id);
    }
    public void updateSpecializationColumnById(Integer id, Integer specializationId) throws DaoException {
        executeUpdate(SQL_UPDATE_SPECIALIZATION_QUERY,specializationId,id);
    }
}
