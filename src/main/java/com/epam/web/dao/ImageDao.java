package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.image.Image;
import com.epam.web.mapper.Mapper;

import java.util.List;
import java.util.Optional;

public class ImageDao<I extends Image> extends AbstractDao<I> {
    private final String SQL_CREATE_IMAGE;
    private final String SQL_UPDATE_IMAGE;
    private final String SQL_SELECT_FACULTY_IMAGES;
    private final String SQL_SELECT_SPECIALIZATION_IMAGES;
    private final String SQL_SELECT_IMAGE;

    public ImageDao(ProxyConnection connection, Mapper<I> mapper, String tableName) {
        super(connection, mapper, tableName);
        this.SQL_CREATE_IMAGE = "INSERT INTO" + tableName + " (id,path) VALUES (?,?)";
        this.SQL_UPDATE_IMAGE = "UPDATE " + tableName + " SET id=?,path=?";
        this.SQL_SELECT_FACULTY_IMAGES = "SELECT id,path FROM " + tableName + " JOIN faculty ON faculty.faculty_id=" + tableName + ".id";
        this.SQL_SELECT_SPECIALIZATION_IMAGES = "SELECT id,path FROM " + tableName + " JOIN specialization ON specialization.specialization_id=" + tableName + ".id AND specialization.faculty_id=?";
        this.SQL_SELECT_IMAGE = "SELECT * FROM " + tableName + " WHERE id=?";
    }

    @Override
    protected void create(I image) throws DaoException {
        executeUpdate(SQL_CREATE_IMAGE, image.getId(), image.getPath());
    }

    @Override
    protected void update(I image) throws DaoException {
        Optional<I> imageOptional = findById(image.getId());
        if (!imageOptional.isPresent()) {
            throw new DaoException("Image doesn't exist in table. Id is invalid: " + image.getId());
        }
        executeUpdate(SQL_UPDATE_IMAGE, image.getId(), image.getPath());
    }

    public List<I> selectFacultyImages() throws DaoException {
        return executeQuery(SQL_SELECT_FACULTY_IMAGES);
    }

    public List<I> selectSpecializationImagesById(Integer id) throws DaoException {
        return executeQuery(SQL_SELECT_SPECIALIZATION_IMAGES, id);
    }

    public Optional<I> selectSingleImage(Integer id) throws DaoException {
        return executeSingleResultQuery(SQL_SELECT_IMAGE, id);
    }
}
