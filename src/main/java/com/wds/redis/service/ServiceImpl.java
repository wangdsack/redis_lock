package com.wds.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @USER: wds
 * @MES: 测试service类
 */
@Service
public class ServiceImpl {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;


    public void add(){
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        Object num = valueOperations.get("num");
        int a=1;
        if (num != null) {
            a=(int)num+1;
        }
        valueOperations.set("num",a);
    }

    public int get(){
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        return (int) valueOperations.get("num");
    }
}
