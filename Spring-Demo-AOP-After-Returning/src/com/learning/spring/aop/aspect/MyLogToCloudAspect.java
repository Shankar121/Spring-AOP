package com.learning.spring.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.learning.spring.aop.Account;

@Aspect
@Component
@Order(1)
public class MyLogToCloudAspect {
	
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
