package com.biz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutCommand implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse resopnse) throws Exception { 
		
		ModelAndView nextPage=new ModelAndView();
		HttpSession session=request.getSession(false);  
		
		if(session != null && session.getAttribute("id") !=null){
			session.invalidate();  
		}
		 
		nextPage.addObject("message","LogOut Success");
		
		nextPage.setViewName("result");
		return nextPage;
	}
 
}
