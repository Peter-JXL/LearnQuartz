package com.peterjxl.learnquartz.demo3;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.util.concurrent.TimeUnit;

public class QuartzTest2 {
    public static void main(String[] args) {

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();


            JobDetail job = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("job", "group1")
                    .storeDurably()
                    .build();


            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger", "group1")
                    .forJob("job", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(3)
                            .repeatForever())
                    .build();

            scheduler.addJob(job, true);
            scheduler.scheduleJob(trigger);

            TimeUnit.SECONDS.sleep(3);
            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}