<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/register.js"></script>
<body>
	<form method="post" action="register/seller.action">
		email: <input type="text" name="email" id="email" onBlur="return validateEmail()">
		<br>
		code: <input type="text" name="code" id="code" onBlur="return validateCode()"><button onclick="return getCode()">获取验证码</button>
		<br>
		password: <input type="text" name="password" id="password">
		<br>
		<input type="hidden" name="role" value="seller">
		<input type="submit" value="提交">
	</form>
</body>
</html>