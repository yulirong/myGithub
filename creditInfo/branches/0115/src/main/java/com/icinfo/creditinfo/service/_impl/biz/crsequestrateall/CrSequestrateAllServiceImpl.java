/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-26
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crsequestrateall;

import com.icinfo.creditinfo.bean.biz.crsequestrateall.CrSequestrateAll;
import com.icinfo.creditinfo.dao.biz.crsequestrateall.CrSequestrateAllDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crsequestrateall.CrSequestrateAllService;
/**
 * 
 * 描述: 土地房产查封信息 Service 实现<br>
 * @author gaotong
 * @date 2015-10-26
 */
public class CrSequestrateAllServiceImpl extends HxBaseServiceImpl<CrSequestrateAll> implements CrSequestrateAllService
{
	

	public CrSequestrateAllDao doGetCrSequestrateAllDao()
	{
		return (CrSequestrateAllDao)hxBaseDao;
	}
}
