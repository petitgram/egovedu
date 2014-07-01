package com.biz.user.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.biz.user.vo.Users;

public interface UsersDAOIF {

	public abstract int insert(Users user) throws SQLException;
	public abstract int update(Users user) throws SQLException; 
	public abstract int detele(String id) throws SQLException;
	public abstract Users findUser(String id);
	public abstract boolean login(String id,String password);
	public abstract ArrayList<Users> findUserList();
	
}
