package com.learning.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.spring.aop.Account;

@Component
public class AccountDAO {

	private String serviceCode;
	private String name;
	public String getServiceCode() {
		System.out.println("getServiceCode");
		return serviceCode;
	}
	
	public List<Account> findAccounts(boolean tripWire){
		if(tripWire) {
			throw new RuntimeException("No results for you.");
		}
		List<Account> myAccounts=new ArrayList<Account>();
		myAccounts.add(new Account("Shankar", "Gold"));
		myAccounts.add(new Account("Puja", "Platinum"));
		myAccounts.add(new Account("Pojo", "Diamond"));
		System.out.println("finding accounts....");
		return myAccounts;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("setServiceCode");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account account, Boolean result) {
		System.out.println("Adding Account..DB work "+getClass());
	}
	
	public boolean doWork() {
		System.out.println("hey I am doing my work");
		return false;
	}

	public String getName() {
		System.out.println("getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}
	
}
