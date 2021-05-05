package com.epam.web.service;

import com.epam.web.dao.DaoException;
import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.dao.ImageDao;
import com.epam.web.entity.image.FacultyImage;
import com.epam.web.entity.image.SpecializationImage;

import java.util.List;
import java.util.Optional;

public class ImageService{
    private final DaoHelperFactory factory;

    public ImageService(DaoHelperFactory factory) {
        this.factory = factory;
    }

    public List<FacultyImage> getFacultyImages() throws ServiceException {
        try (DaoHelper daoHelper = factory.create()) {
            ImageDao<FacultyImage> dao = daoHelper.createFacultyImageDao();
            return dao.selectFacultyImages();
        } catch (DaoException e) {
            throw new ServiceException(e, e.getMessage());
        }
    }
    public List<SpecializationImage> getSpecializationImages(Integer facultyId) throws ServiceException {
        try (DaoHelper daoHelper = factory.create()) {
            ImageDao<SpecializationImage> dao = daoHelper.createSpecializationImageDao();
            return dao.selectSpecializationImagesById(facultyId);
        } catch (DaoException e) {
            throw new ServiceException(e, e.getMessage());
        }
    }

    public Optional<FacultyImage> getFacultyImage(Integer id) throws ServiceException {
        try (DaoHelper daoHelper = factory.create()) {
            ImageDao<FacultyImage> dao = daoHelper.createFacultyImageDao();
            return dao.selectSingleImage(id);
        } catch (DaoException e) {
            throw new ServiceException(e, e.getMessage());
        }
    }
    public Optional<SpecializationImage> getSpecializationImage(Integer id) throws ServiceException {
        try (DaoHelper daoHelper = factory.create()) {
            ImageDao<SpecializationImage> dao = daoHelper.createSpecializationImageDao();
            return dao.selectSingleImage(id);
        } catch (DaoException e) {
            throw new ServiceException(e, e.getMessage());
        }
    }
}
