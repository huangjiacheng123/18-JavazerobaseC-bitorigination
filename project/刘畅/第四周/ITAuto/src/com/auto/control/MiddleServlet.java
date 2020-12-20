package com.auto.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hc.core5.http.ParseException;


import com.auto.utils.HttpDriver;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class MiddleServlet
 */
@WebServlet("/ms")
public class MiddleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiddleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String method =request.getParameter("method");
		String url = request.getParameter("url");
		String type = request.getParameter("type");
		String body = request.getParameter("body");
		String params = request.getParameter("params");
	    
		
		if(method.equals("GET")) {
			if(params.equals("")) {
				try {
					//response.getWriter().write(HttpDriver.doGet(url).toString());
					getServletContext().setAttribute("res",HttpDriver.doGet(url) );
					//得到根路径
					response.sendRedirect(request.getContextPath()+"/auto/addcase/index.jsp");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				try {
					String result = HttpDriver.doGet1(url, params);
					//response.getWriter().write(result.toString());
					getServletContext().setAttribute("res",result);
					System.out.println("hello2");
					response.sendRedirect(request.getContextPath()+"/auto/addcase/index.jsp");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			}else if(method.equals("POST")){
				if(type.equals("application_json")) {
					JSONObject rbody = JSONObject.fromObject(body.trim());
				    System.out.println(rbody);
					try {
						String res = HttpDriver.doPost1(url, rbody).toString();
						getServletContext().setAttribute("res",res);
						response.sendRedirect(request.getContextPath()+"/auto/addcase/index.jsp");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					 String []ss = body.split(",");
					    Map<String, Object> map = new HashMap<String, Object>();
					    for(String s: ss) {
					    	String[] s1 = s.split("=");
					    	map.put(s1[0], s1[1]);
					    }
					    
					    
						try {
							getServletContext().setAttribute("res",HttpDriver.doPost(url, map).toString() );
							response.sendRedirect(request.getContextPath()+"/auto/addcase/index.jsp");
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
				
				
			}else {
				System.out.println("以后写");
				System.out.println(url+method);
			}
			
		}
		
	}


