package com.epam.web.entity;

import com.epam.web.entity.enums.SexEnum;
import com.epam.web.entity.enums.UserRole;

public class User implements Entity {

    private Integer id;
    private final String login;
    private final String password;
    private String name;
    private String surname;
    private SexEnum sex;
    private UserRole role = UserRole.ENROLEE;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(Integer id, String login, String password, String name, String surname, SexEnum sex, UserRole role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.role = role;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public SexEnum getSex() {
        return sex;
    }

    public UserRole getRole() {
        return role;
    }
}
