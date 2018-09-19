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
	jQuery.validator
			.addMethod(
					"isEmail",
					function(value, element) {
						var email = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
						return this.optional(element) || email.test(value);
					}, "请正确填写您的邮箱");

	// 账号验证  
	jQuery.validator
			.addMethod(
					"isLogUsername",
					function(value, element) {
						var length = value.length;
						var mobile = /^1[3,5,7,8]\d{9}$/;
						var username = /^([a-zA-Z0-9_\u4e00-\u9fa5]{4,16})$/;
						var email = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
						return this.optional(element)
								|| ((length == 11 && mobile.test(value))
										|| email.test(value) || username
										.test(value));
					}, "请正确填写您的账号");

	$("#logForm")
			.validate(
					{
						rules : {
							logUsername : {
								required : true,
								isLogUsername : true
							},
							logPassword : {
								required : true,
								rangelength : [ 6, 18 ]
							}
						},
						//错误提示  
						messages : {
							logUsername : {
								required : "<em>请输入你的账号！</em>",
								isLogUsername : "<em>请输入正确格式的手机号/邮箱，用户名为4到16位（字母，数字，汉字，下划线）.</em>"
							},
							logPassword : {
								required : "<em>密码不能为空！</em>",
								rangelength : $.validator
										.format("请输入6-18位字符的密码.")
							}
						},

						submitHandler : function(form) {
							console.info("hi");
							form.submit();
						}
					});

	$("#regForm").validate({
		rules : {
			regUsername : {
				required : true,
				isEmail : true
			},
			vCodeS : {
				required : true
			},
			regPassword1 : {
				required : true,
				rangelength : [ 6, 18 ]
			},
			regPassword2 : {
				required : true,
				rangelength : [ 6, 18 ],
				equalTo : "#regPassword1"
			}
		},
		//错误提示  
		messages : {
			regUsername : {
				required : "<em>请输入你的邮箱！</em>",
				isEmail : "<em>请输入正确格式的邮箱.</em>"
			},
			vCodeS : {
				required : "<em>验证码不能为空！</em>"
			},
			regPassword1 : {
				required : "<em>密码不能为空！</em>",
				rangelength : $.validator.format("请输入6-18位字符的密码.")
			},
			regPassword2 : {
				required : "<em>密码不能为空！</em>",
				rangelength : $.validator.format("请输入6-18位字符的密码."),
				equalTo : "两次输入密码不一致"
			}
		},

		submitHandler : function(form) {
			console.info("hi");
			form.submit();
		}
	});