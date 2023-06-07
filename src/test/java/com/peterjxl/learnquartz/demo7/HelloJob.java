package com.peterjxl.learnquartz.demo7;

import com.peterjxl.learnquartz.service.HelloSpringService;
import com.peterjxl.learnquartz.utils.DateFormatUtil;
import com.peterjxl.learnquartz.utils.SpringContextUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
public class HelloJob implements Job {

    HelloSpringService helloSpringService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        String className = StringUtils.uncapitalize(HelloSpringService.class.getSimpleName());
        helloSpringService = (HelloSpringService) SpringContextUtil.applicationContext.getBean(className);

        System.out.print("HelloJob.execute "
                + DateFormatUtil.format(new Date()) + " "
                + Thread.currentThread().getName()  + " ");

        System.out.println(helloSpringService);

    }
}
