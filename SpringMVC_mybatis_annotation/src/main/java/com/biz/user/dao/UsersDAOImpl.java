package com.biz.user.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.biz.common.DBUtil;
import com.biz.user.vo.Users; 

@Repository("userDAO")
public class UsersDAOImpl implements UsersDAOIF {

	public int insert(Users user) throws SQLException { 
	 
		SqlSession session = DBUtil.getSqlMapInstance().openSession();
		int row=-1;
		 
		try {
			row = session.update("insert",user);
			session.commit();
		} catch (Exception e) { 
			e.printStackTrace();
		} finally{
			session.close();
		}	 
		
		return row;
	}
 
	public int update(Users user) throws SQLException {
		
		SqlSession session = DBUtil.getSqlMapInstance().openSession();
		int row=-1; 
		 
		try {
			row = session.update("update", user);
			session.commit();
		} catch (Exception e) { 
			e.printStackTrace();
		} finally{
			session.close();
		}
		
		return row; 
	}
  
	public int detele(String id) throws SQLException { 

		SqlSession session = DBUtil.getSqlMapInstance().openSession();
		int row=-1; 
		 
		try {
			row = session.delete("delete",id);
			session.commit();
		} catch (Exception e) { 
			e.printStackTrace();
		} finally{
			session.close();
		}
		
		return row;
	} 
	
	public Users findUser(String id) {
		Users user=null;
		
		SqlSession session = DBUtil.getSqlMapInstance().openSession();
	 
		try {
			user=(Users) session.selectOne("findUser", id);
		} catch (Exception e) { 
			e.printStackTrace();
		} finally{
			session.close();
		} 
		
		return user;  
	}
 
	public boolean login(String id, String password) {
 		boolean isExist=false;
 		Object result = null;
		SqlSession session = DBUtil.getSqlMapInstance().openSession();
		HashMap<String,String> loginInfo = new HashMap<String,String>();
		
		loginInfo.put("id", id);
		loginInfo.put("password", password);
		
		try {
			result = session.selectOne("login",loginInfo);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		if(result!=null) isExist=true;
		
		return isExist;
	}
 
	public ArrayList<Users> findUserList() {
		 
		ArrayList<Users> userList = new ArrayList<Users>();
		SqlSession session = DBUtil.getSqlMapInstance().openSession(); 
		
		try {
			List<Users> result = session.selectList("findUserList");
			
			for (Users users : result) { 
				userList.add(users);
			}
			
		} catch (Exception e) { 
			e.printStackTrace();
		} finally{
			if(session!=null) session.close();
		}
		
		return userList;
	}

}
