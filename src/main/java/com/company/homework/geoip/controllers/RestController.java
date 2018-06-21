package com.company.homework.geoip.controllers;

import com.company.homework.geoip.model.json.GeoIpInfo;
import com.company.homework.geoip.services.GeoIpService;
import com.company.homework.geoip.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {

    @Autowired
    private GeoIpService geoIpService;

    @GetMapping("/geoip/{ip}")
    @ResponseBody
    public ResponseEntity<GeoIpInfo> getGeoIpInfo(@PathVariable(value = "ip", required = true) String ipString) {
        if (Utils.validateIpAddress(ipString)) {
            GeoIpInfo geoIpInfo = (geoIpService.getGeoIpFromLongIpForJson(ipString));
            if (null != geoIpInfo) return new ResponseEntity<>(geoIpInfo, HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}


