package com.company.homework.geoip.services;

import com.company.homework.geoip.model.entities.GeoIP;
import com.company.homework.geoip.model.json.GeoIpInfo;
import com.company.homework.geoip.repositories.GeoIpRepository;
import com.company.homework.geoip.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GeoIpService {
    @Autowired
    private GeoIpRepository repository;

    /* returns json.GeoIpInfo object ready to be converted to json from String ipString (e.g 255.255.255.255)    *
    * */
    public GeoIpInfo getGeoIpFromLongIpForJson(String ipString) {

        Long longIp = Utils.ipStringToIpLong(ipString);
        List<GeoIP> geoIPEntities = repository.findDataInRangeSingle(longIp);
        if (geoIPEntities.size() > 1)
            throw new IllegalStateException("WTF, repository returned more than one result for findDataInRangeSingle query with longIp=" + longIp);
        GeoIpInfo geoIpInfo;
        if (geoIPEntities.isEmpty()) geoIpInfo = null;
        else geoIpInfo = geoIpEntityToGeoIpInfo(geoIPEntities.get(0), ipString, longIp);
        return geoIpInfo;

    }

    private GeoIpInfo geoIpEntityToGeoIpInfo(GeoIP geoIpEntity, String ipString, Long longIp) {

        return new GeoIpInfo(ipString, geoIpEntity.getCityName(), geoIpEntity.getCountryCode(), geoIpEntity.getCountryName(),
                longIp, geoIpEntity.getLatitude(), geoIpEntity.getLongitude(), geoIpEntity.getRegionName());


    }


}
