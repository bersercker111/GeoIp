package com.company.homework.geoip.model.json;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/* Data class that represents an object ready to be converter into json
* */
public class GeoIpInfo {
    private String canonicalIPv4Representation;
    private String cityName;
    private String countryCode;
    private String countryName;
    private Long IPv4;
    private Double latitude;
    private Double longitude;
    private String regionName;

    public GeoIpInfo() {
    }

    public GeoIpInfo(String canonicalIPv4Representation, String cityName, String countryCode,
                     String countryName, Long IPv4, Double latitude, Double longitude, String regionName) {
        this.canonicalIPv4Representation = canonicalIPv4Representation;
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.IPv4 = IPv4;
        this.latitude = latitude;
        this.longitude = longitude;
        this.regionName = regionName;
    }

    public String getCanonicalIPv4Representation() {
        return canonicalIPv4Representation;
    }

    public void setCanonicalIPv4Representation(String canonicalIPv4Representation) {
        this.canonicalIPv4Representation = canonicalIPv4Representation;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Long getIPv4() {
        return IPv4;
    }

    public void setIPv4(Long IPv4) {
        this.IPv4 = IPv4;
    }

    @JsonSerialize(using = JsonDoubleCoordsSerializer.class)
    public Double getLatitude() {
        return latitude;
    }

    @JsonSerialize(using = JsonDoubleCoordsSerializer.class)
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonSerialize(using = JsonDoubleCoordsSerializer.class)
    public Double getLongitude() {
        return longitude;
    }

    @JsonSerialize(using = JsonDoubleCoordsSerializer.class)
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}

