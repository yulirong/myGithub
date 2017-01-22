/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.crelecpay;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crelecpay.CrElecPay;
import com.icinfo.creditinfo.dao.biz.crelecpay.CrElecPayDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 用电量信息表 Dao 实现<br>
 * @author myw
 * @date 2015-11-03
 */
public class CrElecPayDaoImpl extends HxBaseDaoImpl<CrElecPay> implements CrElecPayDao
{

	/**
	 * 描述：获取用电量统计信息
	 * @author 马亚伟
	 * @date 2015-11-02
	 * @param qryMap
	 * @return List<CrElecPay>
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CrElecPay> selectAnalyElecPayList(Map<String, Object> qryMap)
			throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-crelecpay.selectAnalyElecPayList", qryMap);
	}

	/** 
	 * 描述:经信委接口
	 * @auther gqf
	 * @date 2015年12月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CrElecPay> selectCrElecPayListByJxwService(
			Map<String, Object> qryMap) throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-crelecpay.selectCrElecPayByJxwService", qryMap);
	}

	/** 
	 * 描述: TODO
	 * @auther gqf
	 * @date 2015年12月30日 
	 * @param qryMap
	 * @return
	 * @throws Exception 
	 */
	@Override
	public Integer selectCrElecPayListByJxwServiceTotal(
			Map<String, Object> qryMap) throws Exception {
		return (Integer)getBaseSqlMapDao().queryForObject("ibatis-crelecpay.selectCrElecPayByJxwServiceTotal", qryMap);
	}

	

}