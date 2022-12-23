package com.russel.crud_spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudSpringApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrudSpringApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringApplication.class, args);
            LOGGER.info("#############################################");
            LOGGER.info("CRUD PROJECT SPRING BOOT STARTED SUCCESSFULLY");
            LOGGER.info("##############################################");
    }

}
