package com.auto.caseservice;

import java.util.List;
import java.util.Map;

import com.auto.caseentity.Case;
import com.auto.utils.DBUtil;

public class CaseService {
	
	//查找所有的测试用例，以map形式返回
	public List<Map<String, Object>> findAll() {
		return DBUtil.findAll("select * from `case`");
	}
	
	//查找所有的测试用例，以对象形式返回
	public List<Case> findAllCases(){
		return DBUtil.find(Case.class, "select * from `case`", null);
	}

	//插入一条测试用例
	public int saveCases(Case casee) {
		//return DBUtil.executeUpdate("insert into `case` (id,method,type,url,param,form,json,response) values (?,?,?,?,?,?,?,?)", new Object[] { casee.getId(),casee.getMethod(),casee.getType(),casee.getUrl(),casee.getParam(),casee.getForm(),casee.getJson(),casee.getResponse() });
		return DBUtil.executeUpdate("insert into `case` (id,project,name,method,type,url,param,form,json,expected,response,status) values (0,?,?,?,?,?,?,?,?,?,?,?)", new Object[] {casee.getProject(),casee.getName(),casee.getMethod(),casee.getType(),casee.getUrl(),casee.getParam(),casee.getForm(),casee.getJson(),casee.getExpect(),casee.getResponse(),casee.getStatus() });
	}

	//根据id查找单个测试用例
	public Case findById(String id) {
		Object obj = DBUtil.findById(Case.class, id);
		return obj != null ? (Case)obj : null;
	}
	
	//根据id模糊查询
	public List<Map<String, Object>> findByIdLike(Integer id) {
		List<Map<String, Object>> list= DBUtil.findByIdLike(Case.class, id);
		return list != null ? list : null;
	}
	
	//根据id更新
	
//	public int updateCase(Case casee) {
//		return 0;
//	}
	
	//删除测试用例
	public int deleteCase(String id) {
		return DBUtil.executeUpdate("delete from `case` where id=?", new Object[] {id});
	}

}
