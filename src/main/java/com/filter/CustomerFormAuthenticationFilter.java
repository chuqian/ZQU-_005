
package com.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 *@author : lgpeng
 *@datetime : Sep 12, 2018 4:42:43 PM
 *@descriptioin :  买家表单验证
 */
public class CustomerFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	public void setSuccessUrl(String successUrl) {
		super.setSuccessUrl("/customer.jsp");
	}
	
}
