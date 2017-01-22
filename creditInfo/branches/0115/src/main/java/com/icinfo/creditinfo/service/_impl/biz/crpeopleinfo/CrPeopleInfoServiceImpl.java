/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-22
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crpeopleinfo;

import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crpeopleinfo.CrEntInfo;
import com.icinfo.creditinfo.dao.biz.crpeopleinfo.CrPeopleInfoDao;
import com.icinfo.creditinfo.service.biz.crpeopleinfo.CrPeopleInfoService;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
/**
 * 
 * 描述: 个人关联信息Service 实现<br>
 * @author gaotong
 * @date 2015-10-22
 */
public class CrPeopleInfoServiceImpl extends HxBaseServiceImpl<CrEntInfo> implements CrPeopleInfoService
{
	/**
	 * 描述：获取值得关注的高风险企业（top10）数据
	 * 
	 * @author yulirong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Integer doGetCrEntTotal(Map<String, Object> qryMap)
			throws Exception {
		return doGetPeopleInfoDao().selectCrEntTotal(qryMap);
	}
	public CrPeopleInfoDao doGetPeopleInfoDao()
	{
		return (CrPeopleInfoDao)hxBaseDao;
	}

}
