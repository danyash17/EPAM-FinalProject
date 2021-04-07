package com.epam.web.entity;

import java.util.Date;

public class Query implements Entity{
    private Integer id;
    private String city;
    private Date birthday;
    private String school;
    private boolean medal;
    private Integer specializationId;
    private Integer firstExam;
    private Integer secondExam;
    private Integer thirdExam;
    private Integer grade;

    public Query(int id, String city, Date birthday, String school, boolean medal, Integer specializationId, int firstExam, int secondExam, int thirdExam, int grade) {
        this.id = id;
        this.city = city;
        this.birthday = birthday;
        this.school = school;
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
}
