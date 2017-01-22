/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author mayawei
 * @date 2015-10-29
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.yccodeindustrytype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


import com.icinfo.creditinfo.bean.biz.yccodeindustrytype.YcCodeIndustryType;
import com.icinfo.creditinfo.dao.biz.yccodeindustrytype.YcCodeIndustryTypeDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.yccodeindustrytype.YcCodeIndustryTypeService;
/**
 * 
 * 描述: 行业类型 Service 实现<br>
 * @author mayawei
 * @date 2015-10-29
 */
public class YcCodeIndustryTypeServiceImpl extends HxBaseServiceImpl<YcCodeIndustryType> implements YcCodeIndustryTypeService
{
	/**
	 * 描述：获取三大产业的行业
	 * @author 马亚伟
	 * @date 2015-11-23
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<YcCodeIndustryType> doGetCodeIndustryTypeListJsonByMainIndustry(
			String mainIndustry) throws Exception {
		
		if(StringUtils.isBlank(mainIndustry))return null;
		//封装三大行业下的行业类型
		Map<String,String[]> mainIndustryMap = new HashMap<String, String[]>();
		String[] primaryArr = new String[]{"A"};//第一产业
		String[] secondArr = new String[]{"B","C","D","E"};//第二产业
		String[] thirdArr = new String[]{"F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};//第三产业
		mainIndustryMap.put("1", primaryArr);
		mainIndustryMap.put("2", secondArr);
		mainIndustryMap.put("3", thirdArr);
		
		Map<String,Object> qryMap = new HashMap<String,Object>();
		String[] typeArr = mainIndustryMap.get(mainIndustry);
		if(typeArr==null||typeArr.length==0)return null;
		qryMap.put("industryTypeArr",typeArr);
		return doGetYcCodeIndustryTypeDao().selectIndustryTypeByMainIndustry(qryMap);
	}

	public YcCodeIndustryTypeDao doGetYcCodeIndustryTypeDao()
	{
		return (YcCodeIndustryTypeDao)hxBaseDao;
	}
}
