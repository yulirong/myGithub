/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.tempelecpay;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.creditinfo.bean.upload.tempbaseinfotax.TempBaseInfoTax;
import com.icinfo.creditinfo.bean.upload.tempelecpay.TempElecPay;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 电力电费 Service 接口<br>
 * @author gaotong
 * @date 2015-11-12
 */
public interface TempElecPayService extends HxBaseService<TempElecPay>{
	
	/**
	 * 描述：导入电力电费
	 * 
	 * @author gaotong
	 * @param sheet
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBatchImportTempElecPay(Sheet sheet,String deptName,String deptCode) throws Exception;

}
