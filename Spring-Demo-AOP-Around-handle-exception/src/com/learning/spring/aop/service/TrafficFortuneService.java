package com.learning.spring.aop.service;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Your fortune expects heavy traffic today";
		
	}

	public String getFortune(boolean tripWire) {
		if(tripWire) {
			throw new RuntimeException("Major Accident! Flyover is closed");
		}
		return getFortune();
	}
	
}
