<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>玩咖智能生活商城--后台</title>
		<script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css"/>
		<style>
			.header{
				margin-bottom: 20px;
			}
		</style>
	</head>
	<body>
		<div class="container-fluid">
			<div class="row header">
				<h2 class="col-md-4 col-md-offset-4">请填写商品具体信息</h2>
			</div>
			
			<div class="row">
				<form class="form-horizontal col-md-8 col-md-offset-2" role="form" action="<%=basePath %>product/add" method="post" enctype="multipart/form-data">

	    			<div class="form-group form-bottom">
	    				<label for="name">商品名称</label>
			  			<input type="text" class="form-control" name="product.name" id="name" placeholder="请填写商品名称"/>
	    			</div>

	    			<div class="form-group form-bottom">
	    				<label for="type">商品类型</label>
			  			<select  name="product.type" id="type" class="form-control">
				  			<option value="1">智能生活</option>
				  			<option value="2">手机个性化配件</option>
				  			<option value="3">充电和移动电源 </option>
				  			<option value="4">耳机与音箱</option>
				  			<option value="5">电脑与家电配件</option>
				  			<option value="6">Apple配件</option>
				  			<option value="7">玩咖生活方式</option>
				  			<option value="8">增值业务</option>
				  		</select>
	    			</div>
			    	
			    	<div class="form-group form-bottom">
			    		<label for="image">上传图片</label>
		  				<input type="file" name="file" id="image"/>
		  				<p class="help-block">请选择要上传的图片</p>
			    	</div>
		  		
		  			<div class="form-group form-bottom">
			    		<label for="price">价格</label>
		  				<input class="form-control" type="text" name="product.price" id="price"/>
			    	</div>
		  		
		  			<div class="form-group form-bottom">
			    		<label for="originPrice">原价格</label>
		  				<input class="form-control" type="text" name="product.originPrice" id="originPrice"/>
			    	</div>
		  		
		  			<div class="form-group form-bottom">
			    		<label for="hot">是否为热卖</label>
				  		<select  name="product.hot" id="hot" class="form-control">
				  			<option value="1">是</option>
				  			<option value="0">否</option>
				  		</select>
			    	</div>
		  		
		  			<div class="form-group form-bottom">
			    		<label for="newP">是否为新品</label>
				  		<select  name="product.newP" id="newP" class="form-control">
				  			<option value="1">是</option>
				  			<option value="0">否</option>
				  		</select>
			    	</div>
		  		
		  			<div class="form-group form-bottom">
			    		<label for="stP">是否为明星新品</label>
				  		<select  name="product.stP" id="stP" class="form-control">
				  			<option value="1">是</option>
				  			<option value="0">否</option>
				  		</select>
			    	</div>

			    	<div class="form-group form-bottom">
			    		<label for="alP">是否大家都喜欢</label>
				  		<select  name="product.alP" id="alP" class="form-control">
				  			<option value="1">是</option>
				  			<option value="0">否</option>
				  		</select>
			    	</div>

			    	<div class="form-group form-bottom">
			    		<label for="saleP">是否打折</label>
				  		<select  name="product.saleP" id="saleP" class="form-control">
				  			<option value="1">是</option>
				  			<option value="0">否</option>
				  		</select>
			    	</div>
			    	
			    	<div class="form-group form-bottom">
			    		<label for="song">是否包邮</label>
				  		<select  name="product.res1" id="song" class="form-control">
				  			<option value="1">是</option>
				  			<option value="0">否</option>
				  		</select>
			    	</div>
			    	
			    	<div class="form-group form-bottom">
			    		<label for="ji">商品等级</label>
		  				<input class="form-control" type="text" name="product.res2" id="ji" placeholder="请输入1-5之间的数字表示1-5星"/>
			    	</div>
		  		
		  			<div class="form-group form-bottom">
			    		<label for="content">简介</label>
		  				<textarea name="product.content" class="form-control" rows="3"></textarea>
			    	</div>
		  		
		  			<div class="form-group form-bottom">
			    		<input type="submit" value="提交" class="btn btn-primary btn-block"/>
			    	</div>
			    	<input type="hidden" id="info" value="<s:property value="#session.message"/>">
			    	<script>
			    		window.onload = function(){
			    			var infoNode = document.getElementById('info');
			    			if(infoNode.value == "error"){
			    				alert("添加失败，请重新添加");
			    			}else if(infoNode.value == "success"){
			    				alert("添加成功");
			    			}
			    		};
			    		
			    	</script>
				</form>	
			</div>
		</div>
	</body>
</html>