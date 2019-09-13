package com.allenwhis.rabbitmq.dynamic.create.listener;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @Title:
 * @Package: com.allenwhis.rabbitmq.dynamic.create.listener
 * @Description:
 * @author: AllenWhis
 * @date: 2019/9/13 11:53
 */
@Component("demoListener")
public class DemoListener implements MessageListener {
    private static Logger logger = LoggerFactory.getLogger(DemoListener.class);

    @Override
    public void onMessage(Message message) {

        try {
            logger.info("listener consume message:{}", JSONObject.parse(message.getBody()).toString());
        } catch (Exception e) {
            logger.info("listener consume message:{}", JSONObject.toJSONString(message.getBody()));
        }
    }


}
