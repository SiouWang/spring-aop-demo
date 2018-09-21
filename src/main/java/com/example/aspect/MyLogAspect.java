package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(MyLogAspect.class);

    /**
     * 环绕通知
     */
    @Around("@annotation(com.example.annotation.MyAspectHandler)")
    public Object processMethod(ProceedingJoinPoint jp) throws Throwable {
        Object obj = null;
        logger.info("切面开始执行业务.....方法即将执行！");
        obj = jp.proceed();
        logger.info("切面执行完毕......方法执行完毕！");
        return obj;
    }
}
