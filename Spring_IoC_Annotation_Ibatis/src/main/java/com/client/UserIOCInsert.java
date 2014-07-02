package com.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.biz.user.service.UsersServiceIF;
import com.biz.user.vo.Users;
 

public class UserIOCInsert {

	public static void main(String[] args) {   
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  
		UsersServiceIF service = (UsersServiceIF) context.getBean("usersService");
		
		try {
			service.addUser(new Users("spring23","spring11","SPRING11","user"));
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
	}

}
