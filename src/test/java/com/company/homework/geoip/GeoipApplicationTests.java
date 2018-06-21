package com.company.homework.geoip;

import com.company.homework.geoip.repositories.GeoIpRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GeoipApplicationTests {
    private final Logger logger = LoggerFactory.getLogger(GeoipApplication.class);
    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
    }

    @Test
    public void TestRepositorySpeedForFindInRangeQuery() {
        GeoIpRepository repository = context.getBean(GeoIpRepository.class);
        long executionTime = System.currentTimeMillis();
        /*should get the last record in table - highest execution time with certain indices */
        repository.findDataInRangeSingle(2147483646L);
        executionTime = System.currentTimeMillis() - executionTime;
        logger.info("Execution time: " + executionTime + " ms.");
        assertTrue(executionTime <= 100);

    }

}
