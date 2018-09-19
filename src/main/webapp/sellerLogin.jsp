<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/main.css">
<link rel="stylesheet" href="./css/loginStyle.css">
<title>卖家入口</title>
<style type="text/css">
.error {
	color: goldenrod;
}
</style>
</head>

<body>
	<div class="navbar navbar-default">
		<!-- 放置logo -->
		<div class="container">
			<div class="hidden-xs">
				<ul class="nav navbar-nav">
					<li class="active"><a href="./index.html"><img alt="" src="img/ban.jpg" style="height: 20px;width: 1000px;"></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a class="hidden" href="sellerLogin.jsp#login">登录</a></li>
					<li><a class="hidden" href="sellerLogin.jsp#singup">注册</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container container-height"
		style="width: 100%; height: 570px; background: #FAF2CC; margin-top: -20px;">
		<div
			style="max-width: 1200px; height: 470px; margin-left: 300px; position: relative;">
			<div class="login-banner-bg"
				style="width: 450px; height: 570px; margin-right: 200px; position: relative;">
				<span></span><img src="img/big.jpg" />
			</div>
			<div id="login" class="container-small"
				style="margin-right: 200px; background: white;">
				<h1>
					登录 <small>没有账号？<a id="singupBtn" href="#singup">注册</a></small>
				</h1>
				<form action="" name="logForm" id="logForm" method="post">
					<div class="form-group">
						<label for="">用户名/手机/邮箱</label> <input class="form-control"
							type="text" name="logUsername" id="logUsername"
							placeholder="请输入已验证的用户名/手机/邮箱">
					</div>
					<div class="form-group">
						<label for="">密码</label> <input class="form-control"
							type="password" name="logPassword" id="logPassword"
							placeholder="请输入密码">
					</div>
					<div class="form-group">
						<input type="checkbox"><span class="form-group">记住我</span>
					</div>
					<div class="form-group">
						<a href="#">忘记密码?</a>
					</div>
					<div class="form-group">
						<input class="btn btn-primary btn-block" type="submit"
							name="logSubmit" id="logSubmit" value="登录">
					</div>
				</form>
			</div>
			<div id="singup" class="container-small"
				style="margin-right: 200px; background: white; margin-bottom: -85px; margin-top: -60px;">
				<h1>
					注册 <small>已有账号？<a id="loginBtn" href="#login">登录</a></small>
				</h1>
				<form action="register/seller.action" name="regForm" id="regForm" method="post">
					<div class="form-group">
						<label for="">邮箱</label> <input class="form-control" type="text"
							name="regUsername" id="regUsername" placeholder="请输入邮箱">
					</div>
					<div class="from-group">
						<label for="">验证码</label>
						<div class="input-group" name="vCodeS">
							<input type="text" class="form-control" name="vCode" id="vCode"
								placeholder="请输入验证码">
							<div class="input-group-btn" id="code">
								<button class="btn btn-default" id="getCode">获取验证码</button>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="">密码</label> <input class="form-control"
							type="password" name="regPassword1" id="regPassword1"
							placeholder="设置密码">
					</div>
					<div class="form-group">
						<label for="">密码</label> <input class="form-control"
							type="password" name="regPassword2" id="regPassword2"
							placeholder="确认密码">
					</div>
					<div class="form-group">
						注册xxx即代表您同意 <a href="#">xxx条款</a>
					</div>
					<div class="form-group">
						<input class="btn btn-primary btn-block" type="submit"
							name="regSubmit" id="regSubmit" value="注册">
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="footer">（沪）字第1248号 | 网络文化经营许可证：沪网文[2016]2296-134号 |
		互联网ICP备案：沪ICP备13002172号-3 沪</div>
</body>
<script src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/jquery.validate.js"></script>
<script src="./js/sellerValidation.js"></script>
<script src="js/sellerLogin.js"></script>
<script src="js/sellerRegister.js"></script>
</html>