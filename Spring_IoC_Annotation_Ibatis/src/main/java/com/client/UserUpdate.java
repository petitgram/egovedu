package com.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.biz.common.ORADBUtil;

public class UserUpdate {
	public static void main(String[] args){
	 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = -1;
		String sql = "UPDATE users SET password=?, name=?, role=? "
				+ "where id=?";
		ORADBUtil db=ORADBUtil.getInstance();
		
		try{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"1234");
			pstmt.setString(2,"testtest");
			pstmt.setString(3,"anon");
			pstmt.setString(4,"test1");
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				db.close(pstmt, conn);
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}   
		 
		System.out.println("row ============ " + row);
	}
}
