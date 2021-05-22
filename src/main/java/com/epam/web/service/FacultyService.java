package com.epam.web.service;

import com.epam.web.dao.DaoException;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.FacultyDao;
import com.epam.web.entity.Faculty;

import java.util.List;
import java.util.Optional;

public class FacultyService {
    private final DaoHelperFactory factory;

    public FacultyService(DaoHelperFactory factory) {
        this.factory = factory;
    }

    public List<Faculty> getLimitedFaculties(int pageid, int total) throws ServiceException {
        try (DaoHelper daoHelper = factory.create()) {
            FacultyDao dao = daoHelper.createFacultyDao();
            return dao.selectLimitedFaculties(pageid, total);
        } catch (DaoException e) {
            throw new ServiceException(e, e.getMessage());
        }
    }

    public Optional<Faculty> getFaculty(Integer facultyId) throws ServiceException {
        try (DaoHelper daoHelper = factory.create()) {
            FacultyDao dao = daoHelper.createFacultyDao();
            return dao.selectFacultyById(facultyId);
        } catch (DaoException e) {
            throw new ServiceException(e, e.getMessage());
        }
    }
}
