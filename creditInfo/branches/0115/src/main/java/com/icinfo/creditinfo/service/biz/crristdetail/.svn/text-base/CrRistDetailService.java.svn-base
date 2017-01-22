/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.service.biz.crristdetail;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.icinfo.creditinfo.bean.biz.crristdetail.CrRistDetail;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 风险指数明细 Service 接口<br>
 * 
 * @author gaotong
 * @date 2015-11-03
 */
public interface CrRistDetailService extends HxBaseService<CrRistDetail> {


	/**
	 * 
	 * 描述: 获得风险类型与数量
	 * 
	 * @author LiYaFeng
	 * @date 2015年11月4日
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrRistDetail> doGetCountAndNameList(Map<String, Object> qryMap) throws Exception;

	/**
	 * 
	 * 描述: 获得风险关注类预警对象
	 * 
	 * @author LiYaFeng
	 * @date 2015年11月4日
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrRistDetail> doGetExtendCrRistDetailList(Map<String, Object> qryMap) throws Exception;

	/**
	 * 
	 * 描述: 获得总数
	 * 
	 * @author LiYaFeng
	 * @date 2015年11月4日
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */

	public Integer doGetExtendCrRistDetailListTotal(Map<String, Object> qryMap) throws Exception;

	/**
	 * 描述：风险指数详细信息
	 * 
	 * @author zhuyong
	 * @date 2015-11-05
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrRistDetail> doGetRistIndexRecordList(Map<String, Object> qryMap) throws Exception;

	/**
	 * 描述：风险指数详细信息
	 * 
	 * @author zhuyong
	 * @date 2015-11-05
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Integer doGetRistIndexRecordTotal(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * 描述：获取风险类型
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrRistDetail> doGetRistTypeList(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * 描述：构建风险类型返回参数
	 * 
	 * @author zhuyong
	 * @date 2015-11-09
	 * @param ristList
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBuildRistTypeDataList(List<CrRistDetail> ristList) throws Exception;
}
