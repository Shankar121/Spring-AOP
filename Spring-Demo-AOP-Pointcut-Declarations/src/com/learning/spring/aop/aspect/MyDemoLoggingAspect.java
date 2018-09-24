package com.learning.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.learning.spring.aop.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.learning.spring.aop.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* com.learning.spring.aop.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageWithNoGetterSetter() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println(">>>>> Executing @Before Advice on method");
	}
	
	@Before("forDaoPackageWithNoGetterSetter()")
	public void performingAPIAnalytics() {
		System.out.println(">>>>> Performing API Analytics on method");
	}
	
}
