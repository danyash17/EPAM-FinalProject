package com.epam.web.service;

import com.epam.web.dao.*;
import com.epam.web.entity.image.FacultyImage;
import com.epam.web.entity.image.SpecializationImage;

import java.util.List;
import java.util.Optional;

public class ImageService{
    private final DaoHelperFactory factory;

    public ImageService(DaoHelperFactory factory) {
        this.factory = factory;
    }

    public List<FacultyImage> getLimitedFacultyImages() throws ServiceException, Exception {
        try (DaoHelper daoHelper = factory.create()) {
            ImageDao<FacultyImage> dao = daoHelper.createFacultyImageDao();
            return dao.selectLimitedFacultyImages();
        } catch (DaoException e) {
            throw new ServiceException(e, e.getMessage());
        }
    }
    public List<SpecializationImage> getLimitedSpecializationImages(Integer facultyId) throws ServiceException, Exception {
        try (DaoHelper daoHelper = factory.create()) {
            ImageDao<SpecializationImage> dao = daoHelper.createSpecializationImageDao();
            return dao.selectLimitedSpecializationImagesById(facultyId);
        } catch (DaoException e) {
            throw new ServiceException(e, e.getMessage());
        }
    }

    public Optional<FacultyImage> getFacultyImage(Integer id) throws Exception, ServiceException {
        try (DaoHelper daoHelper = factory.create()) {
            ImageDao<FacultyImage> dao = daoHelper.createFacultyImageDao();
            return dao.selectSingleImage(id);
        } catch (DaoException e) {
            throw new ServiceException(e, e.getMessage());
        }
    }
    public Optional<SpecializationImage> getSpecializationImage(Integer id) throws Exception, ServiceException {
        try (DaoHelper daoHelper = factory.create()) {
            ImageDao<SpecializationImage> dao = daoHelper.createSpecializationImageDao();
            return dao.selectSingleImage(id);
        } catch (DaoException e) {
            throw new ServiceException(e, e.getMessage());
        }
    }
}
