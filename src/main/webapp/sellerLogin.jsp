<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<link rel="stylesheet" href="./css/bootstrap.css">
		<link rel="stylesheet" href="./css/main.css">
		<title>Document</title>
		
		<style>  
			.error{  
				color:goldenrod; 
			}  
		</style>
		
	</head>

	<body>
		<div class="navbar navbar-default">
			<!-- 放置logo -->
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="./index.html"></a>
				</div>
				<label class="toggle-label visible-xs-inline-block" for="toggle-checkbox">菜单</label>
				<input class="hidden" type="checkbox" name="" id="toggle-checkbox">
				<div class="hidden-xs">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="./index.html">首页</a>
						</li>
						<li>
							<a href="">国内</a>
						</li>
						<li>
							<a href="">国际</a>
						</li>
						<li>
							<a href="">速读</a>
						</li>
						<li>
							<a href="">社会</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="sellerLogin.jsp#login">登录</a>
						</li>
						<li>
							<a href="sellerLogin.jsp#singup">注册</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container container-height" style="width:100%;height:570px; background:#FAF2CC;margin-top:-20px;">

			<div style="max-width:1200px;height:470px;margin-left:300px;position:relative;">
				<div class="login-banner-bg" style="width:450px;height:570px;margin-right:200px;position:relative;"><span></span><img src="img/big.jpg" /></div>
				<div id="login" class="container-small" style="margin-right: 200px;background: white;">
					<h1>
                登录
                <small>没有账号？<a id="singupBtn" href="#singup">注册</a></small>
                </h1>
					<form action="" name="logForm" id="logForm">
						<div class="form-group">
							<label for="">用户名/手机/邮箱</label>
							<input class="form-control" type="text" name="logUsername" id="logUsername" placeholder="请输入已验证的用户名/手机/邮箱">
						</div>
						<div class="form-group">
							<label for="">密码</label>
							<input class="form-control" type="password" name="logPassword" id="logPassword" placeholder="请输入密码">
						</div>
						<div class="form-group">
							<a href="#">忘记密码?</a>
						</div>
						<div class="form-group">
							<input class="btn btn-primary btn-block" type="submit" name="logSubmit" id="logSubmit" value="登录">
						</div>
					</form>
				</div>
				<div id="singup" class="container-small" style="margin-right: 200px;background: white;margin-bottom: -85px;margin-top: -60px;">
					<h1>
                    注册
                    <small>已有账号？<a id="loginBtn" href="#login">登录</a></small>
                    </h1>
					<form action="" name="regForm" id="regForm">
						<div class="form-group">
							<label for="">邮箱</label>
							<input class="form-control" type="text" name="regUsername" id="regUsername" placeholder="请输入邮箱">
						</div>
						<div class="from-group">
							<label for="">验证码</label>
							<div class="input-group" name="vCodeS">
								<input type="text" class="form-control" name="vCode" id="vCode" placeholder="请输入验证码">
								<div class="input-group-btn">
									<div class="btn btn-default">获取验证码</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="">密码</label>
							<input class="form-control" type="password" name="regPassword1" id="regPassword1" placeholder="设置密码">
						</div>
						<div class="form-group">
							<label for="">密码</label>
							<input class="form-control" type="password" name="regPassword2" id="regPassword2" placeholder="确认密码">
						</div>
						<div class="form-group">
							注册xxx即代表您同意
							<a href="#">xxx条款</a>
						</div>
						<div class="form-group">
							<input class="btn btn-primary btn-block" type="submit" name="regSubmit" id="regSubmit" value="注册">
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="footer">
			（沪）字第1248号 | 网络文化经营许可证：沪网文[2016]2296-134号 | 互联网ICP备案：沪ICP备13002172号-3 沪
		</div>
	</body>
	<script src="./js/jquery.min.js"></script>
	<script type="text/javascript" src="./js/jquery.validate.js"></script>
	<script>
		$(function() {
			$(location.hash).css('display', 'block')
			$('.container-small').css('top', $('.navbar ').height() + 15)
			$('#loginBtn').click(function() {
				switchView('singup', 'login')
			})
			$('#singupBtn').click(function() {
				switchView('login', 'singup')
			})
		})

		function switchView(from, to) {
			$('#' + from).fadeOut(300)
			$('#' + to).fadeIn(300)
		}
		window.onresize = function() {
			$('.container-small').css('top', $('.navbar ').height() + 15)
		}
		
		
   // 邮箱验证  
 jQuery.validator.addMethod("isEmail", function(value, element) {  
 var email = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
 return this.optional(element) ||  email.test(value);  
 }, "请正确填写您的邮箱");  
 
   // 账号验证  
 jQuery.validator.addMethod("isLogUsername", function(value, element) {  
 var length = value.length;  
 var mobile = /^1[3,5,7,8]\d{9}$/;
 var username = /^([a-zA-Z0-9_\u4e00-\u9fa5]{4,16})$/;
 var email = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
 return this.optional(element) || ((length == 11 && mobile.test(value)) || email.test(value) || username.test(value));  
 }, "请正确填写您的账号");  
 
	
		
		
		
		
		$("#logForm").validate({  
		 rules: {    
			 logUsername:{  
			 required: true,
			 isLogUsername:true
			 },  
			 logPassword: {  
			 required: true,  
			 rangelength: [6,18]  
			 }
		 },		 
		 //错误提示  
		 messages: {  
			 logUsername: {  
			 required: "<em>请输入你的账号！</em>",
			 isLogUsername:"<em>请输入正确格式的手机号/邮箱，用户名为4到16位（字母，数字，汉字，下划线）.</em>"
			 },  
			 logPassword: {  
			 required: "<em>密码不能为空！</em>",  
			 rangelength: $.validator.format( "请输入6-18位字符的密码." )  
			 }
		 },
		 
		 submitHandler: function(form) {  
			 console.info("hi");  
			 form.submit();  
		 }  
		 });			
		
		
		$("#regForm").validate({  
		 rules: {    
			 regUsername:{  
			 required: true,
			 isEmail:true
			 }, 
			 vCodeS:{
			 	required:true
			 },
			 regPassword1: {  
			 required: true,  
			 rangelength: [6,18]  
			 },  
			 regPassword2:{  
			 required: true,  
			 rangelength: [6,18],  
			 equalTo: "#regPassword1"  
			 }
		 },		 
		 //错误提示  
		 messages: {  
			 regUsername: {  
			 required: "<em>请输入你的邮箱！</em>" ,
			 isEmail:"<em>请输入正确格式的邮箱.</em>"
			 },
			 vCodeS:{
			 	required:"<em>验证码不能为空！</em>"
			 },
			 regPassword1: {  
			 required: "<em>密码不能为空！</em>",  
			 rangelength: $.validator.format( "请输入6-18位字符的密码." )  
			 },  
			 regPassword2: {  
			 required: "<em>密码不能为空！</em>",  
			 rangelength: $.validator.format( "请输入6-18位字符的密码." ),  
			 equalTo: "两次输入密码不一致"  
			 }
		 },
		 
		 submitHandler: function(form) {  
			 console.info("hi");  
			 form.submit();  
		 }  
		 });		
		
		
		
	</script>

</html>