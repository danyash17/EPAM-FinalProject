package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.Specialization;
import com.epam.web.mapper.SpecializationMapper;

import java.util.List;
import java.util.Optional;

public class SpecializationDao extends AbstractDao<Specialization> {
    private static final String tableName = "specialization";
    public SpecializationDao(ProxyConnection connection) {
        super(connection, new SpecializationMapper(), tableName);
    }
    public static final String SQL_CREATE_SPECIALIZATION =
            "INSERT INTO specialization (specialization_id, specialization, faculty_id,plan) VALUES (?, ?, ?,?)";
    public static final String SQL_UPDATE_SPECIALIZATION =
            "UPDATE specialization SET specialization_id=?, specialization = ?, faculty=?, plan=? WHERE specialization_id = ?";
    public static final String SQL_SELECT_SPECIALIZATION=
            "SELECT * FROM specialization WHERE specialization_id=?";
    public static final String SQL_SELECT_LIMITED_SPECIALIZATIONS_BY_FACULTY_ID=
            "SELECT * FROM specialization WHERE faculty_id=? LIMIT ?,?";

    @Override
    protected void create(Specialization specialization) throws DaoException {
        executeUpdate(SQL_CREATE_SPECIALIZATION,specialization.getId(),specialization.getSpecialization(),specialization.getFacultyId(),specialization.getPlan());
    }

    @Override
    protected void update(Specialization specialization) throws DaoException {
        Optional<Specialization> specializationOptional=findById(specialization.getId());
        if (!specializationOptional.isPresent()) {
            throw new DaoException("Specialization doesn't exist in table. Id is invalid: " + specialization.getId());
        }
        executeUpdate(SQL_UPDATE_SPECIALIZATION,specialization.getId(),specialization.getSpecialization(),specialization.getFacultyId(),specialization.getPlan());
    }

    public Optional<Specialization> selectSpecialization(Integer specializationId) throws DaoException {
        return executeSingleResultQuery(SQL_SELECT_SPECIALIZATION,specializationId);
    }

    public List<Specialization> selectLimitedSpecializations(Integer facultyId, int pageid, int total) throws DaoException {
    return executeQuery(SQL_SELECT_LIMITED_SPECIALIZATIONS_BY_FACULTY_ID,facultyId,pageid,total);
    }
}
