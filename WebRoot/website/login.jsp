<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>会员登录</title>
		<meta name="author" content="wan-ka">
		<meta name="copyright" content="wan-ka">
		<link href="login/celink_common.css" rel="stylesheet" type="text/css">
		<link href="login/login.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="login/jquery.js"></script> 
		<script type="text/javascript" src="login/jquery.validate.js"></script>
		<script type="text/javascript" src="login/jsbn.js"></script>
		<script type="text/javascript" src="login/prng4.js"></script>
		<script type="text/javascript" src="login/rng.js"></script>
		<script type="text/javascript" src="login/rsa.js"></script>
		<script type="text/javascript" src="login/base64.js"></script>
		<script type="text/javascript" src="login/common.js"></script>
		<script type="text/javascript">
			$().ready(function() {
				var $loginForm = $("#loginForm");
				var $username = $("#username");
				var $password = $("#password");
				var $captcha = $("#captcha");
				var $captchaImage = $("#captchaImage");
				var $isRememberUsername = $("#isRememberUsername");
				var $submit = $(".login_btn");
				
				// 记住用户名
				if (getCookie("memberUsername") != null) {
					$isRememberUsername.prop("checked", true);
					$username.val(getCookie("memberUsername"));
					$password.focus();
				} else {
					$isRememberUsername.prop("checked", false);
					$username.focus();
				}
				if (getCookie("memberPassword") != null) {
					$isRememberUsername.prop("checked", true);
					$password.val(getCookie("memberPassword"));
					$submit.focus();
				} else {
					$isRememberUsername.prop("checked", false);
					$password.focus();
				}
				
				
				if($('#username').val()=="用户名"){
					$('#username').val('');
				}
				$('#username').bind('focus',function(){
					var value = this.value,
					hint = this.dataset['hint'];
					if(value == hint){
						this.value = '';
					}
				}).bind('blur',function(){
					var value = this.value,
						hint = this.dataset['hint'];
					if(value == ''){
						this.value = hint;
					}
				});
				
				if($('#password1').val()=="密码"){
					$('#password1').hide().next().show();
				}
				$('#password1').bind('focus',function(){
					var value = this.value,
						hint = this.dataset['hint'];
					if(value == hint){
						$(this).hide().next().show().focus();
					}
				});
				$('#password').bind('blur',function(){
					var value = this.value;
					if(value == ''){
						$(this).hide().prev().show();
					}
				});
				$('#captcha').bind('focus',function(){
					var value = this.value,
						hint = this.dataset['hint'];
					if(value == hint){
						this.value = '';
					}
				}).bind('blur',function(){
					var value = this.value,
						hint = this.dataset['hint'];
					if(value == ''){
						this.value = hint;
					}
				});

				// 更换验证码
				$captchaImage.click(function() {
					$captchaImage.attr("src", "login/captcha.jhtml?captchaId=cc5b0c3f-f102-4aa2-89c5-10ff32486458&timestamp=" + (new Date()).valueOf());
				});
			
				// 表单验证、记住用户名
				$submit.click(function() {
					$.ajax({
						url: $loginForm.attr("action"),
						type: "POST",
						data: {
							"user.username": $username.val(),
							"user.password": $password.val()/* ,
							isRememberUsername: $isRememberUsername.val()
								,captchaId: "cc5b0c3f-f102-4aa2-89c5-10ff32486458",
								captcha: $captcha.val() */
						},
						dataType: "json",
						cache: false,
						success: function(data) {
							if ($isRememberUsername.prop("checked")) {
								addCookie("memberUsername", $username.val(), {expires: 14 * 24 * 60 * 60});
								addCookie("memberPassword", $password.val(), {expires: 14 * 24 * 60 * 60});
							} else {
								removeCookie("memberUsername");
								removeCookie("memberPassword");
							}
							$submit.prop("disabled", false);
							if (data.message == "success") {
								location.href = "/Project/website/index.jsp";
							} else {
								$.message("error","登陆失败");
								/* $captcha.val("");
								$captchaImage.attr("src", "/common/captcha.jhtml?captchaId=cc5b0c3f-f102-4aa2-89c5-10ff32486458&timestamp=" + (new Date()).valueOf()); */
							}
						}
					});
				});
			});
		</script>
	</head>
<body style="background:#F9F9F9;">
	<div class="login">
    <div class="login_logo">
    	<a href="<%=basePath%>website/index.jsp">
    		<img src="login/d74b5412-a9e7-4481-b86d-5e9d6fbd891c.png">
    	</a>
    </div>
    <div class="login_content">
      <div class="login_form">
      <div class="regHeaderTip"><h1>玩咖科技，好玩</h1></div>
      	<div style="white-space:nowrap;margin-bottom:60px;color:#999">
			<a href="#">智能生活</a>
			,
			<a href="#">手机个性化配件</a>
			,
			<a href="#">充电与移动电源</a>
			,
			<a href="#">耳机与音箱</a>
			
		</div>
        <form id="loginForm" action="<%=basePath%>web/login" method="post" novalidate="novalidate">
     	 <div class="flogin">
			<div class="formdiv">
				<div class="undiv">
	          		<input type="text" id="username" name="user.username" class="mytext login_name" maxlength="50" data-hint="用户名" value="用户名">
	          	</div>
	          	<div class="pwdiv">
	          		<input type="text" data-hint="密码" value="密码" id="password1" class="mytext login_password">
	          		<input type="password" id="password" name="user.password" class="mytext login_password" style="display:none;" maxlength="20" autocomplete="off">
	          	</div>
			  	<!-- <div class="cadiv">
					<input type="text" style="width:200px;" id="captcha" name="captcha" class="mytext captcha login_captcha" maxlength="4" autocomplete="off" data-hint="验证码" value="验证码">
					<img id="captchaImage" style="vertical-align:middle" src="login/captcha.jhtml" title="点击更换验证码">
				</div> -->
			</div>
	  		<input type="button" class="login_btn" value="登 录">
			<p class="login_tips clearfix">
			  <span class="l_t_1 left">
			  	<input type="checkbox" id="isRememberUsername" name="isRememberUsername" value="true">两周内记住登录密码
			  </span> 
			  <span class="l_t_2 right">
			  	<a href="javascript:void($.message('warn','完善中。。。'))" class="forget_password">忘记密码？</a>
			  </span>
			</p>
	          	<a href="<%=basePath %>website/registered.jsp" class="login_reg">立即注册</a>
          </div>	
        </form>
      </div>
      <div class="clear"></div>
    </div>
    <div class="login_footer">
    	<p class="copyright">Copyright &copy; 2005-2013 玩咖智能生活商城 版权所有-粤ICP备11060697号-2</p>       
    </div>
  </div>
</body>
</html>