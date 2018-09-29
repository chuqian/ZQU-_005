/**
 * 分类
 */
var dataAllCommodityK;
function initAllCommodity() {
	$.post("../customer_1/allCommodityURL.action", function(dataAllCommodity) {
		if (dataAllCommodity != null) {
//			console.log(dataAllCommodity);
			var oo = dataAllCommodity.length - 1;
			// console.log(oo);
			dataAllCommodity = dataAllCommodity.substring(20, oo);
			dataAllCommodityK = JSON.parse(dataAllCommodity);
//			 console.log(dataAllCommodityK);
			var str = '';
			var i, j;
			for (i = 0; i < dataAllCommodityK.length; i++) {
				str = str + '<div class=am-u-sm-7 id=am-u-sm-7div' + i + '>'
				+ '<form id=form'
				+ dataAllCommodityK[i].id
				+ ' action=../customer_1/introductionURL.action method=post>'
				+ '<div class=outer-con>'
				+ '<input type=hidden name=commodityId value='
				+ dataAllCommodityK[i].id
				+ ' />'
				+ '<input type=hidden name=PageURL value=home />'
				+ '<div class=title>'
				+ dataAllCommodityK[i].commodityName
				+ '</div>'
				+ '<div class=sub-title>￥'
				+ dataAllCommodityK[i].price
				+ '</div><i class=am-icon-shopping-basket id=am-icon-shopping-basketi' + i + '>'
				+ '</i></div>'
				+ '<a class=inToIntr'
				+ dataAllCommodityK[i].id
				+ ' href=javascript:document.getElementById(\'form'
				+ dataAllCommodityK[i].id
				+ '\').submit();><img src='
				+ dataAllCommodityK[i].imgSrc
				+ '></a>'
				+ '</form></div>';
			}
//			console.log(str);
			document.getElementById("floodFour").innerHTML = str;

			for (var i = 0; i < dataAllCommodityK.length; i++) {
				var obj = document.getElementById('am-u-sm-7div' + i);
				obj.className += ' am-u-md-4'; // 注意前面加空格，防止两个属性挨一起
				obj.className += ' text-two';
				var obj = document.getElementById('am-icon-shopping-basketi' + i);
				obj.className += ' am-icon-md';
				obj.className += ' seprate';
			}
		} else {
			alert("发生错误");
		}
	});
};
initAllCommodity();
