package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.Faculty;
import com.epam.web.mapper.FacultyMapper;

import java.util.List;
import java.util.Optional;

public class FacultyDao extends AbstractDao<Faculty> {
    private static final String tableName = "faculty";
    private static final String SQL_CREATE_FACULTY="INSERT INTO faculty (faculty_id,faculty,first_exam,second_exam,third_exam) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE_FACULTY="UPDATE faculty SET faculty_id=?,faculty=?,first_exam=?,second_exam=?,third_exam=?";
    private static final String SQL_SELECT_LIMITED_FACULTIES ="SELECT * FROM faculty LIMIT ?,?";
    private static final String SQL_SELECT_FACULTY_BY_ID ="SELECT * FROM faculty WHERE faculty_id=?";

    public FacultyDao(ProxyConnection connection) {
        super(connection, new FacultyMapper(), tableName);
    }

    @Override
    protected void create(Faculty faculty) throws DaoException {
        executeUpdate(SQL_CREATE_FACULTY,faculty.getId(),faculty.getFaculty(),faculty.getFirstExam(),faculty.getSecondExam(),faculty.getThirdExam());
    }

    @Override
    protected void update(Faculty faculty) throws DaoException {
        Optional<Faculty> facultyOptional=findById(faculty.getId());
        if (!facultyOptional.isPresent()) {
            throw new DaoException("Faculty doesn't exist in table. Id is invalid: " + faculty.getId());
        }
        executeUpdate(SQL_UPDATE_FACULTY,faculty.getId(),faculty.getFaculty(),faculty.getFirstExam(),faculty.getSecondExam(),faculty.getThirdExam());
    }
    public List<Faculty> selectLimitedFaculties(int pageid, int total) throws DaoException {
        return executeQuery(SQL_SELECT_LIMITED_FACULTIES,pageid,total);
    }

    public Optional<Faculty> selectFacultyById(Integer facultyId) throws DaoException {
    return executeSingleResultQuery(SQL_SELECT_FACULTY_BY_ID,facultyId);
    }
}
