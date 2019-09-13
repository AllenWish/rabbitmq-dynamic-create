package com.allenwhis.rabbitmq.dynamic.create.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerEndpoint;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @Title: 默认配置项
 * @Package: com.allenwhis.rabbitmq.dynamic.create.config
 * @Description:springboot2.0是个分界线，2.0以下setAdmin参数为rabbitAdmin，2.0及以上为AmqpAdmin
 * @author: AllenWhis
 * @date: 2019/9/13 11:07
 */
@Component
public class AmqpConfig {

    @Bean("defaultSimpleRabbitListener")
    public SimpleRabbitListenerEndpoint simpleRabbitListenerEndpoint(ConnectionFactory connectionFactory){
        SimpleRabbitListenerEndpoint simpleRabbitListenerEndpoint = new SimpleRabbitListenerEndpoint();
        simpleRabbitListenerEndpoint.setAdmin(rabbitAdmin(connectionFactory));
        return simpleRabbitListenerEndpoint;
    }

    @Bean
    public AmqpAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

}
