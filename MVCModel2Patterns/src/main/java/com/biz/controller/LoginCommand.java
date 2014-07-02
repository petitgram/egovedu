package com.biz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.biz.user.service.UsersServiceImpl;

public class LoginCommand extends Command { 
	
	private Logger logger = Logger.getLogger(getClass());

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		logger.info("============= login start"); 
		
		//data Check
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String nextPage="login.jsp"; 
		
		//business method call
		try {
			
			boolean isExist = new UsersServiceImpl().login(id,password);
			
			if(isExist){
				HttpSession session=request.getSession();
				session.setAttribute("id", id);
				
				nextPage="list.jsp";
			}else{
				nextPage="login.jsp";
				request.setAttribute("message", "Login Failed");
			}
		} catch (Exception e) { 
			request.setAttribute("message", "Login Failed");
			e.printStackTrace();
		}
		
		logger.info("============= login finish"); 
		
		 return nextPage; 
		 
	}

}
