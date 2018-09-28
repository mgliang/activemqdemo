package com.mp.activemqdemo.activemq.service.impl;

import com.mp.activemqdemo.activemq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    @Override
    public void sendMessage(Destination destination, String message) {

        jmsMessagingTemplate.convertAndSend(destination, message);
    }
    @JmsListener(destination = "return-queue", containerFactory="topicListenerContainer")
    public void Message(String message) {
        System.out.println("product收到参数了：" + message);
    }


}
