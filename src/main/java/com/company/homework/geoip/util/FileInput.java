package com.company.homework.geoip.util;

import com.company.homework.geoip.model.entities.GeoIP;
import com.company.homework.geoip.repositories.GeoIpRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FileInput {

    private final Logger logger = LoggerFactory.getLogger(FileInput.class);
    @Autowired
    private GeoIpRepository repository;

    public void loadFromCsvFile(String path) {
        try (Stream<String> lineStream = Files.lines(Paths.get(path))) {
            lineStream.map(this::csvLineToGeoIpEntity)
                    .forEach(repository::save);
            logger.info("File loading done");
        } catch (IOException | InvalidPathException e) {
            logger.error("Unable to load data from file " + path);
        } catch (DataIntegrityViolationException ex) {
            logger.info("Duplicate data in file, stopped loading data.");
        }

    }

    private GeoIP csvLineToGeoIpEntity(String line) {

        String[] values = line.split("\",\"");
        for (int i = 0; i < values.length; i++) values[i] = values[i].replaceAll("\"", "");
        Long startRange = Long.parseLong(values[0]);
        Long endRange = Long.parseLong(values[1]);
        String stateCode = values[2];
        String state = values[3];
        String region = values[4];
        String city = values[5];
        Double latitude = Double.parseDouble(values[6]);
        Double longitude = Double.parseDouble(values[7]);
        return new GeoIP(startRange, endRange, stateCode, state, region, city, latitude, longitude);
    }
}
