package com.qatix.hello.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableScheduling //加了这个才可以运行
public class MyScheduledTasks {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final Logger log = LoggerFactory.getLogger(MyScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 5000) //单位毫秒
//    private void reportCurrentTime(){
//        log.info("The time is now {}",dateFormat.format(new Date()));
//    }

//    @Scheduled(fixedRate = 3000)
//    private void addToQueue(){
//        double rand = Math.random();
//        log.info("add numer {} to queue",rand);
//        redisTemplate.opsForList().leftPush("test-schedule-queue",String.valueOf(rand));
//    }
}
