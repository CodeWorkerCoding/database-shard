package com.nchu.tech.database.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by fujianjian on 2017/7/13.
 */
@Slf4j
@Component
public class CommonTask {

    @Scheduled(cron = "0/2 * * * * ?")
    public void testSchedule() throws InterruptedException {
        log.info(" start test annonation test");

        Thread.sleep(10000);
        log.info("test annonation schedule");
    }

    //@Scheduled(cron = "0/2 * * * * ?")
    public void testSchedule2() throws InterruptedException {
        log.info(" start test annonation test-----");

        Thread.sleep(10000);
        log.info("test annonation schedule---------");
    }
}