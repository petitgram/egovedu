package com.biz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.user.service.UsersServiceImpl;
import com.biz.user.vo.Users;

public class InputCommand extends Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nextPage="input.jsp";
		Users user=null;
	
		try { 
			if(request.getParameter("id") != null){ 
				user = new UsersServiceImpl().findUser(request.getParameter("id"));
				request.setAttribute("user", user);
				request.setAttribute("updateid", request.getParameter("id"));
			} 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return nextPage;
	}

}
