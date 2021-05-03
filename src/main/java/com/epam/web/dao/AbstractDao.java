package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.Entity;
import com.epam.web.mapper.Mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Entity> implements Dao {

    private static final String SELECT_BY_ID = "SELECT * FROM %s WHERE application_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM %s";
    private static final String DELETE = "DELETE FROM %s WHERE application_id = ?";

    private final ProxyConnection connection;
    private final Mapper<T> mapper;
    private final String tableName;

    public AbstractDao(ProxyConnection connection, Mapper<T> mapper, String tableName) {
        this.connection = connection;
        this.mapper = mapper;
        this.tableName = tableName;
    }

    private PreparedStatement createStatement(String query, Object ...params) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 0; i < params.length; ++i) {
            statement.setObject(i+1 , params[i]);
        }
        return statement;
    }

    protected List<T> executeQuery(String query, Object ...params) throws DaoException {

        try (PreparedStatement statement = createStatement(query, params);
             ResultSet resultSet = statement.executeQuery()) {

            List<T> entities = new ArrayList<>();
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }

            return entities;

        } catch (SQLException e) {
            throw new DaoException(e,e.getMessage());
        }
    }

    protected Optional<T> executeSingleResultQuery(String query, Object ...params) throws DaoException {

        List<T> entities = executeQuery(query, params);

        if (entities.size() > 1) {
            throw new DaoException("Application is not single");
        }

        if (entities.size() > 0) {
            return Optional.of(entities.get(0));
        }

        return Optional.empty();
    }

    protected void executeUpdate(String query, Object ...params) throws DaoException {

        try (PreparedStatement statement = createStatement(query, params)) {
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e,e.getMessage());
        }
    }

    @Override
    public Optional<T> findById(Integer id) throws DaoException {
        String query = String.format(SELECT_BY_ID, tableName);
        return executeSingleResultQuery(query, id);
    }

    @Override
    public List<T> findAll() throws DaoException {
        String query = String.format(SELECT_ALL, tableName);
        return executeQuery(query);
    }

    @Override
    public void save(Entity entity) throws DaoException {
        if (entity.getId() == null) {
            create((T) entity);
        } else {
            update((T) entity);
        }
    }

    protected abstract void create(T entity) throws DaoException;

    protected abstract void update(T entity) throws DaoException;

    @Override
    public void deleteById(Integer id) throws DaoException {
        String query = String.format(DELETE, tableName);
        executeUpdate(query, id);
    }

}
