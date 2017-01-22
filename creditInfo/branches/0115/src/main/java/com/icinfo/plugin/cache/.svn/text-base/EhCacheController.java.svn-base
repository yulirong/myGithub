/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 系统文件 <br/>
 * @author 胡义振
 * @date 2013-7-26
 * @version 1.0
 */
package com.icinfo.plugin.cache;

import java.net.URL;
import java.util.Properties;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import com.ibatis.sqlmap.engine.cache.CacheController;
import com.ibatis.sqlmap.engine.cache.CacheModel;

/** 
 * 描述: ehcach 缓存类<br>
 * @author 胡义振
 * @date 2013-7-26  
 */
public class EhCacheController implements CacheController 
{
	private CacheManager cacheManager;
	
	/** 
	 * 描述: TODO
	 * @auther 胡义振
	 * @date 2013-7-26 
	 * @param cacheModel 
	 */
	@Override
	public void flush(CacheModel cacheModel)
	{
		getCache(cacheModel).removeAll();
	}

	/** 
	 * 描述: 获取缓存
	 * @auther 胡义振
	 * @date 2013-7-26 
	 * @param cacheModel
	 * @param key
	 * @return 
	 */
	@Override
	public Object getObject(CacheModel cacheModel, Object key)
	{
		Object result = null;
		Element element = getCache(cacheModel).get(key);
		if (element != null) {
			result = element.getObjectValue();
		}
		return result;
	}

	/** 
	 * 描述: 删除缓存
	 * @auther 胡义振
	 * @date 2013-7-26 
	 * @param cacheModel
	 * @param key
	 * @return 
	 */
	@Override
	public Object removeObject(CacheModel cacheModel, Object key)
	{
		Object result = this.getObject(cacheModel, key);
		getCache(cacheModel).remove(key);
		return result;
	}

	/** 
	 * 描述: 设置缓存
	 * @auther 胡义振
	 * @date 2013-7-26 
	 * @param cacheModel
	 * @param key
	 * @param object 
	 */
	@Override
	public void putObject(CacheModel cacheModel, Object key, Object object)
	{
		getCache(cacheModel).put(new Element(key, object));
		
	}

	/** 
	 * 描述: 设置 ehcache 配置属性
	 * @auther 胡义振
	 * @date 2013-7-26 
	 * @param props 
	 */
	@Override
	public void setProperties(Properties props)
	{
	    URL url = getClass().getResource(props.getProperty("configFile"));
	    cacheManager = CacheManager.create(url);
	}
	
    /**
     * 描述: 获取缓存值
     * @auther 胡义振
     * @date 2013-7-26 
     * @param cacheModel
     * @return
     */
	private Cache getCache(CacheModel cacheModel) {
		String cacheName = cacheModel.getId();
		
		System.out.println("\n\n cacheName:"+cacheName);
		
		Cache cache = cacheManager.getCache(cacheName);
		return cache;
	}

	/**
	 * 
	 * 描述: TODO
	 * @auther 胡义振
	 * @date 2013-7-26
	 */
	public void finalize() {
		if (cacheManager != null) {
			cacheManager.shutdown();
		}
	}
	
	

}
