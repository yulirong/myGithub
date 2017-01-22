/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.service.biz.crgaspay;

import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.biz.crgaspay.CrGasPay;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 用气量信息表 Service 接口<br>
 * @author myw
 * @date 2015-11-03
 */
public interface CrGasPayService extends HxBaseService<CrGasPay>{

	/**
	 * 描述：获取用气量统计信息
	 * @author 马亚伟
	 * @date 2015-11-02
	 * @param qryMap
	 * @return JSONObject
	 * @throws Exception
	 */
	JSONObject doGetAnalyGasPayList(Map<String, Object> qryMap) throws Exception;

}
