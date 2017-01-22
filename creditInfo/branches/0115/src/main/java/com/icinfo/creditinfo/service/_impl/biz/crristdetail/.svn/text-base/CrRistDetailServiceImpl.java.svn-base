/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crristdetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.biz.crristdetail.CrRistDetail;
import com.icinfo.creditinfo.dao.biz.crristdetail.CrRistDetailDao;
import com.icinfo.creditinfo.service.biz.crristdetail.CrRistDetailService;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;

/**
 * 
 * 描述: 风险指数明细 Service 实现<br>
 * 
 * @author gaotong
 * @date 2015-11-03
 */
public class CrRistDetailServiceImpl extends HxBaseServiceImpl<CrRistDetail> implements CrRistDetailService {

	public CrRistDetailDao doGetCrRistDetailDao() {
		return (CrRistDetailDao) hxBaseDao;
	}
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
	@Override
	public List<CrRistDetail> doGetCountAndNameList(Map<String, Object> qryMap) throws Exception {
		return doGetCrRistDetailDao().selectCountAndNameList(qryMap);
	}

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
	@Override
	public List<CrRistDetail> doGetExtendCrRistDetailList(Map<String, Object> qryMap) throws Exception {
		return doGetCrRistDetailDao().selectExtendCrRistDetailList(qryMap);

	}

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
	@Override
	public Integer doGetExtendCrRistDetailListTotal(Map<String, Object> qryMap) throws Exception {
		return doGetCrRistDetailDao().selectExtendCrRistDetailListTotal(qryMap);
	}

	/**
	 * 描述：风险指数详细信息
	 * 
	 * @author zhuyong
	 * @date 2015-11-05
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrRistDetail> doGetRistIndexRecordList(Map<String, Object> qryMap) throws Exception {
		return doGetCrRistDetailDao().doGetRistIndexRecordList(qryMap);
	}
	
	/**
	 * 描述：风险指数详细信息
	 * 
	 * @author zhuyong
	 * @date 2015-11-05
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Integer doGetRistIndexRecordTotal(Map<String,Object> qryMap) throws Exception{
		return doGetCrRistDetailDao().doGetRistIndexRecordTotal(qryMap);
	}
	
	/**
	 * 描述：获取风险类型
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrRistDetail> doGetRistTypeList(Map<String,Object> qryMap) throws Exception{
		return doGetCrRistDetailDao().doGetRistTypeList(qryMap);
	}
	
	/**
	 * 描述：构建风险类型返回参数
	 * 
	 * @author zhuyong
	 * @date 2015-11-09
	 * @param ristList
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBuildRistTypeDataList(List<CrRistDetail> ristList) throws Exception{
		Map<String,Object> rstMap = new HashMap<String, Object>();
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();
		List<String> legendList = new ArrayList<String>();
		for (CrRistDetail rist : ristList) {
			legendList.add(rist.getName());
			obj.put("name",rist.getName());
			obj.put("value", rist.getCount());
			arr.add(obj);
			obj = new JSONObject();
		}
		rstMap.put("legendList",JSONArray.fromObject(legendList));
		rstMap.put("dataList", arr);
		return rstMap;
	}
	
}
