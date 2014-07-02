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

public class LoginCommand implements Controller { 
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 
		//data Check
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		ModelAndView nextPage=new ModelAndView(); 
		
		//business method call
		try {
			
			if(id == null && password == null){
				
				HttpSession session=request.getSession();
				String sessid = (String) session.getAttribute("id"); 
				 
				if(sessid!=null ) nextPage.addObject("message", "Already Login :: " + sessid);
				else nextPage.addObject("message", "Not login");
				
			}else{
				boolean isExist = new UsersServiceImpl().login(id,password);
				
				if(isExist){
					HttpSession session=request.getSession();
					session.setAttribute("id", id); 
	
					nextPage.addObject("message", "Login Success");
					nextPage.setViewName("result");
				}else{ 
					nextPage.addObject("message", "Login Failed");
				}
			}
		} catch (Exception e) { 
			request.setAttribute("message", "Login Failed");
			nextPage.setViewName("login");
			e.printStackTrace();
		} 
 
		 return nextPage; 
	}
 

}
