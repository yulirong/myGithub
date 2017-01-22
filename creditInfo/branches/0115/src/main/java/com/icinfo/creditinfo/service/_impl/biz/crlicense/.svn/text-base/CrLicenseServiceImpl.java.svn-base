/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-22
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crlicense;

import java.util.List;

import com.icinfo.creditinfo.bean.biz.crlicense.CrLicense;
import com.icinfo.creditinfo.dao.biz.crlicense.CrLicenseDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crlicense.CrLicenseService;
/**
 * 
 * 描述: 许可信息 Service 实现<br>
 * @author yulirong
 * @date 2015-10-22
 */
public class CrLicenseServiceImpl extends HxBaseServiceImpl<CrLicense> implements CrLicenseService
{
	

	public CrLicenseDao doGetCrLicenseDao()
	{
		return (CrLicenseDao)hxBaseDao;
	}
    /**
     * 
     * 描述: 查询状态
     * @author  LiYaFeng
     * @date 2015年11月13日 
     * @return
     * @throws Exception
     */
	@Override
	public List<String> doGetStateList() throws Exception {
		return doGetCrLicenseDao().selectStateList();
	}
}
