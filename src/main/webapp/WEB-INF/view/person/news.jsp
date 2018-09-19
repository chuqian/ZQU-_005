<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>我的消息</title>

		<link href="./customerFile/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="./customerFile/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="./customerFile/css/personal.css" rel="stylesheet" type="text/css">
		<link href="./customerFile/css/newstyle.css" rel="stylesheet" type="text/css">

		<script src="./customerFile/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="./customerFile/AmazeUI-2.4.2/assets/js/amazeui.js"></script>

	</head>
	<body>
		<!--头 -->
		<header id="hmtop"></header>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
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

					<div class="user-news">

						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">我的消息</strong> / <small>News</small></div>
						</div>
						<hr/>

						<div class="am-tabs am-tabs-d2" data-am-tabs>
							<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
								<li><a href="#tab2">物流助手</a></li>
								<li><a href="#tab3">交易信息</a></li>

							</ul>

							<div class="am-tabs-bd">
							

								<div class="am-tab-panel am-fade" id="tab2">
									<!--消息 -->
										<div class="s-msg-item s-msg-temp i-msg-downup">
											<h6 class="s-msg-bar"><span class="s-name">订单已签收</span></h6>
											<div class="s-msg-content i-msg-downup-wrap">
												<div class="i-msg-downup-con">
													<a class="i-markRead" target="_blank" href="./tongwebinf?url=person/logistics">
													<div class="m-item">	
														<div class="item-pic">															
																	<img src="./customerFile/images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg">
														</div>
														<div class="item-info">
															您购买的美康粉黛醉美唇膏已签收，
															快递单号:373269427868
														</div>
																											
                                                    </div>	

													<p class="s-row s-main-content">
														<a href="./tongwebinf?url=person/logistics">查看详情</a> <i class="am-icon-angle-right"></i>
													</p>
													</a>
												</div>
											</div>
											<a class="i-btn-forkout" href="#"><i class="am-icon-close am-icon-fw"></i></a>
										</div>
								</div>

								<div class="am-tab-panel am-fade" id="tab3">
									<!--消息 -->
										<div class="s-msg-item s-msg-temp i-msg-downup">
											<h6 class="s-msg-bar"><span class="s-name">卖家已退款&nbsp;¥12.90元</span></h6>
											<div class="s-msg-content i-msg-downup-wrap">
												<div class="i-msg-downup-con">
													<a class="i-markRead" target="_blank" href="./tongwebinf?url=person/record">
													<div class="m-item">	
														<div class="item-pic">															
																	<img src="./customerFile/images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg">
														</div>
														<div class="item-info">
															<p class="item-comment">您购买的美康粉黛醉美唇膏卖家已退款</p>
															<p class="item-time">2015-12-21&nbsp;17:38:29</p>
														</div>
																											
                                                    </div>	

													<p class="s-row s-main-content">
													<a href="./tongwebinf?url=person/record">钱款去向</a> <i class="am-icon-angle-right"></i>
													</p>
													</a>
												</div>
											</div>
											<a class="i-btn-forkout" href="#"><i class="am-icon-close am-icon-fw"></i></a>
										</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!--底部-->
				<div id="footer" class="footer">
					
				</div>
			</div>

			<aside id="menu" class="menu"></aside>
		</div>
		<script src="./customerFile/js/jquery-1.7.2.min.js"></script>
		<script src="./customerFile/js/_headerPerson.js"></script>
		<script src="./customerFile/js/_footer.js"></script>
		<script src="./customerFile/js/_menu.js"></script>
	</body>
</html>