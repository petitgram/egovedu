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

public class DeleteCommand implements Controller { 

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
 
		ModelAndView nextPage= new ModelAndView();
		String id = request.getParameter("id");
		
		try { 
				new UsersServiceImpl().deleteUser(id);  
				nextPage.addObject("message","deleteUser Success"); 
				
		}catch(Exception e){
			nextPage.addObject("message","deleteUser Failed");
			e.printStackTrace();
		} 
		
		nextPage.setViewName("result");
		return nextPage; 
		
	}

	 

}
