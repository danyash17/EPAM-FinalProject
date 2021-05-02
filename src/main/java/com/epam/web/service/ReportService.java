package com.epam.web.service;

import com.epam.web.comparator.ApplicationComparator;
import com.epam.web.entity.Application;
import com.epam.web.dto.ReportDto;

import java.util.*;

public class ReportService {
    private final ApplicationComparator comparator=new ApplicationComparator();

    public Optional<ReportDto> doCompetition(List<Application> applicationList, int plan) throws Exception, ServiceException {
        if(!applicationList.isEmpty()) {
            Collections.sort(applicationList,comparator);
            Collections.reverse(applicationList);
            Map<Application, Boolean> applicationMap = new LinkedHashMap<Application, Boolean>();
            for (Application i : applicationList) {
                if(plan>0){
                applicationMap.put(i,true);
                plan--;
            }
                else {
                applicationMap.put(i,false);
                }
            }
            return Optional.of(new ReportDto(applicationMap));
        }
        else {
            return Optional.empty();
        }
    }
}
