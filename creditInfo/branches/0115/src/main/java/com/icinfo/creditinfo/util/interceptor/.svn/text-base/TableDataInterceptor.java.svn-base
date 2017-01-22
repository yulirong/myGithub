package com.icinfo.creditinfo.util.interceptor;

import java.util.List;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.InitializingBean;
import com.icinfo.creditinfo.bean.sys.crusertable.CrUserTable;
import com.icinfo.creditinfo.bean.sys.sysuser.SysUser;
import com.icinfo.plugin.common.HxConstants;

public class TableDataInterceptor implements MethodInterceptor,InitializingBean{
	
	public TableDataInterceptor(){
		super();
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

	/** 
	 * 描述: 数据权限拦截
	 * @auther gqf
	 * @date 2015年10月27日 
	 * @param invocation
	 * @return
	 * @throws Throwable 
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		 //String classMethod = invocation.getThis().getClass().getSimpleName()+"."+invocation.getMethod().getName();
	     SysUser sysUser = (SysUser)ServletActionContext.getRequest().getSession().getAttribute(HxConstants.SESSION_USER);
	     String reqestUrl = ServletActionContext.getRequest().getRequestURI();
	     List<CrUserTable> 	crUserTableList = sysUser.getCrUserTableList(); 
	     for(CrUserTable userTable:crUserTableList){
	    	 if(reqestUrl.equals(userTable.getTabItem())){
	    		 Object result= invocation.proceed();
	    		 return result;
	    	 }
	     }
		return null;
	}

}
