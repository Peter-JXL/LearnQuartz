package com.peterjxl.learnquartz.jobconfig;


import com.peterjxl.learnquartz.demo8.SpringJob1;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

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
                .build();
    }

}
