$('#logSubmit').click(function(){
	var userName = $('#logUsername').val().trim();
	var password = $('#logPassword').val().trim();
	
	$.post('login/seller.action', {"userName" : userName, "password" : password}, function(data){
		if(data == 'fail'){
			$('#logPassword').after('<p id="tip">账号不存在或密码不正确</p>');
		}
		else
			location.href = data;
	})
	
	var tip = $('#tip').html();
	if(tip != undefined)
		$('#tip').remove();
	
	return false;
});
