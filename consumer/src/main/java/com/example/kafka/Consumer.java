package com.example.kafka;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static Logger logger = Logger.getLogger(Consumer.class);


    @KafkaListener(topics = {"test-topic"})
    public void consumer(String message){
        System.out.println("消费者: {}"+ message);
    }
}
