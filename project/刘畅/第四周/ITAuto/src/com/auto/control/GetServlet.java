package com.auto.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.hc.core5.http.ParseException;

import com.auto.utils.HttpDriver;


/**
 * Servlet implementation class GetServlet
 */
@WebServlet("/get")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetServlet() {
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
		
		
		String url = request.getParameter("url");
		String param = request.getParameter("param");
		if(param==null) {
			try {
				//response.getWriter().write(HttpDriver.doGet(url).toString());
				getServletContext().setAttribute("res",HttpDriver.doGet(url) );
				response.sendRedirect("index.jsp");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			try {
				String result = HttpDriver.doGet1(url, param);
				//response.getWriter().write(result.toString());
				getServletContext().setAttribute("res",result);
				response.sendRedirect("index.jsp");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
