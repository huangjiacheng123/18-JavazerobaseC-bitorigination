<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>菜鸟教程(runoob.com)</title>
</head>
<body>
	Hello World!
	<br />
	<%
		out.println("你的 IP 地址 " + request.getRemoteAddr());
	%>
	<%-- 该部分注释在网页中不会被显示--%>
	<%--

<%-- 注释 --%	JSP注释，注释内容不会被发送至浏览器甚至不会被编译
<!-- 注释 --	HTML注释，通过浏览器查看网页源代码时可以看见注释内容
<\%	 代表静态       <%常量
%\>	代表静态        %> 常量
\'	在属性中使用的单引号
\"	在属性中使用的双引号

 --%>


	<p>
		今天的日期是:
		<%=(new java.util.Date()).toLocaleString()%>
	</p>
</body>
</html>