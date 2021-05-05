package com.epam.web.service;

import com.epam.web.dao.ApplicationDao;
import com.epam.web.dao.DaoException;
import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.entity.Application;

import java.util.List;
import java.util.Optional;

public class ApplicationService {
    private final DaoHelperFactory factory;

    public ApplicationService(DaoHelperFactory daoHelper) {
        this.factory = daoHelper;
    }

    public Optional<Application> getApplication(Integer id) throws ServiceException {
        try(DaoHelper daoHelper=factory.create()){
            ApplicationDao dao=daoHelper.createApplicationDao();
            return dao.selectExtendedApplicationById(id);
        }
        catch (DaoException e){
            throw new ServiceException(e,e.getMessage());
        }
    }

    public void updateSpecialization(Integer id, Integer specializationId) throws ServiceException {
        try(DaoHelper daoHelper=factory.create()){
            ApplicationDao dao=daoHelper.createApplicationDao();
            dao.updateSpecializationColumnById(id,specializationId);
        }
        catch (DaoException e){
            throw new ServiceException(e,e.getMessage());
        }
    }

    public List<Application> getApplicationList() throws ServiceException {
        try(DaoHelper daoHelper=factory.create()){
            ApplicationDao dao=daoHelper.createApplicationDao();
            return dao.findAll();
        }
        catch (DaoException e){
            throw new ServiceException(e,e.getMessage());
        }
    }

    public List<Application> getLimitedSpecifiedApplicationList(Integer specializationId, int page, int total) throws ServiceException {
        try(DaoHelper daoHelper=factory.create()){
            ApplicationDao dao=daoHelper.createApplicationDao();
            return dao.selectLimitedSpecifiedApplicationListBySpecificationId(specializationId,page,total);
        }
        catch (DaoException e){
            throw new ServiceException(e,e.getMessage());
        }
    }

    public void updateStatus(Integer applicationId, Boolean result) throws ServiceException {
        try(DaoHelper daoHelper=factory.create()){
            ApplicationDao dao=daoHelper.createApplicationDao();
            dao.updateSpecializationReportResultById(applicationId,result);
        }
        catch (DaoException e){
            throw new ServiceException(e,e.getMessage());
        }
    }

    public List<Application> getFullSpecifiedApplicationList(int specializationId) throws ServiceException {
        try(DaoHelper daoHelper=factory.create()){
            ApplicationDao dao=daoHelper.createApplicationDao();
            return dao.selectSpecifiedApplicationListBySpecificationId(specializationId);
        }
        catch (DaoException e){
            throw new ServiceException(e,e.getMessage());
        }
    }
}
