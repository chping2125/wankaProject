//首页加载内容
(function(){
	//加载左侧导航栏信息
	var node1 = document.querySelectorAll(".nav-m-l-h3");
	$.ajax({
		url: "./../go/getType",
		type: "GET",
		dataType: "json",
		success: function(data) {
			if(data.typeList != null){
				for(var i =0; i<node1.length;i++){
					node1[i].innerHTML = data.typeList[i].typeName;
				}
			}
		}
	});
	
	//加载nav导航内容
	var node2 = document.querySelectorAll(".nav-link");
	$.ajax({
		url: "./../go/getNav",
		type: "GET",
		dataType: "json",
		success: function(data) {
			if(data.navList != null){
				for(var i =0; i<node2.length;i++){
					node2[i].innerHTML = data.navList[i].navName;
				}
			}
		}
	});
	
	//加载明星单品
	var node3 = document.querySelector("#sp_ul");
	$.ajax({
		url: "./../go/getStartPro",
		type: "GET",
		dataType: "json",
		success: function(data) {
			if(data.startProList != null){
				var tag = "";
				for(var i =0; i<8;i++){
					var newNode = "<li class=\"sp_li\">";
					newNode +="<div class=\"sp_l_div\">";
					newNode +="<a class=\"sp_title\" href=\"#\">"+data.startProList[i].name+"</a>";
					newNode +="<span>"+data.startProList[i].price+"元</span>";
					newNode +="<a class=\"sp_img\">";
					newNode +="<img src=\""+data.startProList[i].image+"\" alt=\""+data.startProList[i].name+"\" width=\"264\" height=\"220\" />";
					newNode +="</a></div></li>";
					tag += newNode;
				}
				node3.innerHTML= tag;
			}
		}
	});
})();

