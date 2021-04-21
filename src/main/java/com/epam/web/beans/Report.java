package com.epam.web.beans;

import java.util.Map;

public class Report{
    private final Map<Query,Boolean> queryMap;

    public Report(Map<Query,Boolean> queryMap) {
        this.queryMap = queryMap;
    }

    public Map<Query,Boolean> getQueryMap() {
        return queryMap;
    }
}
