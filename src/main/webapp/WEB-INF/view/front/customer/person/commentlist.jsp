<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">
<title>发表评论</title>
<link href="./customerFile/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css">
<link href="./customerFile/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css">
<link href="./customerFile/css/personal.css" rel="stylesheet" type="text/css">
<link href="./customerFile/css/appstyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="./customerFile/js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<!--头 -->
	<header id="hmtop"></header>
	<div class="nav-table">
		<div class="long-title">
			<span class="all-goods">全部分类</span>
		</div>
		<div class="nav-cont">
			<ul>
				<li class="index"><a href="./unitShop/home.jsp">首页</a></li>
			</ul>
		</div>
	</div>
	<b class="line"></b>
	<div class="center">
		<div class="col-main">
			<div class="main-wrap">

				<div class="user-comment">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">发表评论</strong> / <small>Make&nbsp;Comments</small>
						</div>
					</div>
					<hr />

					<div class="comment-main">
						<div class="comment-list">
							<div class="item-pic">
								<a href="./unitShop/introduction.jsp" class="J_MakePoint"> <img
									src="./customerFile/images/comment.jpg_400x400.jpg" class="itempic">
								</a>
							</div>

							<div class="item-title">

								<div class="item-name">
									<a href="./unitShop/introduction.jsp">
										<p class="item-basic-info">美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
									</a>
								</div>
								<div class="item-info">
									<div class="info-little">
										<span>颜色：洛阳牡丹</span> <span>包装：裸装</span>
									</div>
									<div class="item-price">
										价格：<strong>19.88元</strong>
									</div>
								</div>
							</div>
							<div class="clear"></div>
							<div class="item-comment">
								<textarea placeholder="请写下对宝贝的感受吧，对他人帮助很大哦！"></textarea>
							</div>
							<div class="filePic">
								<input type="file" class="inputPic"
									allowexts="gif,jpeg,jpg,png,bmp" accept="image/*"> <span>晒照片(0/5)</span>
								<img src="./customerFile/images/image.jpg" alt="">
							</div>
							<div class="item-opinion">
								<li><i class="op1"></i>好评</li>
								<li><i class="op2"></i>中评</li>
								<li><i class="op3"></i>差评</li>
							</div>
						</div>

						<!--多个商品评论-->
						<div class="comment-list">
							<div class="item-pic">
								<a href="./unitShop/introduction.jsp" class="J_MakePoint"> <img
									src="./customerFile/images/comment.jpg_400x400.jpg" class="itempic">
								</a>
							</div>
							<div class="item-title">
								<div class="item-name">
									<a href="./unitShop/introduction.jsp">
										<p class="item-basic-info">美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
									</a>
								</div>
								<div class="item-info">
									<div class="info-little">
										<span>颜色：洛阳牡丹</span> <span>包装：裸装</span>
									</div>
									<div class="item-price">
										价格：<strong>19.88元</strong>
									</div>
								</div>
							</div>
							<div class="clear"></div>
							<div class="item-comment">
								<textarea placeholder="请写下对宝贝的感受吧，对他人帮助很大哦！"></textarea>
							</div>
							<div class="filePic">
								<input type="file" class="inputPic"
									allowexts="gif,jpeg,jpg,png,bmp" accept="image/*"> <span>晒照片(0/5)</span>
								<img src="./customerFile/images/image.jpg" alt="">
							</div>
							<div class="item-opinion">
								<li><i class="op1"></i>好评</li>
								<li><i class="op2"></i>中评</li>
								<li><i class="op3"></i>差评</li>
							</div>
						</div>

						<div class="comment-list">
							<div class="item-pic">
								<a href="./unitShop/introduction.jsp" class="J_MakePoint"> <img
									src="./customerFile/images/comment.jpg_400x400.jpg" class="itempic">
								</a>
							</div>

							<div class="item-title">

								<div class="item-name">
									<a href="./unitShop/introduction.jsp">
										<p class="item-basic-info">美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
									</a>
								</div>
								<div class="item-info">
									<div class="info-little">
										<span>颜色：洛阳牡丹</span> <span>包装：裸装</span>
									</div>
									<div class="item-price">
										价格：<strong>19.88元</strong>
									</div>
								</div>
							</div>
							<div class="clear"></div>
							<div class="item-comment">
								<textarea placeholder="请写下对宝贝的感受吧，对他人帮助很大哦！"></textarea>
							</div>
							<div class="filePic">
								<input type="file" class="inputPic"
									allowexts="gif,jpeg,jpg,png,bmp" accept="image/*"> <span>晒照片(0/5)</span>
								<img src="./customerFile/images/image.jpg" alt="">
							</div>
							<div class="item-opinion">
								<li><i class="op1"></i>好评</li>
								<li><i class="op2"></i>中评</li>
								<li><i class="op3"></i>差评</li>
							</div>
						</div>
						<div class="info-btn">
							<div class="am-btn am-btn-danger">发表评论</div>
						</div>
						<script type="text/javascript">
							$(document)
									.ready(
											function() {
												$(
														".comment-list .item-opinion li")
														.click(
																function() {
																	$(this)
																			.prevAll()
																			.children(
																					'i')
																			.removeClass(
																					"active");
																	$(this)
																			.nextAll()
																			.children(
																					'i')
																			.removeClass(
																					"active");
																	$(this)
																			.children(
																					'i')
																			.addClass(
																					"active");
																});
											})
						</script>
					</div>
				</div>
			</div>
			<!--底部-->
			<div id="footer" class="footer"></div>
		</div>

		<aside id="menu" class="menu"></aside>
	</div>
	<script src="./customerFile/js/_headerPerson.js"></script>
	<script src="./customerFile/js/_footer.js"></script>
	<script src="./customerFile/js/_menu.js"></script>
</body>
</html>