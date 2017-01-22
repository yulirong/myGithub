/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-30
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.crcreditdms;

import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crcreditdms.CrCreditDms;
import com.icinfo.creditinfo.dao.biz.crcreditdms.CrCreditDmsDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 信用维度 Dao 实现<br>
 * 
 * @author gaotong
 * @date 2015-10-30
 */
public class CrCreditDmsDaoImpl extends HxBaseDaoImpl<CrCreditDms> implements CrCreditDmsDao {
	/**
	 * 
	 * 描述: 获得平均分
	 * 
	 * @author LiYaFeng
	 * @date 2015年10月31日
	 * @param qryMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public CrCreditDms selectAvgScoreListByTrade(Map<String, Object> qryMap) throws Exception {

		return (CrCreditDms) getBaseSqlMapDao().queryForObject("ibatis-crcreditdms.selectAvgScoreListByTrade", qryMap);

	}
}
