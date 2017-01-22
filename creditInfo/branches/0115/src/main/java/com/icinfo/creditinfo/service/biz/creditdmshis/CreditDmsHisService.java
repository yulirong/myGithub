/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author lyf
 * @date 2015-10-30
 * @version 1.0
 */
package com.icinfo.creditinfo.service.biz.creditdmshis;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.creditdmshis.CreditDmsHis;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 信用维度历史 Service 接口<br>
 * 
 * @author lyf
 * @date 2015-10-30
 */
public interface CreditDmsHisService extends HxBaseService<CreditDmsHis> {

	/**
	 * 
	 * 描述: 获取公司的行业
	 * 
	 * @author LiYaFeng
	 * @date 2015年11月3日
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> doGetDmsEntTrade(Map<String, Object> qryMap) throws Exception;

	/**
	 * 
	 * 描述: 获得公司分数、平均分数、日期
	 * 
	 * @author LiYaFeng
	 * @date 2015年11月17日
	 * @param qryMap1
	 * @return
	 */
	public Map<String, Object> doGetDateListAndAvgScoreListAndScoreList(Map<String, Object> qryMap) throws Exception;
    /**
     * 
     * 描述: 得到本期与上一期的信用评分
     * @author LiYaFeng
     * @date 2015年11月25日 
     * @param qryMap
     * @return
     */
	public List<BigDecimal> doGetScoreListByCopyId(Map<String, Object> qryMap);

}
