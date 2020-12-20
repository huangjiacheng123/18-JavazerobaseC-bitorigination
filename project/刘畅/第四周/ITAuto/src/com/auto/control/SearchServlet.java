package com.auto.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auto.caseentity.Case;
import com.auto.caseservice.CaseService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		
//		String key = request.getParameter("key");
//		if(!key.equals("")) {
//			
//			
//			List<Map<String, Object>> list=new CaseService().findByIdLike(Integer.valueOf(key));
//			getServletContext().setAttribute("search2",list);
//			//之前demo的路径
//			//response.sendRedirect("index.jsp");
//			
//			String s = request.getContextPath();
//			response.sendRedirect(s+"/auto/showcase/index.jsp");
//		}else {
//			List<Map<String, Object>> list=new CaseService().findAll();
//			
//			//先转化再打印，已弃用
////			List<String> ls = new ArrayList<String>();
////			ls.add("id"+"       "+"method"+"         "+"type"+"         "+"url"+ "             "+"param"+"       "+"form" +"             "+"json"+"<br>");
////			for(int i=0;i<list.size();i++) {
////				StringBuilder sb = new StringBuilder();
////				Map<String, Object> map = list.get(i);
////				for(String s : map.keySet()) {
////					sb.append(map.get(s)).append("           ");
////				}
////				//sb.append("<br/>");
////				ls.add(sb.toString());
////			}
////			getServletContext().setAttribute("search2",ls);
////			response.sendRedirect("index.jsp");	
//			
//			//这是好的，我先注释掉，我调试别的；12/8；
//			getServletContext().setAttribute("search2",list);
//			String s = request.getContextPath();
//			response.sendRedirect(s+"/auto/showcase/index.jsp");
//			
//		
//			
//			
//			
//			
//			
//			
//		}
		
		
		
		
		
		
		
		
		String key = request.getParameter("key");
		String project = request.getParameter("project");
		String name = request.getParameter("name");
		String method = request.getParameter("method");
		String status = request.getParameter("status");
		
	    String sql = "SELECT * FROM `case` " + 
	    		"where (id like '%"+ key+"%' or '"+ key+"' is null or '"+ key+"' = '') " + 
	    		"and (project like '%"+ project+"%' or '"+ project+"' is null or '"+ project+"' = '') " + 
	    		"and (name like '%"+ name+"%' or '"+ name+"' is null or '"+ name+"' = '') " + 
	    		"and (method like '%"+ method+"%' or '"+ method+"' is null or '"+ method+"' = '') " + 
	    		"and (status like '%"+ status+"%' or '"+ status+"' is null or '"+ status+"' = '');";
	    String countSql="SELECT count(*) FROM `case` " + 
	    		"where (id like '%"+ key+"%' or '"+ key+"' is null or '"+ key+"' = '') " + 
	    		"and (project like '%"+ project+"%' or '"+ project+"' is null or '"+ project+"' = '') " + 
	    		"and (name like '%"+ name+"%' or '"+ name+"' is null or '"+ name+"' = '') " + 
	    		"and (method like '%"+ method+"%' or '"+ method+"' is null or '"+ method+"' = '') " + 
	    		"and (status like '%"+ status+"%' or '"+ status+"' is null or '"+ status+"' = '');";
	    String successSql="SELECT count(*) FROM `case` " + 
	    		"where (id like '%"+ key+"%' or '"+ key+"' is null or '"+ key+"' = '') " + 
	    		"and (project like '%"+ project+"%' or '"+ project+"' is null or '"+ project+"' = '') " + 
	    		"and (name like '%"+ name+"%' or '"+ name+"' is null or '"+ name+"' = '') " + 
	    		"and (method like '%"+ method+"%' or '"+ method+"' is null or '"+ method+"' = '') " + 
	    		"and (status like '%"+ status+"%' or '"+ status+"' is null or '"+ status+"' = '') and status= 'passed';";
	    String failureSql="SELECT count(*) FROM `case` " + 
	    		"where (id like '%"+ key+"%' or '"+ key+"' is null or '"+ key+"' = '') " + 
	    		"and (project like '%"+ project+"%' or '"+ project+"' is null or '"+ project+"' = '') " + 
	    		"and (name like '%"+ name+"%' or '"+ name+"' is null or '"+ name+"' = '') " + 
	    		"and (method like '%"+ method+"%' or '"+ method+"' is null or '"+ method+"' = '') " + 
	    		"and (status like '%"+ status+"%' or '"+ status+"' is null or '"+ status+"' = '') and status= 'failed';";
	    
	    getServletContext().setAttribute("search2",sql);
	    getServletContext().setAttribute("countSql",countSql);
	    getServletContext().setAttribute("successSql",successSql);
	    getServletContext().setAttribute("failureSql",failureSql);
		String s = request.getContextPath();
		response.sendRedirect(s+"/auto/showcase/page.jsp");
			
		
		
		
	}

}
