<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*" %>
<%@page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setContentType("application/x-download");//设置为下载application/x-download  
		String filedownload = "/download/ITAuto.xlsx";//即将下载的文件的相对路径  
		String filedisplay = "ITAuto.xlsx";//下载文件时显示的文件保存名称  
		URLEncoder.encode(filedisplay, "UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);

		try {
			RequestDispatcher dis = application.getRequestDispatcher(filedownload);
			if (dis != null) {
				dis.forward(request, response);
			}
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.clear();
			out = pageContext.pushBody();
			out.close();
		}
	%>



	%>>

</body>
</html>