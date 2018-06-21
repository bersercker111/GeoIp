package com.company.homework.geoip.util;


import java.util.regex.Pattern;

public class Utils {
    private static final String VALID_IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    private static final Pattern validIpAdressPattern = Pattern.compile(VALID_IPADDRESS_PATTERN);


    public static boolean validateIpAddress(String ip) {
        return validIpAdressPattern.matcher(ip).matches();
    }

    /*
  * Code taken from FAQ at https://lite.ip2location.com/faqs
* */
    public static long ipStringToIpLong(String ipString) {
        String[] ipAddressInArray = ipString.split("\\.");
        long result = 0;
        long ip = 0;
        for (int x = 3; x >= 0; x--) {
            ip = Long.parseLong(ipAddressInArray[3 - x]);
            result |= ip << (x << 3);
        }
        return result;
    }
}
