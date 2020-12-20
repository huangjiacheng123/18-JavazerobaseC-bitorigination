	var one = document.getElementsByClassName('one')[0];
	var two = document.getElementsByClassName('two')[0];
	var three = document.getElementsByClassName('three')[0];
	var four = document.getElementsByClassName('four')[0];
	var time2,time3,time4;
	two.style.right = '-110px';
	three.style.right = '-110px';	
	one.style.opacity = 0.7;
	two.style.opacity = 0.7;
	three.style.opacity = 0.7;	
	four.style.opacity = 0.7;

	one.onclick = function(){
		window.scrollTo({
			top : 0,
			behavior:"smooth"
		})
	}
	one.onmouseover = function(){
		one.style.opacity = 1;
	}
	one.onmouseout = function(){
		one.style.opacity = 0.7;
	}
	two.onmouseover = function(){
		var t = parseInt(two.style.right);
		clearInterval(time2);
		two.style.opacity = 1;
		time2 = setInterval(function(){
			t++;
			two.style.right = t + "px";
			if(t>=0){
				two.style.right = "0px";
				clearInterval(time2);
			}
		},0.1);
	}
	two.onmouseout = function(){
		var t = parseInt(two.style.right);
		clearInterval(time2);
		two.style.opacity = 0.7;
		time2 = setInterval(function(){
			t--;
			two.style.right = t + "px";
			if(t<=-110){
				two.style.right = -110+'px';
				clearInterval(time2);
			}
		},0.1);
	}

	three.onmouseover = function(){
		var t = parseInt(three.style.right);
		clearInterval(time3);
		three.style.opacity = 1;
		time3 = setInterval(function(){
			t++;
			three.style.right = t + "px";
			if(t>=0){
				three.style.right = "0px";
				clearInterval(time3);
			}
		},0.1);
	}
	three.onmouseout = function(){
		var t = parseInt(three.style.right);
		clearInterval(time3);
		three.style.opacity = 0.7;
		time3 = setInterval(function(){
			t--;
			three.style.right = t + "px";
			if(t<=-110){
				three.style.right = -110+'px';
				clearInterval(time3);
			}
		},0.1);
	}
	four.onmouseover = function(){
		four.style.opacity = 1;
	}
	four.onmouseout = function(){
		four.style.opacity = 0.7;
	}

	
