/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-04
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crristindex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crristindex.CrRistIndex;
import com.icinfo.creditinfo.dao.biz.crristindex.CrRistIndexDao;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crristindex.CrRistIndexService;
/**
 * 
 * 描述: 风险指数 Service 实现<br>
 * @author zhuyong
 * @date 2015-11-04
 */
public class CrRistIndexServiceImpl extends HxBaseServiceImpl<CrRistIndex> implements CrRistIndexService
{
	/**
	 * 描述：构造返回map
	 * 
	 * @author zhuyong
	 * @param indexList
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBuildResultMap(List<CrRistIndex> indexList) throws Exception{
		Map<String,Object> rstMap = new HashMap<String, Object>();
		List<String> axisList = new ArrayList<String>();
		List<BigDecimal> dataList = new ArrayList<BigDecimal>();
		List<BigDecimal> avgDataList = new ArrayList<BigDecimal>();
		for (CrRistIndex index : indexList) {
			axisList.add(HxDateUtil.dateToString(index.getRistDate(),"yyyy-MM-dd"));
			dataList.add(index.getRistIndex());
			avgDataList.add(index.getAvgRistIndex());
		}
		rstMap.put("axisList", axisList);
		rstMap.put("dataList", dataList);
		rstMap.put("avgDataList", avgDataList);
		return rstMap;
	}
	/**
	 * 描述：获取值得关注的高风险企业（top10）数据
	 * 
	 * @author yulirong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrRistIndex> doGetCrRistIndexToptList(Map<String,Object> qryMap) throws Exception{
		return doGetCrRistIndexDao().doGetCrRistIndexToptList(qryMap);
	}

	public CrRistIndexDao doGetCrRistIndexDao()
	{
		return (CrRistIndexDao)hxBaseDao;
	}
	/**
	 * 
	 * 描述: 获取风险日期，指数，行业平均指数
	 * @author  LiYaFeng
	 * @date 2015年12月18日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrRistIndex> doGetCrRistIndexList(Map<String, Object> qryMap) throws Exception {
		return doGetCrRistIndexDao().selectCrRistIndexList(qryMap);
	}
}
