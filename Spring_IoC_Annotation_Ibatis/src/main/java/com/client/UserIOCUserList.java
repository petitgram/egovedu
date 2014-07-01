package com.client;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.biz.user.service.UsersServiceIF; 
import com.biz.user.vo.Users;
 

public class UserIOCUserList {

	public static void main(String[] args) {   
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		UsersServiceIF service = (UsersServiceIF) context.getBean("usersService");
		
		try {
			ArrayList<Users> userList = service.findUserList();
			 
			for (int i = 0; i < userList.size(); i++) {
				System.out.println(userList.get(i));
			}  
			 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
	}

}
