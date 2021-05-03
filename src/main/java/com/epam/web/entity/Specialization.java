package com.epam.web.entity;

public class Specialization implements Entity {
    private final Integer id;
    private final String specialization;
    private final Integer facultyId;
    private final Integer plan;
    private final String description;

    public Specialization(Integer id, String specialization, Integer facultyId, int plan, String description) {
        this.id = id;
        this.specialization = specialization;
        this.facultyId = facultyId;
        this.plan = plan;
        this.description = description;
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

    public String getDescription() { return description; }
}
