<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
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
                        <label>物流管理</label>
                    </div>
                    <form>
                        <div class="row form-item">
                            <div class="col-sm-3">
                                <label for="">订单编号</label>
                                <input type="text" class="searchCondition">
                            </div>
                            <div class="col-sm-4">
                                <label for="">收件人姓名：</label>
                                <input type="text" class="searchCondition">
                            </div>
                            <div class="col-sm-4">
                                <label>卖家昵称：</label>
                                <input type="text" class="searchCondition">
                            </div>
                        </div>
                        <div class="row form-item">
                            <div class="col-sm-5">
                                <label for="">创建时间：</label>
                                <input id="start" type="text" class="searchCondition" style="width: 120px;">
                                <label>&nbsp;-&nbsp;</label>
                                <input id="end" type="text" class="searchCondition" style="width: 120px;">
                            </div>
                            <div class="col-sm-4">
                                <label for="">物流状态：</label>
                                <select name="" id="" class="searchCondition">
                                    <option value="0">未发货</option>
                                    <option value="1">发货中</option>
                                    <option value="2">已收货</option>
                                </select>
                            </div>
                            <div class="col-sm-1">
                                <input type="button" value='搜索' class="searchBtn">
                            </div>
                        </div>
                    </form>
                    <hr style="border-color: #888; margin-bottom: 10px;">

                    <div class="orders-list">
                        <div class="row ">
                            <div class="col-sm-3">订单编号</div>
                            <div class="col-sm-3">收件人姓名</div>
                            <div class="col-sm-3">卖家昵称</div>
                            <div class="col-sm-2">下单时间</div>
                            <div class="col-sm-1">状态</div>
                        </div>
                        <hr style="border-color: #888; margin-bottom: 10px;">
                        <div class="row orders-item">
                            <div class="col-sm-3"><a href="./orderInfo.html">6666666666</a></div>
                            <div class="col-sm-3">林哈哈</div>
                            <div class="col-sm-3">林哈哈</div>
                            <div class="col-sm-2">2018-08-08</div>
                            <div class="col-sm-1">未发货</div>
                        </div>
                        <hr style="border-color: #888; margin-bottom: 10px;">
                        <div class="row orders-item">
                            <div class="col-sm-3"><a href="./orderInfo.html">6666666666</a></div>
                            <div class="col-sm-3">林哈哈</div>
                            <div class="col-sm-3">林哈哈</div>
                            <div class="col-sm-2">2018-08-08</div>
                            <div class="col-sm-1">未发货</div>
                        </div>
                        <hr style="border-color: #888; margin-bottom: 10px;">
                        <div class="row orders-item">
                            <div class="col-sm-3"><a href="">6666666666</a></div>
                            <div class="col-sm-3">林哈哈</div>
                            <div class="col-sm-3">林哈哈</div>
                            <div class="col-sm-2">2018-08-08</div>
                            <div class="col-sm-1">未发货</div>
                        </div>
                        <hr style="border-color: #888; margin-bottom: 10px;">
                        <div class="row orders-item">
                            <div class="col-sm-3"><a href="">6666666666</a></div>
                            <div class="col-sm-3">林哈哈</div>
                            <div class="col-sm-3">林哈哈</div>
                            <div class="col-sm-2">2018-08-08</div>
                            <div class="col-sm-1">未发货</div>
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
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath }/kindeditor-master/kindeditor-all-min.js"></script>
    <script src="${pageContext.request.contextPath }/js//zh-CN.js"></script>
    <script src="${pageContext.request.contextPath }/js/generatePagenationBar.js"></script>
    <script src="${pageContext.request.contextPath }/js/_sellerCenter.js"></script>
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