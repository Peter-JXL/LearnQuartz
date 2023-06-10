package com.peterjxl.learnquartz.demo8;

import com.peterjxl.learnquartz.service.HelloSpringService;
import com.peterjxl.learnquartz.utils.DateFormatUtil;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import java.util.Date;
import java.util.StringJoiner;

public class SpringJob1 extends QuartzJobBean{

    @Autowired
    private HelloSpringService helloSpringService;

    @Override
    protected void executeInternal(JobExecutionContext context)  {
        StringJoiner outStr = new StringJoiner(" ")
                .add("HelloJob.execute ")
                .add(DateFormatUtil.format(new Date()))
                .add(Thread.currentThread().getName())
                .add(context.getTrigger().getKey().getName())
                .add(helloSpringService.helloSpring());

        System.out.println(outStr);

    }
}
