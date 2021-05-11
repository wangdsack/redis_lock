package com.wds.redis.controller;

import com.alibaba.fastjson.JSONObject;
import com.wds.redis.aop.RedissonLockAnnotation;
import com.wds.redis.service.ServiceImpl;
import jdk.nashorn.internal.ir.LiteralNode;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @USER: wds
 * @MES: 测试controller类
 */
@RestController
public class TestController {

    @Autowired
    private ServiceImpl service;


    /**
     * 并发测试  300次请求结果为 300
     */
    @PostMapping(value = "testLock", consumes = "application/json")
    @RedissonLockAnnotation(lockRedisKey = "productName,platFormName")
    public String testLock(@RequestBody JSONObject params){
        /**
         * 分布式锁key=params.getString("productName")+params.getString("platFormName");
         * productName 产品名称  platFormName 平台名称 如果都一致,那么分布式锁的key就会一直,那么就能避免并发问题
         */
        //TODO 业务处理

        System.out.println("接收到的参数："+params.toString());
        System.out.println("执行相关业务...");
        System.out.println("执行相关业务.....");

        System.out.println("执行相关业务......");
        service.add();

        return "success";
    }

    /**
     * 并发测试    300次请求结果不一定
     */
    @PostMapping(value = "testLock2", consumes = "application/json")
    public String testLock2(@RequestBody JSONObject params){
        /**
         * 分布式锁key=params.getString("productName")+params.getString("platFormName");
         * productName 产品名称  platFormName 平台名称 如果都一致,那么分布式锁的key就会一直,那么就能避免并发问题
         */
        //TODO 业务处理

        System.out.println("接收到的参数："+params.toString());
        System.out.println("执行相关业务...");
        System.out.println("执行相关业务.....");

        System.out.println("执行相关业务......");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        service.add();
        return "success";
    }




    @GetMapping
    public int getNum(){
        return service.get();
    }



}