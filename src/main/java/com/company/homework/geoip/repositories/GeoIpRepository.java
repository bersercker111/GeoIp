package com.company.homework.geoip.repositories;

import com.company.homework.geoip.model.entities.GeoIP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GeoIpRepository extends JpaRepository<GeoIP, Long> {

    /*    SELECT * FROM geoip WHERE
            ip_range_start = (SELECT MAX(ip_range_start) FROM geoip WHERE ip_range_start <= ? )
          AND
            ip_range_end = (SELECT MIN(ip_range_end) FROM geoip WHERE ip_range_end >= ? );

            Should return a single result, making sure it is so at a later stage.
            */
    @Query("select g from GeoIP g where g.ipRangeStart=(select max(g.ipRangeStart) from GeoIP g where g.ipRangeStart <=:longIp)" +
            "AND g.ipRangeEnd=(select MIN(g.ipRangeEnd) from GeoIP g where g.ipRangeEnd >= :longIp)")

    public List<GeoIP> findDataInRangeSingle(@Param("longIp") Long longIp);
}
