package com.epam.web.entity;

public class User implements Entity {

    private Integer id;
    private String username;
    private String surname;
    private String password;
    private UserRole role = UserRole.ENROLEE;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String username,String surname,String login, String password, UserRole role) {
        this(username, password);
        this.id = id;
        this.surname=surname;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
