package com.epam.web.service;

import com.epam.web.comparator.QueryComparator;
import com.epam.web.dao.DaoException;
import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.dao.QueryDaoImplement;
import com.epam.web.entity.Query;
import com.epam.web.entity.Report;

import java.util.*;

public class ReportService {
    private final QueryComparator comparator=new QueryComparator();

    public Optional<Report> doCompetition(List<Query> queryList,int plan) throws Exception, ServiceException {
        if(!queryList.isEmpty()) {
            Collections.sort(queryList,comparator);
            Collections.reverse(queryList);
            Map<Query, Boolean> queryMap = new HashMap<Query, Boolean>();
            for (Query i : queryList) {
                if(plan>0){
                queryMap.put(i,true);
                plan--;
            }
                else {
                queryMap.put(i,false);
                }
            }
            Map<Query, Boolean> sortedQueryMap = new TreeMap<Query, Boolean>(new QueryComparator().reversed());
            sortedQueryMap.putAll(queryMap);
            return Optional.of(new Report(sortedQueryMap));
        }
        else {
            return Optional.empty();
        }
    }
}
