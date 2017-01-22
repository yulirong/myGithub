/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author mayawei
 * @date 2015-10-26
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crleprep;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crleprep.CrLepRep;
import com.icinfo.creditinfo.dao.biz.crleprep.CrLepRepDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crleprep.CrLepRepService;
/**
 * 
 * 描述: 企业法人代表 Service 实现<br>
 * @author mayawei
 * @date 2015-10-26
 */
public class CrLepRepServiceImpl extends HxBaseServiceImpl<CrLepRep> implements CrLepRepService
{
	
	/**
	 * 描述：法人查询
	 * @author 马亚伟 
	 * @date 2015-10-26
	 * @param qryMap
	 * @return
	 */
	@Override
	public List<CrLepRep> doGetCrLepRepSearchList(Map<String, Object> qryMap) throws Exception {
		return doGetCrLepRepDao().selectCrLepRepSearchList(qryMap);
	}
	
	/**
	 * 描述：法人查询
	 * @author 马亚伟 
	 * @date 2015-10-26
	 * @param qryMap
	 * @return
	 */
	@Override
	public Integer doGetCrLepRepSearchTotal(Map<String, Object> qryMap) throws Exception{
		return doGetCrLepRepDao().selectCrLepRepSearchTotal(qryMap);
	}


	public CrLepRepDao doGetCrLepRepDao()
	{
		return (CrLepRepDao)hxBaseDao;
	}

}
