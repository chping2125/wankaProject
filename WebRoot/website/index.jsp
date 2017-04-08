<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>玩咖智能生活商城</title>
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
		<link rel="stylesheet" type="text/css" href="css/iconfont/iconfont.css"/>
	</head>
	<body>
		<div class="header">
			<div class="header-bg com-bg">
				<ul class="clear h-left">
					<li><a href="<%=basePath%>website/login.jsp">登录</a></li>
					<li class="h-bd"><a>|</a></li>
					<li><a href="<%=basePath%>website/registered.jsp">注册</a></li>
					<li class="h-bd"><a>|</a></li>
					<li><a href="#">玩咖商城移动版</a></li>
				</ul>
				<ul class="clear h-right">
					<li><a href="#">会员中心</a></li>
					<li class="h-bd"><a>|</a></li>
					<li><a href="#">购物指南</a></li>
					<li class="h-bd"><a>|</a></li>
					<li><a href="#">产品说明书</a></li>
					<li class="h-bd"><a>|</a></li>
					<li><a>客服热线:400-0518-068</a></li>
				</ul>
			</div>
		</div>

		<div class="top com-bg clear">
			<h1>
				<a href="#">玩咖智能商城</a>
			</h1>
			<div class="t-left">
				<div class="t-l-search">
					<div class="t-l-s-input clear">
						<input type="text" placeholder="商品搜索"/>
						<span class="iconfont">&#xf00ae;</span>
					</div>
					<div class="t-l-s-links">
						<a href="#">智能手环</a>
					</div>
				</div>
				<div class="t-l-cart">
					<i></i>
					<a href="#"><i class="iconfont">&#xe856;</i>购物车</a>
					<div class="t-l-c-content">
						购物车中还没有商品，抓紧选购吧！
					</div>
				</div>
			</div>
		</div>

		<div class="nav com-bg clear">
			<div class="nav-menu">
				<a class="nav-m-title" href="#">所有商品分类</a>
				<ul class="nav-m-links">
					<li class="nav-m-link">
						<div class="nav-m-l-show">
							<a class="nav-m-l-h3" href="#">智能生活</a>
							<a class="nav-m-l-span" href="#">智能穿戴</a>
							<a class="nav-m-l-span" href="#">智能家居</a>
						</div>
						<ul class="nav-m-l-hidden">
							<li>
								<a href="#">
									<img src="images/nav-1-1.jpg" width="40" height="40" alt="智能穿戴"/>
									<span>智能穿戴</span>
								</a>
							</li>
							<li>
								<a href="#">
									<img src="images/nav-1-2.png" width="40" height="40" alt="智能家居"/>
									<span>智能家居</span>
								</a>
							</li>
						</ul>
					</li>
					<li class="nav-m-link">
						<div class="nav-m-l-show">
							<a class="nav-m-l-h3" href="#">智能生活</a>
							<a class="nav-m-l-span" href="#">智能穿戴</a>
							<a class="nav-m-l-span" href="#">智能家居</a>
						</div>
						<ul class="nav-m-l-hidden">
							<li>
								<a href="#">
									<img src="images/nav-1-1.jpg" width="40" height="40" alt="智能穿戴"/>
									<span>智能穿戴</span>
								</a>
							</li>
							<li>
								<a href="#">
									<img src="images/nav-1-2.png" width="40" height="40" alt="智能家居"/>
									<span>智能家居</span>
								</a>
							</li>
						</ul>
					</li>
					<li class="nav-m-link">
						<div class="nav-m-l-show">
							<a class="nav-m-l-h3" href="#">智能生活</a>
							<a class="nav-m-l-span" href="#">智能穿戴</a>
							<a class="nav-m-l-span" href="#">智能家居</a>
						</div>
						<ul class="nav-m-l-hidden">
							<li>
								<a href="#">
									<img src="images/nav-1-1.jpg" width="40" height="40" alt="智能穿戴"/>
									<span>智能穿戴</span>
								</a>
							</li>
							<li>
								<a href="#">
									<img src="images/nav-1-2.png" width="40" height="40" alt="智能家居"/>
									<span>智能家居</span>
								</a>
							</li>
						</ul>
					</li>
					<li class="nav-m-link">
						<div class="nav-m-l-show">
							<a class="nav-m-l-h3" href="#">智能生活</a>
							<a class="nav-m-l-span" href="#">智能穿戴</a>
							<a class="nav-m-l-span" href="#">智能家居</a>
						</div>
						<ul class="nav-m-l-hidden">
							<li>
								<a href="#">
									<img src="images/nav-1-1.jpg" width="40" height="40" alt="智能穿戴"/>
									<span>智能穿戴</span>
								</a>
							</li>
							<li>
								<a href="#">
									<img src="images/nav-1-2.png" width="40" height="40" alt="智能家居"/>
									<span>智能家居</span>
								</a>
							</li>
						</ul>
					</li>
					<li class="nav-m-link">
						<div class="nav-m-l-show">
							<a class="nav-m-l-h3" href="#">智能生活</a>
							<a class="nav-m-l-span" href="#">智能穿戴</a>
							<a class="nav-m-l-span" href="#">智能家居</a>
						</div>
						<ul class="nav-m-l-hidden">
							<li>
								<a href="#">
									<img src="images/nav-1-1.jpg" width="40" height="40" alt="智能穿戴"/>
									<span>智能穿戴</span>
								</a>
							</li>
							<li>
								<a href="#">
									<img src="images/nav-1-2.png" width="40" height="40" alt="智能家居"/>
									<span>智能家居</span>
								</a>
							</li>
						</ul>
					</li>
					<li class="nav-m-link">
						<div class="nav-m-l-show">
							<a class="nav-m-l-h3" href="#">智能生活</a>
							<a class="nav-m-l-span" href="#">智能穿戴</a>
							<a class="nav-m-l-span" href="#">智能家居</a>
						</div>
						<ul class="nav-m-l-hidden">
							<li>
								<a href="#">
									<img src="images/nav-1-1.jpg" width="40" height="40" alt="智能穿戴"/>
									<span>智能穿戴</span>
								</a>
							</li>
							<li>
								<a href="#">
									<img src="images/nav-1-2.png" width="40" height="40" alt="智能家居"/>
									<span>智能家居</span>
								</a>
							</li>
						</ul>
					</li>
					<li class="nav-m-link">
						<div class="nav-m-l-show">
							<a class="nav-m-l-h3" href="#">智能生活</a>
							<a class="nav-m-l-span" href="#">智能穿戴</a>
							<a class="nav-m-l-span" href="#">智能家居</a>
						</div>
						<ul class="nav-m-l-hidden">
							<li>
								<a href="#">
									<img src="images/nav-1-1.jpg" width="40" height="40" alt="智能穿戴"/>
									<span>智能穿戴</span>
								</a>
							</li>
							<li>
								<a href="#">
									<img src="images/nav-1-2.png" width="40" height="40" alt="智能家居"/>
									<span>智能家居</span>
								</a>
							</li>
						</ul>
					</li>
					<li class="nav-m-link">
						<div class="nav-m-l-show">
							<a class="nav-m-l-h3" href="#">智能生活</a>
							<a class="nav-m-l-span" href="#">智能穿戴</a>
							<a class="nav-m-l-span" href="#">智能家居</a>
						</div>
						<ul class="nav-m-l-hidden">
							<li>
								<a href="#">
									<img src="images/nav-1-1.jpg" width="40" height="40" alt="智能穿戴"/>
									<span>智能穿戴</span>
								</a>
							</li>
							<li>
								<a href="#">
									<img src="images/nav-1-2.png" width="40" height="40" alt="智能家居"/>
									<span>智能家居</span>
								</a>
							</li>
						</ul>
					</li>	
				</ul>
			</div>
			<ul class="nav-links clear">
				<li>
					<a class="active nav-link" href="#">首页<span></span></a>
				</li>
				<li>
					<a class="nav-link" href="#">智能手表</a>
					<span class="nav-link-child"></span>
					<ul class="nav-l-content">
						<li>
							<a href="#">
								<img src="images/nav-l-1-1.png"width="160" height="150" alt=""/>
								<div class="nav-l-c-text">
									<h4>苹果6数据线 2米</h4>
									<p>Cable</p>
									<strong>99.00</strong>
									<span>元起</span>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="images/nav-l-1-2.png"width="160" height="150" alt=""/>
								<div class="nav-l-c-text">
									<h4>苹果6数据线 2米</h4>
									<p>Cable</p>
									<strong>99.00</strong>
									<span>元起</span>
								</div>
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a class="nav-link" href="#">智能开关<span></span></a>
				</li>
				<li>
					<a class="nav-link" href="#">智能电源<span></span></a>
				</li>
				<li>
					<a class="nav-link" href="#">Apple配件</a>
					<span class="nav-link-child"></span>
					<ul class="nav-l-content">
						<li>
							<a href="#">
								<img src="images/nav-l-1-1.png"width="160" height="150" alt=""/>
								<div class="nav-l-c-text">
									<h4>苹果6数据线 2米</h4>
									<p>Cable</p>
									<strong>99.00</strong>
									<span>元起</span>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="images/nav-l-1-2.png"width="160" height="150" alt=""/>
								<div class="nav-l-c-text">
									<h4>苹果6数据线 2米</h4>
									<p>Cable</p>
									<strong>99.00</strong>
									<span>元起</span>
								</div>
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a class="nav-link" href="#">服务</<span></a>
				</li>
				<li>
					<a class="nav-link" href="#">社区</<span></a>
				</li>
				<li>
					<a class="nav-link" href="#">玩咖运动APP</a>
				</li>
			</ul>
		</div>
		
		<div class="com-bg">
			<div class="banner">
				<div class="banner_bg" id="banner">
					<div class="banner_box" style="left:-945px">
						<img width="945" height="420" src="images/banner2.jpg"/>
						<img width="945" height="420" src="images/banner1.jpg"/>
						<img width="945" height="420" src="images/banner2.jpg"/>
						<img width="945" height="420" src="images/banner1.jpg"/>
					</div>
					<div class="banner_btn">
						<span class="banner_lbtn">&lt;</span>
						<span class="banner_rbtn">&gt;</span>
					</div>
					<div class="banner_num">
						<span class="num1 seclect"></span>
						<span class="num2"></span>
					</div>
				</div>
			</div>
			<div class="banner_bottom">
				<ul class="clear">
					<li>
						<a href="#">
							<img src="images/b-img1.jpg" alt=""/>
						</a>
					</li>
					<li>
						<a href="#">
							<img src="images/b-img2.jpg" alt=""/>
						</a>
					</li>
					<li>
						<a href="#">
							<img src="images/b-img3.jpg" alt=""/>
						</a>
					</li>
				</ul>
			</div>
		</div>
	
		<div class="startPro com-bg">
			<div class="sp_title clear">
				<h3>玩咖明星单品</h3>
				<div>
					<span class="sp_t_left">&lt;</span>
					<span class="sp_t_right">&gt;</span>
				</div>
			</div>
			<div class="sp_Pro">
				<ul class="sp_ul clear" id="sp_ul"></ul>
			</div>
		</div>

		<div class="new_Pro com-bg clear">
			<div class="sp_title clear">
				<h3>新品上架</h3>
				<a href="#">更多&gt;&gt;</a>
			</div>
			<div class="new_left">
				<ul class="sp_ul clear" id="new_left_ul"></ul>
			</div>
			<div class="new_right">
				<ul id="new_right_ul"></ul>
			</div>
		</div>
		
		<div class="allLove com-bg clear">
			<div class="sp_title clear">
				<h3>大家都喜欢</h3>
				<a href="#">更多&gt;&gt;</a>
			</div>
			<div class="new_left">
				<ul class="sp_ul clear" id="allLove_left_ul"></ul>
			</div>
			<div class="new_right al_right">
				<ul id="allLove_right_ul"></ul>
			</div>
		</div>

		<div class="hotPro com-bg clear">
			<div class="sp_title clear">
				<h3>热评商品</h3>
				<a href="#">更多&gt;&gt;</a>
			</div>
			<div class="new_left hot_pros">
				<ul class="sp_ul clear" id="hot_ul"></ul>
			</div>
		</div>

		<div class="salePro com-bg clear">
			<div class="sp_title clear">
				<h3>折扣商品</h3>
				<a href="#">更多&gt;&gt;</a>
			</div>
			<div class="new_left hot_pros s_pros">
				<ul class="sp_ul clear" id="sale_ul"></ul>
			</div>
		</div>

		<div class="footer">
			<div class="footer_bg com-bg">
				<div class="f_top">
					<ul class="clear f_t_ul">
						<li class="f_t_li1">
							<a href="#">
								<i></i>
								<strong>厂家直销</strong>
								<span>品牌品质，质优价廉</span>
							</a>
						</li>
						<li class="f_t_li2">
							<a href="#">
								<i></i>
								<strong>厂家直销</strong>
								<span>品牌品质，质优价廉</span>
							</a>
						</li>
						<li class="f_t_li3">
							<a href="#">
								<i></i>
								<strong>厂家直销</strong>
								<span>品牌品质，质优价廉</span>
							</a>
						</li>
						<li class="f_t_li4">
							<a href="#">
								<i></i>
								<strong>厂家直销</strong>
								<span>品牌品质，质优价廉</span>
							</a>
						</li>
					</ul>
				</div>
				<div class="f_middle f_top clear">
					<ul class="f_m_ul clear">
						<li>
							<h4 class="f_m_u_title">我的账户</h4>
							<a href="#">我的账户</a>
							<a href="#">查询订单状态</a>
							<a href="#">配送方式</a>
						</li>
						<li>
							<h4 class="f_m_u_title">客服服务</h4>
							<a href="#">产品目录</a>
							<a href="#">售后政策</a>
							<a href="#">玩咖运送APP</a>
						</li>
						<li>
							<h4 class="f_m_u_title">关于我们</h4>
							<a href="#">联系我们</a>
							<a href="#">商务合作</a>
							<a href="#">公司简介</a>
							<a href="#">企业文化</a>
						</li>
						<li>
							<h4 class="f_m_u_title">支付方式</h4>
							<a href="#">银行汇款</a>
							<a href="#">支付宝</a>
							<a href="#">财付通</a>
						</li>
						<li>
							<h4 class="f_m_u_title">关注我们</h4>
							<a href="#">官方微信</a>
							<a href="http://weibo.com/wankakeji">新浪微博</a>
						</li>
					</ul>
					<div class="f_m_tel">
						<strong>400-0518-068</strong>
						<p>周一至周日，8 : 30-18 : 00</p>
						<a href="">在线客服</a>
					</div>
				</div>
				<div class="f_bottom f_top">
					<ul class="f_b_ul clear">
						<li>友情链接:</li>
						<li><a href="http://www.alivv.com/?rz">链接平台</a></li>
						<li>|</li>
						<li><a href="http://www.baiwanzhan.com/">百万站</a></li>
						<li>|</li>
						<li><a href="http://www.kuaidi100.com/">快递查询</a></li>
					</ul>
					<p class="f_b_img">
						<a class="f_b_img1" href="http://www.miitbeian.gov.cn/"></a>
						<a class="f_b_img2" href="http://www.315online.com.cn/"></a>
					</p>
					<p>Copyright &copy; 2005-2013 玩咖智能生活商城 版权所有</p>
					<p class="f_b_ba">
						<a href="http://www.miitbeian.gov.cn/">粤ICP备11060697号-2</a>
						<a class="f_b_cnzz" href="http://new.cnzz.com/v1/login.php?siteid=1253513575"></a>
					</p>
				</div>
			</div>
		</div>

		<div class="sildbar">
			<ul class="sildbar_ul clear">
				<li><a class="onSale" href="#">在线导购</a></li>
				<li><a class="sh" href="#">售后咨询</a></li>
				<li><a class="wx" href="#">微信关注</a></li>
				<li><a class="returntop">回到顶部</a></li>
			</ul>
		</div>
		<script type="text/javascript" src="js/Util.js"></script>
		<script type="text/javascript" src="js/Banner.js"></script>
		<script type="text/javascript" src="js/Animation.js"></script>
		<script>
			var Params = (function(){
				return {
					leftBtnNode: null,
					rightBtnNode: null,
					spProulNode: null,
					returntopNode: null,
					flag:0
				};
			}());
			window.onload=function(){
				var bannerNode = document.getElementById('banner');
				banner(bannerNode,945,2,'banner_lbtn','banner_rbtn','#ccc','#fff',3000,80);

				//startPro left/right Button
				Params.leftBtnNode = document.querySelector('.sp_t_left');
				Params.rightBtnNode = document.querySelector('.sp_t_right');
				Params.spProulNode = document.querySelector('.sp_ul');
				EventUtil.addHandler(Params.leftBtnNode,'click',spLeftBtn);
				EventUtil.addHandler(Params.rightBtnNode,'click',spRightBtn);

				//return Top
				Params.returntopNode = document.querySelector('.returntop');
				returnTopSH();
				EventUtil.addHandler(window,'scroll',returnTopSH);
				EventUtil.addHandler(Params.returntopNode,'click',returnTop);
			};
			
			function spLeftBtn(){
				Animation.transform2(Params.spProulNode,{left:0},10);
			}
			function spRightBtn(){
				Animation.transform2(Params.spProulNode,{left:-1189},-10);
			}

			function returnTopSH(){
				if(WindowUtil.getScrollTop()>200){
					Params.returntopNode.style.display= 'block';
				}else{
					Params.returntopNode.style.display= 'none';
				}
			}
			function returnTop(){
				var target = document.body||document.documentElement;
				Animation.transfrom(target,{scrollTop:0});
			}
		</script>
		<script src="<%=basePath %>website/js/jquery.js"></script>
		<script src="<%=basePath %>website/js/header.js"></script>
	</body>
</html>