/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gqf
 * @date 2015-10-14
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.hzqyhznr;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.hzqyhznr.Hzqyhznr;
import com.icinfo.creditinfo.dao.biz.hzqyhznr.HzqyhznrDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.hzqyhznr.HzqyhznrService;
/**
 * 
 * 描述: 异常名录 Service 实现<br>
 * @author gqf
 * @date 2015-10-14
 */
public class HzqyhznrServiceImpl extends HxBaseServiceImpl<Hzqyhznr> implements HzqyhznrService
{
	
	/** 
	 * 描述: TODO
	 * @auther gqf
	 * @date 2015年10月14日 
	 * @param qryMap
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<Hzqyhznr> doGetSubHzqyhznrList(Map<String,Object> qryMap) throws Exception {
		return doGetHzqyhznrDao().doGetSubSelectHzqyhznr(qryMap);
	}

	public HzqyhznrDao doGetHzqyhznrDao()
	{
		return (HzqyhznrDao)hxBaseDao;
	}
}
