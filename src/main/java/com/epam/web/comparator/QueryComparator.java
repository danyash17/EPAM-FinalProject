package com.epam.web.comparator;

import com.epam.web.entity.Query;

import java.util.Comparator;

public class QueryComparator implements Comparator<Query> {
    @Override
    public int compare(Query first, Query second) {
        Integer firstGrade=first.getTotalGrade();
        Integer secondGrade=second.getTotalGrade();
        if(firstGrade!=secondGrade){
            return firstGrade.compareTo(secondGrade);
        }
        else {
            Boolean firstMedal=first.hasMedal();
            Boolean secondMedal=second.hasMedal();
            return firstMedal.compareTo(secondMedal);
        }
    }
}
