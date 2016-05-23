package com.laufu.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerInterceptor {

	@Before("execution(* com.laufu.controller.*.*(..))")
	public void doBefore(JoinPoint jp) {
		System.out.println("测试方法***************************");
		StringBuffer method = new StringBuffer();
		method.append(jp.getTarget().getClass().getName()).append(".")
				.append(jp.getSignature().getName());
		Object[] args = jp.getArgs();

		HttpServletRequest request = null;
		for (Object arg : args) {
			if (arg instanceof HttpServletRequest) {
				request = (HttpServletRequest) arg;
			}
		}
		System.out.println(method.toString());
	}

	@After("execution(* com.laufu.controller..*.*Controller.*(..))")
	public void doAfter(JoinPoint jp) {
		Object[] args = jp.getArgs();
		StringBuffer method = new StringBuffer();
		method.append(jp.getTarget().getClass().getName()).append(".")
				.append(jp.getSignature().getName());

		HttpServletRequest request = null;
		for (Object arg : args) {
			if (arg instanceof HttpServletRequest) {
				request = (HttpServletRequest) arg;
			}
		}
		String account = request.getParameter("accountName");
		System.out.println(method.toString());
	}
//	@Around("methodCachePointcut()")  
//	public Object around(){
//		
//	}
}
