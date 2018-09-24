package com.learning.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MemebrshipDAO {
	public void addAccount() {
		System.out.println("Adding Account..DB work "+getClass());
	}
	
	public String addMember() {
		System.out.println("Adding Member..DB work "+getClass());
		return "member";
	}
}
