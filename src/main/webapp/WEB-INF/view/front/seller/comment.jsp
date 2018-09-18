<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css"> 
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/goods.css">
    
    <title>Document</title>
</head>

<body>
    <div class="navbar navbar-default myheader">
        <!-- 放置logo -->
        <div class="container" id="sellerTop">
            
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
                        <label>评价管理</label> 
                    </div>
                    <div class="comments-list">
                        <div class="row comments-list-head">
                            <div class="col-sm-1">
                                <select name="" id="">
                                    <option value="0">评价</option>
                                    <option value="1">好评</option>
                                    <option value="2">中评</option>
                                    <option value="3">差评</option>
                                </select>
                            </div>
                            <div class="col-sm-6">评论</div>
                            <div class="col-sm-1">评价人</div>
                            <div class="col-sm-1">时间</div>
                            <div class="col-sm-3">宝贝信息</div>
                        </div>
                        <hr style="border-color: #888; margin-bottom: 10px;"> 
                        <div class="row comments-item">
                            <div class="col-sm-1"><img src="./img/1.svg" alt="好评" width="25px" height="25px"></div>
                            <div class="col-sm-6">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Corporis sit nam sint ipsam id repudiandae vitae vel, tempora eius doloremque, perferendis error natus esse necessitatibus quis veritatis consequatur ipsum eaque?</div>
                            <div class="col-sm-1">林哈哈</div>
                            <div class="col-sm-1">2018-08-31</div>
                            <div class="col-sm-3"><a href="">Lorem ipsum dolor sit amet consectetur, adipisicing elit.</a></div>
                        </div>
                        <hr style="border-color: #888; margin-bottom: 10px;"> 
                        <div class="row comments-item">
                            <div class="col-sm-1"><img src="./img/2.svg" alt="中评" width="25px" height="25px"></div>
                            <div class="col-sm-6">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Corporis sit nam sint ipsam id repudiandae vitae vel, tempora eius doloremque, perferendis error natus esse necessitatibus quis veritatis consequatur ipsum eaque?</div>
                            <div class="col-sm-1">林哈哈</div>
                            <div class="col-sm-1">2018-08-31</div>
                            <div class="col-sm-3"><a href="">Lorem ipsum dolor sit amet consectetur, adipisicing elit.</a></div>
                        </div>
                        <hr style="border-color: #888; margin-bottom: 10px;"> 
                        <div class="row comments-item">
                            <div class="col-sm-1"><img src="./img/3.svg" alt="差评" width="25px" height="25px"></div>
                            <div class="col-sm-6">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Corporis sit nam sint ipsam id repudiandae vitae vel, tempora eius doloremque, perferendis error natus esse necessitatibus quis veritatis consequatur ipsum eaque?</div>
                            <div class="col-sm-1">林哈哈</div>
                            <div class="col-sm-1">2018-08-31</div>
                            <div class="col-sm-3"><a href="">Lorem ipsum dolor sit amet consectetur, adipisicing elit.</a></div>
                        </div>
                        <hr style="border-color: #888; margin-bottom: 10px;"> 
                        <div class="row comments-item">
                            <div class="col-sm-1"><img src="./img/1.svg" alt="好评" width="25px" height="25px"></div>
                            <div class="col-sm-6">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Corporis sit nam sint ipsam id repudiandae vitae vel, tempora eius doloremque, perferendis error natus esse necessitatibus quis veritatis consequatur ipsum eaque?</div>
                            <div class="col-sm-1">林哈哈</div>
                            <div class="col-sm-1">2018-08-31</div>
                            <div class="col-sm-3"><a href="">Lorem ipsum dolor sit amet consectetur, adipisicing elit.</a></div>
                        </div>
                        <hr style="border-color: #888; margin-bottom: 10px;"> 
                        <div class="row comments-item">
                            <div class="col-sm-1"><img src="./img/1.svg" alt="好评" width="25px" height="25px"></div>
                            <div class="col-sm-6">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Corporis sit nam sint ipsam id repudiandae vitae vel, tempora eius doloremque, perferendis error natus esse necessitatibus quis veritatis consequatur ipsum eaque?</div>
                            <div class="col-sm-1">林哈哈</div>
                            <div class="col-sm-1">2018-08-31</div>
                            <div class="col-sm-3"><a href="">Lorem ipsum dolor sit amet consectetur, adipisicing elit.</a></div>
                        </div>
                        <hr style="border-color: #888; margin-bottom: 10px;"> 
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="footer ">
        （沪）字第1248号 | 网络文化经营许可证：沪网文[2016]2296-134号 | 互联网ICP备案：沪ICP备13002172号-3 沪
    </div>
    <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/kindeditor-master/kindeditor-all-min.js"></script>
    <script src="${pageContext.request.contextPath }/js//zh-CN.js"></script>
    <script src="${pageContext.request.contextPath }/js/generatePagenationBar.js"></script>
    <script src="${pageContext.request.contextPath }/js/_sellerCenter.js"></script>
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
    <script>
        function toggleSelect(target){
            var box = document.getElementsByName('box');
            for(let i=0; i<box.length; i++){
                box[i].checked = target.checked
            }
            if(target.checked) {
                $('#deleAll').removeClass("disabled")
            }else {
                $('#deleAll').addClass("disabled")
            }
        }
    </script>
</body>

</html>
