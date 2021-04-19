package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.Entity;
import com.epam.web.entity.Specialization;
import com.epam.web.mapper.QueryMapper;
import com.epam.web.mapper.SpecializationMapper;

import java.util.List;
import java.util.Optional;

public class SpecializationDaoImplement extends AbstractDao<Integer,Specialization> implements SpecializationDao {
    private static final String tableName = "specialization";
    public SpecializationDaoImplement(ProxyConnection connection) {
        super(connection, new SpecializationMapper(), tableName);
    }
    public static final String SQL_CREATE_SPECIALIZATION =
            "INSERT INTO specialization (specialization_id, specialization, faculty_id,plan) VALUES (?, ?, ?,?)";
    public static final String SQL_UPDATE_SPECIALIZATION =
            "UPDATE specialization SET specialization_id=?, specialization = ?, faculty=?, plan=? WHERE specialization_id = ?";
    public static final String SQL_SELECT_SPECIALIZATION=
            "SELECT * FROM specialization WHERE specialization_id=?";

    @Override
    protected void create(Specialization entity) throws DaoException {

    }

    @Override
    protected void update(Specialization entity) throws DaoException {

    }

    public Optional<Specialization> selectSpecialization(Integer specializationId) throws DaoException {
        return executeSingleResultQuery(SQL_SELECT_SPECIALIZATION,specializationId);
    }
}
