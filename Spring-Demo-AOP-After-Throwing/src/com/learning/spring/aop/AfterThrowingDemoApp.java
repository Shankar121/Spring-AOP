package com.learning.spring.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.spring.aop.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
		System.out.println("Start executing...");
		
		List<Account> accounts=null;
		try {
			boolean tripWire=true;
			accounts=accountDAO.findAccounts(tripWire);
		}catch(Exception ex) {
			System.out.println("Main Program Caught Exception: "+ex);
		}
		
		System.out.println("Main Program: After Throwing demo app");
		System.out.println("-----");
		System.out.println(accounts);
		context.close();
	}

}
