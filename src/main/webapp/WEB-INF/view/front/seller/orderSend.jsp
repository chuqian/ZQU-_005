<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
                        <label>发货</label>
                    </div>
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">订单编号：</label>
                            <div class="col-sm-10">
                                <label class="my-form-control">465432489432486</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">收件人：</label>
                            <div class="col-sm-10">
                                <label class="my-form-control">林哈哈</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">买家昵称：</label>
                            <div class="col-sm-10">
                                <label class="my-form-control">林哈哈副本</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">下单时间：</label>
                            <div class="col-sm-10">
                                <label class="my-form-control">2018-08-08</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">收货地址：</label>
                            <div class="col-sm-10">
                                <label class="my-form-control">广东省肇庆市端州区肇庆大道肇庆学院主校区</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">物流选择：</label>
                            <div class="col-sm-2">
                                <select name="" id="" class="form-control">
                                    <option value="">顺丰快递</option>
                                    <option value="">圆通快递</option>
                                    <option value="">中通快递</option>
                                    <option value="">哈哈快递</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">发货地址：</label>
                            <div class="col-sm-10">
                                <form class="form-inline" style="margin-left:15px;">
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
                                        <div class="form-group"><input type="text" class="form-control" placeholder="详细地址"></div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">邮政编码：</label>
                            <div class="col-sm-2">
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">商品信息：</label>
                            <div class="col-sm-10">
                                <table class="table table-hover">
                                    <tr>
                                        <td width="10%"><img src="./img/default.png" width="100px" height="100px"></td>
                                        <td width="70%"><a href="">短袖T恤男潮流嘻哈夏天简约宽松圆领纯棉纯色基本款潮牌学生半袖 </a></td>
                                        <td width="10%">￥45.00</td>
                                        <td width="10%">1</td>
                                    </tr>    
                                    <tr>
                                        <td width="10%"><img src="./img/default.png" width="100px" height="100px"></td>
                                        <td width="70%"><a href="">短袖T恤男潮流嘻哈夏天简约宽松圆领纯棉纯色基本款潮牌学生半袖 </a></td>
                                        <td width="10%">￥45.00</td>
                                        <td width="10%">1</td>
                                    </tr>    
                                    <tr>
                                        <td width="10%"><img src="./img/default.png" width="100px" height="100px"></td>
                                        <td width="70%"><a href="">短袖T恤男潮流嘻哈夏天简约宽松圆领纯棉纯色基本款潮牌学生半袖 </a></td>
                                        <td width="10%">￥45.00</td>
                                        <td width="10%">1</td>
                                    </tr>    
                                    <tr>
                                        <td width="10%"><img src="./img/default.png" width="100px" height="100px"></td>
                                        <td width="70%"><a href="">短袖T恤男潮流嘻哈夏天简约宽松圆领纯棉纯色基本款潮牌学生半袖 </a></td>
                                        <td width="10%">￥45.00</td>
                                        <td width="10%">1</td>
                                    </tr>    
                                </table>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">确定</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="footer ">
        （沪）字第1248号 | 网络文化经营许可证：沪网文[2016]2296-134号 | 互联网ICP备案：沪ICP备13002172号-3 沪
    </div>
    <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath }/kindeditor-master/kindeditor-all-min.js"></script>
    <script src="${pageContext.request.contextPath }/js//zh-CN.js"></script>
    <script src="${pageContext.request.contextPath }/js/generatePagenationBar.js"></script>
    <script src="${pageContext.request.contextPath }/js/_sellerCenter.js"></script>
    <script src="${pageContext.request.contextPath }/js/distpicker.data.js"></script>
    <script src="${pageContext.request.contextPath }/js/distpicker.js"></script>
    <script src="${pageContext.request.contextPath }/js/main.js"></script>

    <script>
        function toggleSelect(target) {
            var box = document.getElementsByName('box');
            for (let i = 0; i < box.length; i++) {
                box[i].checked = target.checked
            }
            if (target.checked) {
                $('#deleAll').removeClass("disabled")
            } else {
                $('#deleAll').addClass("disabled")
            }
        }
    </script>
    <script src="${pageContext.request.contextPath }/js/laydate.js"></script>
    <script>
        laydate.render({
            elem: '#start' //指定元素
        });
        laydate.render({
            elem: '#end' //指定元素
        });
    </script>
</body>

</html>