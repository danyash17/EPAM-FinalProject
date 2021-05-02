package com.epam.web.image;

import com.epam.web.entity.Entity;

public class SpecializationImage extends Image{
    private final Integer specializationId;

    public SpecializationImage(String path,Integer specializationId) {
        super(path);
        this.specializationId = specializationId;
    }

    @Override
    public Integer getId() {
        return specializationId;
    }
}
