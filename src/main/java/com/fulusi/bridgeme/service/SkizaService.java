package com.fulusi.bridgeme.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fulusi.bridgeme.constant.Queue;

@Service
public class SkizaService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void queueSms(String mobile, String text, String senderId, String payload) throws Exception{
        HashMap <String, String> data  = new HashMap<>();
        data.put("senderId", senderId);
        data.put("text", text);
        data.put("mobile", mobile);
        Message queue = new Message(payload.getBytes("UTF-8"));
        rabbitTemplate.convertAndSend(Queue.SKIZA_SMS, queue);
    }
}