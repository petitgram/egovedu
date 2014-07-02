package com.biz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.biz.user.service.UsersServiceImpl;

public class DeleteCommand extends Command {

	private Logger logger = Logger.getLogger(getClass());
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("============= delete start"); 
		
		String nextPage="result.jsp";
		String id = request.getParameter("id");
		
		try {
			HttpSession session=request.getSession();
			String sessid = (String) session.getAttribute("id");
			
			if(sessid != null){
				new UsersServiceImpl().deleteUser(id);  
				request.setAttribute("message", "deleteUser Success");
				
			}else{
				nextPage="login.jsp";
			}
			
		}catch(Exception e){
			request.setAttribute("message", "deleteUser Failed");
			e.printStackTrace();
		}

		logger.info("============= delete finish"); 
		
		return nextPage; 
	}

}
