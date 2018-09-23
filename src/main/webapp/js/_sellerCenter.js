const sellerCenter = 
`
<div class="category">
        <div class="category-title">我的店铺</div>
        <ul class="item">
            <li><a href="./seller/storeInfo.action">商铺信息</a></li>
        </ul>
    </div>
    <div class="category">
        <div class="category-title">商品管理</div>
        <ul class="item">
            <li><a href="./goodsPullOn.html">商品上架</a></li>
            <li><a href="./goodsInfo.html">商品信息</a></li>
        </ul>
    </div>
    <div class="category">
        <div class="category-title">交易管理</div>
        <ul class="item">
            <li><a href="./soldGood.html">已卖出的宝贝</a></li>
            <li><a href="./comment.html">评价管理</a></li>
        </ul>
    </div>
    <div class="category">
        <div class="category-title">物流管理</div>
        <ul class="item">
            <li><a href="./order.html">物流管理</a></li>
        </ul>
    </div>

    <div class="category">
        <div class="category-title">客户服务</div>
        <ul class="item">
            <li><a href="">退款管理</a></li>
            <li><a href="">违规记录</a></li>
        </ul>
</div>
`

const sellerTop = 
`
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
`

$(function(){
    $(sellerCenter).appendTo('#sellerMenu');
    $(sellerTop).appendTo('#sellerTop');
})
