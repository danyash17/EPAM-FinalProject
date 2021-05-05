package com.epam.web.service;


import com.epam.web.dao.*;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.entity.enums.SexEnum;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import com.epam.web.entity.User;
import com.epam.web.entity.enums.UserRole;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
public class UserServiceTest {
    private final User
            USER = new User(1,"johndoe","johndoe","John","Doe",SexEnum.MALE, UserRole.ENROLEE);
    private final DaoHelperFactory FACTORY = Mockito.mock(DaoHelperFactory.class);
    private final DaoHelper DAO_HELPER = Mockito.mock(DaoHelper.class);
    private final UserDao DAO = Mockito.mock(UserDao.class);
    private final UserService SERVICE = new UserService(FACTORY);
    @Test
    public void testLogin() throws ServiceException, DaoException {
        //given
        when(FACTORY.create()).thenReturn(DAO_HELPER);
        when(DAO_HELPER.createUserDao()).thenReturn(DAO);
        when(DAO.findUserByLoginAndPassword(anyString(),anyString())).thenReturn(Optional.of(USER));
        //when
        Optional<User> actual = SERVICE.login(USER.getLogin(),USER.getPassword());
        //then
        assertNotNull(actual.get());
    }
}