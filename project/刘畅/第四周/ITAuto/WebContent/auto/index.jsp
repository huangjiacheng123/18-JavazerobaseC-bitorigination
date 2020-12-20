
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
			<!--logo -->
			<div class="left">JavaZeroC</div>
			<!-- 右侧导航栏 -->
			<ul class="right">
				<li><a href="#" id="selected" class="pos">首页</a></li>
				<li><a href="addcase/index.jsp" class="pos">用例维护</a></li>
				<li><a href="#" class="pos">用例数据配置</a></li>
				<li><a href="showcase/page.jsp" class="pos">数据展示</a></li>
				<li><a href="#" class="pos">联系我们</a></li>
			</ul>
		</div>
	</div>

	<!--  Home大图板块-->
	<div id="home" class="text-center">
		<div class="over">
			<div class="content">
				<h1>
					JAVA语言 零基础 <span>C位出道</span>
				</h1>
				<p>一个接口测试平台，测试人测试魂，测试人都有美好的未来</p>
			</div>
		</div>
	</div>

	<!-- news1 -->
	<div id="news1" class="text-center">
		<div class="container">
			<div id="left">
				<div id="img-left">
					<img src="images/1.jpg">
				</div>
				<div id="content-right">
					<h2 class="bigger">用例维护</h2>
					<p class="grey">借口自动化测试用例维护入口</p>
					<p>
						<a href="#" class="beblue">Pigeon用例列表</a>
					</p>
					<p>
						<a href="#" class="beblue">Mapi用例列表</a>
					</p>
					<p>
						<a href="addcase/index.jsp" class="beblue">Http用例列表</a>
					</p>
				</div>
			</div>
			<div id="left">
				<div id="img-left">
					<img src="images/2.jpg">
				</div>
				<div id="content-right">
					<h2 class="bigger">用例数据配置</h2>
					<p class="grey">接口自动化测试用例数据维护</p>
					<p>
						<a href="#" class="beblue">测试团队维护</a>
					</p>
					<p>
						<a href="#" class="beblue">服务信息维护</a>
					</p>
					<p>
						<a href="showcase/page.jsp" class="beblue">数据库信息维护</a>
					</p>
					<p>
						<a href="#" class="beblue">参数替换维护</a>
					</p>
					<p>
						<a href="#" class="beblue">前置/后置动作维护</a>
					</p>
				</div>
			</div>
			<div id="left">
				<div id="img-left">
					<img src="images/3.jpg">
				</div>
				<div id="content-right">
					<h2 class="bigger">数据展示</h2>
					<p class="grey">数据展示快捷入口</p>
					<p>
						<a href="#" class="beblue">Jenkins任务地址添加</a>
					</p>
					<p>
						<a href="#" class="beblue">查看 成功率</a>
					</p>
					<p>
						<a href="#" class="beblue">查看 覆盖率</a>
					</p>
				</div>
			</div>
		</div>
	</div>


	<!-- 过渡介绍分类1 -->
	<div class="text-center" id="intro">
		<div class="over">
			<div class="head">
				CONTACT <span>WITH US</span>
			</div>
			<div id="downscroll">
				<img src="images/down.png" />
			</div>
		</div>
	</div>

	<!-- contact with us -->
	<div class="contact">
		<div class="contact_center">
			<div class="left">
				<h3>Hi,ARE YOU READY?</h3>
				<h4>对我们有什么建议？</h4>
				<h4>那就与我们取得联系吧!</h4>
				<div class="div1"></div>
				<p>让我们听到您的声音!</p>
				<p>您可以填写右边的表格，让我们了解自身问题所在，这是一个良好的开始，我们将对您的建议表示感谢。</p>
				<p id="bar1" class="bar">18633852030</p>
				<p id="bar2" class="bar">在线咨询</p>
			</div>
			<div class="right">
				<h3>请填写您的反馈信息</h3>
				<div style="margin-top: 10px;">
					您的姓名：<input name="txtName" type="text" autocomplete="off"
						class="inp">
				</div>
				<p class="notice"></p>
				<div>
					您的QQ：<input name="txtName" type="text" autocomplete="off"
						class="inp">
				</div>
				<p class="notice"></p>
				<div>
					<p>请告诉我们您的反馈</p>
					<textarea class="inp"></textarea>
				</div>

				<p class="notice"></p>
				<p id="getcode">
					<input class="inpcode" type="text" placeholder="验证码">
				</p>
				<button class="getCode">获取验证码</button>
				<p class="codeImg">
					<!-- 点击‘获取验证码’按钮后，在此处添加 验证码图片的img标签 -->
				</p>
				<p class="notice"></p>
				<input class="btnmess_btn" type="submit" value="提交">
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
				<!--				<li><a href="#">团队成员关系</a></li>-->
			</ul>
			<ul>
				<li style="font-size: 18px;">用例维护</li>
				<li><a href="#">Pigeon用例列表</a></li>
				<li><a href="#">Mapi用例列表</a></li>
				<li><a href="#">Http用例列表</a></li>
				<li><a href="#">其他用例列表</a></li>
				<li><a href="#">用例管理<//a></li>
				<!--				<li><a href="#">私人订制</a></li>-->
			</ul>
			<ul>
				<li style="font-size: 18px;">用例数据配置</li>
				<li><a href="#">测试团队维护</a></li>
				<li><a href="#">服务信息维护</a></li>
				<li><a href="#">数据库信息维护</a></li>
				<li><a href="#">参数替换维护</a></li>
				<li><a href="#">前置/后置动作维护</a></li>
				<!--				<li><a href="#">训练方案</a></li>-->
			</ul>
			<ul id="_right">
				<li style="font-size: 18px;">数据展示</li>
				<li><a href="#">Jenkins任务地址</a></li>
				<li><a href="#">查看 正确率</a></li>
				<li><a href="#">查看 覆盖率</a></li>
				<li><a href="#">查看 错误用例</a></li>
				<li><a href="#">查看 正确用例</a></li>
				<!--				<li><a href="#">鹰飞跳伞</a></li>-->
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

	<!--	<div id="topTop">-->
	<!--		<img src="images/回到顶部.png"/>-->
	<!--	</div>-->
</body>
<script src="js/animate.js"></script>
<script src="js/index.js"></script>
<script src="js/foot.js"></script>
<script src="js/smallScroll.js"></script>
<script src="js/inpcode.js"></script>
</html>
































