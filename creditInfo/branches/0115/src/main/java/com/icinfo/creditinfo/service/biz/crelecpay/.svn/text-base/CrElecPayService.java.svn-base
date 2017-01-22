/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.service.biz.crelecpay;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.biz.crelecpay.CrElecPay;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 用电量信息表 Service 接口<br>
 * @author myw
 * @date 2015-11-03
 */
public interface CrElecPayService extends HxBaseService<CrElecPay>{

	/**
	 * 描述：获取用电量统计信息
	 * @author 马亚伟
	 * @date 2015-11-02
	 * @param qryMap
	 * @return JSONObject
	 * @throws Exception
	 */
	JSONObject doGetAnalyElecPayList(Map<String, Object> qryMap) throws Exception;
	
	/** 
	 * 描述: TODO
	 * @auther gqf
	 * @date 2015年12月24日 
	 * @return
	 * @throws Exception 
	 */
	
	public List<CrElecPay> doGetCrElecPayList(Map<String, Object> qryMap) throws Exception;
	
	/** 
	 * 描述: 经信委service
	 * @auther gqf
	 * @date 2015年12月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception 
	 */
	public List<CrElecPay> doGetServiceCrElecPayList(Map<String, Object> qryMap) throws Exception;
	
	/** 
	 * 描述: TODO
	 * @auther gqf
	 * @date 2015年12月30日 
	 * @param qryMap
	 * @return
	 * @throws Exception 
	 */
	
	public Integer doGetServiceCrElecPayTotal(Map<String, Object> qryMap) throws Exception;

}
