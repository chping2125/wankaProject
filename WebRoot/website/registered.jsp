<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>会员注册</title>
	<meta name="author" content="SHOP++ Team">
	<meta name="copyright" content="SHOP++" />
	<link href="registered/style-celink.css" rel="stylesheet" type="text/css"/>
	<link href="registered/zebra_dialog.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="registered/jquery.js"></script>
	<script type="text/javascript" src="registered/jquery.cookie.js"></script>
	<script type="text/javascript" src="registered/jquery.validate.js"></script>
	<script type="text/javascript" src="registered/zzsc-celink.js"></script>
	<script type="text/javascript" src="registered/jsbn.js"></script>
	<script type="text/javascript" src="registered/prng4.js"></script>
	<script type="text/javascript" src="registered/rng.js"></script>
	<script type="text/javascript" src="registered/rsa.js"></script>
	<script type="text/javascript" src="registered/base64.js"></script>
	<script type="text/javascript" src="registered/zebra_dialog.js"></script>
	<script type="text/javascript" src="registered/common2.js"></script>
	<script type="text/javascript">
		$().ready(function() {
			var $registerForm = $("#registerForm");
			var $username = $("#username");
			var $password = $("#password");
			var $submit = $(":button");
			var $agreement = $("#agreement");
			
			// 注册协议
			$agreement.hover(function() {
				$(this).height(200);
			});
			
			$("#checked_w").attr("checked","true");
			
			// 表单验证
			$submit.click(function(){
				$.ajax({
					url: $registerForm.attr("action"),
					type: "POST",
					data: {
						"user.username": $username.val(),
						"user.password": $password.val()
					},
					dataType: "json",
					cache: false,
					success: function(data) {
						if (data.message == "success") {
							$submit.prop("disabled", false);
							$.message2("success","注册成功，马上跳转登录界面");
							window.setTimeout(function() {
								location.href = "/Project/website/login.jsp";
							}, 3000);
						}else if(data.message == "null"){
							$submit.prop("disabled", true);
							$.message2("error","手机号、密码为必填项");
						}else if(data.message == "repeatedRegistered"){
							$submit.prop("disabled", true);
							$.message2("error","该账号已注册");
						}
						else {
							$submit.prop("disabled", true);
							$.message2("error","注册失败，请重新注册");
						}
					}
				});
			});
		});
	</script>
	
	<style type="text/css">
		#sendRegister{
			color: #000;
		    float: right;
		    font-weight: normal;
		    height: 37px;
		    padding-top: 0;
		    border: 1px solid #dadada;
		    width:90px;
		    float:left;
		}
		#sendRegister:hover{
			background:#cccccc;
		}
		
		table th{
			width:72px;
		}
		.fine_name{
			float:left;
		}
		
		.register {
		    margin: 0 auto;
		    width: 650px;
		}
		
		.point_email {
		    border-bottom: 1px dashed #c9c9c9;
		    padding: 30px 0;
		    text-align: center;
		}
		
		.other {
		    color: #999;
		    padding: 30px 0 0 83px;
		    text-align: left;
		}
		
		.register p {
		    line-height: 22px;
		}
		.register p {
		    font-size: 14px;
		}
	</style>
