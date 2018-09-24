package com.learning.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.spring.aop.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService trafficFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		System.out.println("Main Program Around Demo App");
		System.out.println("calling Fortune");
		String fortune=trafficFortuneService.getFortune();
		System.out.println("Today's Fortune: "+fortune);
		System.out.println("---Finished---");
		context.close();
	}

}
