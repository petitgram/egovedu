package com.client;

import com.biz.common.DBUtil;
import com.biz.user.vo.Users;
import com.ibatis.sqlmap.client.SqlMapClient;

public class UserIbatisDelete {

	public static void main(String[] args){
		
		SqlMapClient sqlMap = DBUtil.getSqlMapInstance();
 		  
		try { 
			int result = sqlMap.delete("delete","spring10");
			System.out.println("result ========== " + result);
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		
	}
}
