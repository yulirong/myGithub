/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-23
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.crarrearinfo;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crarrearinfo.CrArrearInfo;
import com.icinfo.creditinfo.dao.biz.crarrearinfo.CrArrearInfoDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 逾期和欠费信息 Dao 实现<br>
 * @author yulirong
 * @date 2015-10-23
 */
public class CrArrearInfoDaoImpl extends HxBaseDaoImpl<CrArrearInfo> implements CrArrearInfoDao
{
	/**
	 * 描述: 获取水电气税欠费详情
	 * 
	 * @author ylr
	 * @date 2015-12-7
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CrArrearInfo> doGetAllArrearList(Map<String,Object> qryMap) throws Exception{
		return getBaseSqlMapDao().queryForList("ibatis-crarrearinfo.selectAllArrearList",qryMap);
	}

}