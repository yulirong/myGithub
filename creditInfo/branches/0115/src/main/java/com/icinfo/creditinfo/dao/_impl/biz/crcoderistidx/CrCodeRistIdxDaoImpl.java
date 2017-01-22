/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-09
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.crcoderistidx;

import com.icinfo.creditinfo.bean.biz.crcoderistidx.CrCodeRistIdx;
import com.icinfo.creditinfo.dao.biz.crcoderistidx.CrCodeRistIdxDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 风险指数明细 Dao 实现<br>
 * 
 * @author liyafeng
 * @date 2015-11-09
 */
public class CrCodeRistIdxDaoImpl extends HxBaseDaoImpl<CrCodeRistIdx> implements CrCodeRistIdxDao {
	/**
	 * 
	 * 描述: 添加
	 * 
	 * @author LiYaFeng
	 * @date 2015年11月9日
	 * @param crCodeRistIdx
	 */
	public void insertCrCodeRistIdx(CrCodeRistIdx crCodeRistIdx) throws Exception {
		   getBaseSqlMapDao().insert("ibatis-crcoderistidx.insertCrCodeRistIdx", crCodeRistIdx);

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
	public CrCodeRistIdx selectGetcrCodeRistIdxById(int id) throws Exception {
		return (CrCodeRistIdx) getBaseSqlMapDao().queryForObject("ibatis-crcoderistidx.selectCrCodeRistIdxById", id);
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
	public int delete(int id) {
		return (int)getBaseSqlMapDao().delete("ibatis-crcoderistidx.deleteCrCodeRistIdx", id);
	}

}