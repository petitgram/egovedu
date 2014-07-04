package com.biz.user.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biz.user.vo.Users;

@Repository("userDAO")
public class UsersDAOImpl implements UsersDAOIF {
	
	@Autowired
	SqlSession session;
	
	public int insert(Users user) throws SQLException {   
		return session.insert("insert",user);
	}
 
	public int update(Users user) throws SQLException { 
		
		return session.update("update", user);
	}
  
	public int detele(String id) throws SQLException {  
		return session.delete("delete",id);
	} 
	
	public Users findUser(String id) { 
		return session.selectOne("findUser", id);  
	}
 
	public boolean login(String id, String password) {
 		boolean isExist=false; 
		
		HashMap<String,String> loginInfo = new HashMap<String,String>();
		
		loginInfo.put("id", id);
		loginInfo.put("password", password);
		 
		Object result = session.selectOne("login",loginInfo); 
		
		if(result!=null) isExist=true;
		
		return isExist;
	}
 
	public ArrayList<Users> findUserList() {
		 
		ArrayList<Users> userList = new ArrayList<Users>();  
	 
		List<Users> result = session.selectList("findUserList");
		
		for (Users users : result) { 
			userList.add(users);
		} 
		
		return userList;
	}

}
