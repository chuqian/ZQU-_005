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
    <link rel="stylesheet" href="./css//goods.css">
    
    <title>Document</title>
</head>

<body>
    <div class="navbar navbar-default myheader">
        <!-- 放置logo -->
        <div class="container">
            <div class="navbar-header myBrand">
                多野卖家中心
            </div>
            <label class="toggle-label visible-xs-inline-block" for="toggle-checkbox">菜单</label>
            <input class="hidden" type="checkbox" name="" id="toggle-checkbox">
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
                <div id="sellerMenu" class="hidden-xs list-group side-bar">
                    
                </div>
            </div>
            <div class="col-sm-10">
                <div class="wrapper">
                    <div class="location">
                        <label>卖家中心</label>
                        <label>></label>
                        <label>商品上架</label>
                    </div>
                    <div class="goodsInfo">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="nickname" class="col-sm-2 control-label">商品名称:</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="shopBrand"  class="col-sm-2 control-label ">商品图片：</label>
                              <div class="col-sm-10 " id="imgContainer">
                                <img src="./img/default.png " width="150px " height="150px " alt="shopBrand " class="img-rounded goodsImg">
                              </div>
                            </div>
                            <div class="form-group ">
                              <div class="col-sm-offset-2 col-sm-10 ">
                                <label for="avatarInput" class="myBtn">上传</label>
                                <input id="avatarInput" type="file" style="display:none" accept=".jpg " onchange="imgPreview(this)" >
                              </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">商品类目:</label>
                                <div class="col-sm-3">
                                    <select name="" id="" class="form-control">
                                        <option value="">手机</option>
                                        <option value="">服饰</option>
                                        <option value="">食品</option>    
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">价格:</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">库存:</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2 control-label">是否上架</div>
                                <div class="col-md-2">
                                    <label class="radio-inline">
                                    <input type="radio" name="pullOn" id="inlineRadio1" value="1"> 是
                                    </label>
                                    <label class="radio-inline">
                                    <input type="radio" name="pullOn" id="inlineRadio2" value="0"> 否
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">商品介绍:</label>
                                <div class="col-md-2">
                                    <textarea name="content" style="width:700px;height:200px;visibility:hidden;">KindEditor</textarea>
                                </div>
                            </div>
                            <div class="form-group ">
                              <div class="col-sm-offset-2 col-sm-10 ">
                                <button type="submit" class="btn btn-default ">保存</button>
                              </div>
                            </div>
                          </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="footer ">
        （沪）字第1248号 | 网络文化经营许可证：沪网文[2016]2296-134号 | 互联网ICP备案：沪ICP备13002172号-3 沪
    </div>
    <script src="./js/jquery.min.js"></script>
    <script src="./kindeditor-master/kindeditor-all-min.js"></script>
    <script src="./js//zh-CN.js"></script>
    <script src="./js/_sellerCenter.js"></script>
    <script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="content"]', {
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
    function imgPreview(fileDom) {
        //判断浏览器是否支持FileReader
        if (window.FileReader) {
            var reader = new FileReader()
        } else {
            alert('您的设备不支持图片预览功能，如需该功能请升级设备')
        }
        //获取文件
        var file = fileDom.files[0]
        var imageType = /^image\//
        console.log(file.type)
        if (!imageType.test(file.type)) {
            alert('请选择图片')
            return
        }
        //图片读取完成
        reader.onload = function (e) {
            //获取imgContainer节点下没有显示图片的img节点的下标
            var index = $('#imgContainer')[0].childElementCount - 1
            //获取图片预览的dom
            var img = $('#imgContainer').children('img').get(index)
            img.name = 'goodsImg' + index
            img.src = e.target.result
            //创建新的图片预览dom
            let imgDom = '<img src="./img/default.png " width="150px " height="150px " alt="shopBrand " class="img-rounded goodsImg">'
            $('#imgContainer').append(imgDom)
            console.log(index)
        }
        reader.readAsDataURL(file)
    }
    </script>
</body>

</html>
