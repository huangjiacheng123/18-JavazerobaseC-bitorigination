	

/*
	提示文字
*/
var hint = ["请输入真实姓名","请输入5-11位QQ号","请输入反馈意见"];
var inp = document.getElementsByClassName("inp");
var noticeList = document.getElementsByClassName("notice");
//获得焦点时显示提示
inp[0].onfocus = function(){
	noticeList[0].innerHTML = hint[0];
}
inp[1].onfocus = function(){
	noticeList[1].innerHTML = hint[1];
}
inp[2].onfocus = function(){
	noticeList[2].innerHTML = hint[2];
}
//失去焦点，提示消失
inp[0].onblur = function(){
	noticeList[0].innerHTML = "";
}
inp[1].onblur = function(){
	noticeList[1].innerHTML = "";
}
inp[2].onblur = function(){
	noticeList[2].innerHTML = "";
}

/*
	验证码
*/
var currentCode;
var codes = ["zAZfB", "ZEhUN", "zFC9H", "zhWY9", "Zin4c", "ZITGj", "zJ6iV", "zjsKP", "ZKc9S", "zKDXU"];
var getCode = document.getElementsByClassName("getCode")[0];
getCode.onclick = function(){
	var codeImg = document.getElementsByClassName("codeImg")[0];
	//生成随机src
	currentCode = codes[Math.floor(Math.random()*10)];
	var src = "images/" + currentCode + ".jpg";
	var img = document.createElement("img");
	img.setAttribute("src", src);
	//如果验证码已经存在，则替换原节点
	if(codeImg.children[0]){
		codeImg.replaceChild(img, codeImg.children[0]);
	}
	//否则创建节点
	else{
		codeImg.appendChild(img);
	}
}


/*
	验证是否登录成功
*/
var checkMessage = ["请输入姓名","QQ位数不对", "请输入反馈意见", "验证码错误"];
var btn = document.getElementsByClassName("btnmess_btn")[0];
btn.onclick = function(){
	//获取信息
	var userName = inp[0].value;
	var qq = inp[1].value;
	var comment = inp[2].value;
	var code = document.getElementsByClassName("inpcode")[0].value;
	var flag = 1;   //登录成功判断标志
	//逐一验证
	if(userName == ""){
		noticeList[0].innerHTML = checkMessage[0];
	}
	if(qq.length < 5 || qq.length > 11 || qq == ""){
		noticeList[1].innerHTML = checkMessage[1];
		flag = 0;
	}
	if(comment == ""){
		noticeList[2].innerHTML = checkMessage[2];
		flag = 0;
	}
	if(code != currentCode){
		noticeList[3].innerHTML = checkMessage[3];
		flag = 0;
	}
	if(flag){
		alert("成功提交反馈！");
	}
}