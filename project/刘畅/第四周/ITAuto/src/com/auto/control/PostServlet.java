package com.auto.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hc.core5.http.ParseException;

import com.auto.utils.HttpDriver;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/post")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
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
		String body = request.getParameter("body");
	    JSONObject rbody = JSONObject.fromObject(body.trim());
	    System.out.println(rbody);
		try {
			getServletContext().setAttribute("res",HttpDriver.doPost1(url, rbody).toString());
			response.sendRedirect("post.jsp");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
	}

}
