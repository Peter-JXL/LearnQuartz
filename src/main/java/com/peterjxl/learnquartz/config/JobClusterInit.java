package com.peterjxl.learnquartz.config;


import com.peterjxl.learnquartz.demo8.SpringJob1;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JobClusterInit {

    @Autowired
    public Scheduler scheduler;
    @PostConstruct
    public void init() throws SchedulerException {
        System.out.println("JobClusterInit init");
        startSpringJob("job-1", "trigger-1");
        startSpringJob("job-2", "trigger-2");
        startSpringJob("job-3", "trigger-3");
    }

    private void startSpringJob(String jobName, String triggerName) throws SchedulerException{
        JobDetail detail = JobBuilder.newJob(SpringJob1.class)
                .withIdentity(jobName)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName)
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
                .build();
        scheduler.scheduleJob(detail, trigger);
    }
}
