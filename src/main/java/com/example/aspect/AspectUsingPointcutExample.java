package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectUsingPointcutExample {

    private static final Logger logger = LoggerFactory.getLogger(AspectUsingPointcutExample.class);


    @Before("com.example.pointcut.PointcutExample.inWebLayer()")
    public void inWebLayerBefore() {
        logger.info("web层方法即将被调用......");
    }

    @After("com.example.pointcut.PointcutExample.inWebLayer()")
    public void inWebLayerAfter() {
        logger.info("web层方法调用完毕......");
    }

    @Before("com.example.pointcut.PointcutExample.inServiceLayer()")
    public void inServiceLayerBefore() {
        logger.info("service层方法即将被调用......");
    }

    @After("com.example.pointcut.PointcutExample.inServiceLayer()")
    public void inServiceLayerAfter() {
        logger.info("service层方法调用完毕......");
    }

    @Before("com.example.pointcut.PointcutExample.dataAccessOperation()")
    public void dataAccessOperationBefore() {
        logger.info("dao层方法即将被调用......");
    }

    @After("com.example.pointcut.PointcutExample.dataAccessOperation()")
    public void dataAccessOperationAfter() {
        logger.info("dao层方法调用完毕......");
    }

    @Around("com.example.pointcut.PointcutExample.commonLogHander()")
    public Object updateUserAround(ProceedingJoinPoint pjp) {

        String methodName = pjp.getSignature().getName();
        logger.info("当前被切入的方法名称为：{}", methodName);
        Object [] args = pjp.getArgs();
        if(args.length > 0) {
            for(Object obj : args) {
                logger.info("当前被切入的方法{} 参数为：{}", methodName, obj.toString());
            }
        }

        logger.info("{} 即将执行......", methodName);
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        logger.info("{} 执行完毕......", methodName);
        return result;
    }

    @AfterReturning(pointcut = "com.example.pointcut.PointcutExample.listOperation()", returning = "returnVal")
    public void listOperationAfterReturning(Object returnVal) {
        logger.info("目标方法已经执行完毕，它的返回值是：{}", returnVal);
    }
}
