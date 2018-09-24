package com.learning.spring.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.spring.aop.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
		System.out.println("Start executing...");
		
		List<Account> accounts=accountDAO.findAccounts();
		System.out.println("Main Program: After Returning demo app");
		System.out.println("-----");
		System.out.println(accounts);
		context.close();
	}

}
