package com.auto.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auto.caseentity.Case;
import com.auto.caseservice.CaseService;

/**
 * Servlet implementation class CaseInsertServlet
 */
@WebServlet("/insert")
public class CaseInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaseInsertServlet() {
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
		
		String id = request.getParameter("id");
		String method = request.getParameter("method");
		String type = request.getParameter("type");
		String url = request.getParameter("url");
		String param = request.getParameter("param");
		String form = request.getParameter("form");
		String json = request.getParameter("json");
		String response1 = request.getParameter("response");
		Case case1 = new Case();
		case1.setCase(id, method, type, url, param, form, json,response1);
		
		new CaseService().saveCases(case1);
		String path=request.getContextPath();
		response.sendRedirect(path+"/auto/showcase/index.jsp");
	}

}
