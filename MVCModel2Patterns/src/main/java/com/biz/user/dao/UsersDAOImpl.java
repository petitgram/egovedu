package com.biz.user.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.biz.common.DBUtil;
import com.biz.user.vo.Users;
import com.ibatis.sqlmap.client.SqlMapClient;
 
public class UsersDAOImpl implements UsersDAOIF {

	public int insert(Users user) throws SQLException { 
	 
		SqlMapClient sqlMap = DBUtil.getSqlMapInstance();
		int row=-1;
		Object result=null; 
		 
		try {
			result = sqlMap.update("insert",user);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	 
		
		if(result != null) row=1;
		
		return row;
	}
 
	public int update(Users user) throws SQLException {
		
		SqlMapClient sqlMap = DBUtil.getSqlMapInstance();
		int row=-1; 
		 
		try {
			row = sqlMap.update("update", user);
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		
		return row; 
	}
  
	public int detele(String id) throws SQLException { 

		SqlMapClient sqlMap = DBUtil.getSqlMapInstance();
		int row=-1; 
		 
		try {
			row = sqlMap.delete("delete",id);
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		
		return row;
	} 
	
	public Users findUser(String id) {
		Users user=null;
		
		SqlMapClient sqlMap = DBUtil.getSqlMapInstance();
	 
		try {
			user=(Users) sqlMap.queryForObject("findUser", id);
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		
		return user;  
	}
 
	public boolean login(String id, String password) {
 		boolean isExist=false;
 		Object result = null;
		SqlMapClient sqlMap = DBUtil.getSqlMapInstance();
		HashMap<String,String> loginInfo = new HashMap<String,String>();
		
		loginInfo.put("id", id);
		loginInfo.put("password", password);
		
		try {
			result = sqlMap.queryForObject("login",loginInfo);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		if(result!=null) isExist=true;
		
		return isExist;
	}
 
	public ArrayList<Users> findUserList() {
		 
		ArrayList<Users> userList = new ArrayList<Users>();
		SqlMapClient sqlMap = DBUtil.getSqlMapInstance();
		 
		try {
			userList = (ArrayList<Users>) sqlMap.queryForList("findUserList");
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return userList;
	}

}
