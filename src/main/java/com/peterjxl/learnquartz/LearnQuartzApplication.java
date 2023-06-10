package com.peterjxl.learnquartz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class LearnQuartzApplication {

    @Value("${spring.quartz.properties.org.quartz.scheduler.instanceId}")
    private String instanceId;

    @PostConstruct
    public void init() {
        System.out.println("instanceId: " + instanceId);
    }

    public static void main(String[] args) {
        SpringApplication.run(LearnQuartzApplication.class, args);
    }

}
