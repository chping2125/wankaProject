$(document).ready(function(){
	//显示下拉框   
	
	$("#goods-list").mouseenter(function() {  
		$(".all-goods").show();
	}).mouseleave(function() {  
		$(".all-goods").hide();
	});  
	  
	$("#all-goods").mouseenter(function(){  
		$(this).show(); 
	}).mouseleave(function() {  
		$(this).hide(); 
	}); 
});