package com.mp.activemqdemo.activemq.service.impl;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
@Service
public class Consumer {

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "zh-queue")
    public void Message(String message) {
        System.out.println("Consumer收到：" + message);
    }

}
