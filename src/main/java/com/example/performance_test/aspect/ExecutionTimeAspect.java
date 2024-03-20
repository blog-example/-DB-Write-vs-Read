package com.example.performance_test.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ExecutionTimeAspect {

  @Pointcut("execution(* com.example.performance_test.service..*(..))")
  public void measureExecutionTime() {}

  @Around("measureExecutionTime()")
  public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    Object proceed = joinPoint.proceed(); // 메소드 실행
    long executionTime = System.currentTimeMillis() - start;

    log.info(joinPoint.getSignature() + " 실행 시간 : " + executionTime + "ms");

    return proceed;
  }
}
