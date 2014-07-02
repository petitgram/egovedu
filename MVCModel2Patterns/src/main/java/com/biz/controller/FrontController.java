package com.biz.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.biz.controller.command.HandlerMapping;
 
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(getClass());
        
    public FrontController() {
        super(); 
    }
     
 
	@Override
	public void init(ServletConfig config) throws ServletException { 
		super.init(config); 
		String fileName = getServletContext().getRealPath(getInitParameter("configFile"));
		HandlerMapping.mapping(fileName);
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); 
		
		// action Check
		String action = request.getParameter("action");
		String nextPage=HandlerMapping.getCommand(action).execute(request, response);
		
		logger.info("action ============= " + action + " : " + HandlerMapping.getCommand(action)); 
		;
		
//		if(action == null) nextPage="login.jsp";
//		else if(action.equals("login")) nextPage=new LoginCommand().execute(request, response);
//		else if(action.equals("logout")) nextPage=new LogoutCommand().execute(request, response);
//		else if(action.equals("list")) nextPage=new ListCommand().execute(request, response);
//		else if(action.equals("view")) nextPage=new ViewCommand().execute(request, response);
//		else if(action.equals("input")) nextPage=new InputCommand().execute(request, response);
//		else if(action.equals("save")) nextPage=new SaveCommand().execute(request, response);
//		else if(action.equals("delete")) nextPage=new DeleteCommand().execute(request, response);
//		else if(action.equals("update")) nextPage=new UpdateCommand().execute(request, response); 
   
		request.getRequestDispatcher(nextPage).forward(request, response);
	}
 
  


}
