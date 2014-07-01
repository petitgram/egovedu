package com.client;

import java.util.ArrayList;
import java.util.HashMap;

import com.biz.common.DBUtil;
import com.biz.user.vo.Users;
import com.ibatis.sqlmap.client.SqlMapClient;

public class UserIbatisLogin {

	public static void main(String[] args){
		
		SqlMapClient sqlMap = DBUtil.getSqlMapInstance();
 		  
		try { 
			HashMap<String,String> loginInfo = new HashMap<String,String>();
			loginInfo.put("id", "test");
			loginInfo.put("password", "test123");
			
			Object result = sqlMap.queryForObject("login",loginInfo);
			System.out.println("result ========== " + result);
			
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		
	}
}
