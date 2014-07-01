package com.biz.user.service;

import java.util.ArrayList;

import com.biz.user.dao.UsersDAOIF;
import com.biz.user.vo.Users;

public class UsersServiceImpl implements UsersServiceIF {
	private UsersDAOIF userDAO;
	
	public UsersServiceImpl(UsersDAOIF userDAO){
		this.userDAO = userDAO;
	}
	
	@Override
	public void addUser(Users user) throws Exception { 
		int row = userDAO.insert(user);
		if(row < 0) throw new Exception("Insert FAIL " + user.getId()); 
	}

	@Override
	public void updateUser(Users user) throws Exception {
		int row = userDAO.update(user);
		if(row < 0) throw new Exception("Update FAIL " + user.getId());   
	}

	@Override
	public void deleteUser(String id) throws Exception { 
		int row = userDAO.detele(id);
		if(row < 0) throw new Exception("Update FAIL " + id);  
	}

	@Override
	public Users findUser(String id) throws Exception {
		Users user = userDAO.findUser(id);
		if(user == null) throw new Exception("findUser FAIL " + id);   
		return null;
	}

	@Override
	public ArrayList<Users> findUserList() throws Exception {
		ArrayList<Users> userList = new ArrayList<Users>();
		userList = userDAO.findUserList();
		if(userList.isEmpty()) throw new Exception("findUserList FAIL ");   
		return null;
	}

}
