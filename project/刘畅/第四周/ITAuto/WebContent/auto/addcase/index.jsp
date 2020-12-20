<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>JAVA0C 首页</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/foot.css">
</head>

<body>
	<!-- 导航栏 -->
	<div class="nav">
		<div class="container">
			<div class="left">JavaZeroC</div>
			<!-- 右侧导航栏 -->
			<ul class="right">
				<li><a href="../index.jsp" class="pos">首页</a></li>
				<li><a href="#" id="selected" class="pos">用例维护</a></li>
				<li><a href="#" class="pos">用例数据配置</a></li>
				<li><a href="../showcase/page.jsp" class="pos">数据展示</a></li>
				<li><a href="#" class="pos">联系我们</a></li>
			</ul>
		</div>
	</div>
	<!--  Home大图板块-->
	<div id="home" class="text-center">
		<div class="over">
			<div>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> 
				<h1>Http测试用例维护</h1>
			</div>
		</div>
	</div>

	<!-- 这里是你要写的内容啦 -->
	<div id="news1" class="text-center">

		<div class="container">
			<!-- 刘畅加的 -->
			<div>
				<br>
				<form action="download.jsp" method="post">
		<input type="submit" value="下载excel模板">
	</form>
	<br>
				

				<form action="<%=request.getContextPath()%>/upload"
					enctype="multipart/form-data" method="post" id="uploadexcel">
					<span class="a-upload"> <input type="file" name="excel"
						value="" class="">点击上传excel文件
					</span> <input type="submit" value="点击上传" class="a_demo_two">
				</form>

			</div>
			<form action="<%=request.getContextPath()%>/ms" method="post">
				<div id="box">
					<div id="option">
						<select name="method" id="options">
							<option value="GET">GET</option>
							<option value="POST">POST</option>
							<option value="PUT">PUT</option>
							<option value="PATCH">PATCH</option>
							<option value="DELETE">DELETE</option>
							<option value="HEAD">HEAD</option>
							<option value="OPTIONS">OPTIONS</option>
						</select>
					</div>
					<input id="input1" type="text" name="url"
						placeholder="type your url here" />
					<button id="right" onclick="loadXMLDoc()">SEND</button>
				</div>
				<div class="main-center">
					<div class="left">
						<div class="left-header">
							<h1>Requset</h1>
							<img src="./image/vertical-line.png" alt="vertical-line">
							<div class="choice1" onclick="onclickchoice1()">Body</div>
							<img src="./image/vertical-line.png" alt="vertical-line">
							<div class="choice2" onclick="onclickchoice2()">Params</div>
							<img src="./image/vertical-line.png" alt="vertical-line">
							<div class="choice3">
								<select id="select2" name="type">
									<option value="Content_Type">Content-Type</option>
									<option value="application_xml">application/xml</option>
									<option value="application_json">application/json</option>
									<option value="multipart_form_data">multipart/form-data</option>
									<option value="application_x_www_form_urlencoded">
										application/x-www-form-urlencoded</option>
								</select>
							</div>
						</div>
						<div class="tab_bd_item" style="display: block">
							<textarea id="textarea1" name="body" class="textarea0" rows="10"
								placeholder="name1=white, value=white &#13;&#10;name2=black, value=black"></textarea>
							<div id="two_button">
								<!--                            这里还没实现，放到下一个迭代-->
								<button type="button">KV</button>
								<button type="button">Raw</button>
							</div>
						</div>
						<div class="tab_bd_item" style="display: none">
							<textarea id="textarea2" name="params" class="textarea0"
								rows="10" placeholder="name=123"></textarea>
						</div>
					</div>
				</div>
			</form>
		</div>

	</div>

	<!-- 过渡介绍分类1 -->
	<div class="text-center" id="intro">
		<div class="over">
			<div class="head">
				HERE'S <span>RESPONSE RESULT</span>
			</div>
			<div id="downscroll">
				<img src="images/down.png" />
			</div>
		</div>
	</div>

	<!-- contact with us -->
	<div class="contact">
		<div class="contact_center">
			<div class="main-center">
				<div class="left2">
					<div class="left-header2">
						<h1>Response</h1>
						<img src="./image/vertical-line.png" alt="vertical-line">
						<div class="choice4" onclick="onclickchoice3()">Body</div>
						<img src="./image/vertical-line.png" alt="vertical-line">
						<div class="choice5" onclick="onclickchoice4()">Header</div>
						<img src="./image/vertical-line.png" alt="vertical-line">
					</div>
					<div class="tab_bd_item" style="display: block">
						<!-- 不要格式化，在jsp代码前不要换行，空格什么的。 -->
							<!--  -->
						<textarea id="textarea3" class="textarea1" name="showresponse"
							rows="10"><%
                    	if (application.getAttribute("res") != null) {
                    		String s = application.getAttribute("res").toString();
                    		out.print(s.trim());
                    		application.setAttribute("res",null);
                    		
                    	}
                    %></textarea>
						<div id="three_button">
							<!--                            这里还没实现，放到下一个迭代-->
							<button type="button">Raw</button>
							<button type="button">Preview</button>
							<button type="button">Copy</button>
							<button type="button">Save</button>
						</div>
					</div>
					<div class="tab_bd_item" style="display: none">
						<textarea id="textarea4" class="textarea1" rows="10"
							placeholder=" Done is better than perfect"></textarea>
					</div>
				</div>
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
				<li><a href="#">用例管理</a></li>
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

	<div id="topTop">
		<a href="#"><img src="images/回到顶部.png" /></a>
	</div>
</body>
<script src="js/animate.js"></script>
<script src="js/index.js"></script>
<script src="js/foot.js"></script>
<script src="js/smallScroll.js"></script>
<script src="js/inpcode.js"></script>
<script src="js/form.js"></script>
</html>
































