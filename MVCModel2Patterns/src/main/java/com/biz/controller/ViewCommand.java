package com.biz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.biz.user.service.UsersServiceImpl;
import com.biz.user.vo.Users;

public class ViewCommand extends Command {
	
	private Logger logger = Logger.getLogger(getClass());

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		logger.info("============= view start"); 
		
		String nextPage="view.jsp";
		String id = request.getParameter("id");
		Users user = null;
		
		try { 
				user = new UsersServiceImpl().findUser(id);
				request.setAttribute("user", user);
				request.setAttribute("id", id);
		 
			
		}catch(Exception e){
			e.printStackTrace();
		}

		logger.info("============= view finish"); 
		
		return nextPage; 
		
	}

}
