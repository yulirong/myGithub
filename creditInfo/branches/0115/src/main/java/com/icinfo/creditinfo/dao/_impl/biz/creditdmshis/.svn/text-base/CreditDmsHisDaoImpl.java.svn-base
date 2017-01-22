/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author lyf
 * @date 2015-10-30
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.creditdmshis;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crcreditdms.CrCreditDms;
import com.icinfo.creditinfo.bean.biz.creditdmshis.CreditDmsHis;
import com.icinfo.creditinfo.dao.biz.creditdmshis.CreditDmsHisDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 信用维度历史 Dao 实现<br>
 * @author lyf
 * @date 2015-10-30
 */
public class CreditDmsHisDaoImpl extends HxBaseDaoImpl<CreditDmsHis> implements CreditDmsHisDao
{
    /**
     * 
     * 描述:  获得公司分数、平均分数、日期
     * @author  LiYaFeng
     * @date 2015年11月17日 
     * @param qryMap1
     * @return
     * @throws Exception
     */
   @Override
   public List<CreditDmsHis> selectDateListAndAvgScoreListAndScoreList(Map<String, Object> qryMap1) throws Exception {
	return   (List<CreditDmsHis>)getBaseSqlMapDao().queryForList("ibatis-creditdmshis.selectDateListAndAvgScoreListAndScoreList", qryMap1);
}
    /**
     * 
     * 描述: 得到本期与上一期的信用评分
     * @author  LiYaFeng
     * @date 2015年11月25日 
     * @param qryMap
     * @return
     */
	@Override
	public List<BigDecimal> selectScoreListByCopyId(Map<String, Object> qryMap) {
		return (List<BigDecimal>)getBaseSqlMapDao().queryForList("ibatis-creditdmshis.selectScoreList",qryMap);
	}
}