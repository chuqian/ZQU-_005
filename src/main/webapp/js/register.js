

function getCode() {
	var email = $('#email').val();
	var data = {"email" : email};
		
	$.post("register/getCode.action", data, function(info) {
		if(info != '')
			alert('success to send the email ' + info);
		else
			alert('fail to send the email ' + info);
	})
	
	return false;
}

function validateCode() {
	var code = $('#code').val();
	var email = $('#email').val();
	var data = {"email" : email, "code" : code};
	
	$.post("register/validateCode.action", data, function(info) {
		if(info == '1')
			alert('success to validate the email ' + info);
		else
			alert('fail to validate the email ' + info);
	})
	
	return false;
}

function validateEmail() {
	var email = $('#email').val();
	var data = {"email" : email, "role" : "seller"};
	
	$.post("register/validateEmail.action", data, function(info) {
		if(info == '1')
			alert('the email not use ' + info);
		else
			alert('the email used ' + info);
	})
}