package com.epam.web.dao.helper;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.dao.*;
import com.epam.web.entity.image.FacultyImage;
import com.epam.web.entity.image.SpecializationImage;
import com.epam.web.mapper.FacultyImageMapper;
import com.epam.web.mapper.SpecializationImageMapper;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {
    private final ProxyConnection connection;

    public DaoHelper(ProxyConnection connection) {
        this.connection = connection;
    }

    @Override
    public void close() {
        try {
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public UserDao createUserDao() {
        return new UserDao(connection);
    }

    public ApplicationDao createApplicationDao() {
        return new ApplicationDao(connection);
    }

    public FacultyDao createFacultyDao() {
        return new FacultyDao(connection);
    }

    public ImageDao<FacultyImage> createFacultyImageDao() {
        return new ImageDao<FacultyImage>(connection, new FacultyImageMapper(), "faculty_image");
    }

    public ImageDao<SpecializationImage> createSpecializationImageDao() {
        return new ImageDao<SpecializationImage>(connection, new SpecializationImageMapper(), "specialization_image");
    }

    public SpecializationDao createSpecializationDao() {
        return new SpecializationDao(connection);
    }

    public void beginTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }

    public void endTransaction() throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }
}
