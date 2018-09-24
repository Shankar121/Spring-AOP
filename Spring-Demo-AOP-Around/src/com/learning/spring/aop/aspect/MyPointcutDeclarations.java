package com.learning.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyPointcutDeclarations {
	
	@Pointcut("execution(* com.learning.spring.aop.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.learning.spring.aop.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.learning.spring.aop.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageWithNoGetterSetter() {}
	
}
