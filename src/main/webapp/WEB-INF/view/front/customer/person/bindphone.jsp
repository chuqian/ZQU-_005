<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>绑定手机</title>

<link href="./customerFile/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css">
<link href="./customerFile/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css">

<link href="./customerFile/css/personal.css" rel="stylesheet" type="text/css">
<link href="./customerFile/css/stepstyle.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="./customerFile/js/jquery-1.7.2.min.js"></script>
<script src="./customerFile/AmazeUI-2.4.2/assets/js/amazeui.js"></script>

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

				<div class="am-cf am-padding">
					<div class="am-fl am-cf">
						<strong class="am-text-danger am-text-lg">绑定手机</strong> / <small>Bind&nbsp;Phone</small>
					</div>
				</div>
				<hr />
				<!--进度条-->
				<div class="m-progress">
					<div class="m-progress-list">
						<span class="step-1 step"> <em class="u-progress-stage-bg"></em>
							<i class="u-stage-icon-inner">1<em class="bg"></em></i>
							<p class="stage-name">绑定手机</p>
						</span> <span class="step-2 step"> <em class="u-progress-stage-bg"></em>
							<i class="u-stage-icon-inner">2<em class="bg"></em></i>
							<p class="stage-name">完成</p>
						</span> <span class="u-progress-placeholder"></span>
					</div>
					<div class="u-progress-bar total-steps-2">
						<div class="u-progress-bar-inner"></div>
					</div>
				</div>
				<form class="am-form am-form-horizontal">
					<div class="am-form-group bind">
						<label for="user-phone" class="am-form-label">验证手机</label>
						<div class="am-form-content">
							<span id="user-phone">186XXXX0531</span>
						</div>
					</div>
					<div class="am-form-group code">
						<label for="user-code" class="am-form-label">验证码</label>
						<div class="am-form-content">
							<input type="tel" id="user-code" placeholder="短信验证码">
						</div>
						<a class="btn" href="javascript:void(0);"
							onclick="sendMobileCode();" id="sendMobileCode">
							<div class="am-btn am-btn-danger">验证码</div>
						</a>
					</div>
					<div class="am-form-group">
						<label for="user-new-phone" class="am-form-label">验证手机</label>
						<div class="am-form-content">
							<input type="tel" id="user-new-phone" placeholder="绑定新手机号">
						</div>
					</div>
					<div class="am-form-group code">
						<label for="user-new-code" class="am-form-label">验证码</label>
						<div class="am-form-content">
							<input type="tel" id="user-new-code" placeholder="短信验证码">
						</div>
						<a class="btn" href="javascript:void(0);"
							onclick="sendMobileCode();" id="sendMobileCode">
							<div class="am-btn am-btn-danger">验证码</div>
						</a>
					</div>
					<div class="info-btn">
						<div class="am-btn am-btn-danger">保存修改</div>
					</div>

				</form>

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