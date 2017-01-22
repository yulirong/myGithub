/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述:  <br/>
 * @author 夏俊伟
 * @date Apr 2, 2015
 * @version 1.0
 */
package com.icinfo.plugin.interceptor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;

/** 
 * 描述: JSTL结果拦截处理<br>
 * @author 夏俊伟
 * @date Apr 2, 2015
 */
public class JstlResultInterceptor extends AbstractInterceptor {

	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 107180619961328415L;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		invocation.addPreResultListener(new PropertyExporter());
		return invocation.invoke();
	}
	public static class PropertyExporter implements PreResultListener {
		private static final List ignore = Arrays.asList(new String[] {
				"class", "texts" });

		public void beforeResult(ActionInvocation invocation, String resultCode) {
			Object action = invocation.getAction();
			if (!(action instanceof JstlSupport)) {
				return;
			}
			JstlSupport jstlAction = (JstlSupport) action;
			Map<String, Object> resultMap = jstlAction.getJstlResults();
			HttpServletRequest request = getRequest(invocation);
			for (Map.Entry e : resultMap.entrySet()) {
				if (ignore.contains(e.getKey()))
					continue;
				request.setAttribute((String) e.getKey(), e.getValue());
			}
			jstlAction.removeJstlResults();
		}

		public HttpServletRequest getRequest(ActionInvocation invocation) {
			return (HttpServletRequest) invocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		}
	}

}
