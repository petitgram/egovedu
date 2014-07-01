package com.client;

import com.biz.common.DBUtil;
import com.biz.user.vo.Users;
import com.ibatis.sqlmap.client.SqlMapClient;

public class UserIbatisFindUser {

	public static void main(String[] args){
		
		SqlMapClient sqlMap = DBUtil.getSqlMapInstance();
 		  
		try { 
			Object result = sqlMap.queryForObject("findUser","spring11");
			System.out.println("result ========== " + result);
			
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		
	}
}
