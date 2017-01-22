/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-30
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crcreditdms;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crcreditdms.CrCreditDms;
import com.icinfo.creditinfo.dao.biz.crcreditdms.CrCreditDmsDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crcreditdms.CrCreditDmsService;
/**
 * 
 * 描述: 信用维度 Service 实现<br>
 * @author gaotong
 * @date 2015-10-30
 */
public class CrCreditDmsServiceImpl extends HxBaseServiceImpl<CrCreditDms> implements CrCreditDmsService
{
	

	public CrCreditDmsDao doGetCrCreditDmsDao()
	{
		return (CrCreditDmsDao)hxBaseDao;
	}
/**
 * 
 * 描述: 根据行业获取平均分
 * @author  LiYaFeng
 * @date 2015年10月31日 
 * @param qryMap
 * @return
 * @throws Exception 
 */
	@Override
	public CrCreditDms  getAvgScoreListByTrade(Map<String, Object> qryMap) throws Exception {
		
		return doGetCrCreditDmsDao().selectAvgScoreListByTrade(qryMap);
	}
	
}
