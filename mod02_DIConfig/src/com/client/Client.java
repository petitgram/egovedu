package com.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.SawonConfig;

public class Client {

	public static void main(String[] args){
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		SawonConfig sc = (SawonConfig)app.getBean("sc");
	}
}
