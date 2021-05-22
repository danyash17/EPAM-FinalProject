package com.epam.web.service;

import com.epam.web.dao.ApplicationDao;
import com.epam.web.dao.DaoException;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.entity.Application;
import com.epam.web.entity.enums.SexEnum;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class ApplicationServiceTest {
    private final Application
            APPLICATION = new Application(1, "john", "doe", SexEnum.MALE, "Belarus", "Minsk", false, 1, 50, 50, 50, 50);
    private final DaoHelperFactory FACTORY = Mockito.mock(DaoHelperFactory.class);
    private final DaoHelper DAO_HELPER = Mockito.mock(DaoHelper.class);
    private final ApplicationDao DAO = Mockito.mock(ApplicationDao.class);
    private final ApplicationService SERVICE = new ApplicationService(FACTORY);


    @Test
    public void testReturnNotNullApplication() throws ServiceException, DaoException {
        //given
        when(FACTORY.create()).thenReturn(DAO_HELPER);
        when(DAO_HELPER.createApplicationDao()).thenReturn(DAO);
        when(DAO.selectExtendedApplicationById(anyInt())).thenReturn(Optional.of(APPLICATION));
        //when
        Optional<Application> actual = SERVICE.getApplication(APPLICATION.getId());
        //then
        assertNotNull(actual.get());
    }

    @Test
    public void testReturnNotNullApplicationList() throws ServiceException, DaoException {
        //given
        when(FACTORY.create()).thenReturn(DAO_HELPER);
        when(DAO_HELPER.createApplicationDao()).thenReturn(DAO);
        List<Application> applications = new ArrayList<>();
        applications.add(APPLICATION);
        applications.add(APPLICATION);
        when(DAO.findAll()).thenReturn(applications);
        //when
        List<Application> actual = SERVICE.getApplicationList();
        //then
        assertNotNull(actual);
    }
}