package com.epam.web.service;

import com.epam.web.dao.*;
import com.epam.web.entity.Faculty;
import com.epam.web.entity.Specialization;

import java.util.List;
import java.util.Optional;

public class SpecializationService  {
    private final DaoHelperFactory factory;

    public SpecializationService(DaoHelperFactory factory) {
        this.factory = factory;
    }

    public Optional<Specialization> getSpecialization(Integer specializationId) throws Exception, ServiceException {
        try(DaoHelper daoHelper=factory.create()){
            SpecializationDao dao=daoHelper.createSpecializationDao();
            return dao.selectSpecialization(specializationId);
        }
        catch (DaoException e){
            throw new ServiceException(e,e.getMessage());
        }
    }

    public List<Specialization> getLimitedSpecializations(Integer facultyId,int pageid, int total) throws Exception, ServiceException {
        try (DaoHelper daoHelper = factory.create()) {
            SpecializationDao dao = daoHelper.createSpecializationDao();
            return dao.selectLimitedSpecializations(facultyId,pageid, total);
        } catch (DaoException e) {
            throw new ServiceException(e, e.getMessage());
        }
    }
}
