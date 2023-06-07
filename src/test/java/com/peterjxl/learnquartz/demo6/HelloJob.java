package com.peterjxl.learnquartz.demo6;

import com.peterjxl.learnquartz.utils.DateFormatUtil;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;

import java.util.Date;

public class HelloJob implements Job {


    private String hehe;

    public void setHehe(String hehe) {
        this.hehe = hehe;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {

        System.out.print("HelloJob.execute "
                + DateFormatUtil.format(new Date()) + " "
                + Thread.currentThread().getName()  + " ");

        System.out.println("hehe: " + hehe);
    }
}
