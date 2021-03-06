<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>搜索页面</title>

<link href="../customerFile/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />
<link href="../customerFile/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css" />

<link href="../customerFile/basic/css/demo.css" rel="stylesheet" type="text/css" />

<link href="../customerFile/css/seastyle.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="../customerFile/basic/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="../customerFile/js/script.js"></script>
</head>
<body>

	<div id="hmtop"></div>


	<b class="line"></b>
	<div class="search">
		<div class="search-list">
			<div class="nav-table">
				<div class="long-title">
					<span class="all-goods">全部分类</span>
				</div>
				<div class="nav-cont">
					<ul>
						<li class="index"><a href="../unitShop/home.jsp">首页</a></li>
					</ul>
				</div>
			</div>


			<div class="am-g am-g-fixed">
				<div class="am-u-sm-12 am-u-md-12">
					<div class="theme-popover">
						<div class="searchAbout">
							<span class="font-pale">相关搜索：</span> <a title="坚果" href="#">坚果</a>
							<a title="瓜子" href="#">瓜子</a> <a title="鸡腿" href="#">豆干</a>

						</div>
						<ul class="select">
							<p class="title font-normal">
								<span class="fl">松子</span> <span class="total fl">搜索到<strong
									class="num">997</strong>件相关商品
								</span>
							</p>
							<div class="clear"></div>
							<li class="select-result">
								<dl>
									<dt>已选</dt>
									<dd class="select-no"></dd>
									<p class="eliminateCriteria">清除</p>
								</dl>
							</li>
							<div class="clear"></div>
							<li class="select-list">
								<dl id="select1">
									<dt class="am-badge am-round">品牌</dt>

									<div class="dd-conent">
										<dd class="select-all selected">
											<a href="#">全部</a>
										</dd>
										<dd>
											<a href="#">百草味</a>
										</dd>
										<dd>
											<a href="#">良品铺子</a>
										</dd>
										<dd>
											<a href="#">新农哥</a>
										</dd>
										<dd>
											<a href="#">楼兰蜜语</a>
										</dd>
										<dd>
											<a href="#">口水娃</a>
										</dd>
										<dd>
											<a href="#">考拉兄弟</a>
										</dd>
									</div>

								</dl>
							</li>
							<li class="select-list">
								<dl id="select2">
									<dt class="am-badge am-round">种类</dt>
									<div class="dd-conent">
										<dd class="select-all selected">
											<a href="#">全部</a>
										</dd>
										<dd>
											<a href="#">东北松子</a>
										</dd>
										<dd>
											<a href="#">巴西松子</a>
										</dd>
										<dd>
											<a href="#">夏威夷果</a>
										</dd>
										<dd>
											<a href="#">松子</a>
										</dd>
									</div>
								</dl>
							</li>
							<li class="select-list">
								<dl id="select3">
									<dt class="am-badge am-round">选购热点</dt>
									<div class="dd-conent">
										<dd class="select-all selected">
											<a href="#">全部</a>
										</dd>
										<dd>
											<a href="#">手剥松子</a>
										</dd>
										<dd>
											<a href="#">薄壳松子</a>
										</dd>
										<dd>
											<a href="#">进口零食</a>
										</dd>
										<dd>
											<a href="#">有机零食</a>
										</dd>
									</div>
								</dl>
							</li>

						</ul>
						<div class="clear"></div>
					</div>
					<div class="search-content">
						<div class="sort">
							<li class="first"><a title="综合">综合排序</a></li>
							<li><a title="销量">销量排序</a></li>
							<li><a title="价格">价格优先</a></li>
							<li class="big"><a title="评价" href="#">评价为主</a></li>
						</div>
						<div class="clear"></div>

						<c:if test="${empty requestScope.dataSearch}">
							<br><br><br><p style="margin-left: 35%;">该商品不存在，请换其他关键词搜索</p>
						</c:if>
						<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes" id="searchList_js">
							<c:forEach items="${requestScope.dataSearch}" var="dataSearch">
								<li>
									<div class="i-pic limit">
										<form id="form${dataSearch.id}" action="" method="post">
											<input type="hidden" name="commodityId" value="${dataSearch.id}" />
											<input type="hidden" name="searchContent" value="${searchContent}" />
										</form>
										<a class="inToIntr${dataSearch.id}" href="../customer_1/introductionURL.action"><img src="${dataSearch.imgSrc}" />
										<p class="title fl">${dataSearch.commodityName}</p></a>
										<p class="price fl">
											<b>¥</b> <strong>${dataSearch.price}</strong>
										</p>
										<p class="number fl">
											销量<span>${dataSearch.saledNum}</span>
										</p>
										<script type="text/javascript">
											$(function(){
												$(".inToIntr${dataSearch.id}").click(function(){
													var href = $(this).attr("href");
													$("#form${dataSearch.id}").attr("action", href).submit();	
													return false;
												});
											})
										</script>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
					<div class="search-side">

						<div class="side-title">经典搭配</div>

						<li>
							<div class="i-pic check">
								<img src="../customerFile/images/cp.jpg" />
								<p class="check-title">萨拉米 1+1小鸡腿</p>
								<p class="price fl">
									<b>¥</b> <strong>29.90</strong>
								</p>
								<p class="number fl">
									销量<span>1110</span>
								</p>
							</div>
						</li>
						<li>
							<div class="i-pic check">
								<img src="../customerFile/images/cp2.jpg" />
								<p class="check-title">ZEK 原味海苔</p>
								<p class="price fl">
									<b>¥</b> <strong>8.90</strong>
								</p>
								<p class="number fl">
									销量<span>1110</span>
								</p>
							</div>
						</li>
						<li>
							<div class="i-pic check">
								<img src="../customerFile/images/cp.jpg" />
								<p class="check-title">萨拉米 1+1小鸡腿</p>
								<p class="price fl">
									<b>¥</b> <strong>29.90</strong>
								</p>
								<p class="number fl">
									销量<span>1110</span>
								</p>
							</div>
						</li>

					</div>
					<div class="clear"></div>
					<!--分页 -->
					<ul class="am-pagination am-pagination-right">
						<li class="am-disabled"><a href="#">&laquo;</a></li>
						<li class="am-active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">&raquo;</a></li>
					</ul>

				</div>
			</div>
			<div id="footer" class="footer"></div>
		</div>

	</div>

	<!--引导 -->
	<div class="navCir">
		<li><a href="../unitShop/home.jsp"><i class="am-icon-home "></i>首页</a></li>
		<li><a href="../unitShop/sort.jsp"><i class="am-icon-list"></i>分类</a></li>
		<li><a href="./tongwebinf?url=home/shopcart"><i class="am-icon-shopping-basket"></a></i>购物车</li>
		<li><a href="./tongwebinf?url=person/index"><i class="am-icon-user"></i>我的</a></li>
	</div>

			<!--菜单 -->
			<div class=tip>
				<div id="sidebar">
					<div id="wrap">
						<div id="prof" class="item ">
							<a href="./tongwebinf?url=person/index"> <span class="setting "></span>
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
									<a href="../person/order.jsp" class="login_order ">我的订单</a> <a
										href="../person/collection.jsp" class="login_favorite ">我的收藏</a>
								</div>
								<i class="icon_arrow_white "></i>
							</div>
		
						</div>
						<div id="shopCart" class="item ">
							<a href="shopcart.jsp"> <span class="message "></span></a>
							<p>购物车</p>
							<a href="shopcart.jsp"><p class="cart_num ">0</p></a>
						</div>
						<div id="brand " class="item ">
							<a href="../person/collection.jsp"> <span class="wdsc "><img
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
						.write('<script src="basic/js/jquery-1.9.min.js"><\/script>');
	</script>
	<script type="text/javascript" src="../customerFile/basic/js/quick_links.js"></script>

	<div class="theme-popover-mask"></div>
	<script src="../customerFile/js/_header.js"></script>
	<script src="../customerFile/js/_footer.js"></script>
</body>
</html>