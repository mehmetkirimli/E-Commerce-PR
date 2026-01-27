package com.reis.ecommerce.common.aop.aspect;

import com.reis.ecommerce.common.aop.annotation.TrackPerformance;
import java.util.SequencedSet;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PerformanceAspect
{
  @Around("@annotation(TrackPerformance)")
  public Object measureExecutionTime(ProceedingJoinPoint joinPoint , TrackPerformance trackPerformance) throws Throwable
  {
    long startTime = System.currentTimeMillis();

    try
    {
      return joinPoint.proceed();
    }
    finally
    {
      long duration = System.currentTimeMillis() - startTime;

      log.info("[PERF] {}.{} executed in {} ms", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), duration );
    }
  }


}
