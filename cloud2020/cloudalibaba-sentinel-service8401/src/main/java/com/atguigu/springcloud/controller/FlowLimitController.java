package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: garrick
 * @Date: 2021/4/19 19:54
 * @Description:
 */
@RestController
@Log
public class FlowLimitController {
    //流控规则  流控模式（直接，关联，链路） 流控效果（快速失败，预热，排队等待）
    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }
    @GetMapping("/testC")
    public String testC()
    {
        return "------testC";
    }
    @GetMapping("/testD")
    public String testD()
    {
        return "------testD";
    }
    //降级规则
    @GetMapping("/testE")
    public String testE()
    {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");
        return "------testE 测试RT";
    }
    @GetMapping("/testF")
    public String testF()
    {
        log.info("testF 测试异常比例");
        int age = 10/0;
        return "------testF 测试异常比例";
    }
    @GetMapping("/testG")
    public String testG()
    {
        log.info("testG 测试异常数");
        int age = 10/0;
        return "------testG 测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        log.info(p1+"==="+p2);
        return "-----testHotKey";
    }
    public String dealHandler_testHotKey(String p1,String p2,BlockException e){
        e.printStackTrace();
        return "-----dealHandler_testHotKey";
    }
}
