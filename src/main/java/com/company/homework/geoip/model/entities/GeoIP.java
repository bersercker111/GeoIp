package com.company.homework.geoip.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "geoip", schema = "", catalog = "mydb")
public class GeoIP {
    private Long id;
    private Long ipRangeStart;
    private Long ipRangeEnd;
    private String countryCode;
    private String countryName;
    private String regionName;
    private String cityName;
    private Double latitude;
    private Double longitude;

    protected GeoIP() {
    }

    public GeoIP(Long ipRangeStart, Long ipRangeEnd, String countryCode, String countryName, String regionName, String cityName, Double latitude, Double longitude) {
        this.ipRangeStart = ipRangeStart;
        this.ipRangeEnd = ipRangeEnd;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.regionName = regionName;
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_geoip")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ip_range_start")
    public Long getIpRangeStart() {
        return ipRangeStart;
    }

    public void setIpRangeStart(Long ipRangeStart) {
        this.ipRangeStart = ipRangeStart;
    }

    @Column(name = "ip_range_end")
    public Long getIpRangeEnd() {
        return ipRangeEnd;
    }

    public void setIpRangeEnd(Long ipRangeEnd) {
        this.ipRangeEnd = ipRangeEnd;
    }

    @Column(name = "country_code")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Column(name = "country_name")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Column(name = "region_name")
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Column(name = "latitude")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Column(name = "longitude")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
