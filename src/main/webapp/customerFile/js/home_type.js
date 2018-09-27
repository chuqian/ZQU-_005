/**
 * 分类
 */
var dataTypeK;
function initType() {
	$.post("../customer_1/typeURL.action", function(dataType) {
		if (dataType != null) {
			var oo = dataType.length - 1;
			// console.log(oo);
			dataType = dataType.substring(12, oo);
			dataTypeK = JSON.parse(dataType);
			// console.log(dataTypeK);
			var str = '';
			var i, j;
			for (i = 0; i < dataTypeK.length; i++) {
				str = str + '<li class=appliance id=applianceli' + i + '>'
						+ '<div class=category-info>'
						+ '<h3 class=category-name id=category-nameh3' + i
						+ '>'
						+ '<i><img src=../customerFile/images/cake.png></i>'
						+ '<a class=ml-22 title=' + dataTypeK[i].sellType + '>'
						+ dataTypeK[i].sellType
						+ '</a></h3><em>&gt;</em></div>'
						+ '<div class=menu-item id=menu-itemdiv' + i + '>'
						+ '<div class=area-in>' + '<div class=area-bg>'
						+ '<div class=menu-srot>' + '<div class=sort-side>'
						+ '<dl class=dl-sort>' + '<dt><span title='
						+ dataTypeK[i].sellType + '>' + dataTypeK[i].sellType
						+ '</span></dt>';

				for (j = 0; j < dataTypeK[i].commodityTypes.length; j++) {
					str = str + '<dd><a title='
							+ dataTypeK[i].commodityTypes[j]
							+ ' href=introduction.jsp><span>'
							+ dataTypeK[i].commodityTypes[j]
							+ '</span></a></dd>';
				}
				str = str + '</dl></div></div></div></div>'
						+ '</div> <b class=arrow></b></li>';
			}
//			console.log(str);
			document.getElementById("js_climit_li").innerHTML = str;

			for (var i = 0; i < dataTypeK.length; i++) {
				var obj = document.getElementById('applianceli' + i);
				obj.className += ' js_toggle'; // 注意前面加空格，防止两个属性挨一起
				obj.className += ' relative';
				if (i == 0)
					obj.className += ' first';
				var obj = document.getElementById('category-nameh3' + i);
				obj.className += ' b-category-name';
				var obj = document.getElementById('menu-itemdiv' + i);
				obj.className += ' menu-in';
				obj.className += ' top';
			}
		} else {
			alert("发生错误");
		}
	});
};
initType();
