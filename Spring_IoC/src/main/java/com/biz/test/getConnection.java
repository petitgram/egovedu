package com.biz.test;

import java.sql.Connection;

import com.biz.common.*;

public class getConnection {

	public static void main(String args[]){
		 
		ORADBUtil db = ORADBUtil.getInstance();
		//MYDBUtil db = MYDBUtil.getInstance();
		Connection conn = db.getConnection();
		System.out.println(conn);
		
	}
	
}
