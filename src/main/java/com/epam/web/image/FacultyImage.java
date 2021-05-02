package com.epam.web.image;

import com.epam.web.entity.Entity;

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
