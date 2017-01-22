/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-30
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.crrelationnetall;

import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crrelationnetall.CrRelationNetAll;
import com.icinfo.creditinfo.dao.biz.crrelationnetall.CrRelationNetAllDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 关系网络汇总信息 Dao 实现<br>
 * @author zhuyong
 * @date 2015-11-30
 */
public class CrRelationNetAllDaoImpl extends HxBaseDaoImpl<CrRelationNetAll> implements CrRelationNetAllDao
{
	/**
	 * 描述：获取关系概要数据
	 * 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public CrRelationNetAll doSelectRelationSummaryData(Map<String,Object> qryMap) throws Exception{
		return (CrRelationNetAll)getBaseSqlMapDao().queryForObject("ibatis-crrelationnetall.selectRelationSummary",qryMap);
	}
}