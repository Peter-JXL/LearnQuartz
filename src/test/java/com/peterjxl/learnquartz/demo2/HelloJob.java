package com.peterjxl.learnquartz.demo2;

import com.peterjxl.learnquartz.utils.DateFormatUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;
import java.util.StringJoiner;

public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        StringJoiner outStr = new StringJoiner(" ")
                .add("HelloJob.execute ")
                .add(DateFormatUtil.format(new Date()))
                .add(" ")
                .add(Thread.currentThread().getName())
                .add(" ")
                .add(jobExecutionContext.getTrigger().getKey().getName());

        System.out.println(outStr);
    }
}
