package com.epam.web.entity;

import com.epam.web.entity.enums.SexEnum;

import java.util.Objects;

public class Application implements Entity {
    private final Integer id;
    private final String name;
    private final String surname;
    private final SexEnum sex;
    private final String country;
    private final String city;
    private final Boolean medal;
    private final Integer specializationId;
    private final Integer firstExam;
    private final Integer secondExam;
    private final Integer thirdExam;
    private final Integer grade;

    public Application(Integer id, String name, String surname, SexEnum sex, String country, String city, Boolean medal, Integer specializationId, int firstExam, int secondExam, int thirdExam, int grade) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.country = country;
        this.city = city;
        this.medal = medal;
        this.specializationId = specializationId;
        this.firstExam = firstExam;
        this.secondExam = secondExam;
        this.thirdExam = thirdExam;
        this.grade = grade;
    }

    @Override
    public Integer getId() {
        return id;
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

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Boolean getMedal() {
        return medal;
    }

    public Integer getSpecializationId() {
        return specializationId;
    }

    public int getFirstExam() {
        return firstExam;
    }

    public int getSecondExam() {
        return secondExam;
    }

    public int getThirdExam() {
        return thirdExam;
    }

    public int getGrade() {
        return grade;
    }

    public int getTotalGrade() {
        return firstExam + secondExam + thirdExam + grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Application application = (Application) o;
        return medal == application.medal &&
                Objects.equals(id, application.id) &&
                Objects.equals(name, application.name) &&
                Objects.equals(surname, application.surname) &&
                sex == application.sex &&
                Objects.equals(country, application.country) &&
                Objects.equals(city, application.city) &&
                Objects.equals(specializationId, application.specializationId) &&
                Objects.equals(firstExam, application.firstExam) &&
                Objects.equals(secondExam, application.secondExam) &&
                Objects.equals(thirdExam, application.thirdExam) &&
                Objects.equals(grade, application.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, sex, country, city, medal, specializationId, firstExam, secondExam, thirdExam, grade);
    }
}
