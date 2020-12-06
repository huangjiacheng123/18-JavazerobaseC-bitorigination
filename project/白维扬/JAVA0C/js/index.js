/*
 	ÊúÖ±ÂÖ²¥Í¼
*/
var home = document.getElementById("home");
var box = document.getElementById("box");
var slider = document.getElementById("slider");
var slidList = document.getElementsByClassName("slide");
var image = document.getElementById("image");
var isMoving = false;  //ÊÇ·ñÕýÔÚ¶¯
var index = 2; 		   //³õÊ¼ÏÔÊ¾µÚÈýÕÅÍ¼Æ¬
var imgList = ["images/skiing.png", "images/Surfing.png", "images/f1.png", "images/climbing.png", "images/i_one_img4.jpg"]
var up = document.getElementById("up");
var main = document.getElementById("main");
var down = document.getElementById("down");
var goRight = document.getElementsByClassName("goRight");
var right = document.getElementById("right");
var boxHiddenList = document.getElementsByClassName("box_hidden");
var posList = document.getElementsByClassName("pos");
var news1 = document.getElementById("news1");
var cur = document.getElementById("cur");
var foot = document.getElementById("foot");
var new2 = document.getElementById("new2");
var btn = document.getElementById("btn");
var second =document.getElementsByClassName("secon")[0];
var downscroll = document.getElementById("downscroll");
var bian =document.getElementById("bian");
var intro = document.getElementById("intro");
var downscroll2 = document.getElementById("downscroll2");
var intro2 = document.getElementById("intro2");
var downscroll3 = document.getElementById("downscroll3");
var intro3 = document.getElementById("intro3");
var topTop = document.getElementById("topTop");

//²¥·ÅÏÂÒ»ÕÅº¯Êý
function next(){
	var flag = false;
	if(isMoving){
		return;
	}
	index ++;
	if(index == 6) {
		index--;
		return;
	}
	imgChange(flag);
	isMoving = true;
	animate(slider, {top : -166 * index}, function(){
		if(index == 5){
			slider.style.top = "0";
			index = 0;
			slidList[index].id = "active";
		}
		isMoving = false;
	});
}


function pre(){
	if(isMoving){
		return;
	}
	index --;
	if(index == -1){
		index = 0;
		return;
	}
	imgChange();
	isMoving = true;
	console.log(index);
	animate(slider, {top : -166 * index}, function(){
		if(index == 0){
			slider.style.top = "-830px";
			index = 5;
			slidList[index].id = "active";
		}
		isMoving = false;
	});
}


//×Ô¶¯ÂÖ²¥
var timer = setInterval(next, 3000);


//Í¼Æ¬ÒÔ¼°ÎÄ×ÖµÄ±ä»¯
function imgChange(){
	for(var i = 0; i < slidList.length; ++i){
		slidList[i].id = "";
	}
	slidList[index].id = "active";
	//Í¼Æ¬±ä»¯
	if(index == 0){
		image.src = imgList[3];
	}else if(index == 1){
		image.src = imgList[4];
	}else{
		image.src = imgList[index-2];
	}
	//ÓÒ²àÎÄ×Ö½éÉÜµÄ±ä»¯
	for(var i = 0; i < boxHiddenList.length; ++i){
		boxHiddenList[i].style.display = "";
		boxHiddenList[i].style.top = "370px";
	}
	if(index == 0){
		boxHiddenList[3].style.display = "block";
		animate(boxHiddenList[3], {top : 210});
	}else if(index == 1){
		boxHiddenList[4].style.display = "block";
		animate(boxHiddenList[4], {top : 210});
	}else{
		boxHiddenList[index-2].style.display = "block";
		animate(boxHiddenList[index-2], {top : 210});
	}
}


