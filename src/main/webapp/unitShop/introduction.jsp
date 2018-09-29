<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>商品页面</title>

		<link href="../customerFile/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="../customerFile/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="../customerFile/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link type="text/css" href="../customerFile/css/optstyle.css" rel="stylesheet" />
		<link type="text/css" href="../customerFile/css/style.css" rel="stylesheet" />

		<script type="text/javascript" src="../customerFile/basic/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="../customerFile/basic/js/quick_links.js"></script>

		<script type="text/javascript" src="../customerFile/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
		<script type="text/javascript" src="../customerFile/js/jquery.imagezoom.min.js"></script>
		<script type="text/javascript" src="../customerFile/js/jquery.flexslider.js"></script>
		<script type="text/javascript" src="../customerFile/js/list.js"></script>

	</head>
	<body>
		<div id="hmtop">
		</div>
				<!--分类-->
			<div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="../unitShop/home.jsp">首页</a></li>
							</ul>
						</div>
			</div>
				<ol class="am-breadcrumb am-breadcrumb-slash">
					<li><a href="#">首页</a></li>
					<li><a href="#">分类</a></li>
					<li class="am-active">内容</li>
					<li class="am-active">店铺：<a href="${requestScope.sellerId}">${requestScope.name}</a></li>
				</ol>

				<!--放大镜-->
				<div class="item-inform">
					<div class="clearfixLeft" id="clearcontent">

						<div class="box">
							<script type="text/javascript">
								$(document).ready(function() {
									$(".jqzoom").imagezoom();
									$("#thumblist li a").click(function() {
										$(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
										$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
										$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
									});
								});
							</script>

							<div class="tb-booth tb-pic tb-s310">
								<a href="${requestScope.commodity.imgSrc[0]}"><img src="${requestScope.commodity.imgSrc[0]}" alt="细节展示放大镜特效" rel="${requestScope.commodity.imgSrc[0]}" class="jqzoom" /></a>
							</div>
							<ul class="tb-thumb" id="thumblist">
								<c:forEach items="${requestScope.commodity.imgSrc}" var="imgSrc">
									<li>
										<div class="tb-pic tb-s40">
											<a href="#"><img src="${imgSrc}" mid="${imgSrc}" big="${imgSrc}"></a>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
						<div class="clear"></div>
					</div>
					<div class="clearfixRight">

						<!--规格属性-->
						<!--名称-->
						<div class="tb-detail-hd">
							<h1>${requestScope.commodity.name}</h1>
						</div>
						<div class="tb-detail-list">
							<!--价格-->
							<div class="tb-detail-price">
<!-- 								<li class="price iteminfo_price"> -->
<!-- 									<dt>促销价</dt> -->
<!-- 									<dd><em>¥</em><b class="sys_item_price">56.90</b>  </dd>                                  -->
<!-- 								</li> -->
								<li class="price iteminfo_mktprice">
									<dt>原价</dt>
									<dd><em>¥</em><b class="sys_item_price">${requestScope.commodity.price}</b></dd>									
								</li>
								<li class="price iteminfo_mktprice">
									<dt>快递费</dt>
									<dd><em>¥</em><b class="sys_item_freprice">${requestScope.commodity.formwork}</b>元</dd>									
								</li>
								<div class="clear"></div>
							</div><br>

							<!--销量-->
							<ul class="tm-ind-panel">
								<li class="tm-ind-item tm-ind-sumCount canClick">
									<div class="tm-indcon"><span class="tm-label">累计销量</span><span class="tm-count">${requestScope.commodity.saledNum}</span></div>
								</li>
								<li class="tm-ind-item tm-ind-reviewCount canClick tm-line3">
									<div class="tm-indcon"><span class="tm-label">累计评价</span><span class="tm-count">${requestScope.commentNum}</span></div>
								</li>
							</ul>
							<div class="clear"></div>

							<!--各种规格-->
							<dl class="iteminfo_parameter sys_item_specpara">
								<dt class="theme-login"><div class="cart-title">可选规格<span class="am-icon-angle-right"></span></div></dt>
								<dd>
									<!--操作页面-->

									<div class="theme-popover-mask"></div>

									<div class="theme-popover">
										<div class="theme-span"></div>
										<div class="theme-poptit">
											<a href="javascript:;" title="关闭" class="close">×</a>
										</div>
										<div class="theme-popbod dform">
											<form class="theme-signin" name="loginform" action="" method="post">

												<div class="theme-signin-left">
													<div class="theme-options">
														<div class="cart-title number">数量</div>
														<dd>
															<input id="min" class="am-btn am-btn-default" name="" type="button" value="-" />
															<input id="text_box" name="amount" type="text" value="1" style="width:30px;" disabled="disabled"/>
															<input id="add" class="am-btn am-btn-default" name="" type="button" value="+" />
															<span id="Stock" class="tb-hidden">库存<span class="stock">${requestScope.commodity.stock}</span>件</span>
														</dd>
											 			<script>
											            	//商品数量的增加
											                function number(){
															var index = ${requestScope.commodity.stock};
											                var Input0=document.getElementById('text_box');
											                var Input1=document.getElementById('add');
															var vval = Number(Input0.value);
											                    Input1.onclick=function(){
																	if(vval<index-1){
																		vval = vval + 1;
																	}
																	if(Number(Input0.value)>=index-1){
																		Input0.value = index-1;
																		console.log(Input0.value);
																	}
											                    }
											                };
															number();
											            </script>

													</div>
													<div class="clear"></div>

													<div class="btn-op">
														<div class="btn am-btn am-btn-warning">确认</div>
														<div class="btn close am-btn am-btn-warning">取消</div>
													</div>
												</div>
												<div class="theme-signin-right">
													<div class="img-info">
														<img src="../customerFile/images/songzi.jpg" />
													</div>
													<div class="text-info">
														<span class="J_Price price-now">¥39.00</span>
														<span id="Stock" class="tb-hidden">库存<span class="stock">1000</span>件</span>
													</div>
												</div>
											</form>
										</div>
									</div>
								</dd>
							</dl>
							<div class="clear"></div>
						</div>

						<div class="pay">
							<script type="text/javascript">
								var commodityId = "${requestScope.commodity.id}";
								var name = "${requestScope.commodity.name}";
								var price = "${requestScope.commodity.price}";
								var imgScr = "${requestScope.commodity.imgSrc[0]}";
								var datetime = "${requestScope.commodity.shelfTime}";
								$(function(){									
									$("#LikCollection").click(function(){
										event.preventDefault(); // 使a自带的方法失效，即无法向deleteCollent.action发出请求
										var flag = document.getElementById("LikCollection").innerHTML;
										if(flag=="加入收藏夹"){
											addCon(flag);
										}else {
											deleteCon(flag);
										}
									});
									function addCon(flag) {
										console.log(flag);
										$.ajax({
											type:"POST",
											url:"../customer_1/addCollent.action",
											data:{
												"customerId":"12345678",
	 											"commodityId":commodityId,
	 											"name":name,
	 											"price":price,
	 											"imgScr":imgScr,
	 											"datetime":datetime
											},
											success:function(data){
												console.log(data);
												if(data=="isAdd"){
													var content;
													content=document.getElementById("LikCollection");
													$('#LikCollection').html('取消收藏');
// 													alert(content);
													console.log(content);
// 													alert(content.getAttribute('title'));
													console.log(content.getAttribute('title'));
													
													content.setAttribute('title','取消收藏');
													content.setAttribute('class','LikDelCollection');
													content.setAttribute('href','../customer_1/deleteCollent1.action');
													var con = document.getElementById("LikCollectionDIV");
													con.setAttribute('class','clearfix tb-btn tb-btn-basket theme-login');
												}
											}
										});
									};
									function deleteCon(flag) {
// 										alert(flag);
										console.log(flag);
										$.ajax({
											type:"POST",
											url:"../customer_1/deleteCollent.action",
											data:{
												"customerId":"12345678",
	 											"commodityId":commodityId	
											},
											success:function(data){
												console.log(data);
												if(data=="isNull"){
													var content;
													content=document.getElementById("LikCollection");
													$('#LikCollection').html('加入收藏夹');
// 													alert(content);
													console.log(content);
// 													alert(content.getAttribute('title'));
													console.log(content.getAttribute('title'));
													
													content.setAttribute('title','加入收藏夹');
													content.setAttribute('class','LikAddCollection');
													content.setAttribute('href','../customer_1/addCollent1.action');
													var con = document.getElementById("LikCollectionDIV");
													con.setAttribute('class','clearfix tb-btn tb-btn-buy theme-login');						
												}
											}
										});
									};
								})
							</script>
							<li>
								<div class="clearfix tb-btn tb-btn-buy theme-login">
									<a id="LikBuy" title="点此按钮到下一步确认购买信息" href="#">立即购买</a>
								</div>
							</li>
							<li>
								<div class="clearfix tb-btn tb-btn-basket theme-login">
									<a id="LikShopCart" title="加入购物车" href="#"><i></i>加入购物车</a>
								</div>
							</li>
							<li>
								<div>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</div>
							</li>
							<li>
								<c:if test="${requestScope.isCollent == -1}">
								<div id="LikCollectionDIV" class="clearfix tb-btn tb-btn-buy theme-login">
									<a id="LikCollection" class="LikAddCollection" title="加入收藏夹" href="../customer_1/addCollent1.action">加入收藏夹</a>
								</div>
								</c:if>
								<c:if test="${requestScope.isCollent == 1}">
								<div id="LikCollectionDIV" class="clearfix tb-btn tb-btn-basket theme-login">
									<a id="LikCollection" class="LikDelCollection" title="取消收藏" href="../customer_1/deleteCollent1.action">取消收藏</a>
								</div>
								</c:if>
							</li>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<br /><br />

				<!-- introduce-->

				<div class="introduce">
					<div class="introduceMain">
						<div class="am-tabs" data-am-tabs>
							<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active">
									<a href="#">
										<span class="index-needs-dt-txt">宝贝详情</span></a>
								</li>
								<li>
									<a href="#">
										<span class="index-needs-dt-txt">全部评价</span></a>
								</li>
								<li>
									<a href="#">
										<span class="index-needs-dt-txt">猜你喜欢</span></a>
								</li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active">
									<div class="J_Brand">
										<div class="attr-list-hd tm-clear">
											<h4>产品参数：</h4></div>
										<div class="clear"></div>
										<ul id="J_AttrUL">
											<li title="">产品类型:&nbsp;烘炒类</li>
											<li title="">原料产地:&nbsp;巴基斯坦</li>
											<li title="">产地:&nbsp;湖北省武汉市</li>
											<li title="">配料表:&nbsp;进口松子、食用盐</li>
											<li title="">产品规格:&nbsp;210g</li>
											<li title="">保质期:&nbsp;180天</li>
											<li title="">产品标准号:&nbsp;GB/T 22165</li>
											<li title="">生产许可证编号：&nbsp;QS4201 1801 0226</li>
											<li title="">储存方法：&nbsp;请放置于常温、阴凉、通风、干燥处保存 </li>
											<li title="">食用方法：&nbsp;开袋去壳即食</li>
										</ul>
										<div class="clear"></div>
									</div>
									<div class="clear"></div>
								</div>

								<div class="am-tab-panel am-fade">
									<div class="tb-r-filter-bar">
										<ul class=" tb-taglist am-avg-sm-4">
											<li class="tb-taglist-li tb-taglist-li-current">
												<div class="comment-info">
													<span>全部评价</span>
													<span class="tb-tbcr-num">${requestScope.commentNum}</span>
												</div>
											</li>
										</ul>
									</div>
									<div class="clear"></div>

									<ul class="am-comments-list am-comments-list-flip">
										<c:forEach items="${requestScope.commodity.comments}" var="comment">
										<li class="am-comment">
											<!-- 评论容器 -->
											<img class="am-comment-avatar" src="../customerFile/images/hwbn40x40.jpg" />
											<!-- 评论者头像 -->
											<div class="am-comment-main">
												<!-- 评论内容容器 -->
												<header class="am-comment-hd">
													<div class="am-comment-meta">
														<!-- 评论元数据 -->
														<a href="#link-to-user" class="am-comment-author">b***1 (匿名)</a>
														<!-- 评论者 -->
														评论于
														<time datetime="">2015年11月02日 17:46 ${comment.contentTime}</time>
													</div>
												</header>

												<div class="am-comment-bd">
													<div class="tb-rev-item " data-id="255776406962">
														<div class="J_TbcRate_ReviewContent tb-tbcr-content ">
															${comment.content}
														</div>
													</div>
												</div>
												<c:if test="${not empty comment.answer}">
												<div class="am-comment-hd">
													<div class="am-comment-meta" data-id="255776406962">
														<div class="tb-r-act-bar">
															卖家回复：${comment.answer}
														</div>
													</div>
												</div>
												</c:if>
												<!-- 评论内容 -->
											</div>
										</li>
										</c:forEach>
										
										
										
										
										
<!-- 										<li class="am-comment"> -->
<!-- 											评论容器 -->
<!-- 											<a href=""> -->
<!-- 												<img class="am-comment-avatar" src="../customerFile/images/hwbn40x40.jpg" /> -->
<!-- 												评论者头像 -->
<!-- 											</a> -->

<!-- 											<div class="am-comment-main"> -->
<!-- 												评论内容容器 -->
<!-- 												<header class="am-comment-hd"> -->
<!-- 													<h3 class="am-comment-title">评论标题</h3> -->
<!-- 													<div class="am-comment-meta"> -->
<!-- 														评论元数据 -->
<!-- 														<a href="#link-to-user" class="am-comment-author">l***4 (匿名)</a> -->
<!-- 														评论者 -->
<!-- 														评论于 -->
<!-- 														<time datetime="">2015年10月28日 11:33</time> -->
<!-- 													</div> -->
<!-- 												</header> -->

<!-- 												<div class="am-comment-bd"> -->
<!-- 													<div class="tb-rev-item " data-id="255095758792"> -->
<!-- 														<div class="J_TbcRate_ReviewContent tb-tbcr-content "> -->
<!-- 															没有色差，很暖和……美美的 -->
<!-- 														</div> -->
<!-- 														<div class="tb-r-act-bar"> -->
<!-- 															颜色分类：蓝调灰&nbsp;&nbsp;尺码：2XL -->
<!-- 														</div> -->
<!-- 													</div> -->

<!-- 												</div> -->
<!-- 												评论内容 -->
<!-- 											</div> -->
<!-- 										</li> -->
<!-- 										<li class="am-comment"> -->
<!-- 											评论容器 -->
<!-- 											<a href=""> -->
<!-- 												<img class="am-comment-avatar" src="../customerFile/images/hwbn40x40.jpg" /> -->
<!-- 												评论者头像 -->
<!-- 											</a> -->

<!-- 											<div class="am-comment-main"> -->
<!-- 												评论内容容器 -->
<!-- 												<header class="am-comment-hd"> -->
<!-- 													<h3 class="am-comment-title">评论标题</h3> -->
<!-- 													<div class="am-comment-meta"> -->
<!-- 														评论元数据 -->
<!-- 														<a href="#link-to-user" class="am-comment-author">h***n (匿名)</a> -->
<!-- 														评论者 -->
<!-- 														评论于 -->
<!-- 														<time datetime="">2015年11月25日 12:48</time> -->
<!-- 													</div> -->
<!-- 												</header> -->

<!-- 												<div class="am-comment-bd"> -->
<!-- 													<div class="tb-rev-item " data-id="258040417670"> -->
<!-- 														<div class="J_TbcRate_ReviewContent tb-tbcr-content "> -->
<!-- 															式样不错，初冬穿 -->
<!-- 														</div> -->
<!-- 														<div class="tb-r-act-bar"> -->
<!-- 															颜色分类：柠檬黄&nbsp;&nbsp;尺码：L -->
<!-- 														</div> -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 												评论内容 -->
<!-- 											</div> -->
<!-- 										</li> -->
									</ul>

									<div class="clear"></div>

									<!--分页 -->
									<ul class="am-pagination am-pagination-right">
										<li class="am-disabled"><a href="#">&laquo;</a></li>
										<li class="am-active"><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#">&raquo;</a></li>
									</ul>
									<div class="clear"></div>

									<div class="tb-reviewsft">
										<div class="tb-rate-alert type-attention">购买前请查看该商品的 <a href="#" target="_blank">购物保障</a>，明确您的售后保障权益。</div>
									</div>

								</div>

								<div class="am-tab-panel am-fade">
									<div class="like">
										<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
											<li>
												<div class="i-pic limit">
													<img src="../customerFile/images/imgsearch1.jpg" />
													<p>【良品铺子_开口松子】零食坚果特产炒货
														<span>东北红松子奶油味</span></p>
													<p class="price fl">
														<b>¥</b>
														<strong>298.00</strong>
													</p>
												</div>
											</li>
											<li>
												<div class="i-pic limit">
													<img src="../customerFile/images/imgsearch1.jpg" />
													<p>【良品铺子_开口松子】零食坚果特产炒货
														<span>东北红松子奶油味</span></p>
													<p class="price fl">
														<b>¥</b>
														<strong>298.00</strong>
													</p>
												</div>
											</li>
										</ul>
									</div>
									<div class="clear"></div>

									<!--分页 -->
									<ul class="am-pagination am-pagination-right">
										<li class="am-disabled"><a href="#">&laquo;</a></li>
										<li class="am-active"><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#">&raquo;</a></li>
									</ul>
									<div class="clear"></div>

								</div>

							</div>

						</div>

						<div class="clear"></div>

						<div id="footer" class="footer">
							
						</div>
					</div>

				</div>
			</div>
			
			<!--菜单 -->
			<div class=tip>
				<div id="sidebar">
					<div id="wrap">
						<div id="prof" class="item ">
							<a href="../tongwebinf?url=person/index"> <span class="setting "></span>
							</a>
							<div class="ibar_login_box status_login ">
								<div class="avatar_box ">
									<p class="avatar_imgbox ">
										<img src="../customerFile/images/no-img_mid_.jpg " />
									</p>
									<ul class="user_info ">
										<li>用户名sl1903</li>
										<li>级&nbsp;别普通会员</li>
									</ul>
								</div>
								<div class="login_btnbox ">
									<a href="../tongwebinf?url=person/order" class="login_order ">我的订单</a> <a
										href="../tongwebinf?url=person/collection" class="login_favorite ">我的收藏</a>
								</div>
								<i class="icon_arrow_white "></i>
							</div>
		
						</div>
						<div id="shopCart" class="item ">
							<a href="../tongwebinf?url=home/shopcart"> <span class="message "></span></a>
							<p>购物车</p>
							<a href="../tongwebinf?url=home/shopcart"><p class="cart_num ">0</p></a>
						</div>
						<div id="brand " class="item ">
							<a href="../tongwebinf?url=person/collection"> <span class="wdsc "><img
									src="../customerFile/images/wdsc.png " /></span>
							</a>
							<div class="mp_tooltip ">
								我的收藏 <i class="icon_arrow_right_black "></i>
							</div>
						</div>
						<div class="quick_toggle ">
							<li class="qtitem "><a href="# "><span class="kfzx "></span></a>
								<div class="mp_tooltip ">
									客服中心<i class="icon_arrow_right_black "></i>
								</div></li>
							<!--二维码 -->
							<li class="qtitem "><a href="#none "><span
									class="mpbtn_qrcode "></span></a>
								<div class="mp_qrcode " style="display: none;">
									<img src="../customerFile/images/weixin_code_145.png " /><i
										class="icon_arrow_white "></i>
								</div></li>
							<li class="qtitem "><a href="#top " class="return_top "><span
									class="top "></span></a></li>
						</div>
						<!--回到顶部 -->
						<div id="quick_links_pop " class="quick_links_pop hide "></div>
					</div>
				</div>
			</div>
			<script src="../customerFile/js/_header.js"></script>
			<script src="../customerFile/js/_footer.js"></script>
	</body>
</html>