package com.epam.web.dao;

import com.epam.web.beans.Entity;

import java.util.List;
import java.util.Optional;

public interface Dao <K extends Number, T extends Entity> {
    public Optional<T> findById(K id) throws DaoException;
    public List<T> findAll() throws DaoException;
    public void save(T entity) throws DaoException;
    public void deleteById(K id) throws DaoException;
}
