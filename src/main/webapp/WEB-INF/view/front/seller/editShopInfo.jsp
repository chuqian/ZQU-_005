<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">
    
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
                        <label>店铺信息</label>
                    </div>
                    <div class="shopInfo">
                        <form class="form-horizontal">
                        	<div class="form-group">
                                <div class="col-sm-10">
                                    <input name="id" value="${seller.id }" type="hidden" /> 
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="nickname" class="col-sm-2 control-label">登录名/昵称:</label>
                                <div class="col-sm-10">
                                    <label name="name" for="" class="control-label">${seller.name }</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="shopBrand" class="col-sm-2 control-label ">店铺标志：</label>
                                <div class="col-sm-10 ">
                                	<img id="preview" src="img/"+"${seller.storeImg }" width="150px" height="150px " alt="shopBrand " class="img-rounded ">
                                </div>
                            </div>
                            <div class="form-group ">
                              <div class="col-sm-offset-2 col-sm-10 ">
                                <label for="avatarInput" class="myBtn">上传图标</label>
                                <input id="avatarInput" name="file" type="file" style="display:none" accept=".jpg " onchange="imgPreview(this)" >
                              </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">店铺类型:</label>
                                <div class="col-sm-3">
                                    <select name="type" id="" class="form-control">
                                    	<c:forEach items="${storeTypes }" var="storeType">
                                    		<option value="${storeType.value }" <c:if test="${type }==${storeType.value }">selected</c:if> >
                                    			${storeType.desc }
                                    		</option>
                                    	</c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">联系地址:</label>
                                <div class="col-sm-10">
	                                <div class="form-inline" style="margin-left:15px;">
	                                    <div id="distpicker2">
	                                        <div class="form-group" style="margin-right:20px">
	                                        	<select class="form-control" id="province5"><option value="" data-code="">---- 所在省 ----</option><option value="北京市" data-code="110000" selected="">北京市</option><option value="天津市" data-code="120000">天津市</option><option value="河北省" data-code="130000">河北省</option><option value="山西省" data-code="140000">山西省</option><option value="内蒙古自治区" data-code="150000">内蒙古自治区</option><option value="辽宁省" data-code="210000">辽宁省</option><option value="吉林省" data-code="220000">吉林省</option><option value="黑龙江省" data-code="230000">黑龙江省</option><option value="上海市" data-code="310000">上海市</option><option value="江苏省" data-code="320000">江苏省</option><option value="浙江省" data-code="330000">浙江省</option><option value="安徽省" data-code="340000">安徽省</option><option value="福建省" data-code="350000">福建省</option><option value="江西省" data-code="360000">江西省</option><option value="山东省" data-code="370000">山东省</option><option value="河南省" data-code="410000">河南省</option><option value="湖北省" data-code="420000">湖北省</option><option value="湖南省" data-code="430000">湖南省</option><option value="广东省" data-code="440000">广东省</option><option value="广西壮族自治区" data-code="450000">广西壮族自治区</option><option value="海南省" data-code="460000">海南省</option><option value="重庆市" data-code="500000">重庆市</option><option value="四川省" data-code="510000">四川省</option><option value="贵州省" data-code="520000">贵州省</option><option value="云南省" data-code="530000">云南省</option><option value="西藏自治区" data-code="540000">西藏自治区</option><option value="陕西省" data-code="610000">陕西省</option><option value="甘肃省" data-code="620000">甘肃省</option><option value="青海省" data-code="630000">青海省</option><option value="宁夏回族自治区" data-code="640000">宁夏回族自治区</option><option value="新疆维吾尔自治区" data-code="650000">新疆维吾尔自治区</option><option value="台湾省" data-code="710000">台湾省</option><option value="香港特别行政区" data-code="810000">香港特别行政区</option><option value="澳门特别行政区" data-code="820000">澳门特别行政区</option></select>
	                                        </div>
	                                        <div class="form-group" style="margin-right: 20px">
	                                        	<select class="form-control" id="city5"><option value="" data-code="">---- 所在市 ----</option><option value="北京市市辖区" data-code="110100" selected="">北京市市辖区</option></select>
	                                        </div>
	                                        <div class="form-group" style="margin-right: 20px">
	                                        	<select class="form-control" id="district5"><option value="" data-code="">---- 所在区 ----</option><option value="东城区" data-code="110101" selected="">东城区</option><option value="西城区" data-code="110102">西城区</option><option value="朝阳区" data-code="110105">朝阳区</option><option value="丰台区" data-code="110106">丰台区</option><option value="石景山区" data-code="110107">石景山区</option><option value="海淀区" data-code="110108">海淀区</option><option value="门头沟区" data-code="110109">门头沟区</option><option value="房山区" data-code="110111">房山区</option><option value="通州区" data-code="110112">通州区</option><option value="顺义区" data-code="110113">顺义区</option><option value="昌平区" data-code="110114">昌平区</option><option value="大兴区" data-code="110115">大兴区</option><option value="怀柔区" data-code="110116">怀柔区</option><option value="平谷区" data-code="110117">平谷区</option><option value="密云区" data-code="110118">密云区</option><option value="延庆区" data-code="110119">延庆区</option></select>
	                                        </div>
	                                        <div class="form-group">
	                                        	<input type="text" class="form-control" placeholder="详细地址">
	                                        </div>
	                                    </div>
	                                </div>
                            </div>
                            </div>
                  
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">邮政编码:</label>
                                <div class="col-md-2">
                                    <input name="contactAddress.postalNumber" type="text" class="form-control" value="${seller.contactAddress.postalNumber}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">店铺介绍:</label>
                                <div class="col-md-2">
                                    <textarea name="content" style="width:700px;height:200px;visibility:hidden;">KindEditor</textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <input name="state" value="${seller.state }" type="hidden" /> 
                                </div>
                            </div>
                            <div class="form-group ">
                              <div class="col-sm-offset-2 col-sm-10 ">
                                <button type="button" class="btn btn-default" onclick="infoSave()">保存</button>
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
    <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/kindeditor-master/kindeditor-all-min.js"></script>
    <script src="${pageContext.request.contextPath }/js/zh-CN.js"></script>
    <script src="${pageContext.request.contextPath }/js/_sellerCenter.js"></script>
    <script src="${pageContext.request.contextPath }/js/distpicker.data.js"></script>
    <script src="${pageContext.request.contextPath }/js/distpicker.js"></script>
    <script src="${pageContext.request.contextPath }/js/main.js"></script>
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
		        //获取图片预览的dom
		        var img = document.getElementById('preview')
		        img.src = e.target.result
		    }
		    reader.readAsDataURL(file)
		}
		
		function infoSave(){
			var data = $("form").serialize();
			$.ajax({
				url: "../seller/infoSave.action",
				type: "post",
				data: data,
				function(msg){
					
				}				
			});
		}
		
    </script>
</body>

</html>