package com.learning.spring.aop.dao;

import org.springframework.stereotype.Component;

import com.learning.spring.aop.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, Boolean result) {
		System.out.println("Adding Account..DB work "+getClass());
	}
	
	public boolean doWork() {
		System.out.println("hey I am doing my work");
		return false;
	}
	
}
