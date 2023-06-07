package com.peterjxl.learnquartz.demo6;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

public class QuartzTest {
    public static void main(String[] args) {

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDetail job = JobBuilder.newJob(HelloJob.class)
                    .usingJobData("detail-key-1", "detail-key-1")
                    .usingJobData("hehe", "jobDetail-hehe")
                    .withIdentity("job1", "group1")
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .usingJobData("trigger-key-1", "trigger-key-1")
                    .usingJobData("hehe", "trigger-hehe")
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(1)
                            .repeatForever())
                    .build();

            scheduler.scheduleJob(job, trigger);
            TimeUnit.SECONDS.sleep(5);
            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}