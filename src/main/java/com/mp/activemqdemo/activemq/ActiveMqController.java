package com.mp.activemqdemo.activemq;

import com.mp.activemqdemo.activemq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Topic;
import javax.jms.Queue;

@RestController
@RequestMapping("/activeMq")
public class ActiveMqController {

    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;
    @Autowired
    private ProductService productService;
    @GetMapping("/queue/{msg}")
    public void sendQueue(@PathVariable("msg") String msg) {
        productService.sendMessage(this.queue, msg);
    }
    @GetMapping("/topic/{msg}")
    public void sendTopic(@PathVariable("msg") String msg) {
        productService.sendMessage(this.topic, msg);
    }











}
