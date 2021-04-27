package com.atguigu.springcloud.alibaba.domain;

import lombok.Data;

/**
 * @Auther: garrick
 * @Date: 2021/4/27 13:57
 * @Description:
 */
@Data
public class Storage {
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
