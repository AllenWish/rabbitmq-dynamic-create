package com.allenwhis.rabbitmq.dynamic.create.entity.request;

import lombok.Data;

/**
 * @version V1.0
 * @Title:
 * @Package: com.allenwhis.rabbitmq.dynamic.create.entity.request
 * @Description:
 * @author: AllenWhis
 * @date: 2019/9/13 12:10
 */
@Data
public class CreateQueueVo {

    private String exchange;

    private String queueName;

    private String routingKey;

    private String listener;

    private Integer consumers;

}
