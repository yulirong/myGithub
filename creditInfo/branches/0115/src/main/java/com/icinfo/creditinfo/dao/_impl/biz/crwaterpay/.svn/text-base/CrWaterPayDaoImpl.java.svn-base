/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.crwaterpay;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crwaterpay.CrWaterPay;
import com.icinfo.creditinfo.dao.biz.crwaterpay.CrWaterPayDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 用水量信息统计表 Dao 实现<br>
 * @author myw
 * @date 2015-11-03
 */
public class CrWaterPayDaoImpl extends HxBaseDaoImpl<CrWaterPay> implements CrWaterPayDao
{

	/**
	 * 描述：获取用水量统计信息
	 * @author 马亚伟
	 * @date 2015-11-03
	 * @param qryMap
	 * @return List<CrElecPay>
	 * @throws Exception
	 */
	@Override
	public List<CrWaterPay> selectAnalyWaterPayList(Map<String, Object> qryMap)
			throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-crwaterpay.selectAnalyWaterPayList", qryMap);
	}
	

}