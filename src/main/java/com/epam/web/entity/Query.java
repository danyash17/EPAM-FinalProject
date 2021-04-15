package com.epam.web.entity;

import java.util.Date;

public class Query implements Entity{
    private final Integer id;
    private final String city;
    private final Date birthday;
    private final String school;
    private final boolean medal;
    private final Integer specializationId;
    private final Integer firstExam;
    private final Integer secondExam;
    private final Integer thirdExam;
    private final Integer grade;
    private final String specialization;

    public Query(int id, String city, Date birthday, String school, boolean medal, Integer specializationId,String specialization, int firstExam, int secondExam, int thirdExam, int grade) {
        this.id = id;
        this.city = city;
        this.birthday = birthday;
        this.school = school;
        this.medal = medal;
        this.specializationId = specializationId;
        this.specialization=specialization;
        this.firstExam = firstExam;
        this.secondExam = secondExam;
        this.thirdExam = thirdExam;
        this.grade = grade;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getSchool() {
        return school;
    }

    public boolean hasMedal() {
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

    public String getSpecialization() {
        return specialization;
    }
}
