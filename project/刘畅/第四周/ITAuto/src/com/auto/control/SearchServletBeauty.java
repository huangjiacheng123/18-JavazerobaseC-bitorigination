package com.auto.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/searchBeauty")
public class SearchServletBeauty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServletBeauty () {
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
		String key = request.getParameter("key");
		if(!key.equals("")) {
			String sql = "select * from `case` where id = "+key;
			getServletContext().setAttribute("search2",sql);
			String s = request.getContextPath();
			response.sendRedirect(s+"/auto/showcase/1.jsp");
		}else {
			String sql = "select * from `case`";
			getServletContext().setAttribute("search2",sql);
			String s = request.getContextPath();
			response.sendRedirect(s+"/auto/showcase/1.jsp");
			
		}
		
		
	}

}
