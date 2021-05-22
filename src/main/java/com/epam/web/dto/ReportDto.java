package com.epam.web.dto;

import com.epam.web.entity.Application;

import java.util.Map;

public class ReportDto {
    private final Map<Application, Boolean> applicationMap;

    public ReportDto(Map<Application, Boolean> applicationMap) {
        this.applicationMap = applicationMap;
    }

    public Map<Application, Boolean> getApplicationMap() {
        return applicationMap;
    }
}
