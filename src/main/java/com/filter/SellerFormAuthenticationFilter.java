package com.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 *@author : lgpeng
 *@datetime : Sep 12, 2018 8:36:39 AM
 *@descriptioin :  自定义 FormAuthenticationFilter ,登录成功后指定跳转的页面
 */
public class SellerFormAuthenticationFilter extends FormAuthenticationFilter{
	@Override
	public void setSuccessUrl(String successUrl) {
		System.out.println("the successUrl is " + successUrl);
		super.setSuccessUrl("/seller.jsp");
	}
}
