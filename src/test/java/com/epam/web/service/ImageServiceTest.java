package com.epam.web.service;

import com.epam.web.dao.*;
import com.epam.web.entity.Faculty;

import static org.junit.Assert.*;

import com.epam.web.entity.image.FacultyImage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class ImageServiceTest {
    private final FacultyImage IMAGE =new FacultyImage("faculty-not-found.png",0);
    private final DaoHelperFactory FACTORY = Mockito.mock(DaoHelperFactory.class);
    private final DaoHelper DAO_HELPER = Mockito.mock(DaoHelper.class);
    private final ImageDao<FacultyImage> DAO = Mockito.mock(ImageDao.class);
    private final ImageService SERVICE = new ImageService(FACTORY);
    @Test
    public void getLimitedFacultyImages() throws Exception, ServiceException {
        //given
        when(FACTORY.create()).thenReturn(DAO_HELPER);
        when(DAO_HELPER.createFacultyImageDao()).thenReturn(DAO);
        List<FacultyImage> images = new ArrayList<>();
        images.add(IMAGE);
        images.add(IMAGE);
        when(DAO.selectFacultyImages()).thenReturn(images);
        //when
        List<FacultyImage> actual = SERVICE.getFacultyImages();
        //then
        assertNotNull(actual);
    }

    @Test
    void getFacultyImage() throws Exception, ServiceException {
        //given
        when(FACTORY.create()).thenReturn(DAO_HELPER);
        when(DAO_HELPER.createFacultyImageDao()).thenReturn(DAO);
        when(DAO.selectSingleImage(anyInt())).thenReturn(Optional.of(IMAGE));
        //when
        Optional<FacultyImage> actual = SERVICE.getFacultyImage(0);
        //then
        assertNotNull(actual.get());
    }
}