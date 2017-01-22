/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.service.biz.crwaterpay;

import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.biz.crwaterpay.CrWaterPay;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 用水量信息统计表 Service 接口<br>
 * @author myw
 * @date 2015-11-03
 */
public interface CrWaterPayService extends HxBaseService<CrWaterPay>{

	/**
	 * 描述：获取用水量统计信息
	 * @author 马亚伟
	 * @date 2015-11-02
	 * @param qryMap
	 * @return JSONObject
	 * @throws Exception
	 */
	JSONObject doGetAnalyWaterPayList(Map<String, Object> qryMap) throws Exception;

}
