const sellerCenter = 
`
<div class="category">
        <div class="category-title">我的店铺</div>
        <ul class="item">
            <li><a href="./editShopInfo.html">商铺信息</a></li>
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

$(function(){
    $(sellerCenter).appendTo('#sellerMenu')
})