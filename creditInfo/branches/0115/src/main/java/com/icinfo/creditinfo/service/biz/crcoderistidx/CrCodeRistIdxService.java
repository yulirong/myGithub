/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-09
 * @version 1.0
 */
package com.icinfo.creditinfo.service.biz.crcoderistidx;

import com.icinfo.creditinfo.bean.biz.crcoderistidx.CrCodeRistIdx;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 风险指数明细 Service 接口<br>
 * 
 * @author liyafeng
 * @date 2015-11-09
 */
public interface CrCodeRistIdxService extends HxBaseService<CrCodeRistIdx> {
	/**
	 * 
	 * 描述: 保存
	 * 
	 * @author LiYaFeng
	 * @date 2015年11月9日
	 * @param crCodeRistIdx
	 * @return
	 * @throws Exception
	 */
	public void doSaveCrCodeRistIdx(CrCodeRistIdx crCodeRistIdx) throws Exception;

	/**
	 * 
	 * 描述: 根据id查询
	 * 
	 * @author LiYaFeng
	 * @date 2015年11月9日
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public CrCodeRistIdx doGetcrCodeRistIdxById(int id) throws Exception;
    /**
     * 
     * 描述: 根据id删除
     * @author LiYaFeng
     * @date 2015年11月10日 
     * @param id
     */
	public int doRm(int id);

}
