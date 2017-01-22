/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-21
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.hzqytzf;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.hzqytzf.HzQytzf;
import com.icinfo.creditinfo.dao.biz.hzqytzf.HzQytzfDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.hzqytzf.HzQytzfService;
/**
 * 
 * 描述: 企业投资方 Service 实现<br>
 * @author gaotong
 * @date 2015-10-21
 */
public class HzQytzfServiceImpl extends HxBaseServiceImpl<HzQytzf> implements HzQytzfService
{
	/**
	 * 描述：获取关系 网络所需关联数据
	 * 
	 * @author yulirong
	 * @date 2015-10-31
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<HzQytzf> doGetHzQytzfListForRelationalNet(Map<String, Object> qryMap)
			throws Exception {
		return doGetHzQytzfDao().doSelectHzQytzfListForRelationalNet(qryMap);
	}

	public HzQytzfDao doGetHzQytzfDao()
	{
		return (HzQytzfDao)hxBaseDao;
	}
	
	/** 
	 * 描述: 获取最大股东
	 * @auther gaotong
	 * @date 2015年11月2日 
	 * @param corpid
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<HzQytzf> doSelectHzQytzfListByCorpid(String corpid)  throws Exception {
		return doGetHzQytzfDao().doSelectHzQytzfListByCorpid(corpid);
	}
}