//懒加载
var screenH = $(window).height();
var flag = 1;
$(window).scroll(function(){
	var scrollTop = $(window).scrollTop()+screenH;
	//加载新品
	if(scrollTop > 900){
		if(flag == 1){
			flag++;
			//加载新品--left
			var node4 = document.querySelector("#new_left_ul");
			$.ajax({
				url: "./../go/getNewPro",
				type: "GET",
				dataType: "json",
				success: function(data) {
					if(data.newProList != null){
						var tag = "<li class=\"sp_li sp_li_first\">";
							tag+="<a class=\"sp_img\">";
							tag+="<img src=\"images/n_img1.jpg\" alt=\"智能手环K1 酒红色\" width=\"593\" height=\"326\" /></a></li>";
						for(var i =0; i<4;i++){
							var newNode = "<li class=\"sp_li\">";
							newNode +="<div class=\"sp_l_div\">";
							newNode +="<a class=\"sp_title\" href=\"#\">"+data.newProList[i].name+"</a>";
							newNode +="<span>"+data.newProList[i].price+"元</span>";
							newNode +="<a class=\"sp_img\">";
							newNode +="<img src=\""+data.newProList[i].image+"\" alt=\""+data.newProList[i].name+"\" width=\"264\" height=\"220\" />";
							newNode +="</a></div></li>";
							tag += newNode;
						}
						node4.innerHTML= tag;
					}
				}
			});
			
			//加载新品--right
			var node5 = document.querySelector("#new_right_ul");
			$.ajax({
				url: "./../go/getNewPro2",
				type: "GET",
				dataType: "json",
				success: function(data) {
					if(data.newProList2 != null){
						var tag = "";
						for(var i =0; i<3;i++){
							var newNode = "<li><a href=\"#\"><div>";
							newNode +="<h4>"+data.newProList2[i].name+"</h4>";
							newNode +="<span>"+data.newProList2[i].price+"元</span>";
							newNode +="<del>"+data.newProList2[i].originPrice+"元</del>";
							newNode +="<p>剩余时间:557天15时57分</p>";
							newNode +="</div>";
							newNode +="<img src=\""+data.newProList2[i].image+"\" alt=\""+data.newProList2[i].name+"\" width=\"80\" height=\"70\"/>";
							if(data.newProList2[i].res1!=null){
								newNode +="<strong>"+data.newProList2[i].res1+"</strong>";
							}
							newNode +="</a></li>";
							tag += newNode;
						}
						node5.innerHTML = tag;
						$.ajax({
							url: "./../go/getNews",
							type: "GET",
							dataType: "json",
							success: function(data) {
								var newNode2 = "<li class=\"new_news\"><h3>新闻公告</h3><ul class=\"clear\">";
								for(var j=0;j<5;j++){
									newNode2 +="<li>";
									newNode2 +="<a href=\"#\"><i>·</i>" +
											"<strong>"+data.newList[i].name+"</strong>" +
											"<span>&gt;</span></a></li>";
								}
								newNode2 +="</ul>";
								node5.innerHTML += newNode2;
							}
						});
					}
				}
			});
		}
	}
	//加载大家都喜欢
	if(scrollTop > 1500){
		if(flag == 2){
			flag++;
			var node6 = document.querySelector("#allLove_left_ul");
			$.ajax({
				url: "./../go/getalLovePro",
				type: "GET",
				dataType: "json",
				success: function(data) {
					if(data.alLoveList != null){
						var tag = "<li class=\"sp_li sp_li_first\">";
							tag+="<a class=\"sp_img\">";
							tag+="<img src=\"images/al_img1.jpg\" alt=\"iPhone5带线车充\" width=\"593\" height=\"326\" /></a></li>";
						for(var i =0; i<4;i++){
							var newNode = "<li class=\"sp_li\">";
							newNode +="<div class=\"sp_l_div\">";
							newNode +="<a class=\"sp_title\" href=\"#\">"+data.alLoveList[i].name+"</a>";
							newNode +="<span>"+data.alLoveList[i].price+"元</span>";
							newNode +="<a class=\"sp_img\">";
							newNode +="<img src=\""+data.alLoveList[i].image+"\" alt=\""+data.alLoveList[i].name+"\" width=\"264\" height=\"220\" />";
							newNode +="</a></div></li>";
							tag += newNode;
						}
						node6.innerHTML= tag;
					}
				}
			});
			
			//加载新品--right
			var node7 = document.querySelector("#allLove_right_ul");
			$.ajax({
				url: "./../go/getalLovePro2",
				type: "GET",
				dataType: "json",
				success: function(data) {
					if(data.alLoveList2 != null){
						var tag = "<li class=\"al_r_title\"><h3><span class=\"al_t_t_red\">HOT</span>热销商品排行</h3></li>";
						for(var i =0; i<5;i++){
							var newNode = "<li><a href=\"#\">";
							if(i>2){
								newNode +="<div><i class=\"al_t_t_ccc\">"+ (i+1) +"</i>";
							}else{
								newNode +="<div><i class=\"al_t_t_red\">"+ (i+1) +"</i>";
							}
							
							newNode +="<h4>"+data.alLoveList2[i].name+"</h4>";
							newNode +="<span>"+data.alLoveList2[i].price+"</span>";
							newNode +="</div>";
							newNode +="<img src=\""+data.alLoveList2[i].image+"\" alt=\""+data.alLoveList2[i].name+"\" width=\"80\" height=\"70\"/>";
							newNode +="</a></li>";
							tag += newNode;
						}
						node7.innerHTML = tag;
					}
				}
			});
		}
	}
	//加载热评单品
	if(scrollTop > 2500){
		if(flag == 3){
			flag++;
			var node8 = document.querySelector("#hot_ul");
			$.ajax({
				url: "./../go/getHotPro",
				type: "GET",
				dataType: "json",
				success: function(data) {
					if(data.hotProList != null){
						var tag = "";
						for(var i =0; i<4;i++){
							var newNode = "<li class=\"sp_li hot_li\"><div class=\"sp_l_div\">";
							newNode +="<a class=\"sp_title\" href=\"#\">"+data.hotProList[i].name+"</a>";
							newNode +="<span class=\"hot_comments\"><i></i>1人评价</span>";
							newNode +="<span>"+data.hotProList[i].price+"元</span>";
							newNode +="<a class=\"sp_img\">";
							newNode +="<img src=\""+data.hotProList[i].image+"\" alt=\""+data.hotProList[i].name+"\" width=\"264\" height=\"220\" />";
							newNode +="</a>";
							newNode +="<p class=\"hot_comment_p\">"+data.hotProList[i].content+"</p>";
							newNode +="</div></li>";
							tag += newNode;
						}
						node8.innerHTML= tag;
					}
				}
			});
		}
	}
	//折扣商品
	if(scrollTop > 2900){
		if(flag == 4){
			flag++;
			//加载热评单品
			var node9 = document.querySelector("#sale_ul");
			$.ajax({
				url: "./../go/getSalePro",
				type: "GET",
				dataType: "json",
				success: function(data) {
					if(data.saleProList != null){
						var tag = "";
						for(var i =0; i<4;i++){
							var newNode = "<li class=\"sp_li\"><div class=\"sp_l_div\">";
							newNode +="<a class=\"sp_title\" href=\"#\">"+data.saleProList[i].name+"</a>";
							newNode +="<span>"+data.saleProList[i].price+"元</span>";
							newNode +="<a class=\"sp_img\">";
							newNode +="<img src=\""+data.saleProList[i].image+"\" alt=\""+data.saleProList[i].name+"\" width=\"264\" height=\"220\" />";
							newNode +="</a></div>";
							if(data.saleProList[i].res1 != null){
								newNode +="<p class=\"s_sale\">"+data.saleProList[i].res1+"</p></li>";
							}
							tag += newNode;
						}
						node9.innerHTML= tag;
					}
				}
			});
		}
	}
	
});