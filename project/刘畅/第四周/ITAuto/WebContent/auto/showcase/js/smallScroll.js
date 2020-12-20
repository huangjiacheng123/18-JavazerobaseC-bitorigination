var box1 = document.getElementById("_right_");
var slider2 = document.getElementById("slider0");
var left1 = document.getElementById("left_first");
var right1 = document.getElementById("right_first");
var index1 = 1;
var isMoving1 = false;  //是否正在动
var timer1;

//播放函数
function next1(){
	if(isMoving1){
		return;
	}
	isMoving1 = true;
	index1++;
	if(index1 == 5){
		index1 = 4;
	}
	animate(slider2, {left:-700 * index1}, function(){
		if(index1 == 3){
			slider2.style.left = "0px";
			index1 = 0;
		}else if(index1 == 4){
			slider2.style.left = "-700px";
			index1 = 1;
		}
		isMoving1 = false;
	});
}

//向左移动函数
function prev1(){
	if(isMoving1){
		return;
	}
	isMoving1 = true;
	index1--;
	if(index1 == -1){
		index1 = 0;
	}
	animate(slider2, {left:-700 * index1}, function(){
		if(index1 == 1){
			slider2.style.left = "-2800px";
			index1 = 4;
		}else if(index1 == 0){
			slider2.style.left = "-2100px";
			index1 = 3;
		}
		isMoving1 = false;
	});
}

//自动轮播
timer1 = setInterval(next1, 3000);

//鼠标划上盒子取消轮播，左右箭头透明度设置为50%
box1.onmouseover = function(){
	animate(left1, {opacity:60});
	animate(right1, {opacity:60});
	clearInterval(timer1);
}
//鼠标离开盒子继续轮播，左右箭头消失
box1.onmouseout = function(){
	animate(left1, {opacity:40});
	animate(right1, {opacity:40});
	timer1 = setInterval(next1, 3000);
}

//点击右箭头，向右跳一张图
right1.onclick = function(){
	next1();
}

//点击左箭头,向左跳一张图
left1.onclick = function(){
	prev1();
}