//µã»÷Ã¿¸ö»¬¿é
for(var i = 0; i < slidList.length; ++i){
	//¸ù¾Ý×Ô¶¨ÒånamesÊôÐÔÍê³Éµã»÷ÊÂ¼þ
	slidList[i].onclick = function(){
		console.log(this.getAttribute("name"));
		clearInterval(timer);
		for(var i = 0; i < slidList.length; ++i){
			slidList[i].id = "";
		}
		this.id = "active";
		image.src = imgList[this.getAttribute("name") - 1];

		for(var i = 0; i < boxHiddenList.length; ++i){
			boxHiddenList[i].style.display = "";
			boxHiddenList[i].style.top = "370px";
		}
		boxHiddenList[this.getAttribute("name") - 1].style.display = "block";
		animate(boxHiddenList[this.getAttribute("name") - 1], {top : 210});
	}
}

//Êó±ê»®ÉÏºÐ×ÓÈ¡ÏûÂÖ²¥
image.onmouseover = function(){
	clearInterval(timer);	
}

//Êó±êÀë¿ªºÐ×Ó¼ÌÐøÂÖ²¥
image.onmouseout = function(){	
	timer = setInterval(next, 3000);
}


//ÇÐ»»ÉÏÒ»ÕÅ
up.onclick = pre;
//ÇÐ»»ÏÂÒ»ÕÅ
down.onclick = next;




window.onscroll = function(){
	var topScroll = window.pageYOffset;
	for(var i = 0; i < posList.length; ++i){
		posList[i].id = "";
	}
	if(topScroll < 500){
		posList[0].id = "selected";
	}else if(topScroll < 1200){
		posList[1].id = "selected";
	}else if(topScroll < 2000){
		posList[2].id = "selected";
	}else if(topScroll < 2666){
		posList[3].id = "selected";
	}else{
		posList[4].id = "selected";
	}
}

second.onmouseover = function(){
	this.id = "second";
}
second.onmouseout = function(){
	this.id = "";
}



//ÏòÏÂ»¬¶¯µ½Ö¸¶¨Î»ÖÃ
intro.onmouseover = function(){
	downscroll.firstElementChild.id = "";
}
downscroll.onclick = function(){
	this.firstElementChild.id = "bian";
	window.scrollTo({
        top: 1500,
        behavior:'smooth'
    });
}
//ÏòÏÂ»¬¶¯µ½Ö¸¶¨Î»ÖÃ
intro2.onmouseover = function(){
	downscroll2.firstElementChild.id = "";
}
downscroll2.onclick = function(){
	this.firstElementChild.id = "bian";
	window.scrollTo({
        top: 2650,
        behavior:'smooth'
    });
}
//ÏòÏÂ»¬¶¯µ½Ö¸¶¨Î»ÖÃ
intro3.onmouseover = function(){
	downscroll3.firstElementChild.id = "";
}
downscroll3.onclick = function(){
	this.firstElementChild.id = "bian";
	window.scrollTo({
        top: 3700,
        behavior:'smooth'
    });
}

topTop.onclick = function(){
	window.scroll({
		top : 0,
		behavior : "smooth"
	})
}
topTop.onmouseover = function(){
	animate(topTop, {opacity : 50});
}
topTop.onmouseout = function(){
	animate(topTop, {opacity : 20});
}



// //·ÖÍøÒ³Á´½Ó¶¯»­Ç°½ø
// var flag = false;  //¶¯»­Ò»¶¨±£Ö¤½áÊø
// goRight.onmouseover = function(){
// 	var timer1 = setInterval(function(){
// 		var now = parseInt(getStyle(right, "left"));
// 		console.log(now);
// 		if(now == 80){
// 			clearInterval(timer1);
// 			flag = true;
// 		}else{
// 			right.style.left = now + 1 + "px";
// 		}
// 	},8);
// }


// goRight.onmouseout = function(){
// 	if(flag){
// 			var timer1 = setInterval(function(){
// 			var now = parseInt(getStyle(right, "left"));
// 			if(now == 55){
// 				clearInterval(timer1);
// 			}else{
// 				right.style.left = now - 1 + "px";
// 			}
// 		},8);
// 	}
// }

