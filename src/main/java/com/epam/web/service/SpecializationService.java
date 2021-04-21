package com.epam.web.service;

import com.epam.web.dao.*;
import com.epam.web.beans.Specialization;

import java.util.Optional;

public class SpecializationService  {
    private final DaoHelperFactory factory;

    public SpecializationService(DaoHelperFactory factory) {
        this.factory = factory;
    }

    public Optional<Specialization> getSpecialization(Integer specializationId) throws Exception, ServiceException {
        try(DaoHelper daoHelper=factory.create()){
            SpecializationDaoImplement dao=daoHelper.createSpecializationDao();
            return dao.selectSpecialization(specializationId);
        }
        catch (DaoException e){
            throw new ServiceException(e,e.getMessage());
        }
    }
}
