/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-06
 * @version 1.0
 */
package com.icinfo.creditinfo.service.analy.cranalyzone;

import java.math.BigDecimal;
import java.util.List;
import net.sf.json.JSONArray;

import com.icinfo.creditinfo.bean.analy.cranalyzone.CrAnalyZone;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 地域分布 Service 接口<br>
 * @author zhuyong
 * @date 2015-11-06
 */
public interface CrAnalyZoneService extends HxBaseService<CrAnalyZone>{
	
	/**
	 * 描述：构建返回参数
	 * 
	 * @author zhuyong
	 * @date 2015-11-06
	 * @param zoneList
	 * @return
	 * @throws Exception
	 */
	public JSONArray doBuildDataList(List<CrAnalyZone> zoneList,String typeName) throws Exception;
	
	/***
	 * 描述：构建返回值-总量
	 * 
	 * @author zhuyong
	 * @param zoneList
	 * @param typeName
	 * @return
	 * @throws Exception
	 */
	public BigDecimal doBuildTotalNum(List<CrAnalyZone> zoneList,String typeName) throws Exception;
	/**
	 * 描述：获取企业总数
	 * 
	 * @author zhuyong
	 * @date 2015-11-06
	 * @param zoneList
	 * @return
	 * @throws Exception
	 */
	public BigDecimal doGetAllEntNum(List<CrAnalyZone> zoneList) throws Exception;
	

}
