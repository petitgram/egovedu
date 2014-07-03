package com.biz.common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

 
public class DBUtil {
  
	private static final SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "SqlMapConfig.xml"; 
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =	new SqlSessionFactoryBuilder().build(inputStream); 
			
		} catch (Exception e) { 
			e.printStackTrace();
			throw new RuntimeException ("Error initializing	MyAppSqlConfig class. Cause: " + e); 
		}
	}
	
	public static SqlSessionFactory getSqlMapInstance () {
		return sqlSessionFactory;
	}
	
}
