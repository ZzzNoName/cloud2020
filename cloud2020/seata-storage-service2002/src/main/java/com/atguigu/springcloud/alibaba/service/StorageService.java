package com.atguigu.springcloud.alibaba.service;

/**
 * @Auther: garrick
 * @Date: 2021/4/27 14:00
 * @Description:
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
