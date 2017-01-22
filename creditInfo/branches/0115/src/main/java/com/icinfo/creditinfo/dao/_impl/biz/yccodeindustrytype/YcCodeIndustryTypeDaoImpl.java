/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author mayawei
 * @date 2015-10-29
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.yccodeindustrytype;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.yccodeindustrytype.YcCodeIndustryType;
import com.icinfo.creditinfo.dao.biz.yccodeindustrytype.YcCodeIndustryTypeDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 行业类型 Dao 实现<br>
 * @author mayawei
 * @date 2015-10-29
 */
public class YcCodeIndustryTypeDaoImpl extends HxBaseDaoImpl<YcCodeIndustryType> implements YcCodeIndustryTypeDao
{

	/**
	 * 描述：获得三大产业下的行业
	 * @author 马亚伟
	 * @date 2015-11-23
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<YcCodeIndustryType> selectIndustryTypeByMainIndustry(
			Map<String, Object> qryMap) throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-yccodeindustrytype.selectIndustryTypeByMainIndustry", qryMap);
	}

	
}