package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 定义一个切面
 * 这里使用AspectJ的注解，但是它实际上还是由Spring AOP来解析执行
 */
//@Component
@Aspect
public class MyLogAspect implements Ordered {

    private static final Logger logger = LoggerFactory.getLogger(MyLogAspect.class);

    private static final int DEFAULT_MAX_RETRIES = 2;

    private int maxRetries = DEFAULT_MAX_RETRIES;
    private int order = 1;

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * 环绕通知
     */
    @Around("@annotation(com.example.annotation.MyAspectHandler)")
    public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
        String targetMethodName = pjp.getSignature().getName();
        Object [] args = pjp.getArgs();
        int numAttempts = 0;
        logger.info("切面方法开始执行使用了@MyAspectHandler注解的方法...... retry = {}，被切入的方法名称为：{}, 参数为：{}", numAttempts, targetMethodName);
        ArithmeticException exception;
        do {
            numAttempts++;
            try {
                logger.info("切面方法正在执行使用了@MyAspectHandler注解的方法，retry = {}", numAttempts);
                Object obj = pjp.proceed();
                logger.info("切面方法正在执行使用了@MyAspectHandler注解的方法, 执行成功！");
                return obj;
            } catch(ArithmeticException ex) {
                exception = ex;
            }
        } while(numAttempts <= this.maxRetries);
        logger.info("切面方法执行完毕使用了@MyAspectHandler注解的方法，执行失败，抛出异常: {}", exception.toString());
        throw exception;
    }
}
