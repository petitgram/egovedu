package com.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.biz.user.service.UsersServiceIF;
import com.biz.user.vo.Users;
 

public class UserIOCFindUser {

	public static void main(String[] args) {   
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
 
		System.out.println(context);

		UsersServiceIF service = (UsersServiceIF) context.getBean("usersService");
		
		try {
			System.out.println(service.findUser("spring"));
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
	}

}