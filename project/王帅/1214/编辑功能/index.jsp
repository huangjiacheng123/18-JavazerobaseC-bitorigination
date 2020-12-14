<%@page import="java.util.*"%>
<%@page import="com.auto.caseservice.CaseService"%>
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
</head>

<body>
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
				<input type="text" name="key" placeholder='请输入关键字' /><input
					type="submit" value="提交" />
			</form>	
			<div id="message2"">
				<p class="result" id="message2">

					<%
						String path = request.getContextPath();
						if (application.getAttribute("search2") == null) {

							out.print("<table border='1' align=left id='customers'>");
							//绘制表头
							out.print("<tr class='alt'>");
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
								out.print("<th align:center>" + col + "</th>");
							}
							out.print("</tr>");
							//绘制数据
							List<Map<String, Object>> listmap = new CaseService().findAll();
							//List<Map<String,Object>> listmap =(List<Map<String,Object>>)application.getAttribute("search2"); 

							for (int i = 0; i < listmap.size(); i++) {

								if (i % 2 == 0) {
									out.print("<tr class='alt'>");
									for (String col : cols) {
										out.print("<td align:center>" + listmap.get(i).get(col) + "</td>");
									}
									out.print("<td align:center><button class='delete-button' type='submit'><a href='" + path + "/delete?id=" + listmap.get(i).get("id")
											+ "'>delete</a></button></td>");
									out.print("<td align:center><button class='edit-button' type='submit'><a href='" + path + "/edit?id=" + listmap.get(i).get("id")
											+ "'>edit</a></button></td>");
									out.print("</tr>");
								} else {
									out.print("<tr>");
									for (String col : cols) {
										out.print("<td align:center>" + listmap.get(i).get(col) + "</td>");
									}
									out.print("<td align:center><button class='delete-button' type='submit'><a href='" + path + "/delete?id=" + listmap.get(i).get("id")
											+ "'>delete</a></button></td>");
									out.print("<td align:center><button class='edit-button' type='submit'><a href='" + path + "/edit?id=" + listmap.get(i).get("id")
											+ "'>edit</a></button></td>");
									out.print("</tr>");
								}
							}

							out.print("</table>");
							out.print("<br><br>");
						} else {

							out.print("<table border='1' align=left id='customers'>");
							//绘制表头
							out.print("<tr class='alt'>");
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
								out.print("<th align:center>" + col + "</th>");
							}
							out.print("</tr>");
							//绘制数据
							//List<Map<String, Object>> listmap = new CaseService().findAll();
							List<Map<String,Object>> listmap =(List<Map<String,Object>>)application.getAttribute("search2"); 

							for (int i = 0; i < listmap.size(); i++) {

								if (i % 2 == 0) {
									out.print("<tr class='alt'>");
									for (String col : cols) {
										out.print("<td align:center>" + listmap.get(i).get(col) + "</td>");
									}
									out.print("<td align:center><button class='delete-button' type='submit'><a href='" + path + "/delete?id=" + listmap.get(i).get("id")
											+ "'>delete</a></button></td>");
									out.print("<td align:center><button class='edit-button' type='submit'><a href='" + path + "/edit?id=" + listmap.get(i).get("id")
											+ "'>edit</a></button></td>");
									out.print("</tr>");
								} else {
									out.print("<tr>");
									for (String col : cols) {
										out.print("<td align:center>" + listmap.get(i).get(col) + "</td>");
									}
									out.print("<td align:center><button class='delete-button' type='submit'><a href='" + path + "/delete?id=" + listmap.get(i).get("id")
											+ "'>delete</a></button></td>");
									out.print("<td align:center><button class='edit-button' type='submit'><a href='" + path + "/edit?id=" + listmap.get(i).get("id")
											+ "'>edit</a></button></td>");
									out.print("</tr>");
								}
							}

							out.print("</table>");
							out.print("<br><br>");
							application.setAttribute("search2", null);

						}
					%>
					<form action="<%=request.getContextPath()%>/insert2" method="post"
						id="insertstyle">
						<input type="submit" value="插入" />
			</form>	
				</p>
			</div>
		</div>
		




	</div>
	<!-- foot -->
	<div class="foot" id="foot">
		<div class="foot_center">
			<ul id="first">
				<li style="font-size: 18px;">关于我们</li>
				<li><a href="#">团队介绍</a></li>
				<li><a href="#">加入我们</a></li>
				<li><a href="#">联系我们</a></li>
				<li><a href="#">联系白维扬</a></li>
				<li><a href="#">团队分工合作</a></li>
			</ul>
			<ul>
				<li style="font-size: 18px;">用例维护</li>
				<li><a href="#">Pigeon用例列表</a></li>
				<li><a href="#">Mapi用例列表</a></li>
				<li><a href="#">Http用例列表</a></li>
				<li><a href="#">其他用例列表</a></li>
				<li><a href="#">用例管理<//a></li>
			</ul>
			<ul>
				<li style="font-size: 18px;">用例数据配置</li>
				<li><a href="#">测试团队维护</a></li>
				<li><a href="#">服务信息维护</a></li>
				<li><a href="#">数据库信息维护</a></li>
				<li><a href="#">参数替换维护</a></li>
				<li><a href="#">前置/后置动作维护</a></li>
			</ul>
			<ul id="_right">
				<li style="font-size: 18px;">数据展示</li>
				<li><a href="#">Jenkins任务地址</a></li>
				<li><a href="#">查看 正确率</a></li>
				<li><a href="#">查看 覆盖率</a></li>
				<li><a href="#">查看 错误用例</a></li>
				<li><a href="#">查看 正确用例</a></li>
			</ul>
			<div class="right_part">
				<span style="font-size: 18px;">JAVA0C官方社交平台</span>
				<div class="logo">
					<img src="images/QQa.png" alt="qq" class="small1" /> <img
						src="images/wxa.png" alt="wx" class="small1" /> <img
						src="images/wba.png" alt="wb" class="small1" />
				</div>
				<div class="erweima">
					<img src="images/wxewm.jpg" id="big" />
				</div>
			</div>
			<div class="bottom">© 2020-2022
				JAVA0C网站版权所有，并保留所有权利。ICP备案证书号：冀ICP备17127392号</div>
		</div>
	</div>
</body>
<script src="js/animate.js"></script>
<script src="js/index.js"></script>
<script src="js/foot.js"></script>
<script src="js/smallScroll.js"></script>
<script src="js/inpcode.js"></script>
</html>
