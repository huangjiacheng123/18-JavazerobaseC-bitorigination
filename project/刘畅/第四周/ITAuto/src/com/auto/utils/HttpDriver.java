package com.auto.utils;

import java.io.IOException;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;

import org.apache.hc.client5.http.cookie.Cookie;
import org.apache.hc.client5.http.cookie.CookieStore;
import org.apache.hc.client5.http.cookie.StandardCookieSpec;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import net.sf.json.JSONObject;

public class HttpDriver {
	public static JSONObject doGet(String url, CookieStore cookies) throws IOException, ParseException {

		RequestConfig config = RequestConfig.custom().setCookieSpec(StandardCookieSpec.STRICT).build();
		CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(config).setDefaultCookieStore(cookies)
				.build();

		HttpGet get = new HttpGet(url);

		CloseableHttpResponse response = client.execute(get);

		HttpEntity entity = response.getEntity();
		String strResult = EntityUtils.toString(entity);
		System.out.println(strResult);

		EntityUtils.consume(entity);
		response.close();
		client.close();

		JSONObject result = JSONObject.fromObject(strResult);

		List<Cookie> listCookies = cookies.getCookies();
		for (Cookie cookie : listCookies) {
			System.out.println(cookie.getName() + ":" + cookie.getValue());
		}

		return result;
	}

	public static String doGet(String url) throws IOException, ParseException {
		CloseableHttpClient client = HttpClients.createDefault();

		HttpGet get = new HttpGet(url);

		CloseableHttpResponse response = client.execute(get);

		HttpEntity entity = response.getEntity();
		String strResult = EntityUtils.toString(entity);
		System.out.println(strResult);

		EntityUtils.consume(entity);
		response.close();
		client.close();


		return strResult;

	}

	public static String doGet1(String url, String para) throws IOException, ParseException {
		CloseableHttpClient client = HttpClients.createDefault();

		HttpGet get = new HttpGet(url + para);

		CloseableHttpResponse response = client.execute(get);

		HttpEntity entity = response.getEntity();
		String strResult = EntityUtils.toString(entity);
		System.out.println(strResult);

		EntityUtils.consume(entity);
		response.close();
		client.close();

		

		return strResult;

	}

	public static JSONObject doPost1(String url, JSONObject body) throws IOException, ParseException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		HttpEntity requestEntity = new StringEntity(body.toString());
		post.setHeader("Content-Type", "application/json;charset=utf-8");
		post.setEntity(requestEntity);

		CloseableHttpResponse response = client.execute(post);

		HttpEntity entity = response.getEntity();
		String strResult = EntityUtils.toString(entity);
		System.out.println(strResult);

		EntityUtils.consume(entity);
		response.close();
		client.close();

		JSONObject result = JSONObject.fromObject(strResult);

		return result;

	}

	public static JSONObject doPost(String url, String formbody) throws IOException, ParseException {
		CloseableHttpClient client = HttpClients.createDefault();

		HttpPost post = new HttpPost(url);
		HttpEntity requestEntity = new StringEntity(formbody);
//		post.setHeader("Content-Type","application/json;charset=utf-8");
		post.setEntity(requestEntity);

		CloseableHttpResponse response = client.execute(post);

		HttpEntity entity = response.getEntity();
		String strResult = EntityUtils.toString(entity);
		System.out.println(strResult);

		EntityUtils.consume(entity);
		response.close();
		client.close();

		JSONObject result = JSONObject.fromObject(strResult);

		return result;

	}

	public static String doGet(String url, Map<String, Object> para)
			throws URISyntaxException, IOException, ParseException {
		CloseableHttpClient client = HttpClients.createDefault();
		StringBuffer sb = new StringBuffer();
		for (String s : para.keySet()) {
			sb.append(s).append("=").append(para.get(s)).append("&");
		}
		String result = sb.toString();
		String lastResult = result.substring(0, result.length() - 1);
		HttpGet get = new HttpGet(url + lastResult);
		CloseableHttpResponse response = client.execute(get);
		HttpEntity entity = response.getEntity();
		String result1 = EntityUtils.toString(entity);
		EntityUtils.consume(entity);
		response.close();
		client.close();
		return result1;
	}

	// ×Ô¼ºÌí¼Ó
	// form
	public static String doPost(String url, Map<String, Object> parm) throws IOException, ParseException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.setHeader("content-type", "application/x-www-form-urlencoded");
		if (parm != null) {
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			for (String key : parm.keySet()) {
				list.add(new BasicNameValuePair(key, (String) parm.get(key)));
			}
			HttpEntity entity = new UrlEncodedFormEntity(list);
			post.setEntity(entity);

		}
		CloseableHttpResponse response = client.execute(post);
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity);
		System.out.println(result);
		return result;

	}

	public static Map<String,Object> stringToMap(String body) {
		String[] ss = body.split(",");
		Map<String, Object> map = new HashMap<String, Object>();
		for (String s : ss) {
			String[] s1 = s.split("=");
			map.put(s1[0], s1[1]);
		}
		return map;
	}

}
