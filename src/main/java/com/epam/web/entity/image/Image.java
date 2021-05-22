package com.epam.web.entity.image;

import com.epam.web.entity.Entity;

public abstract class Image implements Entity {
    private String path;

    public Image(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
