/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.tempmortgagereg;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.creditinfo.bean.upload.tempmortgagereg.TempMortgageReg;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 抵押登记 Service 接口<br>
 * @author gaotong
 * @date 2015-11-12
 */
public interface TempMortgageRegService extends HxBaseService<TempMortgageReg>{
	
	/**
     * 
     * 描述: 抵押登记
     * @author yulirong
     * @date 2015年12月22日 
     * @param sheet
     * @return
     * @throws Exception
     */
	public Map<String, Object> doBatchImportTempMortgageRegInfo(HSSFSheet sheet,String depName,String depCode) throws Exception;

}
