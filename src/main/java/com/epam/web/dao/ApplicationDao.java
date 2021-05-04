package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.Application;
import com.epam.web.mapper.ApplicationMapper;

import java.util.List;
import java.util.Optional;

public class ApplicationDao extends AbstractDao<Application> {
    private static final String tableName = "application";

    public ApplicationDao(ProxyConnection connection) {
        super(connection, new ApplicationMapper(), tableName);
    }
    public static final String SQL_CREATE_APPLICATION =
            "INSERT INTO application (application_id,country, city, medal,specialization_id) VALUES (?,?, ?, ?,?,?,?)";
    public static final String SQL_UPDATE_APPLICATION =
            "UPDATE application SET country=?, city=?,  medal=? specialization_id=?  WHERE application_id = ?";
    public static final String SQL_UPDATE_SPECIALIZATION_APPLICATION =
            "UPDATE application SET specialization_id=?  WHERE application_id = ?";
    public static final String SQL_UPDATE_APPLICATION_RESULT =
            "UPDATE report SET result=?  WHERE report.application_id = ? ";
    public static final String SQL_SELECT_APPLICATION_WITH_GRADES ="SELECT name,surname,sex,role,application.application_id,country,city,medal,specialization_id,first_exam,second_exam,third_exam,grade\n" +
            "FROM user JOIN application ON user.id = application.application_id\n" +
            "LEFT JOIN grades ON application.application_id=grades.application_id\n" +
            "LEFT JOIN certificate ON grades.certificate_id=certificate.certificate_id\n" +
            "WHERE id=?";
    public static final String SQL_SELECT_LIMITED_APPLICATION_WITH_GRADES_BY_SPECIALIZATION ="SELECT name,surname,sex,role,application.application_id,country,city,medal,specialization_id,first_exam,second_exam,third_exam,grade\n" +
            "FROM user JOIN application ON user.id = application.application_id\n" +
            "LEFT JOIN grades ON application.application_id=grades.application_id\n" +
            "LEFT JOIN certificate ON grades.certificate_id=certificate.certificate_id\n" +
            "WHERE application.specialization_id=? LIMIT ?,?";
    public static final String SQL_SELECT_FULL_APPLICATION_WITH_GRADES_BY_SPECIALIZATION ="SELECT name,surname,sex,role,application.application_id,country,city,medal,specialization_id,first_exam,second_exam,third_exam,grade\n" +
            "FROM user JOIN application ON user.id = application.application_id\n" +
            "LEFT JOIN grades ON application.application_id=grades.application_id\n" +
            "LEFT JOIN certificate ON grades.certificate_id=certificate.certificate_id\n" +
            "WHERE application.specialization_id=?";
    @Override
    protected void create(Application application) throws DaoException {
        executeUpdate(SQL_CREATE_APPLICATION, application.getId(), application.getCountry(), application.getCity(),  application.getMedal(), application.getSpecializationId());
    }

    @Override
    protected void update(Application application) throws DaoException {
        Optional<Application> applicationOptional=findById(application.getId());
        if (!applicationOptional.isPresent()) {
            throw new DaoException("Application doesn't exist in table. Id is invalid: " + application.getId());
        }
        executeUpdate(SQL_UPDATE_APPLICATION, application.getId(), application.getCountry(), application.getCity(),  application.getMedal(), application.getSpecializationId());
    }
    public Optional<Application> selectExtendedApplicationById(Integer id) throws DaoException {
        return executeSingleResultQuery(SQL_SELECT_APPLICATION_WITH_GRADES,id);
    }
    public List<Application> selectLimitedSpecifiedApplicationListBySpecificationId(Integer specialization_id,int page,int total) throws DaoException {
        return executeQuery(SQL_SELECT_LIMITED_APPLICATION_WITH_GRADES_BY_SPECIALIZATION,specialization_id,page,total);
    }
    public void updateSpecializationColumnById(Integer id, Integer specializationId) throws DaoException {
        executeUpdate(SQL_UPDATE_SPECIALIZATION_APPLICATION,specializationId,id);
    }

    public void updateSpecializationReportResultById(Integer applicationId, Boolean result) throws DaoException {
        executeUpdate(SQL_UPDATE_APPLICATION_RESULT,result,applicationId);
    }

    public List<Application> selectSpecifiedApplicationListBySpecificationId(int specializationId) throws DaoException {
        return executeQuery(SQL_SELECT_FULL_APPLICATION_WITH_GRADES_BY_SPECIALIZATION,specializationId);
    }
}
