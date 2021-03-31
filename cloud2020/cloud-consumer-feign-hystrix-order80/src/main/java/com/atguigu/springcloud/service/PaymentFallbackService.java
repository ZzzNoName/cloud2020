package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Auther: garrick
 * @Date: 2021/3/31 17:12
 * @Description:
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务调用失败，提示来自：hystrix-cloud-order-service";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务调用失败，提示来自：hystrix-cloud-order-service";
    }
}
