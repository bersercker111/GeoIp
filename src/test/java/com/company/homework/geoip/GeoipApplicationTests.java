package com.company.homework.geoip;

import com.company.homework.geoip.repositories.GeoIpRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GeoipApplicationTests {
    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
    }

    @Test
    public void TestRepositorySpeedForFindInRangeQuery() {
        GeoIpRepository repository = context.getBean(GeoIpRepository.class);
        long executionTime = System.currentTimeMillis();
        repository.findDataInRangeSingle(1677731654L);
        executionTime = System.currentTimeMillis() - executionTime;
        System.out.println("Execution time: " + executionTime + " ms.");
        assertTrue(executionTime <= 100000);


    }

}
