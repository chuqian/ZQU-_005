$('#regUsername').blur(function(){
	var email = $('#regUsername').val();
	var data = {"email" : email, "role" : "seller"};
	
	$.post("register/validateEmail.action", data, function(info) {
		if(info == '1'){
			$('#getCode').prop('disabled', false);
			$('#getCode').click(function(event){
				var email = $('#regUsername').val();
				var data = {"email" : email};
				
				$('#getCode').prop('disabled', true);
				$.post("register/getCode.action", data, function(info) {
					if(info != ''){
						alert('success to send the email ' + info);
						countDown();
					}						
					else
						alert('fail to send the email ' + info);
				})				
			});
		}
		else{
			alert('the email used ' + info);
			$('#regUsername').after('<p id="tip">此邮箱已注册</p>');
		}
	})
});

$('#regUsername').focus(function(){
	$('#tip').remove();
});

$('#getCode').attr('disabled', true);

$('#regSubmit').click(function(){
	$('#tip').remove();
	var code = $('#vCode').val().trim();
	var email = $('#regUsername').val().trim();
	var password = $('#regPassword1').val().trim();
	var password1 = $('#regPassword2').val().trim();
	
	if(email == ''){
		$('#regUsername').after('<p id="tip">邮箱不能为空</p>');
		return false;
	}
	
	if(code == ''){
		$('#vCode').after('<p id="tip">验证码不能为空</p>');
		return false;
	}	
	
	if(password == ''){
		$('#regPassword1').after('<p id="tip">密码不能为空</p>');
		return false;
	}
	
	if(password1 == ''){
		$('#regPassword2').after('<p id="tip">密码不能为空</p>');
		return false;
	}
	
	var data = {"email" : email, "code" : code};
	
	$.post("register/validateCode.action", data, function(info) {
		if(info == '1'){
			var data1 = {"email" : email, "password" : password};
			$.post('reigter/seller.action', data1, function(){
				location.href = "shopping/seller.jsp";
			});
		}
		else{
			$('#vCode').after('<p id="tip">验证码有误</p>');
			return false;
		}	
	})
});

var wait = 120;
function countDown(){
	
	if(wait == 0){
		wait = 60;		
		$('#getCode').html('获取验证码');
		$('#getCode').prop('disabled', false);
	}
	else{
		wait--;
		$('#getCode').html(wait + 's 后此验证码无效');
		setTimeout(function(){
			countDown();
		}, 1000)
	}
}
