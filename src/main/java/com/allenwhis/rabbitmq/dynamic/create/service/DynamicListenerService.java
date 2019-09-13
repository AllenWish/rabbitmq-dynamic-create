package com.allenwhis.rabbitmq.dynamic.create.service;

import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerEndpoint;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @version V1.0
 * @Title:
 * @Package: com.allenwhis.rabbitmq.dynamic.create.service
 * @Description:动态实现监听
 * @author: AllenWhis
 * @date: 2019/9/13 11:13
 */
@Service
public class DynamicListenerService {
    @Autowired
    @Qualifier("defaultSimpleRabbitListener")
    private SimpleRabbitListenerEndpoint simpleRabbitListenerEndpoint;

    @Autowired
    private BeanFactory beanFactory;
    @Autowired
    private RabbitListenerEndpointRegistry rabbitListenerEndpointRegistry;

    /**
     * 实现动态监听队列
     * @param queueName
     * @param queue
     * @param messageListener
     * @param rabbitListenerContainerFactory
     */
    public void listener(String queueName, Queue queue, MessageListener messageListener, RabbitListenerContainerFactory rabbitListenerContainerFactory) {

        simpleRabbitListenerEndpoint.setMessageListener(messageListener);
        simpleRabbitListenerEndpoint.setBeanFactory(this.beanFactory);
        simpleRabbitListenerEndpoint.setQueues(queue);
        simpleRabbitListenerEndpoint.setId(queueName);
        this.rabbitListenerEndpointRegistry.registerListenerContainer(simpleRabbitListenerEndpoint, rabbitListenerContainerFactory, true);
    }

}
