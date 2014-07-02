package com.biz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.biz.user.service.UsersServiceImpl;
import com.biz.user.vo.Users;

public class InputCommand implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse resopnse) throws Exception {
		
		ModelAndView nextPage= new ModelAndView();
		Users user=null;
	
		try { 
			if(request.getParameter("id") != null){ 
				user = new UsersServiceImpl().findUser(request.getParameter("id"));
				nextPage.addObject("user", user);
				nextPage.addObject("updateid", request.getParameter("id"));
			} 
		} catch (Exception e) { 
			e.printStackTrace();
		}

		nextPage.setViewName("input");
		return nextPage;
	}
 

}
