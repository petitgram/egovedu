package com.biz.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class ORADBUtil {

	private final static String DRIVER="oracle.jdbc.driver.OracleDriver";
	private final static String URL="jdbc:oracle:thin:@localhost:1521:xe"; 
	private final static String USER="scott";
	private final static String PASSWORD="tiger";


	private static ORADBUtil instance; 
	
	private ORADBUtil(){ 
		try{
			Class.forName(DRIVER);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static ORADBUtil getInstance(){
		if(instance == null ) instance = new ORADBUtil();
		
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
