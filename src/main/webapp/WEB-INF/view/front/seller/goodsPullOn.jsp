<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/main.css">
<link rel="stylesheet" href="./css/goods.css">
<title>Document</title>
</head>

<body>
	<div class="navbar navbar-default myheader">
		<!-- 放置logo -->
		<div class="container">
			<div class="navbar-header myBrand">多野卖家中心</div>
			<label class="toggle-label visible-xs-inline-block"
				for="toggle-checkbox">菜单</label> <input class="hidden"
				type="checkbox" name="" id="toggle-checkbox">
			<div class="hidden-xs">
				<ul class="nav navbar-nav">
					<li><a href="">首页</a></li>
					<li><a href="">消息</a><span id="tipNum" class="tipNum">5</span></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.html#login">登录</a></li>
					<li><a href="login.html#singup">注册</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container myContainer">
		<div class="row">
			<div class="col-sm-2">
				<div id="sellerMenu" class="hidden-xs list-group side-bar"></div>
			</div>
			<div class="col-sm-10">
				<div class="wrapper">
					<div class="location">
						<label>卖家中心</label> <label>></label> <label>商品上架</label>
					</div>
					<div class="goodsInfo">
<!-- 						<form class="form-horizontal" action="./commodiy/onOrDown.action" method="post" enctype="multipart/form-data"> -->
						<form method="POST" enctype="multipart/form-data" class="form-horizontal" id="info"> 
							<input type="hidden" value="5b9625662fcc73437f2a47ce" name="sellerId">
							<div class="form-group">
								<label for="nickname" class="col-sm-2 control-label">商品名称:</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" name="name">
								</div>
							</div>
							<div class="form-group">
								<label for="shopBrand" class="col-sm-2 control-label ">商品图片：</label>
								<div class="col-sm-10 " id="imgContainer">
									
								</div>
							</div>
							<div class="form-group ">
								<div class="col-sm-offset-2 col-sm-10 ">
									<label for="avatarInput" class="myBtn">上传</label> <input name="file"
										id="avatarInput" type="file" style="display: none"
										multiple>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">商品类目:</label>
								<div class="col-sm-3">
									<select name="commodityType" id="" class="form-control">
										<option value="手机">手机</option>
										<option value="服饰">服饰</option>
										<option value="食品">食品</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">价格:</label>
								<div class="col-md-2">
									<input type="text" class="form-control" name="price">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">运费:</label>
								<div class="col-md-2">
									<input type="text" class="form-control" name="formwork">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">库存:</label>
								<div class="col-md-2">
									<input type="text" class="form-control" name="stock">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-2 control-label">是否上架</div>
								<div class="col-md-2">
									<label class="radio-inline"> <input type="radio"
										name="isShelf" id="inlineRadio1" value="1"> 是
									</label> <label class="radio-inline"> <input type="radio"
										name="isShelf" id="inlineRadio2" value="0"> 否
									</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">商品介绍:</label>
								<div class="col-md-10">
									<textarea name="description" style="width:700px;height:200px;visibility:hidden;"></textarea>

								</div>
							</div>
							<div class="form-group ">
								<div class="col-sm-offset-2 col-sm-10 ">
									<button id="submit" class="btn btn-default ">保存</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
	<div class="footer ">（沪）字第1248号 | 网络文化经营许可证：沪网文[2016]2296-134号 |
		互联网ICP备案：沪ICP备13002172号-3 沪</div>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script> 

	<script src="js/jquery.min.js"></script>
	<script src="./js/_sellerCenter.js"></script>

	<script src="./kindeditor-master/kindeditor-all-min.js"></script>
	<script src="./js/zh-CN.js"></script>
	
	<script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="description"]', {
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
				});
			});
	</script>
	<script>
    window.onload = function () {
        var input = document.getElementById("avatarInput");
        var result, div;
        if (typeof FileReader === 'undefined') {
            result.innerHTML = "抱歉，你的浏览器不支持 FileReader";
            input.setAttribute('disabled', 'disabled');
        } else {
            input.addEventListener('change', readFile, false);
        }　　　　　
        //handler   
        var imgDom, div
        function readFile() {
            for (var i = 0; i < this.files.length; i++) {
                if (!input['value'].match(/.jpg|.gif|.png|.bmp/i)) {　　
                	//判断上传文件格式   
                    return alert("上传的图片格式不正确，请重新选择")
                }
                var reader = new FileReader();
                reader.readAsDataURL(this.files[i]);
                reader.onload = function (e) {
                    imgDom = '<img src="' + this.result +'" width="150px " height="150px " alt="shopBrand " class="img-rounded goodsImg">'
                    div = document.createElement('div')
                    div.style.display = 'inline-block';
                    div.innerHTML = imgDom;
                    document.getElementById('imgContainer').appendChild(div);
                }
            }
        }
    }
    </script>
   	 
	<script type="text/javascript" src="js/jquery-form.js"></script>  
    <script type="text/javascript">
	//文件异步上传
    $(document).ready(function() {
        $("#submit").on("click", function() {
            $('.form-horizontal').ajaxForm({  
                url : "./commodiy/onOrDown.action", // 请求的url  
                type : "post", // 请求方式  
                dataType : "text", // 响应的数据类型  
                async : true, // 异步  
                success : function(data) {  
                    alert('添加成功！')
                    //清空表单数据
                 	$('#info')[0].reset();
                    //清空富文本编辑器内容
                    KindEditor.instances[0].html("");
                    //清空图片预览
                    $('#imgContainer').empty();
                },  
                error : function() {  
                    alert("数据加载失败！");  
                }
            });  
        });  
    });  
    </script>
</body>

</html>
