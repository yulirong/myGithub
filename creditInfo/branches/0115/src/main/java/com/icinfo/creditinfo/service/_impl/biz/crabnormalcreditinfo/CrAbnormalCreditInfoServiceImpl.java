/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-15
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crabnormalcreditinfo;

import com.icinfo.creditinfo.bean.biz.crabnormalcreditinfo.CrAbnormalCreditInfo;
import com.icinfo.creditinfo.dao.biz.crabnormalcreditinfo.CrAbnormalCreditInfoDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crabnormalcreditinfo.CrAbnormalCreditInfoService;
/**
 * 
 * 描述: 异常信贷记录明细 Service 实现<br>
 * @author yulirong
 * @date 2015-10-15
 */
public class CrAbnormalCreditInfoServiceImpl extends HxBaseServiceImpl<CrAbnormalCreditInfo> implements CrAbnormalCreditInfoService
{
	

	public CrAbnormalCreditInfoDao doGetCrAbnormalCreditInfoDao()
	{
		return (CrAbnormalCreditInfoDao)hxBaseDao;
	}
}
