/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-05
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.analy.cranalytrade;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalytrade.CrAnalyTrade;
import com.icinfo.creditinfo.dao.analy.cranalytrade.CrAnalyTradeDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.analy.cranalytrade.CrAnalyTradeService;
/**
 * 
 * 描述: 企业数量就业人数 Service 实现<br>
 * @author yulirong
 * @date 2015-11-05
 */
public class CrAnalyTradeServiceImpl extends HxBaseServiceImpl<CrAnalyTrade> implements CrAnalyTradeService
{
	/**
	 * 描述: 获取企业数量信息
	 * @auther yulirong
	 * @date 2015-11-05
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyTrade> doGetCrEntNumList(Map<String, Object> qryMap) throws Exception{
		return doGetCrAnalyTradeDao().doGetCrEntNumList(qryMap);
	}
	/**
	 * 描述: 获取就业人数信息
	 * @auther yulirong
	 * @date 2015-11-05
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyTrade> doGetCrEmpNumList(Map<String, Object> qryMap) throws Exception{
		return doGetCrAnalyTradeDao().doGetCrEmpNumList(qryMap);
	}
	
	public CrAnalyTradeDao doGetCrAnalyTradeDao()
	{
		return (CrAnalyTradeDao)hxBaseDao;
	}
}
