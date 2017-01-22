/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-26
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crequityall;

import com.icinfo.creditinfo.bean.biz.crequityall.CrEquityAll;
import com.icinfo.creditinfo.dao.biz.crequityall.CrEquityAllDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crequityall.CrEquityAllService;
/**
 * 
 * 描述: 出质信息 Service 实现<br>
 * @author gaotong
 * @date 2015-10-26
 */
public class CrEquityAllServiceImpl extends HxBaseServiceImpl<CrEquityAll> implements CrEquityAllService
{
	

	public CrEquityAllDao doGetCrEquityAllDao()
	{
		return (CrEquityAllDao)hxBaseDao;
	}
}
