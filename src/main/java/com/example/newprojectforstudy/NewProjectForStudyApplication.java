package com.example.newprojectforstudy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@Slf4j
public class NewProjectForStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewProjectForStudyApplication.class, args);
        log.info("start!!!!!!!");
    }

}