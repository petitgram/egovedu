package com.client;

import com.biz.common.DBUtil;
import com.biz.user.vo.Users;
import com.ibatis.sqlmap.client.SqlMapClient;

public class UserIbatisInsert {

	public static void main(String[] args){
		
		SqlMapClient sqlMap = DBUtil.getSqlMapInstance();
 		 
		Users user=new Users("spring21","spring11","SPRING11","user");
		try {
			int result = sqlMap.update("insert",user);
			System.out.println("result ========== " + result);
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		
	}
}
