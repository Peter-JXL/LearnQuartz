package com.peterjxl.learnquartz.demo4;

import org.junit.jupiter.api.Test;
import org.springframework.scheduling.support.CronExpression;

public class TestCron {

    @Test
    public void testCron() {
        CronExpression.isValidExpression("* * * * * ? *");
    }
}
