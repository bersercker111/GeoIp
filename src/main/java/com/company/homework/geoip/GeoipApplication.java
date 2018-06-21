package com.company.homework.geoip;

import com.company.homework.geoip.util.FileInput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;


@SpringBootApplication(scanBasePackages = {"com.company.homework.geoip"})
public class GeoipApplication {
    /*If path to .csv file is present in the args, loads data form it into the db
    * */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(GeoipApplication.class, args);
        if (args.length > 0 && args[0] != null && !(args[0].isEmpty()) && !args[0].contains("--spring.output.ansi.enabled=always")) {
            FileInput fileInput = context.getBean(FileInput.class);

            try {
                fileInput.loadFromCsvFile(args[0]);
            } catch (IOException e) {
                System.out.println("Unable to load data from file " + args[0]);
                e.printStackTrace();
            }

        }
    }
}


