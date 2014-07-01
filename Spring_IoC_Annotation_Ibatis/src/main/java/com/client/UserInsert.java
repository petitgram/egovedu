package com.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.biz.common.ORADBUtil;

public class UserInsert {
	public static void main(String[] args){
	 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		
		String sql = "INSERT INTO users(id,password,name,role)"
				+ "VALUES (?,?,?,?)";

		System.out.println("sql ============ " + sql);
		//DBConnection 
		ORADBUtil db = ORADBUtil.getInstance();
		try{
			conn = db.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"test1");
			pstmt.setString(2,"1111");
			pstmt.setString(3,"test1");
			pstmt.setString(4,"geust");
			
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
		System.out.println("row ============ " + row);
	}
}
