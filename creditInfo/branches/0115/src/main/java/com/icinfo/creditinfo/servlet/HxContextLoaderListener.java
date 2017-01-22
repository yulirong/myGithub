/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 系统测试文件 <br/>
 * @author 胡义振
 * @date 2013-6-25
 * @version 1.0
 */
package com.icinfo.creditinfo.servlet;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

/**
 * 描述: 扩展Spring监听器<br>
 * 
 * @author 胡义振
 * @date 2013-6-25
 */
public class HxContextLoaderListener extends ContextLoaderListener
{
	// 该方法是创建webApplictionContext的回调方法
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected WebApplicationContext createWebApplicationContext(
			ServletContext servletContext, ApplicationContext parent) throws BeansException 
	{
	    Class contextClass = determineContextClass(servletContext);
	    ConfigurableWebApplicationContext wac = (ConfigurableWebApplicationContext) BeanUtils.instantiateClass(contextClass);
	    wac.setParent(parent);
	    wac.setServletContext(servletContext);
	    wac.setConfigLocation(servletContext.getInitParameter(CONFIG_LOCATION_PARAM));
	    List<String> allResources = new ArrayList<String>();
	    allResources.add(servletContext.getInitParameter(CONFIG_LOCATION_PARAM));
	    try{
		   PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();  
		   Resource[] resources = patternResolver.getResources("com/icinfo/plugin/hxpermission/xml/spring-*.xml");  
		   for(Resource res:resources){
			   allResources.add(res.getURI().toString());
			   System.out.println("res.getURI():"+res.getURI());
		   }
		   wac.setConfigLocations(allResources.toArray(new String[allResources.size()]));
	    }
	    catch(Exception er){
		   System.out.println("扩充 spring 配置文件出现异常");
	    }
	    customizeContext(servletContext, wac);
	    wac.refresh();
	    return wac;
	}
}
