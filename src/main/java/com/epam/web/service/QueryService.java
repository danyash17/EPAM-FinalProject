package com.epam.web.service;

import com.epam.web.dao.*;
import com.epam.web.entity.Query;
import com.epam.web.entity.User;

import java.util.Optional;

public class QueryService {
    private final DaoHelperFactory factory;

    public QueryService(DaoHelperFactory daoHelper) {
        this.factory = daoHelper;
    }

    public Optional<Query> getQuery (int id) throws ServiceException, Exception {
        try(DaoHelper daoHelper=factory.create()){
            QueryDaoImplement dao=daoHelper.createQueryDao();
            return dao.getFullQueryInfoById(id);
        }
        catch (DaoException e){
            throw new ServiceException(e,e.getMessage());
        }
    }
}
