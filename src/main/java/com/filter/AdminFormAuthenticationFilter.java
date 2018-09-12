package com.filter;
/**
 *@author : lgpeng
 *@datetime : Sep 12, 2018 2:58:37 PM
 *@descriptioin :  设置管理员登录成功后的跳转页面
 */
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class AdminFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	public void setSuccessUrl(String successUrl) {
		
		super.setSuccessUrl("/admin/index.jsp");
	}

}
