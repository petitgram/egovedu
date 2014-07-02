package com.biz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.biz.user.service.UsersServiceImpl;
import com.biz.user.vo.Users;

public class ViewCommand implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
  
		ModelAndView nextPage= new ModelAndView();
		String id = request.getParameter("id");
		Users user = null;
		
		try { 
				user = new UsersServiceImpl().findUser(id);
				nextPage.addObject("user", user);
				nextPage.addObject("id", id); 
			
		}catch(Exception e){
			e.printStackTrace();
		} 
		
		nextPage.setViewName("view");
		return nextPage; 
		
	}

 
}
