package com.biz.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.biz.user.service.UsersServiceImpl;
import com.biz.user.vo.Users;

public class ListCommand extends Command {
	
	private Logger logger = Logger.getLogger(getClass());

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		logger.info("============= list start"); 
		
		String nextPage="list.jsp";

		Users user = null;
		
		try {  
			ArrayList<Users> userList = new UsersServiceImpl().findUserList();
			request.setAttribute("userList", userList); 
		 
		}catch(Exception e){
			e.printStackTrace();
		}

		logger.info("============= list finish"); 
		
		return nextPage; 
		
	}

}
