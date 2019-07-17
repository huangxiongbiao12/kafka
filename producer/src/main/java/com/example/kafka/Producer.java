package com.example.kafka;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Producer {

    private static Logger logger = Logger.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<?, String> kafkaTemplate;

    @Scheduled(fixedDelay = 1000)
    public void send() {
        System.out.println("生产者 :{}"+
                "gaha_hero" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        kafkaTemplate.send("test-topic",
                "gaha_hero" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        //send参数 1：topic,2:key,3:参数
        // 默认情况下，Kafka根据传递消息的key来进行分区的分配，即hash(key) % numPartitions,没有指定key就随机分配一个分区
    }

}
