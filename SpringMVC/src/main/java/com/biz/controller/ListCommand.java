package com.biz.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.biz.user.service.UsersServiceImpl;
import com.biz.user.vo.Users;

public class ListCommand implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		
		ModelAndView nextPage= new ModelAndView();

		Users user = null;
		
		try {  
			ArrayList<Users> userList = new UsersServiceImpl().findUserList();
			nextPage.addObject("userList", userList); 
		 
		}catch(Exception e){
			e.printStackTrace();
		} 
		
		nextPage.setViewName("list");
		return nextPage;  
	} 

}
