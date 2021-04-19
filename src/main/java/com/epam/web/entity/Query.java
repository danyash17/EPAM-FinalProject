package com.epam.web.entity;

import com.epam.web.comparator.QueryComparator;

import java.util.Date;
import java.util.Objects;

public class Query implements Entity{
    private final Integer id;
    private final String enroleeName;
    private final String entoleeSurname;
    private final SexEnum sexEnum;
    private final String country;
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

    public Query(int id,String enroleeName,String enroleeSurname,SexEnum sexEnum,String country, String city, Date birthday, String school, boolean medal, Integer specializationId,String specialization, int firstExam, int secondExam, int thirdExam, int grade) {
        this.id = id;
        this.enroleeName=enroleeName;
        this.entoleeSurname=enroleeSurname;
        this.sexEnum=sexEnum;
        this.country = country;
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

    public String getEnroleeName() {
        return enroleeName;
    }

    public String getEntoleeSurname() {
        return entoleeSurname;
    }

    public SexEnum getSexEnum() { return sexEnum; }

    public String getCountry() { return country; }

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

    public int getTotalGrade(){ return firstExam+secondExam+thirdExam+grade; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Query query = (Query) o;
        return medal == query.medal &&
                Objects.equals(id, query.id) &&
                Objects.equals(enroleeName, query.enroleeName) &&
                Objects.equals(entoleeSurname, query.entoleeSurname) &&
                sexEnum == query.sexEnum &&
                Objects.equals(country, query.country) &&
                Objects.equals(city, query.city) &&
                Objects.equals(birthday, query.birthday) &&
                Objects.equals(school, query.school) &&
                Objects.equals(specializationId, query.specializationId) &&
                Objects.equals(firstExam, query.firstExam) &&
                Objects.equals(secondExam, query.secondExam) &&
                Objects.equals(thirdExam, query.thirdExam) &&
                Objects.equals(grade, query.grade) &&
                Objects.equals(specialization, query.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, enroleeName, entoleeSurname, sexEnum, country, city, birthday, school, medal, specializationId, firstExam, secondExam, thirdExam, grade, specialization);
    }
}
