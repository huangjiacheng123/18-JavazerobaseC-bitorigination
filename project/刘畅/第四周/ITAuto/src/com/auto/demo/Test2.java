package com.auto.demo;

import java.io.IOException;

import org.apache.hc.core5.http.ParseException;
import org.testng.annotations.Test;

import com.auto.dataprovider.NSDataProvider;
import com.auto.utils.HttpDriver;

import net.sf.json.JSONObject;

public class Test2 {
	
	@Test(dataProvider = "autojdbc",dataProviderClass = NSDataProvider.class)
	public void test(String id,String method,String type,String url,String param,String form,String json) throws ParseException, IOException {
		if(method.equals("get")) {
			if(param.equals("none")) {
				HttpDriver.doGet(url);
			
			}else {
				HttpDriver.doGet1(url, param);
			}
		}else {
			if(type.equals("form")) {
				HttpDriver.doPost(url, HttpDriver.stringToMap(form));
			}else {
				HttpDriver.doPost1(url, JSONObject.fromObject(json));
			}
		}
		
	}

}
