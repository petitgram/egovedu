package com.biz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.biz.user.service.UsersServiceImpl;
import com.biz.user.vo.Users;

public class SaveCommand implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
 
		
		ModelAndView nextPage=new ModelAndView();

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		
		try { 
				new UsersServiceImpl().addUser(new Users(id,password,name,role));
				nextPage.addObject("message", "addUser Success"); 
			
		}catch(Exception e){
			nextPage.addObject("message", "addUser Failed");
			e.printStackTrace();
		} 
 
		nextPage.setViewName("result");
		return nextPage; 
		
	}
 

}
