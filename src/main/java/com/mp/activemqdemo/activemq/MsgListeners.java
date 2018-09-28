package com.mp.activemqdemo.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
@EnableJms
public class MsgListeners {

    /**
     * 点对点
     * @return
     */
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("zh-queue");
    }

    /**
     * 发布/订阅
     * @return
     */
    @Bean
    public Topic topic(){
        return new ActiveMQTopic("zh-topic");
    }


    /**TODO
     *  * JmsListener注解默认只接收queue消息,如果要接收topic消息,需要设置containerFactory
     *  */
    @Bean
    public JmsListenerContainerFactory<?> topicListenerContainer(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory  topicListenerContainer = new DefaultJmsListenerContainerFactory();
        topicListenerContainer.setPubSubDomain(true);
        topicListenerContainer.setConnectionFactory(activeMQConnectionFactory);
        return topicListenerContainer;
    }


}
