package com.peterjxl.learnquartz.jobconfig;

import org.quartz.*;
import com.peterjxl.learnquartz.demo8.SpringJob1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

//@Component
public class JobInit {

    @Autowired
    public Scheduler scheduler;

    @PostConstruct
    public void initJob() throws SchedulerException{
        JobDetail detail = JobBuilder.newJob(SpringJob1.class).build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .build();

        scheduler.scheduleJob(detail, trigger);
    }
}
