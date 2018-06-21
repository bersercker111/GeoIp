package com.company.homework.geoip.utils;

import com.company.homework.geoip.util.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsTests {
    @Test
    public void validateIpAddressTest() {
        String[] validIpAddresses = {"1.1.1.1", "255.255.255.255", "192.168.1.1",
                "10.10.1.1", "132.254.111.10", "26.10.2.10", "127.0.0.1"};
        String[] invalidIpAddresses = {"10.10.10", "10.10", "10", "a.a.a.a", "10.0.0.a",
                "10.10.10.256", "222.222.2.999", "999.10.10.20", "2222.22.22.22", "22.2222.22.2"};
        for (String s : validIpAddresses) assertTrue(Utils.validateIpAddress(s));
        for (String s : invalidIpAddresses) assertFalse(Utils.validateIpAddress(s));
    }
}
