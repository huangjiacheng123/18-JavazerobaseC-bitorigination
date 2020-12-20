<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/ITAuto/post.jsp">post方法</a>
	<form action="get" method="post">
		url:<input type="text" name="url" /><br> 参数:<input type="text"
			name="param" /><br> <input type="submit" value="提交" />
	</form>


	<form action="get" method="post">
		url:<input type="text" name="url" /><br> <input type="submit"
			value="提交" />
	</form>

	<div id="message1"">
		<p class="result" id="message1"><%=application.getAttribute("res")%></p>
	</div>

	<form action="search" method="post">
		请输入关键字:<input type="text" name="key" /><br> <input type="submit"
			value="提交" />
	</form>
	<div id="message2"">
		<p class="result" id="message2">

			<%
				if (application.getAttribute("search2") != null) {
					out.print("<table  border='1' align=left>");
					//绘制表头
					out.print("<tr>");
					List<String> cols = new ArrayList<String>();
					cols.add("id");
					cols.add("method");
					cols.add("type");
					cols.add("url");
					cols.add("param");
					cols.add("form");
					cols.add("json");
					cols.add("response");
					for (String col : cols) {
						out.print("<td align:center>" + col + "</td>");
					}
					out.print("</tr>");
					//绘制数据
					List<Map<String,Object>> listmap =(List<Map<String,Object>>)application.getAttribute("search2"); 
					
					for(int i=0;i<listmap.size();i++){
						out.print("<tr>");
						for (String col : cols) {
							out.print("<td align:center>" + listmap.get(i).get(col) + "</td>");
						}
						out.print("<td align:center><a href='delete?id="+listmap.get(i).get("id")+"'>delete</a></td>");
						out.print("</tr>");
						
					}
					
					//}
					out.print("</table>");
					out.print("<br><br>");
					application.setAttribute("search2", null);
					

				}
			%>
		</p>
	</div>


</body>
</html>