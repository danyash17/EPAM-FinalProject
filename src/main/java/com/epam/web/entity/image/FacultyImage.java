package com.epam.web.entity.image;

public class FacultyImage extends Image{
    private final Integer facultyId;

    public FacultyImage(String path, Integer facultyId) {
        super(path);
        this.facultyId = facultyId;
    }

    @Override
    public Integer getId() {
        return facultyId;
    }
}
