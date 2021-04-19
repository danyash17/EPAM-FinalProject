package com.epam.web.entity;

public class Specialization implements Entity {
    private Integer id;
    private String specialization;
    private Integer facultyId;
    private Integer plan;

    public Specialization(int id, String specialization, Integer facultyId, int plan) {
        this.id = id;
        this.specialization = specialization;
        this.facultyId = facultyId;
        this.plan = plan;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public Integer getPlan() {
        return plan;
    }
}
