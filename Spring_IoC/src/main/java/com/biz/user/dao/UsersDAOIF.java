package com.biz.user.dao;

import java.util.ArrayList;

import com.biz.user.vo.Users;

public interface UsersDAOIF {

	public abstract int insert(Users user);
	public abstract int update(Users user); 
	public abstract int detele(String id);
	public abstract Users findUser(String id);
	public abstract boolean login(String id,String password);
	public abstract ArrayList<Users> findUserList();
	
}
