package com.learning.spring.aop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.spring.aop.service.TrafficFortuneService;

public class AroundLoggerDemoApp {
	
	private static Logger logs=Logger.getLogger(AroundLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService trafficFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		logs.info("Main Program Around Demo App");
		logs.info("calling Fortune");
		String fortune=trafficFortuneService.getFortune();
		logs.info("Today's Fortune: "+fortune);
		logs.info("---Finished---");
		context.close();
	}

}
