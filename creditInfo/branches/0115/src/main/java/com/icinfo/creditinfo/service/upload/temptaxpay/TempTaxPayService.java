/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.temptaxpay;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.creditinfo.bean.upload.temptaxpay.TempTaxPay;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 税费缴税 Service 接口<br>
 * @author gaotong
 * @date 2015-11-11
 */
public interface TempTaxPayService extends HxBaseService<TempTaxPay>{
	
    /**
     * 
     * 描述: 导入税收信息
     * @author  gaotong
     * @date 2015年11月11日 
     * @param sheet,taxType
     * @return
     * @throws Exception 
     */
	public Map<String,Object> doBatchImportTempTaxPay(Sheet sheet,String deptName,String deptCode) throws Exception;

}
