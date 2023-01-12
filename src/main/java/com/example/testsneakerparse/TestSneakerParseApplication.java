package com.example.testsneakerparse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestSneakerParseApplication {
    static final Logger log =
            LoggerFactory.getLogger(TestSneakerParseApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TestSneakerParseApplication.class, args);

//        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");

        log.info("Before Starting application");
        SpringApplication.run(TestSneakerParseApplication.class, args);
        log.debug("Starting my application in debug with {} args", args.length);
        log.info("Starting my application with {} args.", args.length);
    }

}
