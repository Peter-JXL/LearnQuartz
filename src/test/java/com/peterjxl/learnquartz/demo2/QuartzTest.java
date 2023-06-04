package com.peterjxl.learnquartz.demo2;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

public class QuartzTest {
    public static void main(String[] args) {

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDetail job = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(1)
                            .repeatForever())
                    .build();

            Trigger trigger2 = TriggerBuilder.newTrigger()
                    .withIdentity("trigger2", "group2")
                    .forJob("job1", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(3)
                            .repeatForever())
                    .build();

            scheduler.scheduleJob(job, trigger);
            scheduler.scheduleJob(trigger2);



            TimeUnit.SECONDS.sleep(3);
            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}