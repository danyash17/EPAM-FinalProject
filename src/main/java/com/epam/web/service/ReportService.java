package com.epam.web.service;

import com.epam.web.comparator.ApplicationComparator;
import com.epam.web.dto.ReportDto;
import com.epam.web.entity.Application;

import java.util.*;

public class ReportService {
    public Optional<ReportDto> doCompetition(List<Application> applicationList, int plan, int page, int total, ApplicationComparator comparator) {
        if (!applicationList.isEmpty()) {
            Collections.sort(applicationList, comparator);
            Collections.reverse(applicationList);
            Map<Application, Boolean> applicationMap = new LinkedHashMap<Application, Boolean>();
            List<Boolean> results = new LinkedList<>();
            for (Application i : applicationList) {
                if (plan > 0) {
                    results.add(true);
                    plan--;
                } else {
                    results.add(false);
                }
            }
            for (int i = page; i < total && i < applicationList.size(); i++) {
                applicationMap.put(applicationList.get(i), results.get(i));
            }
            return Optional.of(new ReportDto(applicationMap));
        } else {
            return Optional.empty();
        }
    }
}
