package com.wds.redis.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 

/**
 * @USER: wds
 * @MES: 分布式锁自定义注解
 */
@Target(ElementType.METHOD) //注解在方法
@Retention(RetentionPolicy.RUNTIME)
public @interface RedissonLockAnnotation {
 
    /**
     * 指定组成分布式锁的key
     */
    String lockRedisKey();
}