package com.learning.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLogToCloudAspect {

	@Before("com.learning.spring.aop.aspect.MyPointcutDeclarations.forDaoPackageWithNoGetterSetter()")
	public void logInAspect() {
		System.out.println(">>>>> Log in to Cloud Aspect running on method");
	}
	
}
