package com.biz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.biz.user.service.UsersServiceImpl;
import com.biz.user.vo.Users;

public class UpdateCommand extends Command {

	private Logger logger = Logger.getLogger(getClass());
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	logger.info("============= view start"); 
		
		String nextPage="result.jsp";

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		
		try {
			HttpSession session=request.getSession();
			String sessid = (String) session.getAttribute("id");
			 
			if(sessid != null){ 
				new UsersServiceImpl().updateUser(new Users(id,password,name,role));
				request.setAttribute("message", "updateUser Success");
				request.setAttribute("id", id);
			}else{
				nextPage="login.jsp";
			}
			
		}catch(Exception e){
			request.setAttribute("message", "updateUser Failed");
			e.printStackTrace();
		}

		logger.info("============= view finish");
		
		return nextPage;  
	}

}
