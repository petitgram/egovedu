package com.biz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class LogoutCommand extends Command {

	private Logger logger = Logger.getLogger(getClass());
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		logger.info("============= logout start"); 
		
		String nextPage="login.jsp";
		HttpSession session=request.getSession(false); 
		session.invalidate(); 
		
		logger.info("============= logout finish"); 
	
		return nextPage;
		
	}

}
