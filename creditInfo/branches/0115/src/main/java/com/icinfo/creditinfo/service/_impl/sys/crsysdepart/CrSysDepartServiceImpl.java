/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-10
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.sys.crsysdepart;

import com.icinfo.creditinfo.bean.sys.crsysdepart.CrSysDepart;
import com.icinfo.creditinfo.dao.sys.crsysdepart.CrSysDepartDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.sys.crsysdepart.CrSysDepartService;
/**
 * 
 * 描述: 部门管理 Service 实现<br>
 * @author zhuyong
 * @date 2015-10-10
 */
public class CrSysDepartServiceImpl extends HxBaseServiceImpl<CrSysDepart> implements CrSysDepartService
{
	

	public CrSysDepartDao doGetCrSysDepartDao()
	{
		return (CrSysDepartDao)hxBaseDao;
	}
}
