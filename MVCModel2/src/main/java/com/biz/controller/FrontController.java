package com.biz.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.biz.user.service.UsersServiceImpl;
import com.biz.user.vo.Users;
 
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(getClass());
        
    public FrontController() {
        super(); 
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); 
		
		// action Check
		String action = request.getParameter("action");
		String nextPage="login.jsp"; 
		
		logger.info("action ============= " + action);
		
		if(action == null) nextPage="login.jsp";
		else if(action.equals("login")) nextPage=login(request,response);
		else if(action.equals("logout")) nextPage=logout(request,response);
		else if(action.equals("list")) nextPage=list(request,response);
		else if(action.equals("view")) nextPage=view(request,response);
		else if(action.equals("input")) nextPage=input(request,response);
		else if(action.equals("save")) nextPage=save(request,response);
		else if(action.equals("delete")) nextPage=delete(request,response);
		else if(action.equals("update")) nextPage=update(request,response); 
		 
		logger.info("nextPage ============= " + nextPage);
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	private String delete(HttpServletRequest request,
			HttpServletResponse response) {


		logger.info("============= delete start"); 
		
		String nextPage="list.jsp";
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

	private String update(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("============= view start"); 
		
		String nextPage="view.jsp";

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

	private String save(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("============= save start"); 
		
		String nextPage="list.jsp";

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		
		try {
			HttpSession session=request.getSession();
			String sessid = (String) session.getAttribute("id");
			 
			if(sessid != null){ 
				new UsersServiceImpl().addUser(new Users(id,password,name,role));
				request.setAttribute("message", "addUser Success");
			}else{
				nextPage="login.jsp";
			}
			
		}catch(Exception e){
			request.setAttribute("message", "addUser Failed");
			e.printStackTrace();
		} 

		logger.info("============= save finish"); 
		
		return nextPage; 
	}

	private String input(HttpServletRequest request,
			HttpServletResponse response) { 
		 
		logger.info("============= input start"); 
		
		String nextPage=null;
		
		if(request.getParameter("id")!=null){
			nextPage="edit.jsp";
		}else{
			nextPage="input.jsp";  
			request.setAttribute("id",request.getParameter("id"));
		} 

		logger.info("============= input finish"); 
		
		return nextPage;
	}

	private String logout(HttpServletRequest request,HttpServletResponse response) {

		logger.info("============= logout start"); 
		
		String nextPage="login.jsp";
		HttpSession session=request.getSession(false); 
		session.invalidate(); 
		
		logger.info("============= logout finish"); 
	
		return nextPage;
	}

	private String view(HttpServletRequest request, HttpServletResponse response) {
 
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

	private String login(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("============= login start"); 
		
		//data Check
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String nextPage="login.jsp"; 
		
		//business method call
		try {
			
			boolean isExist = new UsersServiceImpl().login(id,password);
			
			if(isExist){
				HttpSession session=request.getSession();
				session.setAttribute("id", id);
				
				nextPage="list.jsp";
			}else{
				nextPage="login.jsp";
				request.setAttribute("message", "Login Failed");
			}
		} catch (Exception e) { 
			request.setAttribute("message", "Login Failed");
			e.printStackTrace();
		}
		
		logger.info("============= login finish"); 
		
		 return nextPage; 
	}
	 

	private String list(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("============= list start"); 
		
		String nextPage="list.jsp";

		Users user = null;
		
		try {
			HttpSession session=request.getSession();
			String sessid = (String) session.getAttribute("id");
			
			if(sessid != null){
				ArrayList<Users> userList = new UsersServiceImpl().findUserList();
				request.setAttribute("userList", userList);
				request.setAttribute("sessid", sessid);
			}else{
				nextPage="login.jsp";
			} 
		}catch(Exception e){
			e.printStackTrace();
		}

		logger.info("============= list finish"); 
		
		return nextPage; 
	}
	 


}
