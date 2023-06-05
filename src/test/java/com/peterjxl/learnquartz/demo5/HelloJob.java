package com.peterjxl.learnquartz.demo5;

import com.peterjxl.learnquartz.utils.DateFormatUtil;
import org.quartz.*;
import java.util.Date;

public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {

        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        String detailKey1 = jobDetail.getJobDataMap().getString("detail-key-1");

        Trigger trigger = jobExecutionContext.getTrigger();
        String triggerKey1 = trigger.getJobDataMap().getString("trigger-key-1");

        System.out.print("HelloJob.execute "
                + DateFormatUtil.format(new Date()) + " "
                + Thread.currentThread().getName()  + " ");
        System.out.print("detail-key-1: " + detailKey1);
        System.out.println("  trigger-key-1: " + triggerKey1);

        System.out.println("hehe: " + jobExecutionContext.getMergedJobDataMap().get("hehe"));
    }
}
