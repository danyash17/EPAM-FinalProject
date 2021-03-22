package com.epam.web.service;

import com.epam.web.entity.User;

import java.util.Optional;

public class UserService {
    public Optional<User> login (String user, String password){
        return "admin".equals(user)&&"admin".equals(password)?
                Optional.of(new User("Daniil")):
                Optional.empty();
    }
}
