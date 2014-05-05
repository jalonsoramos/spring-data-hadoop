package com.autentia.tutoriales;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Init {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("META-INF/spring/application-context.xml");
	}
}