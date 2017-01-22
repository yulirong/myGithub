/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-26
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crmortgagesewagedischargeright;

import com.icinfo.creditinfo.bean.biz.crmortgagesewagedischargeright.CrMortgageSewageDischargeRight;
import com.icinfo.creditinfo.dao.biz.crmortgagesewagedischargeright.CrMortgageSewageDischargeRightDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crmortgagesewagedischargeright.CrMortgageSewageDischargeRightService;
/**
 * 
 * 描述: 排污权抵押 Service 实现<br>
 * @author yulirong
 * @date 2015-10-26
 */
public class CrMortgageSewageDischargeRightServiceImpl extends HxBaseServiceImpl<CrMortgageSewageDischargeRight> implements CrMortgageSewageDischargeRightService
{
	

	public CrMortgageSewageDischargeRightDao doGetCrMortgageSewageDischargeRightDao()
	{
		return (CrMortgageSewageDischargeRightDao)hxBaseDao;
	}
}
