//《全部商品分类》右侧弹出菜单
$(function() {
	$('.all-goods .item').hover(
			function() {
				$(this).addClass('active').find('s').hide();
				if (($(this).find('.product-wrap ul li').length - 1) > $(this)
						.nextAll().length) {
					$(this).find('.product-wrap').addClass('bottoms');
				}
				$(this).find('.product-wrap').show();
			}, function() {
				$(this).removeClass('active').find('s').show();
				$(this).find('.product-wrap').hide();
			});
});

// 《购物车》下拉
$(document).ready(function() {
	$("#cart").mouseover(function() {
		$(".cartlist").show();
		$(".cart").addClass("active");
	}).mouseout(function() {
		$(".cartlist").hide();
		$(".cart").removeClass("active");
	});

	$("#cartlist").mouseover(function() {
		$(this).show();
		$(".cart").addClass("active");
	}).mouseout(function() {
		$(this).hide();
		$(".cart").removeClass("active");
	});
	

});

//导航下拉
var timeOutID;
$(document).ready(function() {
    $(".nav-list li").each(function(index) {
        $(this).mouseenter(function() {
            var node = $(this);				
            timeOutID = setTimeout(function() {
			    node.find(".arrow").show();
			    node.find(".nav-main-children").stop().slideDown(100);
            },200);
        }).mouseleave(function() {
		        clearTimeout(timeOutID);
		        $(this).find(".arrow").hide();
				$(this).find(".nav-main-children").stop().slideUp(100);
        });
    });
})


//返回顶部按钮
$(function() {
	$(window).scroll(function(){
		var scrolltop=$(this).scrollTop();		
		if(scrolltop>=200){		
			$("#elevator").css('display','block');
		}else{
			$("#elevator").css('display','none');
		}
	});
	$("#elevator").click(function(){
		$("html,body").animate({scrollTop: 0}, 500);	
	});		
	
  	$(".wechat").hover(function(){
		$(".wechatImg").show();
	},function(){
		$(".wechatImg").hide();
	});	
});


// 兼容IE9以下不显示input框的placeholder属性
(function($) {
	/* 玩珈科技 */

	var placeholderfriend = {
		focus : function(s) {
			s = $(s).hide().prev().show().focus();
			var idValue = s.attr("id");
			if (idValue) {
				s.attr("id", idValue.replace("placeholderfriend", ""));
			}
			var clsValue = s.attr("class");
			if (clsValue) {
				s.attr("class", clsValue.replace("placeholderfriend", ""));
			}
		}
	}

	// 判断是否支持placeholder
	function isPlaceholer() {
		var input = document.createElement('input');
		return "placeholder" in input;
	}
	// 不支持的代码
	if (!isPlaceholer()) {
		$(function() {

			var form = $(this);

			// 遍历所有文本框，添加placeholder模拟事件
			var elements = form.find("input[type='text'][placeholder]");
			elements.each(function() {
				var s = $(this);
				var pValue = s.attr("placeholder");
				var sValue = s.val();
				if (pValue) {
					if (sValue == '') {
						s.val(pValue);
					}
				}
			});

			elements.focus(function() {
				var s = $(this);
				var pValue = s.attr("placeholder");
				var sValue = s.val();
				if (sValue && pValue) {
					if (sValue == pValue) {
						s.val('');
					}
				}
			});

			elements.blur(function() {
				var s = $(this);
				var pValue = s.attr("placeholder");
				var sValue = s.val();
				if (!sValue) {
					s.val(pValue);
				}
			});

			// 遍历所有密码框，添加placeholder模拟事件
			var elementsPass = form.find("input[type='password'][placeholder]");
			elementsPass.each(function(i) {
				var s = $(this);
				var pValue = s.attr("placeholder");
				var sValue = s.val();
				if (pValue) {
					if (sValue == '') {
						// DOM不支持type的修改，需要复制密码框属性，生成新的DOM
					var html = this.outerHTML || "";
					html = html
							.replace(/\s*type=(['"])?password\1/gi,
									" type=text placeholderfriend")
							.replace(
									/\s*(?:value|on[a-z]+|name)(=(['"])?\S*\1)?/gi,
									" ")
							.replace(
									/\s*placeholderfriend/,
									" placeholderfriend value='"
											+ pValue
											+ "' "
											+ "onfocus='placeholderfriendfocus(this);' ");
					var idValue = s.attr("id");
					if (idValue) {
						s.attr("id", idValue + "placeholderfriend");
					}
					var clsValue = s.attr("class");
					if (clsValue) {
						s.attr("class", clsValue + "placeholderfriend");
					}
					s.hide();
					s.after(html);
				}
			}
		})	;

			elementsPass.blur(function() {
				var s = $(this);
				var sValue = s.val();
				if (sValue == '') {
					var idValue = s.attr("id");
					if (idValue) {
						s.attr("id", idValue + "placeholderfriend");
					}
					var clsValue = s.attr("class");
					if (clsValue) {
						s.attr("class", clsValue + "placeholderfriend");
					}
					s.hide().next().show();
				}
			});

		});
	}
	window.placeholderfriendfocus = placeholderfriend.focus;
})(jQuery);

