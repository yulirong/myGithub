/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-07
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.analy.cranalypubres;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalypubres.CrAnalyPubRes;
import com.icinfo.creditinfo.dao.analy.cranalypubres.CrAnalyPubResDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 公共资源统计表 Dao 实现<br>
 * @author myw
 * @date 2015-11-07
 */
public class CrAnalyPubResDaoImpl extends HxBaseDaoImpl<CrAnalyPubRes> implements CrAnalyPubResDao
{
	/**
	 * 描述：插叙公共信息统计数据
	 * @author 马亚伟
	 * @date 2015-11-07
	 * @param qryMap
	 * @return
	 */
	@Override
	public List<CrAnalyPubRes> selectAnalyPubResByType(Map<String, Object> qryMap)
			throws Exception {
		
		return getBaseSqlMapDao().queryForList("ibatis-cranalypubres.selectAnalyPubResByType", qryMap);
	}

	/**
	 * 描述：查询公共资源、区域、时间的统计信息
	 * @author 马亚伟
	 * @date 2015-11-09
	 * @param qryMap
	 * @return
	 */
	@Override
	public List<CrAnalyPubRes> selectZonePubResByType(Map<String, Object> qryMap) {
		return getBaseSqlMapDao().queryForList("ibatis-cranalypubres.selectAnalyPubResZoneByType", qryMap);
	}

	
}