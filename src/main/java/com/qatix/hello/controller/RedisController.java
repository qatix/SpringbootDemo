package com.qatix.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {

//    private static final Logger LOGGER = LoggerFactory.getLogger(HelloApplication.class);
//
//    @Bean
//    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
//                                            MessageListenerAdapter listenerAdapter){
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.addMessageListener(listenerAdapter,new PatternTopic("chat"));
//        return container;
//    }
//
//    @Bean
//    MessageListenerAdapter listenerAdapter(Receiver receiver){
//        return new MessageListenerAdapter(receiver,"receiveMessage");
//    }
//
//    @Bean
//    Receiver receiver(CountDownLatch latch){
//        return new Receiver(latch);
//    }
//
//    @Bean
//    CountDownLatch latch(){
//        return new CountDownLatch(1);
//    }
//
//    @Bean
//    StringRedisTemplate template(RedisConnectionFactory connectionFactory){
//        return new StringRedisTemplate(connectionFactory);
//    }

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/set")
    public String testSet(@RequestParam(value = "msg") String msg) {

        String key = "test-java-key";
        boolean isExist = redisTemplate.hasKey(key);
        if (isExist) {
            return "is existed:" + redisTemplate.opsForValue().get(key);
        } else {
            redisTemplate.opsForValue().set(key, msg, 60, TimeUnit.SECONDS);
            return "not exist,set";
        }
    }

    @RequestMapping("/get")
    public String testGet() {
        String key = "test-java-key";
        return String.format("res:%s", redisTemplate.opsForValue().get(key));
    }

    @RequestMapping("/lpush")
    public String testLpush(@RequestParam(value = "msg") String msg) {
        String key = "test-java-key-arr";
        redisTemplate.opsForList().leftPush(key,msg);
        return "added:[" + msg + "]to queue " + key;
    }

    @RequestMapping("/lpop")
    public String testLpop() {
        String key = "test-java-key-arr";
        String value = redisTemplate.opsForList().leftPop(key);
        return "pop from queue:[" + value + "]";
    }

}
