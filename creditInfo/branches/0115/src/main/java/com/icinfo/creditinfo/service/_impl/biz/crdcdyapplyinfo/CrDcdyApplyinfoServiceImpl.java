/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-24
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crdcdyapplyinfo;

import com.icinfo.creditinfo.bean.biz.crdcdyapplyinfo.CrDcdyApplyinfo;
import com.icinfo.creditinfo.dao.biz.crdcdyapplyinfo.CrDcdyApplyinfoDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crdcdyapplyinfo.CrDcdyApplyinfoService;
/**
 * 
 * 描述: 动产抵押 Service 实现<br>
 * @author gaotong
 * @date 2015-10-24
 */
public class CrDcdyApplyinfoServiceImpl extends HxBaseServiceImpl<CrDcdyApplyinfo> implements CrDcdyApplyinfoService
{
	

	public CrDcdyApplyinfoDao doGetCrDcdyApplyinfoDao()
	{
		return (CrDcdyApplyinfoDao)hxBaseDao;
	}
}
