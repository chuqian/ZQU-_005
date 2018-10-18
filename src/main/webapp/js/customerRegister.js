$('#getCode').prop('disabled', true);
var wait = 60;

$('#regUsername').keyup(function(){
	var nameVali = $('#regForm').validate().element($('#regUsername'));
	console.log(nameVali);
	
	//用户验证通过
	if(nameVali == true) {
		if(wait == 60)
			$('#getCode').prop('disabled', false);
		
		//单击"获取验证码"按钮
		$('#getCode').click(function(envent){
			var email = $('#regUsername').val();
			var data = {"email" : email, "role" : "customer"};
			//验证用户是否已被注册
			$.post("register/validateEmail.action", data, function(info) {
				if(info == '1'){      //用户可以注册
					$('#getCode').prop('disabled', true);
					var data = {"email" : email};
					//获取验证码
					$.post("register/getCode.action", data, function(info) {
						if(info != ''){
							alert('success to send the email ' + info);
						}						
						else
							alert('fail to send the email ' + info);
					});
					countDown();  //60秒后重新获取
				}
				else{
					alert('the email used ' + info);
					$('#regUsername').after('<em class="tip">此邮箱已注册</em>');
				}
			});
		});
	}
	else {
		$('#getCode').prop('disabled', true);
	}
});

$('#regUsername').focus(function(){
	$('.tip').remove();
});

$('#regSubmit').click(function(){
	$('.tip').remove();
	var email = $('#regUsername').val();
	var code = $('#vCode').val();
	var data = {"email" : email, "code" : code};
	var password1 = $('#regPassword1').val().trim();
	var password2 = $('#regPassword2').val().trim();
	
	if(email == ''){
		$('#regUsername').after('<p class="tip">邮箱不能为空</p>');
		return false;
	}
	
	if(code == ''){
		$('#vCode').after('<p class="tip">验证码不能为空</p>');
		return false;
	}
	
	if(password1 == ''){
		$('#regPassword1').after('<p class="tip">密码不能为空</p>');
		return false;
	}
	
	if(password2 == ''){
		$('#regPassword2').after('<p class="tip">密码不能为空</p>');
		return false;
	}
	
	$.post("register/validateCode.action", data, function(info) {
		if(info == '1'){
			var password = $('#regPassword1').val().trim();
			var data1 = {"email" : email, "password" : password};
			$.post('reigter/seller.action', data1, function(){
				location.href = "shopping/customer.jsp";
			});
		}
		else{
			$('#vCode').after('<p class="tip">验证码有误</p>');
			return false;
		}	
	});
});

function countDown(){
	if(wait == 0){
		wait = 60;		
		$('#getCode').html('获取验证码');
		$('#getCode').prop('disabled', false);
	}
	else{
		$('#getCode').prop('disabled', true);
		wait--;
		$('#getCode').html(wait + 's后重新获取');
		setTimeout(function(){
			countDown();
		}, 1000);
	}
}
