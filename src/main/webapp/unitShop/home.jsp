<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.entity.Type,java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>首页</title>

<link href="../customerFile/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />
<link href="../customerFile/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css" />

<link href="../customerFile/basic/css/demo.css" rel="stylesheet" type="text/css" />

<link href="../customerFile/css/hmstyle.css" rel="stylesheet" type="text/css" />
<link href="../customerFile/css/skin.css" rel="stylesheet" type="text/css" />
<script src="../customerFile/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
<script src="../customerFile/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
<script src="../customerFile/basic/js/jquery-1.7.min.js"></script>
<script src="../customerFile/js/home_type.js"></script>
<script src="../customerFile/js/home_allCommodity.js"></script>

</head>
<body>
	<div id="div_1"></div>
	<div id="hmtop" class="hmtop"></div>
	<div class="banner">
		<!--轮播 -->
		<div class="am-slider am-slider-default scoll" data-am-flexslider
			id="demo-slider-0">
			<ul class="am-slides">
				<li class="banner1"><a href="introduction.jsp"><img
						src="../customerFile/images/ad1.jpg" /></a></li>
				<li class="banner2"><a><img src="../customerFile/images/ad2.jpg" /></a></li>
				<li class="banner3"><a><img src="../customerFile/images/ad3.jpg" /></a></li>
				<li class="banner4"><a><img src="../customerFile/images/ad4.jpg" /></a></li>

			</ul>
		</div>
		<div class="clear"></div>
	</div>
	<div class="shopNav">
		<div class="slideall">

			<div class="long-title">
				<span class="all-goods">全部分类</span>
			</div>
			<div class="nav-cont">
				<ul>
					<li class="index"><a class="white-space:nowrap;"
						href="../unitShop/home.jsp">首页</a></li>
				</ul>
			</div>

			<!--侧边导航 -->
			<div id="nav" class="navfull">
				<div class="area clearfix">
					<div class="category-content" id="guide_2">
						<div class="category">
							<ul class="category-list" id="js_climit_li">

							</ul>
						</div>
					</div>

				</div>
			</div>

			<!--轮播-->
			<script type="text/javascript">
				(function() {
					$('.am-slider').flexslider();
				});
				$(document).ready(function() {
					$("li").hover(function() {
						$(".category-content .category-list li.first .menu-in").css("display", "none");
						$(".category-content .category-list li.first").removeClass("hover");
						$(this).addClass("hover");
						$(this).children("div.menu-in").css("display", "block")
					}, function() {
						$(this).removeClass("hover")
						$(this).children("div.menu-in").css("display", "none")
					});
				})
			</script>



			<!--小导航 -->
			<div class="am-g am-g-fixed smallnav">
				<div class="am-u-sm-3">
					<a href="../unitShop/sort.jsp"><img src="../customerFile/images/navsmall.jpg" />
						<div class="title">商品分类</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="#"><img src="../customerFile/images/huismall.jpg" />
						<div class="title">大聚惠</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="../tongwebinf?url=person/index"><img
						src="../customerFile/images/mansmall.jpg" />
						<div class="title">个人中心</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="#"><img src="../customerFile/images/moneysmall.jpg" />
						<div class="title">投资理财</div> </a>
				</div>
			</div>

		</div>
		<script type="text/javascript">
			if ($(window).width() < 640) {
				function autoScroll(obj) {
					$(obj).find("ul").animate({
						marginTop : "-39px"
					}, 500, function() {
						$(this).css({
							marginTop : "0px"
						}).find("li:first").appendTo(this);
					})
				}
				$(function() {
					setInterval('autoScroll(".demo")', 3000);
				})
			}
		</script>
	</div>
	<div class="shopMainbg">
		<div class="shopMain" id="shopmain">

			<div id="f1">
				<!--甜点-->

				<div class="am-container ">
					<div class="shopTitle ">
						<h4>甜品</h4>
						<h3>每一道甜品都有一个故事</h3>
						<div class="today-brands ">
							<a href="# ">桂花糕</a> <a href="# ">奶皮酥</a> <a href="# ">栗子糕 </a> <a
								href="# ">马卡龙</a> <a href="# ">铜锣烧</a> <a href="# ">豌豆黄</a>
						</div>
						<span class="more "> <a href="# ">更多美味<i
								class="am-icon-angle-right" style="padding-left: 10px;"></i></a>
						</span>
					</div>
				</div>

				<div class="am-g am-g-fixed floodFour" id="floodFour">

				</div>
				<div class="clear "></div>
			</div>

			<div id="footer" class="footer "></div>

		</div>
	</div>
	<!--引导 -->
	<div class="navCir">
		<li class="active"><a href="../unitShop/home.jsp"><i
				class="am-icon-home"></i>首页</a></li>
		<li><a href="../unitShop/sort.jsp"><i class="am-icon-list"></i>分类</a></li>
		<li><a href="../tongwebinf?url=home/shopcart"><i class="am-icon-shopping-basket"></i>购物车</a></li>
		<li><a href="../tongwebinf?url=person/index"><i class="am-icon-user"></i>我的</a></li>
	</div>

	<!--菜单 -->
	<div class=tip>
		<div id="sidebar">
			<div id="wrap">
				<div id="prof" class="item ">
					<a href="../tongwebinf?url=person/index"> <span class="setting "></span>
					</a>
					<div class="ibar_login_box status_login ">
						<div class="avatar_box ">
							<p class="avatar_imgbox ">
								<img src="../customerFile/images/no-img_mid_.jpg " />
							</p>
							<ul class="user_info ">
								<li>用户名sl1903</li>
								<li>级&nbsp;别普通会员</li>
							</ul>
						</div>
						<div class="login_btnbox ">
							<a href="../tongwebinf?url=person/order" class="login_order ">我的订单</a> <a
								href="../tongwebinf?url=person/collection" class="login_favorite ">我的收藏</a>
						</div>
						<i class="icon_arrow_white "></i>
					</div>

				</div>
				<div id="shopCart" class="item ">
					<a href="../tongwebinf?url=home/shopcart"> <span class="message "></span></a>
					<p>购物车</p>
					<a href="../tongwebinf?url=home/shopcart"><p class="cart_num ">0</p></a>
				</div>
				<div id="brand " class="item ">
					<a href="../tongwebinf?url=person/collection"> <span class="wdsc "><img
							src="../customerFile/images/wdsc.png " /></span>
					</a>
					<div class="mp_tooltip ">
						我的收藏 <i class="icon_arrow_right_black "></i>
					</div>
				</div>
				<div class="quick_toggle ">
					<li class="qtitem "><a href="# "><span class="kfzx "></span></a>
						<div class="mp_tooltip ">
							客服中心<i class="icon_arrow_right_black "></i>
						</div></li>
					<!--二维码 -->
					<li class="qtitem "><a href="#none "><span
							class="mpbtn_qrcode "></span></a>
						<div class="mp_qrcode " style="display: none;">
							<img src="../customerFile/images/weixin_code_145.png " /><i
								class="icon_arrow_white "></i>
						</div></li>
					<li class="qtitem "><a href="#top " class="return_top "><span
							class="top "></span></a></li>
				</div>
				<!--回到顶部 -->
				<div id="quick_links_pop " class="quick_links_pop hide "></div>
			</div>
		</div>
	</div>
	<script>
		window.jQuery
				|| document
						.write('<script src="basic/js/jquery.min.js "><\/script>');
	</script>
	<script type="text/javascript " src="../customerFile/basic/js/quick_links.js "></script>
	<script src="../customerFile/js/_header.js"></script>
	<script src="../customerFile/js/_footer.js"></script>
</body>
</html>