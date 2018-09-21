$('#logSubmit').click(function(){
	var userName = $('#logUsername').val().trim();
	var password = $('#logPassword').val().trim();
	
	if(userName == ''){
		$('#logUsername').after('<p id="tip">账号不能为空</p>');
		return false;
	}
	
	if(password == ''){
		$('#logPassword').after('<p id="tip">密码不能为空</p>');
		return false;
	}
	
	$.post('login/customer.action', {"userName" : userName, "password" : password}, function(data){
		if(data == 'fail'){
			$('#logPassword').after('<p id="tip">账号不存在或密码不正确</p>');
		}
		else
			location.href = data;
	})
	
	return false;
});


$('#logUsername').focus(function(){
	$('#tip').remove();
});

$('#logPassword').focus(function(){
	$('#tip').remove();
});
