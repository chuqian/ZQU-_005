<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css//goods.css">
    
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
                        <label>商品信息</label>
                    </div>
                    <div class="goodsInfo">
                        <form id="conditions">
                            <div class="row">
                                <div class="col-sm-3">
                                    <label for="">名称：</label>
                                    <input type="text" class="searchCondition" name="name">
                                </div>
                                <div class="col-sm-4">
                                    <label >价格区间：</label>
                                    <input type="text" class="searchCondition" style="width: 60px;" name="down">
                                    <label >&nbsp;-&nbsp;</label>
                                    <input type="text" class="searchCondition" style="width: 60px;" name="up">
                                </div>
                                <div class="col-sm-4">
                                    <label>上架：</label>
                                    <input type="radio" name="isShelf" id="inlineRadio1" value="1"> 是
                                    <input type="radio" name="isShelf" id="inlineRadio2" value="0"> 否
                                </div>
                                <div class="col-sm-1">
                                    <input type="button" value='搜索' class="searchBtn" onclick="formSerialize()">
                                </div>
                            </div>
                        </form>
                        <hr style="border-color: #888; margin-bottom: 10px;">
                        <div class="goods-list">
                            <div class="row goods-list-head">
                                <div class="col-sm-1">
                                    <input type="checkbox" name="" id="" onclick="toggleSelect(this)" >&nbsp;全选
                                </div>
                                <div class="col-sm-2">图片</div>
                                <div class="col-sm-2">名称</div>
                                <div class="col-sm-1">价格</div>
                                <div class="col-sm-1">上架</div>
                                <div class="col-sm-1">库存</div>
                                <div class="col-sm-2">上架时间</div>
                                <div class="col-sm-2">
                                    <label >操作</label>
                                    <a id="deleAll" class="btn deleBtn disabled">删除</a>
                                    
                                </div>
                            </div>
                            <hr style="border-color: #888; margin-bottom: 10px;">
                            <c:forEach items="${commoditys}" var="commodity">
                            <div class="row goods-item">
                                <div class="col-sm-1">
                                    <input type="checkbox" name="box" id="">
                                    <!-- 存放商品的id -->
                                    <input type="hidden" name="${commodity.id }">
                                </div>
                                <div class="col-sm-2">
                                    <img src="../img/default.png" alt="" width="120px" height="120px">
                                </div>
                                <div class="col-sm-2">${commodity.name}</div>
                                <div class="col-sm-1">${commodity.price}</div>
                                <c:choose>
                                	<c:when test="${commodity.isShelf == 1}">
                                		<div class="col-sm-1">是</div>	
                                	</c:when>
                                	<c:otherwise>
                                		<div class="col-sm-1">否</div>
                                	</c:otherwise>
                                </c:choose>
                            	<div class="col-sm-1">${commodity.stock}</div>
                                <div class="col-sm-2">
                                <fmt:formatDate pattern="yyyy-MM-dd" value="${commodity.shelfTime}" type="both"/>
                                </div>
                                <div class="col-sm-2">
                                    <input type="button" value="详细" class="detailBtn">
                                    <input type="button" value="删除" class="deleBtn" onclick="commodityDelete('5b9625662fcc73437f2a47ce','${commodity.id }')">
                                </div>
                            </div>
                            <hr style="border-color: #888; margin-bottom: 10px;">
                            </c:forEach>
                            <div id="pagenationBar" class="pagenationBar pull-right btn-group"></div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="footer ">
        （沪）字第1248号 | 网络文化经营许可证：沪网文[2016]2296-134号 | 互联网ICP备案：沪ICP备13002172号-3 沪
    </div>
    <script src="../js/jquery.min.js"></script>
    <script src="../kindeditor-master/kindeditor-all-min.js"></script>
    <script src="../js//zh-CN.js"></script>
    <script type="text/javascript">
    	var url = window.location.href
    	var params = '';
    	if(url.indexOf('toGoodInfoCondition') != -1){
    		params = url.substr(url.indexOf('name'))
    		params = '&' + decodeURIComponent(params,true)
    	}
    	console.log(params)
	  	//总页数
	    const totalPage = ${totalPage }
	    //当前页数
	    const page = ${page}
	    function _click(target){
	    	let btnText = target.innerText;
	        if(btnText === '<<') {
	            window.location.href ='?currentPage=' + 1 + params
	        }
	        else if(btnText === '>>') {
	            window.location.href ='?currentPage=' + totalPage + params 
	        }
	        else {
	            window.location.href ='?currentPage=' + target.innerText + params
	        }
	    }
	    function formSerialize(){
	    	var data  = $("#conditions").serialize()
	    	data = decodeURIComponent(data,true)
	    	if($("input[name='isShelf']:checked").length == 0){
	    		data += '&isShelf='
	    	}
	    	window.location.href = './toGoodInfoCondition.action?' + data;
	    }
	    function commodityDelete(sellerId, commodityId){
		    console.log("delete")
	    	$.get("./commodityDel.action", {sellerId,commodityId}, function(result){
	    		console.log(result)
	    		if(result === 'success'){
	    			alert("删除成功")	
	    			window.location.reload()
	    		}else{
	    			alert("删除失败")
	    		}
	    	})
	    }
    </script>
    <script src="../js/generatePagenationBar.js"></script>
    <script src="../js/_sellerCenter.js"></script>
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
