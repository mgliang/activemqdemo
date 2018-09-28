package com.mp.activemqdemo.activemq.service.impl;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class QueueConsumer {

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "zh-topic", containerFactory="topicListenerContainer")
    //会将接收到的消息发送到指定的路由目的地，所有订阅该消息的用户都能收到，属于广播。
    @SendTo("return-queue")
    public String receiveQueue(String text) {
        System.out.println("Consumer2收到:"+text);
        return "Consumer2收到!";
    }


    /**
     * @SendToUser

    消息目的地有UserDestinationMessageHandler来处理，会将消息路由到发送者对应的目的地。
    默认该注解前缀为/user。如：用户订阅/user/hi ，
    在@SendToUser('/hi')查找目的地时，会将目的地的转化为/user/{name}/hi,
    这个name就是principal的name值，该操作是认为用户登录并且授权认证，
    使用principal的name作为目的地标识。发给消息来源的那个用户。
    （就是谁请求给谁，不会发给所有用户，区分就是依照principal-name来区分的)。
    此外该注解还有个broadcast属性，表明是否广播。就是当有同一个用户登录多个session时，
    是否都能收到。取值true/false.

     */

}
