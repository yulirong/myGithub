/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-30
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.biz.crrelationnetall;

import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crrelationnetall.CrRelationNetAll;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 关系网络汇总信息 Dao 接口<br>
 * @author zhuyong
 * @date 2015-11-30
 */
public interface CrRelationNetAllDao extends HxBaseDao<CrRelationNetAll>
{

	/**
	 * 描述：获取关系概要数据
	 * 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public CrRelationNetAll doSelectRelationSummaryData(Map<String,Object> qryMap) throws Exception;
}