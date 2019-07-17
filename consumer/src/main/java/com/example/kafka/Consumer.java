package com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static Logger logger = Logger.getLogger(Consumer.class);


    @KafkaListener(topics = {"test-topic"})
    public void consumer(ConsumerRecord<Integer, String> record, Acknowledgment acknowledgment){
        System.out.println("消费者: {}" + record.offset());
        if (record.offset() < 190) {
            acknowledgment.acknowledge();
        }
    }
}
