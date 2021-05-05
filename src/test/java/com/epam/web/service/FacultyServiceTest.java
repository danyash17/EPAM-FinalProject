package com.epam.web.service;


import com.epam.web.dao.DaoException;
import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.dao.FacultyDao;
import com.epam.web.entity.Faculty;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class FacultyServiceTest {
    private final Faculty
            FACULTY = new Faculty(1, "Development", "Math",  "Physics", "English", "For developers");
    private final DaoHelperFactory FACTORY = Mockito.mock(DaoHelperFactory.class);
    private final DaoHelper DAO_HELPER = Mockito.mock(DaoHelper.class);
    private final FacultyDao DAO = Mockito.mock(FacultyDao.class);
    private final FacultyService SERVICE = new FacultyService(FACTORY);


    @Test
    public void testReturnNotNullFaculty() throws ServiceException, DaoException {
        //given
        when(FACTORY.create()).thenReturn(DAO_HELPER);
        when(DAO_HELPER.createFacultyDao()).thenReturn(DAO);
        when(DAO.selectFacultyById(anyInt())).thenReturn(Optional.of(FACULTY));
        //when
        Optional<Faculty> actual = SERVICE.getFaculty(FACULTY.getId());
        //then
        assertNotNull(actual.get());
    }

    @Test
    public void testReturnNotNullFacultyList() throws ServiceException, DaoException {
        //given
        when(FACTORY.create()).thenReturn(DAO_HELPER);
        when(DAO_HELPER.createFacultyDao()).thenReturn(DAO);
        List<Faculty> applications = new ArrayList<>();
        applications.add(FACULTY);
        applications.add(FACULTY);
        when(DAO.selectLimitedFaculties(anyInt(),anyInt())).thenReturn(applications);
        //when
        List<Faculty> actual = SERVICE.getLimitedFaculties(1,3);
        //then
        assertNotNull(actual);
    }
}