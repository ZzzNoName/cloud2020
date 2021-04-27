package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;

/**
 * @Auther: garrick
 * @Date: 2021/4/27 13:34
 * @Description:
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
