/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 系统文件 <br/>
 * @author 胡义振
 * @date 2013-5-22
 * @version 1.0
 */
package com.icinfo.plugin.interceptor;


import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;



import com.icinfo.plugin.common.HxConstants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/** 
 * 描述: 用户拦截器<br>
 * @author 胡义振
 * @date 2013-5-22 
 */
public class GenUserInterceptor extends AbstractInterceptor
{
	private static final long	serialVersionUID	= -4019470285491655812L;

	/** 
	 * 描述: 实现抽象类的拦截器调用方法<br>
	 * @param invocation 
	 * @author 胡义振
	 * @date 2013-5-22 
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session==null){
			return Action.LOGIN;
		}
		else
		{
			if(session.getAttribute(HxConstants.SESSION_USER)==null){
				return Action.LOGIN;
			}
		}
		return invocation.invoke();
	}

}
