package com.auto.demo;

import java.io.File;
import java.io.IOException;

import org.apache.hc.core5.http.ParseException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.auto.caseentity.Case;
import com.auto.caseservice.CaseService;
import com.auto.dataprovider.NSDataProvider;
import com.auto.utils.HttpDriver;


import net.sf.json.JSONObject;

public class Test1 {
	
	@Test(dataProvider = "auto",dataProviderClass = NSDataProvider.class)
	public void test(String id,String project,String name,String method,String type,String url,String param,String form,String json,String expected) throws ParseException, IOException {
		if(method.equals("get")) {
			if(param.equals("none")) {
				String response=HttpDriver.doGet(url).toString();
				Case case1=new Case();
				//case1.setId(id);
				case1.setMethod(method);
				case1.setProject(project);
				case1.setName(name);
				case1.setType(type);
				case1.setUrl(url);
				case1.setParam(param);
				case1.setForm(form);
				case1.setJson(json);
				case1.setExpect(expected);
				case1.setResponse(response);
				if(response.contains(expected)) {
					case1.setStatus("passed");
				}else {
					case1.setStatus("failed");
				}
				new CaseService().saveCases(case1);
				Assert.assertTrue(response.contains(expected));
				Reporter.log("lctest");
				
				
			
			}else {
				String response=HttpDriver.doGet1(url, param).toString();
				Case case1=new Case();
				//case1.setId(id);
				case1.setProject(project);
				case1.setName(name);
				case1.setMethod(method);
				case1.setType(type);
				case1.setUrl(url);
				case1.setParam(param);
				case1.setForm(form);
				case1.setJson(json);
				case1.setExpect(expected);
				case1.setResponse(response);
				if(response.contains(expected)) {
					case1.setStatus("passed");
				}else {
					case1.setStatus("failed");
				}
				new CaseService().saveCases(case1);
				Assert.assertTrue(response.contains(expected));
				Reporter.log("lctest");
			}
		}else {
			if(type.equals("form")) {
				String response=HttpDriver.doPost(url, HttpDriver.stringToMap(form));
				Case case1=new Case();
				//case1.setId(id);
				case1.setProject(project);
				case1.setName(name);
				case1.setMethod(method);
				case1.setType(type);
				case1.setUrl(url);
				case1.setParam(param);
				case1.setForm(form);
				case1.setJson(json);
				case1.setExpect(expected);
				case1.setResponse(response);
				if(response.contains(expected)) {
					case1.setStatus("passed");
				}else {
					case1.setStatus("failed");
				}
				new CaseService().saveCases(case1);
				Assert.assertTrue(response.contains(expected));
				Reporter.log("lctest");
			}else {
				String response=HttpDriver.doPost1(url, JSONObject.fromObject(json)).toString();
				Case case1=new Case();
				//case1.setId(id);
				case1.setProject(project);
				case1.setName(name);
				case1.setMethod(method);
				case1.setType(type);
				case1.setUrl(url);
				case1.setParam(param);
				case1.setForm(form);
				case1.setJson(json);
				case1.setExpect(expected);
				case1.setResponse(response);
				if(response.contains(expected)) {
					case1.setStatus("passed");
				}else {
					case1.setStatus("failed");
				}
				new CaseService().saveCases(case1);
				Assert.assertTrue(response.contains(expected));
				Reporter.log("lctest");
			}
		}
		
	}
	
	@AfterClass
	public void deleteFile() {
		File file = new File("D:\\AD\\temp\\ITAuto.xlsx");
		boolean isExists = file.exists();
		if(isExists) {
			file.delete();
			System.out.println("删除成功");
		}
		else {
			System.out.println("文件不存在");
		}
		
	}
	
	

}
