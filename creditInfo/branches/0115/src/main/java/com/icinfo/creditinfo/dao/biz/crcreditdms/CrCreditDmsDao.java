/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-30
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.biz.crcreditdms;


import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crcreditdms.CrCreditDms;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 信用维度 Dao 接口<br>
 * @author gaotong
 * @date 2015-10-30
 */
public interface CrCreditDmsDao extends HxBaseDao<CrCreditDms>
{
/**
 * 
 * 描述: 根据行业获取各个纬度的平均得分
 * @author LiYaFeng
 * @date 2015年11月2日 
 * @param qryMap
 * @return
 * @throws Exception 
 */
  public CrCreditDms selectAvgScoreListByTrade(Map<String, Object> qryMap) throws Exception;

}