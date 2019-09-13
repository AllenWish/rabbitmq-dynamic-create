package com.allenwhis.rabbitmq.dynamic.create.entity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version V1.0
 * @Title:
 * @Package: com.allenwhis.rabbitmq.dynamic.create.entity.response
 * @Description:
 * @author: AllenWhis
 * @date: 2019/9/13 12:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse {

    private boolean success;

    private String message;

    private String failCode;


}
