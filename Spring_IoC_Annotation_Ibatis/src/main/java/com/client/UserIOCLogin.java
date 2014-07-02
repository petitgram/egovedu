package com.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.biz.user.service.UsersServiceIF; 
 

public class UserIOCLogin {

	public static void main(String[] args) {   
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  
		UsersServiceIF service = (UsersServiceIF) context.getBean("usersService");
		
		try {
			System.out.println(service.login("test", "test123"));
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
	}

}
