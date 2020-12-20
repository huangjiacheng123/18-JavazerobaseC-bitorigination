package com.auto.caseservice;

import com.auto.caseentity.Case;
import com.auto.utils.DBUtil;

public class TestService {
	
	//插入一条测试用例
		public int saveCases(Case casee) {
			return DBUtil.executeUpdate("insert into `test` (id,method,type,url,param,form,json,response) values (0,?,?,?,?,?,?,?)", new Object[] {casee.getMethod(),casee.getType(),casee.getUrl(),casee.getParam(),casee.getForm(),casee.getJson(),casee.getResponse() });
		}
	
	

}
