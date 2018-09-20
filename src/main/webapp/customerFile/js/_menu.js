const _menu = 
`
<ul>
    <li class="person">
        <a href="./tongwebinf?url=person/index">个人中心</a>
    </li>
    <li class="person">
        <a href="#">个人资料</a>
        <ul>
            <li> <a href="./tongwebinf?url=person/information">个人信息</a></li>
            <li> <a href="./tongwebinf?url=person/safety">安全设置</a></li>
            <li> <a href="./tongwebinf?url=person/address">收货地址</a></li>
        </ul>
    </li>
    <li class="person">
        <a href="#">我的交易</a>
        <ul>
            <li><a href="./tongwebinf?url=person/order">订单管理</a></li>
            <li> <a href="./tongwebinf?url=person/change">退款售后</a></li>
        </ul>
    </li>
    <!-- 
    <li class="person">
        <a href="#">我的资产</a>
        <ul>
            <li class="active"> <a href="./tongwebinf?url=person/bill">账单明细</a></li>
        </ul>
    </li>
    -->
    <li class="person">
        <a href="#">我的小窝</a>
        <ul>
            <li> <a href="./tongwebinf?url=person/collection">收藏</a></li>
            <li> <a href="./tongwebinf?url=person/comment">评价</a></li>
            <li> <a href="./tongwebinf?url=person/news">消息</a></li>
        </ul>
    </li>

</ul>
`

$(function(){
    $(_menu).appendTo('#menu')
})