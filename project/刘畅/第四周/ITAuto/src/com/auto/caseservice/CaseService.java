package com.auto.caseservice;

import java.util.List;
import java.util.Map;

import com.auto.caseentity.Case;
import com.auto.utils.DBUtil;

public class CaseService {
	
	//�������еĲ�����������map��ʽ����
	public List<Map<String, Object>> findAll() {
		return DBUtil.findAll("select * from `case`");
	}
	
	//�������еĲ����������Զ�����ʽ����
	public List<Case> findAllCases(){
		return DBUtil.find(Case.class, "select * from `case`", null);
	}

	//����һ����������
	public int saveCases(Case casee) {
		//return DBUtil.executeUpdate("insert into `case` (id,method,type,url,param,form,json,response) values (?,?,?,?,?,?,?,?)", new Object[] { casee.getId(),casee.getMethod(),casee.getType(),casee.getUrl(),casee.getParam(),casee.getForm(),casee.getJson(),casee.getResponse() });
		return DBUtil.executeUpdate("insert into `case` (id,project,name,method,type,url,param,form,json,expected,response,status) values (0,?,?,?,?,?,?,?,?,?,?,?)", new Object[] {casee.getProject(),casee.getName(),casee.getMethod(),casee.getType(),casee.getUrl(),casee.getParam(),casee.getForm(),casee.getJson(),casee.getExpect(),casee.getResponse(),casee.getStatus() });
	}

	//����id���ҵ�����������
	public Case findById(String id) {
		Object obj = DBUtil.findById(Case.class, id);
		return obj != null ? (Case)obj : null;
	}
	
	//����idģ����ѯ
	public List<Map<String, Object>> findByIdLike(Integer id) {
		List<Map<String, Object>> list= DBUtil.findByIdLike(Case.class, id);
		return list != null ? list : null;
	}
	
	//����id����
	
//	public int updateCase(Case casee) {
//		return 0;
//	}
	
	//ɾ����������
	public int deleteCase(String id) {
		return DBUtil.executeUpdate("delete from `case` where id=?", new Object[] {id});
	}

}
