package com.epam.web.entity;

public class Faculty implements Entity{
    private final Integer facultyId;
    private final String faculty;
    private final String firstExam;
    private final String secondExam;
    private final String thirdExam;
    private final String description;
    @Override
    public Integer getId() {
        return facultyId;
    }

    public Faculty(Integer facultyId, String faculty, String firstExam, String secondExam, String thirdExam, String description) {
        this.facultyId = facultyId;
        this.faculty = faculty;
        this.firstExam = firstExam;
        this.secondExam = secondExam;
        this.thirdExam = thirdExam;
        this.description = description;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getFirstExam() {
        return firstExam;
    }

    public String getSecondExam() {
        return secondExam;
    }

    public String getThirdExam() {
        return thirdExam;
    }

    public String getDescription() { return description; }
}
