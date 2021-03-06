package com.biz.user.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.user.dao.UsersDAOIF;
import com.biz.user.vo.Users;
 
@Service
public class UsersServiceImpl implements UsersServiceIF {

	@Autowired
	private UsersDAOIF userDAO;
	
//	private UsersDAOIF userDAO = new UsersDAOImpl();
	
//	public UsersServiceImpl(UsersDAOIF userDAO){
//		this.userDAO = userDAO;
//	}
//	public void setUserDAO(UsersDAOIF userDAO){
//		this.userDAO = userDAO;
//	}
	 
	public void addUser(Users user) throws Exception { 
		int row = userDAO.insert(user);
		if(row < 0) throw new Exception("Insert FAIL " + user.getId()); 
	}
 
	public void updateUser(Users user) throws Exception {
		int row = userDAO.update(user);
		if(row < 0) throw new Exception("Update FAIL " + user.getId());   
	}
 
	public void deleteUser(String id) throws Exception { 
		int row = userDAO.detele(id);
		if(row < 0) throw new Exception("Update FAIL " + id);  
	}
 
	public Users findUser(String id) throws Exception {
		Users user = userDAO.findUser(id);
		if(user == null) throw new Exception("findUser FAIL " + id);   
		return user;
	}
 
	public boolean login(String id,String password) throws Exception { 
		boolean login = userDAO.login(id, password); 
		if(login == false) throw new Exception("Login FAIL " + id);   
		return login;
	}
	 
	public ArrayList<Users> findUserList() throws Exception {
		ArrayList<Users> userList = new ArrayList<Users>();
		userList = userDAO.findUserList();
		if(userList.isEmpty()) throw new Exception("findUserList FAIL ");   
		return userList;
	}

}
