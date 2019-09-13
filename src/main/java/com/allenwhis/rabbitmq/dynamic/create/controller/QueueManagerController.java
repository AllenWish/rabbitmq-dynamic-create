package com.allenwhis.rabbitmq.dynamic.create.controller;

import com.alibaba.fastjson.JSONObject;
import com.allenwhis.rabbitmq.dynamic.create.entity.dto.QueueDto;
import com.allenwhis.rabbitmq.dynamic.create.entity.request.CreateQueueVo;
import com.allenwhis.rabbitmq.dynamic.create.entity.response.BaseResponse;
import com.allenwhis.rabbitmq.dynamic.create.service.DynamicManagerQueueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @version V1.0
 * @Title:
 * @Package: com.allenwhis.rabbitmq.dynamic.create.controller
 * @Description: 动态创建队列和监听者
 * @author: AllenWhis
 * @date: 2019/9/13 11:59
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class QueueManagerController {
    private static Logger logger = LoggerFactory.getLogger(QueueManagerController.class);

    @Autowired
    private DynamicManagerQueueService dynamicManagerQueueService;

    @PostMapping(value = "createQueue")
    public BaseResponse createQueue(@RequestBody CreateQueueVo vo) {
        logger.info("tackNo:{} method:{} request:{}", "", "createQueue", JSONObject.toJSONString(vo));
        try {
            QueueDto dto = new QueueDto();
            BeanUtils.copyProperties(vo, dto);
            dynamicManagerQueueService.createQueue(dto);
            return BaseResponse.builder().success(true).build();
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.builder().success(false).message(e.getMessage()).failCode("101").build();
        }
    }


    @DeleteMapping(value = "deleteQueue/{queueName}")
    public BaseResponse deleteQueue(@PathVariable("queueName") String queueName) {
        logger.info("tackNo:{} method:{} request:{}", "", "deleteQueue", queueName);
        dynamicManagerQueueService.delQueue(queueName);
        return BaseResponse.builder().success(true).build();
    }


}
