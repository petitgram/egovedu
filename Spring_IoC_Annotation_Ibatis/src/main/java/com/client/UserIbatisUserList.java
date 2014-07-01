package com.client;

import java.util.ArrayList;

import com.biz.common.DBUtil;
import com.biz.user.vo.Users;
import com.ibatis.sqlmap.client.SqlMapClient;

public class UserIbatisUserList {

	public static void main(String[] args){
		
		SqlMapClient sqlMap = DBUtil.getSqlMapInstance();
 		  
		try {  
			ArrayList<Users> result = (ArrayList<Users>) sqlMap.queryForList("findUserList");
			System.out.println("result ========== " + result);
			
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		
	}
}
