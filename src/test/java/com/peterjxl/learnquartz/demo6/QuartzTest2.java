package com.peterjxl.learnquartz.demo6;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest2 {
    public static void main(String[] args) {

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            System.out.println("instanceName: " + scheduler.getSchedulerName());   //instanceName
            System.out.println("线程个数: " + scheduler.getMetaData().getThreadPoolSize());  //线程池大小

            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}