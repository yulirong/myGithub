/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.tempelecpayarrear;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.creditinfo.bean.upload.tempelecpay.TempElecPay;
import com.icinfo.creditinfo.bean.upload.tempelecpayarrear.TempElecPayArrear;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 电力欠费 Service 接口<br>
 * @author gaotong
 * @date 2015-11-12
 */
public interface TempElecPayArrearService extends HxBaseService<TempElecPayArrear>{
	
	
	/**
	 * 描述：导入电力欠费
	 * 
	 * @author gaotong
	 * @param sheet
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBatchImportTempElecPayArrear(Sheet sheet,String deptName,String deptCode) throws Exception;

}
