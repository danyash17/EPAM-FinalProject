package com.epam.web.entity.image;

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
