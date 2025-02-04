package com.example.SpringJobApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
//	@Before("execution(* com.example.SpringJobApp.service.JobService.*(..))")
//	public void LogMethodCall () {
//		LOGGER.info("Method Called");
//	}
	
	@Before("execution (* com.example.SpringJobApp.service.JobService.getJob(..))")
	public void logMethodCall(JoinPoint jp) {
		LOGGER.info("Method Called "+jp.getSignature().getName());
	}
	
	@After("execution (* com.example.SpringJobApp.service.JobService.getJob(..))")
	public void logMethodExecuted(JoinPoint jp) {
		LOGGER.info("Method Executed "+jp.getSignature().getName());
	}
	
	@AfterThrowing("execution (* com.example.SpringJobApp.service.JobService.getJob(..))")
	public void logMethodExecutionFailed(JoinPoint jp) {
		LOGGER.info("Method Execution Failed "+jp.getSignature().getName());
	}
	
	@AfterReturning("execution (* com.example.SpringJobApp.service.JobService.getJob(..))")
	public void logMethodExecutedSuccessfully(JoinPoint jp) {
		LOGGER.info("Method Execution Success "+jp.getSignature().getName());
	}
}







