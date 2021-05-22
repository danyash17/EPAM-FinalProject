package com.epam.web.dao;

import com.epam.web.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface Dao<T extends Entity> {
    public Optional<T> findById(Integer id) throws DaoException;

    public List<T> findAll() throws DaoException;

    public void save(T entity) throws DaoException;

    public void deleteById(Integer id) throws DaoException;
}
