package com.qatix.hello.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//
@RestController
@RequestMapping("/kafka")
public class KafkaController {
    public static Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

//    private final CountDownLatch latch = new CountDownLatch(3);

    @RequestMapping("/send")
    public String sendMsg(@RequestParam String msg){
        this.kafkaTemplate.send("myTopic",msg);
        return "sent [" + msg + "] to myTopic";
    }

    @KafkaListener(topics = "myTopic")
    public void listen(ConsumerRecord<?,?> cr) throws Exception{
        logger.info(cr.toString());
//        latch.countDown();
        logger.info("Receive msg:[" + cr.topic() + "]:" + cr.value());
    }
}
