/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-31
 * @version 1.0
 */
package com.icinfo.creditinfo.service.biz.hzbgnrdb;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crentbaseinfo.CrEntBaseInfo;
import com.icinfo.creditinfo.bean.biz.hzbgnrdb.HzBgnrdb;
import com.icinfo.creditinfo.bean.biz.hzbgnrdb.RegCapHistory;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 变更记录 Service 接口<br>
 * @author zhuyong
 * @date 2015-10-31
 */
public interface HzBgnrdbService extends HxBaseService<HzBgnrdb>{

	/**
	 * desc:获取返回数据
	 * 
	 * @author zhuyong
	 * @param baseInfo
	 * @param bgList
	 * @return
	 * @throws Exception
	 */
	public List<RegCapHistory> doBuildDataList(CrEntBaseInfo baseInfo,List<HzBgnrdb> bgList) throws Exception;
	
	/**
	 * 描述：获取注册资本和股东变更历史
	 * 
	 * @author zhuyong
	 * @param qrymapMap
	 * @return
	 * @throws Exception
	 */
	public List<RegCapHistory> doGetRegCapHisList(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * 描述：获取注册资本和股东变更历史总和
	 * 
	 * @author zhuyong
	 * @param qrymapMap
	 * @return
	 * @throws Exception
	 */
	public Integer doGetRegCapHisTotal(Map<String,Object> qryMap) throws Exception;

}
