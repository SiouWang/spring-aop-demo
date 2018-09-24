package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class RecordArgumentsAspect {

    @Around("@annotation(com.example.annotation.RecordArguments)")
    public void recordArg(ProceedingJoinPoint jp) {

    }
}
