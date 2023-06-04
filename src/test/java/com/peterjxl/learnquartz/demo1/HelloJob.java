package com.peterjxl.learnquartz.demo1;

import com.peterjxl.learnquartz.utils.DateFormatUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import java.util.Date;

public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("HelloJob.execute "
                + DateFormatUtil.format(new Date()) + " "
                + Thread.currentThread().getName()  + " ");
    }
}
