/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-16
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crtradesuminfo;

import com.icinfo.creditinfo.bean.biz.crtradesuminfo.CrTradeSumInfo;
import com.icinfo.creditinfo.dao.biz.crtradesuminfo.CrTradeSumInfoDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crtradesuminfo.CrTradeSumInfoService;
/**
 * 
 * 描述: 贸易融资汇总 Service 实现<br>
 * @author gaotong
 * @date 2015-10-16
 */
public class CrTradeSumInfoServiceImpl extends HxBaseServiceImpl<CrTradeSumInfo> implements CrTradeSumInfoService
{
	

	public CrTradeSumInfoDao doGetCrTradeSumInfoDao()
	{
		return (CrTradeSumInfoDao)hxBaseDao;
	}
}
