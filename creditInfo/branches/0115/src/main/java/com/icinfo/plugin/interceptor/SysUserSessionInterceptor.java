package com.icinfo.plugin.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.icinfo.plugin.common.HxConstants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SysUserSessionInterceptor  extends AbstractInterceptor {

	private static final long serialVersionUID = -4228268663291078367L;

	/** 
	 * 描述: 系统用户interceptor
	 * @auther gqf
	 * @date 2015年4月15日 
	 * @param invocation
	 * @return
	 * @throws Exception 
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//1.判断SESSION是否过期
		if (!ServletActionContext.getRequest().isRequestedSessionIdValid()) {
			return Action.LOGIN;
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		//2.判断是否登录成功
		if(session==null){
			return Action.LOGIN;
		}else{
			if(session.getAttribute(HxConstants.SESSION_USER)==null){
				return Action.LOGIN;
			}
		}
		return invocation.invoke();
	}

}
