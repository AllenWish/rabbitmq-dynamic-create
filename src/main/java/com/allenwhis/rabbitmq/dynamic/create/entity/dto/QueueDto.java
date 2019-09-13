package com.allenwhis.rabbitmq.dynamic.create.entity.dto;

import lombok.Data;

/**
 * @version V1.0
 * @Title:
 * @Package: com.allenwhis.rabbitmq.dynamic.create.entity
 * @Description:
 * @author: AllenWhis
 * @date: 2019/9/13 11:27
 */
@Data
public class QueueDto {

    private String exchange;

    private String queueName;

    private String routingKey;

    private String listener;

    private Integer consumers;


}
