/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-22
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.biz.crlicense;

import java.util.List;

import com.icinfo.creditinfo.bean.biz.crlicense.CrLicense;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 许可信息 Dao 接口<br>
 * @author yulirong
 * @date 2015-10-22
 */
public interface CrLicenseDao extends HxBaseDao<CrLicense>
{
    /**
     * 
     * 描述: 查询状态
     * @author LiYaFeng
     * @date 2015年11月13日 
     * @return
     * @throws Exception
     */
	public List<String> selectStateList() throws Exception;

}