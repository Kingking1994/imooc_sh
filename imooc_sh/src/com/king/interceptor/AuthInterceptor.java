package com.king.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
			
		if("".equals(session.get("loginUserName")) || session.get("loginUserName") == null){
			return "login";
		}else{
			String result = invocation.invoke();
			return result;
		}
	}

}
