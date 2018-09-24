package com.learning.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.learning.spring.aop.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.learning.spring.aop.aspect.MyPointcutDeclarations.forDaoPackageWithNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println(">>>>> Executing Logging @Before Advice on method");
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: "+methodSignature);
		Object[] args= joinPoint.getArgs();
		for (Object object : args) {
			if(object instanceof Account) {
				Account account=(Account) object;
				System.out.println(account.getName());
				System.out.println(account.getLevel());
			}else {
				System.out.println(object);
			}
			
		}
	}
	
	
}
