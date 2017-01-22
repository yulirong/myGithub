/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.service.biz.crwatersewagedischargepay;

import java.util.Map;

import net.sf.json.JSONArray;

import com.icinfo.creditinfo.bean.biz.crwatersewagedischargepay.CrWaterSewageDischargePay;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 污水排放信息表 Service 接口<br>
 * @author myw
 * @date 2015-11-03
 */
public interface CrWaterSewageDischargePayService extends HxBaseService<CrWaterSewageDischargePay>{

	/**
	 * 描述：获取排污水量统计信息
	 * @author 马亚伟
	 * @date 2015-11-03
	 * @param qryMap
	 * @return JSONArray
	 * @throws Exception
	 */
	JSONArray doGetAnalyWaterSewageDischargePayList(Map<String, Object> qryMap) throws Exception;

}
