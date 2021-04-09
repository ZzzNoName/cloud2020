package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.time.ZonedDateTime;

/**
 * @Auther: garrick
 * @Date: 2021/4/9 12:58
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {
    public static void main(String[] args)
    {
        SpringApplication.run(GateWayMain9527.class,args);
//        2021-04-09T13:25:23.633+08:00[Asia/Shanghai]
//        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
//        System.out.println(zbj);
    }

}
