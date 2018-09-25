package com.example.pointcut;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 切入点集合
 * 用于演示Spring支持的各种切入点
 */
public class PointcutExample {

    /**
     * 切入com.example.web包下定义的所有方法，包括web包的子包
     */
    @Pointcut("within(com.example.web..*)")
    public void inWebLayer() {}

    /**
     * 切入com.example.service包下定义的所有方法，包括service的子包
     */
    @Pointcut("within(com.example.service..*)")
    public void inServiceLayer() {}


    /**
     * 切入com.example.dao下面的子包内的所有方法
     * 例如：接口类在dao包下，而实现类在dao.impl包下
     */
    @Pointcut("execution(* com.example.dao.*.*(..))")
    public void dataAccessOperation() {}

    /**
     * 基于注解的切入点
     * 只有使用了@CommonLogHandler注解的方法才可以被切面类识别
     */
    @Pointcut("@annotation(com.example.annotation.CommonLogHandler)")
    public void commonLogHander() {}

    /**
     * 切入service包以及子包下的所有以list开头的public方法
     */
    @Pointcut("execution(public * com.example.service..*.list*(..))")
    public void listOperation() {}
}
