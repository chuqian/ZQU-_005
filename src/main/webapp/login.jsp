<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<body>
	<form  method="post">
		account: <input type="text" name="id">
		<br>
		password: <input type="text" name="password">
		<br>
		<input type="submit" value="submit" onclick="return send()">
	</form>
</body>
</html>