</head>
<body>
	<div class="f_password">
		<div class="f_p_logo">
			<a href="<%=basePath%>website/index.jsp">
				<img src="registered/d74b5412-a9e7-4481-b86d-5e9d6fbd891c.png">
			</a>
		</div>
	</div>
  	<div class="forgerPassword register_title" id="tab1">
    	<h1>注册&nbsp;玩咖智能生活商城&nbsp;账号</h1>
    	<p class="suc_p">玩咖帐号能使用玩咖社区等其它服务。如果您已拥有玩咖帐号，则可
          <a class="cor_yellow" href="login.jsp">在此登录</a>
      	</p>
    	<div id="reg_tab">
	    	<div id="reg_tab_title">
	         	<label><input type="radio" name="reg" value="手机注册"><span>手机注册</span></label>
	         	<label class="selected"><input type="radio" name="reg" value="邮箱注册" id="checked_w" checked="checked"><span>邮箱注册</span></label>
	    	</div>
	    	<div id="reg_tab_content">
	    		<!--------------手机注册-------------->
		       <div class="hide f_password_form">
			      <form id="f_password_form" action="<%=basePath %>web/registered" method="post" novalidate="novalidate">
			        <table width="700px" border="1" cellspacing="0" cellpadding="0">
			          <tbody><tr>
			            <th scope="row"><span class="requiredField">*</span>手机号码:</th>
			            <td><input type="text" class="fine_name text" name="user.username" id="moblieUsername"></td>
			          </tr>
			          <tr>
			            <th scope="row"><span class="requiredField">*</span>设置密码:</th>
			            <td><input type="password" id="password2" name="user.password" class="fine_password text" maxlength="20" autocomplete="off"></td>
			          </tr>
			          <tr>
			            <th scope="row"><span class="requiredField">*</span>确认密码:</th>
			            <td><input id="repassword2" type="password" name="rePassword" class="fine_password text" maxlength="20" autocomplete="off"></td>
			          </tr> 
			          <tr>
			            <th scope="row">&nbsp;</th>
			            <td><input type="button" value="立刻注册" class="fine_btn reg_btn"></td>
			          </tr>
			          <tr>
			            <th scope="row">&nbsp;</th>
			            <td><font color="#999">点击“立即注册”，即表示您同意并愿意遵守玩咖 </font><a target="_blank" style="color: #f00; text-decoration:underline;" href="http://www.wan-ka.com/register/agreement.jhtml">注册协议</a></td>
			          </tr>
			        </tbody></table>
			      </form>
			    </div>
	    		<!--------------邮箱注册-------------->
		        <div class="f_password_form">
			      <form id="registerForm" action="<%=basePath %>web/registered" method="post" novalidate="novalidate">
			        <table border="0" cellspacing="0" cellpadding="0">
			          <tbody><tr>
			            <th scope="row"><span class="requiredField">*</span>邮箱:</th>
			            <td>
			            	<input type="text" id="username" name="email" class="fine_name text" maxlength="50">
			            </td>
			          </tr>
			          <tr>
			            <th scope="row"><span class="requiredField">*</span>设置密码:</th>
			            <td><input type="password" id="password" name="password" class="fine_password text" maxlength="20" autocomplete="off"></td>
			          </tr>
			          <tr>
			            <th scope="row"><span class="requiredField">*</span>确认密码:</th>
			            <td><input type="password" name="rePassword" class="fine_password text" maxlength="20" autocomplete="off"></td>
			          </tr> 
			          <tr>
			          </tr>
			          <tr>
			            <th scope="row">&nbsp;</th>
			            <td><input id="" type="button" class="fine_btn reg_btn" value="立刻注册"></td>
			          </tr>
			          <tr>
			            <th scope="row">&nbsp;</th>
			            <td><font color="#999">点击“立即注册”，即表示您同意并愿意遵守玩咖 </font><a target="_blank" style="color: #f00; text-decoration:underline;" href="http://www.wan-ka.com/register/agreement.jhtml">注册协议</a></td>
			          </tr>
			        </tbody></table>
			      </form>
			    </div>
	    	</div>
		</div> 
 	</div>
	<div class="forgerPassword register_title" id="tab2" style="display:none;">
	    <div id="reg_tab">
		    <!--------------手机注册-------------->
	       	<div class="hide f_password_form">
	       		<h1>还差一步，请激活您的帐号</h1>
	   			<div class="register">
			        <div class="point_email">
			        	<p>系统已经发送了一封激活邮件到您的邮箱</p><p>请访问您的邮箱，点击邮件中的链接便可激活您的帐号</p>
			        </div>
			        <div class="other">
			        	<p>&nbsp;&nbsp;如果没有收到激活邮件：</p><p>• 也许邮件被您的邮箱误认为是垃圾邮件而放到垃圾箱中，请检查一下</p>
			        	<p>• 或者，您可以<a href="javascript:void(0)" class="action" id="sendMsg">点此重新发送激活邮件</a></p>
			        </div>
		        </div>
			</div>
	    </div>
	</div>
    <div class="fine_footer">
	  	<p class="copyright">Copyright © 2005-2013 玩咖智能生活商城 版权所有</p>
	    <p class="copyright">粤ICP备11060697号-2</p>
  	</div>
  <script type="text/javascript">
	$('#reg_tab_title label').click(function(){
	$(this).addClass("selected").siblings().removeClass();//removeClass就是删除当前其他类；只有当前对象有addClass("selected")；siblings()意思就是当前对象的同级元素，removeClass就是删除；
	$("#reg_tab_content > div").hide().eq($('#reg_tab_title label').index(this)).show();
	});
  </script> 
</body>
</html>