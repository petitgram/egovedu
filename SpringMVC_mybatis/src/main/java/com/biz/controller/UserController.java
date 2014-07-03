package com.biz.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biz.user.service.UsersServiceIF;
import com.biz.user.service.UsersServiceImpl;
import com.biz.user.vo.Users;

@Controller
@RequestMapping("/user")
public class UserController{

	@Autowired
	UsersServiceIF service;

	@RequestMapping("home.do")
	public String home(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return "login";
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		ModelAndView nextPage= new ModelAndView(); 
		
		try {  
			ArrayList<Users> userList = service.findUserList();
			nextPage.addObject("userList", userList); 
		 
		}catch(Exception e){
			e.printStackTrace();
		} 
		
		nextPage.setViewName("list");
		return nextPage;  
		
	}
	
	@RequestMapping("view.do")
	public String view(@RequestParam("id") String id,
			Model model) throws Exception { 
		
		try { 
			Users user = service.findUser(id);
			model.addAttribute("user", user);
			model.addAttribute("id", id); 
			
		}catch(Exception e){
			e.printStackTrace();
		} 
		 
		return "view"; 
		
	}
	
	@RequestMapping("input.do")
	public ModelAndView input(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView nextPage= new ModelAndView();
		Users user=null;
	
		try { 
			if(request.getParameter("id") != null){ 
				user = service.findUser(request.getParameter("id"));
				nextPage.addObject("user", user);
				nextPage.addObject("updateid", request.getParameter("id"));
			} 
		} catch (Exception e) { 
			e.printStackTrace();
		}

		nextPage.setViewName("input");
		return nextPage;
	}
 
	@RequestMapping("save.do")
	public String save(@RequestParam("id") String id,
					   @RequestParam("password") String password,
					   @RequestParam("name") String name,
					   @RequestParam("role") String role,
			Model model) throws Exception { 
		
		try { 
				service.addUser(new Users(id,password,name,role));
				model.addAttribute("message", "addUser Success"); 
			
		}catch(Exception e){
			model.addAttribute("message", "addUser Failed");
			e.printStackTrace();
		} 
  
		return "result"; 
	}
	
	@RequestMapping("update.do")
	public String update(@RequestParam("id") String id,
						 @RequestParam("password") String password,
						 @RequestParam("name") String name,
						 @RequestParam("role") String role,
						 	Model model) throws Exception {  
		
		try { 
			service.updateUser(new Users(id,password,name,role));
			model.addAttribute("message", "updateUser Success"); 			
		}catch(Exception e){
			model.addAttribute("message", "updateUser Failed");
			e.printStackTrace();
		}  
		
		return "result";   
	}
	
	@RequestMapping("delete.do")
	public String delete(@RequestParam("id") String id,Model model) throws Exception {
		ModelAndView nextPage= new ModelAndView(); 
		
		try { 
				service.deleteUser(id);  
				model.addAttribute("message","deleteUser Success"); 
				
		}catch(Exception e){
			model.addAttribute("message","deleteUser Failed");
			e.printStackTrace();
		} 
		
		return "result";
	}
	

	@RequestMapping("sign.do")
	public String login(HttpServletRequest request,Model model) throws Exception { 
		
		HttpSession session=request.getSession();
		String sessid = (String) session.getAttribute("id"); 
		 
		if(sessid!=null ) model.addAttribute("message", "Already Login :: " + sessid);
		else model.addAttribute("message", "Not login Repalce User"); 
		
		return "login";
	}
	
	@RequestMapping("login.do")
	public ModelAndView login(@RequestParam("id") String id,
			@RequestParam("password") String password,HttpServletRequest request) throws Exception {

		ModelAndView nextPage=new ModelAndView(); 
		
		//business method call
		try { 
				boolean isExist = service.login(id,password);
				
				if(isExist){
					HttpSession session=request.getSession();
					session.setAttribute("id", id); 
	
					nextPage.addObject("message", "Login Success");
				}else{ 
					nextPage.addObject("message", "Login Failed");
				} 
		} catch (Exception e) { 
			request.setAttribute("message", "Login Failed"); 
			e.printStackTrace();
		} 

		 nextPage.setViewName("result");
		 return nextPage;  
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
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
