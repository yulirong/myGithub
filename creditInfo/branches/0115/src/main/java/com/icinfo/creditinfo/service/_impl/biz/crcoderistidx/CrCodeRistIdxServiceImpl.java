/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-09
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crcoderistidx;

import com.icinfo.creditinfo.bean.biz.crcoderistidx.CrCodeRistIdx;
import com.icinfo.creditinfo.dao.biz.crcoderistidx.CrCodeRistIdxDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crcoderistidx.CrCodeRistIdxService;

/**
 * 
 * 描述: 风险指数明细 Service 实现<br>
 * 
 * @author liyafeng
 * @date 2015-11-09
 */
public class CrCodeRistIdxServiceImpl extends HxBaseServiceImpl<CrCodeRistIdx> implements CrCodeRistIdxService {

	public CrCodeRistIdxDao doGetCrCodeRistIdxDao() {
		return (CrCodeRistIdxDao) hxBaseDao;
	}

	/**
	 * 
	 * 描述: 添加
	 * 
	 * @author LiYaFeng
	 * @date 2015年11月9日
	 * @param crCodeRistIdx
	 * @return
	 * @throws Exception
	 */
	public void doSaveCrCodeRistIdx(CrCodeRistIdx crCodeRistIdx) throws Exception {
		 doGetCrCodeRistIdxDao().insertCrCodeRistIdx(crCodeRistIdx);

	}

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
	@Override
	public CrCodeRistIdx doGetcrCodeRistIdxById(int id) throws Exception {
		
		return doGetCrCodeRistIdxDao().selectGetcrCodeRistIdxById(id);
	}
    /**
     * 
     * 描述: 根据id删除
     * @author  LiYaFeng
     * @date 2015年11月10日 
     * @param id
     * @return
     */
	@Override
	public int doRm(int id) {
		return doGetCrCodeRistIdxDao().delete(id);
	}
}
