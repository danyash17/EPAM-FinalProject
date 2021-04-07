package com.epam.web.entity;

public class Specialization implements Entity {
    private Integer id;
    private String specialization;
    private Faculty faculty;
    private Integer plan;

    public Specialization(int id, String specialization, Faculty faculty, int plan) {
        this.id = id;
        this.specialization = specialization;
        this.faculty = faculty;
        this.plan = plan;
    }

    @Override
    public Integer getId() {
        return null;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public int getPlan() {
        return plan;
    }
}
