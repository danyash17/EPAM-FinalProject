package com.epam.web.service;


import com.epam.web.dao.*;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;

import static org.junit.Assert.*;

import com.epam.web.entity.Specialization;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class SpecializationServiceTest {
    private final Specialization
            SPECIALIZATION = new Specialization(1, "Java", 1,  3, "Desc");
    private final DaoHelperFactory FACTORY = Mockito.mock(DaoHelperFactory.class);
    private final DaoHelper DAO_HELPER = Mockito.mock(DaoHelper.class);
    private final SpecializationDao DAO = Mockito.mock(SpecializationDao.class);
    private final SpecializationService SERVICE = new SpecializationService(FACTORY);


    @Test
    public void testReturnNotNullSpecialization() throws ServiceException, DaoException {
        //given
        when(FACTORY.create()).thenReturn(DAO_HELPER);
        when(DAO_HELPER.createSpecializationDao()).thenReturn(DAO);
        when(DAO.selectSpecialization(anyInt())).thenReturn(Optional.of(SPECIALIZATION));
        //when
        Optional<Specialization> actual = SERVICE.getSpecialization(SPECIALIZATION.getId());
        //then
        assertNotNull(actual.get());
    }

    @Test
    public void testReturnNotNullSpecializationList() throws ServiceException, DaoException {
        //given
        when(FACTORY.create()).thenReturn(DAO_HELPER);
        when(DAO_HELPER.createSpecializationDao()).thenReturn(DAO);
        List<Specialization> specializations = new ArrayList<>();
        specializations.add(SPECIALIZATION);
        specializations.add(SPECIALIZATION);
        when(DAO.selectLimitedSpecializations(anyInt(),anyInt(),anyInt())).thenReturn(specializations);
        //when
        List<Specialization> actual = SERVICE.getLimitedSpecializations(1,1,3);
        //then
        assertNotNull(actual);
    }
}