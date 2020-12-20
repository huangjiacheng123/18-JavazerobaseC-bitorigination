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
 * Servlet implementation class CaseAddServlet
 */
@WebServlet("/add")
public class CaseAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaseAddServlet() {
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
		String project = request.getParameter("project");
		String name = request.getParameter("name");
		String method = request.getParameter("method");
		String type = request.getParameter("type");
		String url = request.getParameter("url");
		String param = request.getParameter("param");
		String form = request.getParameter("form");
		String json = request.getParameter("json");
		String expected = request.getParameter("expected");
	    Case case1 = new Case();
	    case1.setId(id);
	    case1.setProject(project);
	    case1.setName(name);
	    case1.setMethod(method);
	    case1.setType(type);
	    case1.setUrl(url);
	    case1.setParam(param);
	    case1.setForm(form);
	    case1.setJson(json);
	    case1.setExpect(expected);
	    new CaseService().saveCases(case1);
		String path=request.getContextPath();
		response.sendRedirect(path+"/auto/showcase/page.jsp");
		
		
	}

}
