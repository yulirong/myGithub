/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.crgaspay;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crgaspay.CrGasPay;
import com.icinfo.creditinfo.dao.biz.crgaspay.CrGasPayDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 用气量信息表 Dao 实现<br>
 * @author myw
 * @date 2015-11-03
 */
public class CrGasPayDaoImpl extends HxBaseDaoImpl<CrGasPay> implements CrGasPayDao
{
	/**
	 * 描述：获取用气量统计信息
	 * @author 马亚伟
	 * @date 2015-11-02
	 * @param qryMap
	 * @return List<CrGasPay>
	 * @throws Exception
	 */
	@Override
	public List<CrGasPay> selectAnalyGasPayList(Map<String, Object> qryMap)
			throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-crgaspay.selectAnalyGasPayList", qryMap);
	}

}