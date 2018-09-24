package com.learning.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//@Before("execution(public void com.learning.spring.aop.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(* void add*())") //Modifier is optional so it can be removed
	//@Before("execution(void add*())")
	//@Before("execution(* add*())")
	//@Before("execution(* add*(com.learning.spring.aop.Account))")
	//@Before("execution(* add*(com.learning.spring.aop.Account, ..))")
	//@Before("execution(* add*(..))")
	@Before("execution(* com.learning.spring.aop.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println(">>>>> Executing @Before Advice on method");
	}
	
}
