package com.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.biz.user.service.UsersServiceIF; 

public class UserIOCDelete {

	public static void main(String[] args) {   
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
 
		UsersServiceIF service = (UsersServiceIF) context.getBean("usersService");
		
		try {
			service.deleteUser("spring");
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		
	}

}
