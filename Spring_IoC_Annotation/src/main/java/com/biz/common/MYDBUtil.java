package com.biz.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class MYDBUtil {

	private final static String DRIVER="com.mysql.jdbc.Driver";
	private final static String URL="jdbc:mysql://127.0.0.1:3306/egov"; 
	private final static String USER="egov";
	private final static String PASSWORD="egov";
	
	
	private static MYDBUtil instance; 
	
	private MYDBUtil(){ 
		try{
			Class.forName(DRIVER);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static MYDBUtil getInstance(){
		if(instance == null ) instance = new MYDBUtil();
		
		return instance;
	}
	
	public Connection getConnection(){ 
		Connection conn=null; 
		try{
			conn = DriverManager.getConnection(URL, USER,PASSWORD);

		}catch(Exception e){
			e.printStackTrace();
		} 
		
		return conn;
	}
	
	public void close(ResultSet result,Statement stmt,Connection conn){ 
		try{
			if(result!=null) result.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close(); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void close(Statement stmt,Connection conn) throws SQLException{ 
		
		try{
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
