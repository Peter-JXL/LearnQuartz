package com.peterjxl.learnquartz.jobconfig;


import com.peterjxl.learnquartz.demo8.SpringJob1;
import org.quartz.*;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JobConfig {

    @Bean
    @QuartzDataSource
    public DataSource quartzDataSource(){
        return new DriverManagerDataSource("jdbc:mysql://localhost:3306/learnQuartz?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC",
                "learnQuartzUser",
                "learnQuartzPassword");
    }

    @Bean
    public JobDetail springJobDetail(){
        return JobBuilder.newJob(SpringJob1.class)
                .withIdentity("springJob1Detail")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger springJobTrigger(){
        return TriggerBuilder.newTrigger()
                .forJob("springJob1Detail")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();
    }

}
