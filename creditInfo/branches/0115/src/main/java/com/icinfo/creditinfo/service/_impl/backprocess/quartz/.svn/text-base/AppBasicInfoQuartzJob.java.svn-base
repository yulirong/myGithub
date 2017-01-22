package com.icinfo.creditinfo.service._impl.backprocess.quartz;

/**
 * Copyright© 2003-2014 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 数据服务平台定时任务
 * 
 * @author zhuyong
 * @date 2015-8-17
 * @version 1.0
 */

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.icinfo.creditinfo.lucence.common.PathUtil;
import com.icinfo.creditinfo.service.search.AppSearchService;


/** 
 * 描述: 上虞项目定时任务
 * 
 * @author zhuyong
 * @date 2015-12-17  
 */
public class AppBasicInfoQuartzJob{

	Logger logger = Logger.getLogger(AppBasicInfoQuartzJob.class);

	private AppSearchService appSearchService;
	
	/** 
	 * 描述: 索引增量定时任务
	 * 
	 * @author zhuyong
	 * @date 2015-12-17  
	 * @throws Exception 
	 */
	public void doIncrementForAppbasicInfo() throws Exception{
		logger.info("******基本信息 索引创建开始******");
		long time1 = System.currentTimeMillis();
		//创建索引开始
		String rootPath = PathUtil.getRealCreateIndexPath();
		try {
			if(StringUtils.isNotBlank(rootPath)){
				// 先删除当天所需索引文件夹的索引
				boolean bln = PathUtil.DeleteFolder(rootPath);
				// 创建新索引
				if (bln) {
					appSearchService.doCreateIndex(rootPath);
				}
			}
		} catch (Exception e) {
			PathUtil.DeleteFolder(rootPath);
			e.printStackTrace();
			logger.info("******基本信息 索引创建异常******");
		} 
		long time2 = System.currentTimeMillis();
		logger.info("基本信息 索引创建用时" + (time2 - time1) + "毫秒");
		logger.info("******基本信息 索引创建结束******");
	}

	
	
	
	public AppSearchService getAppSearchService() {
		return appSearchService;
	}

	public void setAppSearchService(AppSearchService appSearchService) {
		this.appSearchService = appSearchService;
	}
	

}
