package com.learning.spring.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.learning.spring.aop.Account;

@Aspect
@Component
@Order(1)
public class MyLogToCloudAspect {
	
	
	@Around("execution(* com.learning.spring.aop.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println(">>>>> After Around method is invoked");
		String shortName= proceedingJoinPoint.getSignature().toShortString();
		System.out.println("Method: Starts "+shortName);
		long begin = System.currentTimeMillis();
		Object result=proceedingJoinPoint.proceed();
		long end=System.currentTimeMillis();
		System.out.println("Duration: "+((end-begin)/1000.0) +" Seconds");
		return result;
	}
	
	
	@After("execution(* com.learning.spring.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyLoggingDemoApp(JoinPoint joinPoint) {
		System.out.println(">>>>> After Finally method is invoked");
		String shortName= joinPoint.getSignature().toShortString();
		System.out.println("Method: Finally Executed "+shortName);
	}
	
	@AfterThrowing(pointcut="execution(* com.learning.spring.aop.dao.AccountDAO.findAccounts(..))",throwing="ex")
	public void afterThrowingLoggingDemoApp(JoinPoint joinPoint, Throwable ex) {
		System.out.println("After Throwing method is invoked");
		String shortName= joinPoint.getSignature().toShortString();
		System.out.println("Method: Exception Occured "+shortName+"Ex: "+ex);
	}
	
	
	@AfterReturning(pointcut="execution(* com.learning.spring.aop.dao.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturningLoggingDemoApp(JoinPoint joinPoint, List<Account> result) {
		System.out.println("After Returning method is invoked");
		String shortName= joinPoint.getSignature().toShortString();
		System.out.println("Method: "+shortName);
		System.out.println(result);
		converToUpperCase(result);
	}
	

	private void converToUpperCase(List<Account> result) {
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
	}


	@Before("com.learning.spring.aop.aspect.MyPointcutDeclarations.forDaoPackageWithNoGetterSetter()")
	public void logInAspect() {
		System.out.println(">>>>> Log in to Cloud Aspect running on method");
	}
	
}
