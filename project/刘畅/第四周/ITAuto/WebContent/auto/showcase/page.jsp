<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>JAVA0C 首页</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/foot.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
<link rel="stylesheet" type="text/css" href="css/other.css">

</head>

<body style="background: linear-gradient(#FFEFD5, #FFEBCD)">
	<!-- 导航栏 -->
	<div class="nav">
		<div class="container">
			<div class="left">JavaZeroC</div>
			<!-- 右侧导航栏 -->
			<ul class="right">
				<li><a href="../index.jsp" class="pos">首页</a></li>
				<li><a href="../addcase/index.jsp" class="pos">用例维护</a></li>
				<li><a href="#" class="pos">用例数据配置</a></li>
				<li><a href="../showcase/index.jsp" id="selected" class="pos">数据展示</a></li>
				<li><a href="#" class="pos">联系我们</a></li>
			</ul>
		</div>
	</div>
	<!--  Home大图板块-->
	<div id="home" class="text-center">
		<div class="over"></div>
	</div>
	<!-- 主体 -->
	<div id="news1" class="text-center">
		<div class="container">
			<form action="<%=request.getContextPath()%>/search" method="post"
				id="searchstyle">
				<input type="text" name="key" class="inlink" placeholder='请输入id' />
				<input type="text" name="project" class="inlink"
					placeholder='请输入项目名称' /> <input type="text" name="name"
					class="inlink" placeholder='请输入用例名称' /> <select name="method"
					class="options">
					<option value="">请选择方法</option>
					<option value="GET">GET</option>
					<option value="POST">POST</option>
				</select> <select name="status" class="options">
					<option value="">请选择状态</option>
					<option value="passed">passed</option>
					<option value="failed">failed</option>
				</select> <input type="submit" value="提交" class="sub-button"/ >
			</form>
			<!--  
			<form action="add.jsp" method="post"
						id="insertstyle">
						<input type="submit" value="插入" />
			</form>	
			-->
			<div id="message2"">
				<p class="result" id="message2">
					<%!int pageSize = 6;
	int pageCount;
	int showPage;%>

					<!-- 连接数据库并从数据库中调取记录-->
					<%
						Connection con;
						Statement sql;
						Statement sqlSuccess;
						Statement sqlFailure;
						Statement sqlCount;
						ResultSet rs;
						ResultSet successRs;
						ResultSet failureRs;
						ResultSet countRs;
						int count=0;
						int success=0;
						int failure=0;

						try {
							Class.forName("com.mysql.jdbc.Driver");
						} catch (ClassNotFoundException e) {
						}

						try {
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itauto?serverTimezone=UTC", "root",
									"123456");
							sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
							sqlSuccess=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
							sqlFailure=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
							sqlCount=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
							//返回可滚动的结果集 
							if (application.getAttribute("search2") != null) {
								rs = sql.executeQuery(application.getAttribute("search2").toString());
								//application.setAttribute("search2", null);
								countRs=sqlCount.executeQuery(application.getAttribute("countSql").toString());
								successRs=sqlSuccess.executeQuery(application.getAttribute("successSql").toString());
								failureRs=sqlFailure.executeQuery(application.getAttribute("failureSql").toString());
								
							} else {
								rs = sql.executeQuery("select * from `case`");
								countRs=sqlCount.executeQuery("select count(*) from `case`");
								successRs=sqlSuccess.executeQuery("select count(*) from `case` where status='passed'");
								failureRs=sqlFailure.executeQuery("select count(*) from `case` where status='failed'");

							}
							
							//计算个数（刘畅加）
							if(countRs.next()){
								count=countRs.getInt(1);
							}
							if(successRs.next()){
								success=successRs.getInt(1);
							}
							if(failureRs.next()){
								failure=failureRs.getInt(1);
							}
							
							
							out.print("总数:<span class='h2'>"+count+"</span>"+"成功用例:<span  class='h2' id='green'>"+success+"</span>"+"失败用例:<span  class='h2' id='red'>"+failure+"</span>");
							
							
							//将游标移到最后一行 
							rs.last();
							//获取最后一行的行号 
							int recordCount = rs.getRow();
							//计算分页后的总数 
							pageCount = (recordCount % pageSize == 0) ? (recordCount / pageSize) : (recordCount / pageSize + 1);

							//获取用户想要显示的页数：
							String integer = request.getParameter("showPage");
							if (integer == null) {
								integer = "1";
							}
							try {
								showPage = Integer.parseInt(integer);
							} catch (NumberFormatException e) {
								showPage = 1;
							}
							if (showPage <= 1) {
								showPage = 1;
							}
							if (showPage >= pageCount) {
								showPage = pageCount;
							}

							//如果要显示第showPage页，那么游标应该移动到的position的值是：
							int position = (showPage - 1) * pageSize + 1;
							//设置游标的位置
							rs.absolute(position);
							//用for循环显示本页中应显示的的记录
							out.print("<table border='1' align=left id='customers'>");
							out.print("<tr class='alt'>");
							List<String> cols = new ArrayList<String>();
							cols.add("id");
							cols.add("project");
							cols.add("name");
							cols.add("method");
							cols.add("type");
							cols.add("url");
							cols.add("param");
							cols.add("form");
							cols.add("json");
							cols.add("expected");
							cols.add("response");
							cols.add("status");
							for (String col : cols) {
								out.print("<th align:center>" + col + "</th>");
							}
							out.print("<th align:center>" + "opera" + "</th>");
							out.print("</tr>");
							for (int i = 1; i <= pageSize; i++) {
					%>

					<%
						String path = request.getContextPath();
								out.print("<tr class='alt'>");
								out.print("<td align:center>" + rs.getString("id") + "</td>");
								out.print("<td align:center>" + rs.getString("project") + "</td>");
								out.print("<td align:center>" + rs.getString("name") + "</td>");
								out.print("<td align:center>" + rs.getString("method") + "</td>");
								out.print("<td align:center>" + rs.getString("type") + "</td>");
								out.print("<td align:center>" + rs.getString("url") + "</td>");
								out.print("<td align:center>" + rs.getString("param") + "</td>");
								out.print("<td align:center>" + rs.getString("form") + "</td>");
								out.print("<td align:center>" + rs.getString("json") + "</td>");
								out.print("<td align:center>" + rs.getString("expected") + "</td>");
								out.print("<td align:center>" + rs.getString("response") + "</td>");
								out.print("<td align:center>" + rs.getString("status") + "</td>");
								out.print("<td align:center><button class='delete-button' type='submit'><a class='alink' href='"
										+ path + "/deleteBeauty?id=" + rs.getString("id") + "'>delete</a></button></td>");
								out.print("</tr>");
					%>

					<%
						rs.next();
							}
							out.print("</table>");
							rs.close();
							con.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					%>
				
				<div class="lc">
					<br> 第<%=showPage%>页（共<%=pageCount%>页） <br>
					<a href="page.jsp?showPage=1">首页 &nbsp</a> <a
						href="page.jsp?showPage=<%=showPage - 1%>">上一页 &nbsp</a>
					<%
						//根据pageCount的值显示每一页的数字并附加上相应的超链接
						for (int i = 1; i <= pageCount; i++) {
					%>
					<a href="page.jsp?showPage=<%=i%>"><%=i%></a>
					<%
						}
					%>
					<a href="page.jsp?showPage=<%=showPage + 1%>">&nbsp 下一页 &nbsp</a> <a
						href="page.jsp?showPage=<%=pageCount%>">末页</a>
					<!-- 通过表单提交用户想要显示的页数 -->
					<form action="page.jsp" method="get">
						跳转到第&nbsp<input type="text" name="showPage" size="4">&nbsp页
						&nbsp&nbsp<input type="submit" name="submit" value="跳转"
							class='jump'>
					</form>
				</div>

			</div>
		</div>
</body>
<script src="js/animate.js"></script>
<script src="js/index.js"></script>
<script src="js/foot.js"></script>
<script src="js/smallScroll.js"></script>
<script src="js/inpcode.js"></script>
</html>



