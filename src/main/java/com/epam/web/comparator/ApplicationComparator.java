package com.epam.web.comparator;

import com.epam.web.entity.Application;

import java.util.Comparator;

public class ApplicationComparator implements Comparator<Application> {
    @Override
    public int compare(Application first, Application second) {
        Integer firstGrade = first.getTotalGrade();
        Integer secondGrade = second.getTotalGrade();
        if (!firstGrade.equals(secondGrade)) {
            return firstGrade.compareTo(secondGrade);
        } else {
            Boolean firstMedal = first.getMedal();
            Boolean secondMedal = second.getMedal();
            return firstMedal.compareTo(secondMedal);
        }
    }
}
