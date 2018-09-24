package com.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 使用@Component注解表示它是Spring的一个组件，可被自动扫描
 * 使用@Aspect注解，表示它是一个切面类
 */
@Component
@Aspect
public class MyAspect {

    private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);

    /**
     * execution，用于匹配所有的方法,表达式内部限制了它只可以匹配
     * 方法名称为sayHello的方法
     */
    @Pointcut("execution(* sayHello(..))")
    public void pointcut1(){
    }

    @Before("com.example.aspect.MyAspect.pointcut1()")
    public void before() {
        logger.info("即将执行sayHello方法");
    }

}
