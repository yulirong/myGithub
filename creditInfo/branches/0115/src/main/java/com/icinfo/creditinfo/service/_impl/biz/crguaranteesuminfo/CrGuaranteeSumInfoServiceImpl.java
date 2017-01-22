/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-16
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crguaranteesuminfo;

import com.icinfo.creditinfo.bean.biz.crguaranteesuminfo.CrGuaranteeSumInfo;
import com.icinfo.creditinfo.dao.biz.crguaranteesuminfo.CrGuaranteeSumInfoDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crguaranteesuminfo.CrGuaranteeSumInfoService;
/**
 * 
 * 描述: 保函汇总 Service 实现<br>
 * @author gaotong
 * @date 2015-10-16
 */
public class CrGuaranteeSumInfoServiceImpl extends HxBaseServiceImpl<CrGuaranteeSumInfo> implements CrGuaranteeSumInfoService
{
	

	public CrGuaranteeSumInfoDao doGetCrGuaranteeSumInfoDao()
	{
		return (CrGuaranteeSumInfoDao)hxBaseDao;
	}
}
