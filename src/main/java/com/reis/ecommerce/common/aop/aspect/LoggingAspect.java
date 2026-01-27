package com.reis.ecommerce.common.aop.aspect;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect
{

  @Around("execution(* com.reis.ecommerce.service..*(..)) || " + "execution(* com.reis.ecommerce.controller..*(..))")
  public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable
  {
    String className = joinPoint.getSignature().getDeclaringTypeName();
    String methodName = joinPoint.getSignature().getName();

    Object[] args = joinPoint.getArgs();

    log.info("[ENTER] {}.{} args={}", className, methodName, Arrays.toString(args));

    try
    {
      Object result = joinPoint.proceed();
      log.info("[EXIT] {}.{} result={}", className, methodName, result );
      return result;
    }
    catch (Exception ex)
    {
      log.error("[ERROR] {}.{} message={}",className, methodName, ex.getMessage(), ex );
      throw ex;
    }
  }

}
