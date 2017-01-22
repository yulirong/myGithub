/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-21
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.crpeopleinfo;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crpeopleinfo.CrEntInfo;
import com.icinfo.creditinfo.bean.biz.crristdetail.CrRistDetail;
import com.icinfo.creditinfo.dao.biz.crpeopleinfo.CrPeopleInfoDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 个人关联信息 Dao 实现<br>
 * @author gaotong
 * @date 2015-10-22
 */
public class CrPeopleInfoDaoImpl extends HxBaseDaoImpl<CrEntInfo> implements CrPeopleInfoDao
{
	/**
	 * 
	 * 描述: 个人关联企业数
	 * 
	 * @author gaotong
	 * @date 2015年11月17日
	 * @param qryMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Integer selectCrEntTotal(Map<String, Object> qryMap) throws Exception {
		return (Integer) getBaseSqlMapDao().queryForObject("ibatis-crpeopleinfo.selectCrEntTotal",
				qryMap);
	}
}