/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 缓存文件 <br/>
 * @author 胡义振
 * @date 2013-9-10
 * @version 1.0
 */
package com.icinfo.plugin.cache;

import java.io.Serializable;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

/**
 * 描述: Spring 的设置 Cache 拦截器<br>
 * @author 胡义振
 * @date 2013-9-10
 */
public class MethodCacheInterceptor implements MethodInterceptor,InitializingBean
{
	public static Logger logger = Logger.getLogger(MethodCacheInterceptor.class);
	
	private Cache cache;

	public MethodCacheInterceptor()
	{
		super();
	}

	/**
	 * 描述: 拦截方法，并查找该结果是否存在，如果存在就返回cache中的值， 否则，返回数据库查询结果，并将查询结果放入cache
	 * @auther 胡义振
	 * @date 2013-9-10 
	 * @param invocation
	 * @return
	 * @throws Throwable
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable
	{
		String targetName = invocation.getThis().getClass().getName();
		String methodName = invocation.getMethod().getName();
		Object[] arguments = invocation.getArguments();
		Object result;
		String cacheKey = getCacheKey(targetName, methodName, arguments);
		
		logger.info("\n cacheKey:"+cacheKey);
		
		Element element = cache.get(cacheKey);
		if (element == null)
		{
			result = invocation.proceed();
			element = new Element(cacheKey, (Serializable) result);
			cache.put(element);
			logger.info("设置缓存:"+cacheKey);
		}
		return element.getValue();
	}

	/**
	 * 描述: 获得cache key的方法，cache key是Cache中一个Element的唯一标识 cache key包括
	 * 包名+类名+方法名，如com.co.cache.service.UserServiceImpl.getAllUser
	 * @auther 胡义振
	 * @date 2013-9-10 
	 * @param targetName
	 * @param methodName
	 * @param arguments
	 * @return
	 */
	private String getCacheKey(String targetName, String methodName,Object[] arguments)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(targetName).append(".").append(methodName);
		if ((arguments != null) && (arguments.length != 0))
		{
			for (int i = 0; i < arguments.length; i++)
			{
				logger.info("\n arguments["+i+"]:"+arguments[i]); 
				sb.append(".").append(arguments[i]);
			}
		}
		return sb.toString();
	}

	/**
	 * 描述: 接口InitializingBean里的方法，在调用BeanPostProcessor的预先初始化方法后执行
	 * @auther 胡义振
	 * @date 2013-9-10 
	 * @throws Exception
	 */
	public void afterPropertiesSet() throws Exception
	{
		
	}

	public Cache getCache()
	{
		return cache;
	}

	public void setCache(Cache cache)
	{
		this.cache = cache;
	}

}
