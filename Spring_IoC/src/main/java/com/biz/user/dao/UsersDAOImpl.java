package com.biz.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.biz.common.DBUtil;
import com.biz.user.vo.Users;

public class UsersDAOImpl implements UsersDAOIF {

	@Override
	public int insert(Users user) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		
		String sql = "INSERT INTO users(name,password,name,role)"
				+ "VALUES (?,?,?,?)";
		
		//DBConnection 
		DBUtil db = DBUtil.getInstance();
		try{
			conn = db.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,user.getId());
			pstmt.setString(2,user.getPassword());
			pstmt.setString(3,user.getName());
			pstmt.setString(4,user.getRole());
			
			row = pstmt.executeUpdate();
			
			System.out.println("conn ============ " + conn);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				db.close(pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 		
		return row;
	}

	@Override
	public int update(Users user) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = -1;
		String sql = "UPDATE users SET password=?, name=?, role=? "
				+ "where id=?";
		DBUtil db=DBUtil.getInstance();
		
		try{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getPassword());
			pstmt.setString(2,user.getName());
			pstmt.setString(3,user.getRole());
			pstmt.setString(4,user.getId());
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				db.close(pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}   
		
		return row;
	}

	@Override
	public int remove(Users user) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = -1;
		String sql = "DELETE FROM users where id=?";
		DBUtil db=DBUtil.getInstance();
					
		try{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1,user.getId());
			
			row = pstmt.executeUpdate(); 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				db.close(pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
		return row;
	}

	@Override
	public int detele(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Users findUser(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Users user=null;
		
		String sql = "SELECT id,password,name,role FROM users "
				+ "where id=?";
		DBUtil db=DBUtil.getInstance();
		
		try{
		conn= db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		result = pstmt.executeQuery();
		
		if(result.next()){
			user=new Users(result.getString(1),
						   result.getString(2),
						   result.getString(3),
						   result.getString(4));
		}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				db.close(pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
		 
		return user;
	}

	@Override
	public boolean login(String id, String password) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		boolean isExist=false;
		
		String sql = "SELECT id,password,name,role FROM users "
				+ "where id=?";
		DBUtil db=DBUtil.getInstance();
		
		try{
		conn= db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		
		result = pstmt.executeQuery();
		
		if(result.next()){
			 isExist=true;
		}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				db.close(pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
		
		return false;
	}

	@Override
	public ArrayList<Users> findUserList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		ArrayList<Users> userList = new ArrayList<Users>();
		
		String sql = "SELECT id,password,name,role FROM users ";
		
		DBUtil db=DBUtil.getInstance();
		
		try{
		conn= db.getConnection();
		pstmt = conn.prepareStatement(sql); 
		
		result = pstmt.executeQuery();
		
		while(result.next()){
			userList.add(new Users(result.getString(1),
						   result.getString(2),
						   result.getString(3),
						   result.getString(4)));
		}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				db.close(pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
		
		return null;
	}

}
