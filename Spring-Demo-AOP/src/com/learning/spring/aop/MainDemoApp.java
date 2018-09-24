package com.learning.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.spring.aop.dao.AccountDAO;
import com.learning.spring.aop.dao.MemebrshipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
		accountDAO.addAccount(new Account(),true);
		accountDAO.doWork();
		MemebrshipDAO memebrshipDAO=context.getBean("memebrshipDAO",MemebrshipDAO.class);
		memebrshipDAO.addAccount();
		memebrshipDAO.addMember();
		context.close();
	}

}
