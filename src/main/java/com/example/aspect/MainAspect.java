package com.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class MainAspect {

    private static final Logger logger = LoggerFactory.getLogger(MainAspect.class);

    /**
     * 匹配任何的public方法
     */
    @Before("execution(public * *(..))")
    private void anyPublicOperation() {
        logger.info("一个public方法即将执行......");
    }
}
