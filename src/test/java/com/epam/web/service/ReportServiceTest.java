package com.epam.web.service;

import com.epam.web.comparator.ApplicationComparator;
import com.epam.web.dto.ReportDto;
import com.epam.web.entity.Application;

import com.epam.web.entity.enums.SexEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ReportServiceTest {
    private final Application BEST_APPLICATION = new Application(1, "best", "best", SexEnum.MALE, "example", "example", false, 1, 100, 100, 100, 100);
    private final Application MIDDLE_APPLICATION = new Application(1, "middle", "middle", SexEnum.MALE, "example", "example", false, 1, 50, 50, 50, 50);
    private final Application WORST_APPLICATION = new Application(1, "worst", "worst", SexEnum.MALE, "example", "example", false, 1, 5, 5, 5, 5);
    private final List<Application> INPUT_LIST = new ArrayList<>(Arrays.asList(MIDDLE_APPLICATION, BEST_APPLICATION, WORST_APPLICATION));
    private final Map<Application, Boolean> EXPECTED_MAP = new LinkedHashMap<>() {{
        put(BEST_APPLICATION, true);
        put(MIDDLE_APPLICATION, false);
        put(WORST_APPLICATION, false);
    }};
    private final int PLAN = 1;

    @Test
    public void testCompetition() {
        //given
        ReportService service = new ReportService();
        //when
        Optional<ReportDto> actual = service.doCompetition(INPUT_LIST, PLAN,0,INPUT_LIST.size(), new ApplicationComparator());
        LinkedHashMap<Application,Boolean> actualMap= (LinkedHashMap<Application, Boolean>) actual.get().getApplicationMap();
        Assert.assertNotNull(actualMap);
        Assert.assertEquals(actualMap.size(), EXPECTED_MAP.size());
        Assert.assertTrue(actualMap.keySet().containsAll(EXPECTED_MAP.keySet()));
        actualMap.keySet().stream().forEach((key) -> {
            Assert.assertEquals(actualMap.get(key), EXPECTED_MAP.get(key));
        });
    }
}