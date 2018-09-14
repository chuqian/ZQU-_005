package com.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;


/**
 *@author : lgpeng
 *@datetime : Sep 13, 2018 8:44:42 AM
 *@descriptioin :  自定义 filter 规则，实现对不同角色登录成功后跳转到不同的页面
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		WebUtils.getAndClearSavedRequest(request);
		System.out.println("step into onLoginSuccess");
		WebUtils.redirectToSavedRequest(request, response, "/seller.jsp");
		return false;
	}
	
}
