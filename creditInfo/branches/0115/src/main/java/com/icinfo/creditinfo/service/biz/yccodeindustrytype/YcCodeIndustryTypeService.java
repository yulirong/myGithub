/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author mayawei
 * @date 2015-10-29
 * @version 1.0
 */
package com.icinfo.creditinfo.service.biz.yccodeindustrytype;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.icinfo.creditinfo.bean.biz.yccodeindustrytype.YcCodeIndustryType;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 行业类型 Service 接口<br>
 * @author mayawei
 * @date 2015-10-29
 */
public interface YcCodeIndustryTypeService extends HxBaseService<YcCodeIndustryType>{

	/**
	 * 描述：获取三大产业的行业
	 * @author 马亚伟
	 * @date 2015-11-23
	 * @param mainIndustry
	 * @return
	 * @throws Exception
	 */
	List<YcCodeIndustryType> doGetCodeIndustryTypeListJsonByMainIndustry(
			String mainIndustry) throws Exception;

}
