package com.learning.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.spring.aop.dao.AccountDAO;
import com.learning.spring.aop.dao.MemebrshipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
		Account myAccount=new Account();
		accountDAO.doWork();
		accountDAO.setServiceCode("Silver");
		
		accountDAO.getName();
		myAccount.setName("Shankar");
		myAccount.setLevel("High");
		
		accountDAO.addAccount(myAccount,true);
		accountDAO.getServiceCode();
		MemebrshipDAO memebrshipDAO=context.getBean("memebrshipDAO",MemebrshipDAO.class);
		memebrshipDAO.addAccount();
		memebrshipDAO.addMember();
		context.close();
	}

}
