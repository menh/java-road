package com.mh.instantiation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mh.springioc.Bean;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		BeanFromConstruct beanFromConstruct = context.getBean("beanFromConstruct", BeanFromConstruct.class);
		System.out.println(beanFromConstruct);
		
		
		BeanFromStaticFunc beanFromStaticFunc = context.getBean("beanFromStaticFunc", BeanFromStaticFunc.class);
		System.out.println(beanFromStaticFunc);
		
		BeanFromInstanFunc beanFromInstanFunc = context.getBean("beanFromInstanFunc", BeanFromInstanFunc.class);
		System.out.println(beanFromInstanFunc);
	}
}
