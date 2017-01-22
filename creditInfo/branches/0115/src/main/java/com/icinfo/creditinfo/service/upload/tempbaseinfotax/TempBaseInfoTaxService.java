/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.tempbaseinfotax;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.creditinfo.bean.upload.tempbaseinfotax.TempBaseInfoTax;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 企业基本信息 Service 接口<br>
 * @author gaotong
 * @date 2015-11-11
 */
public interface TempBaseInfoTaxService extends HxBaseService<TempBaseInfoTax>{
	/**
	 * 描述：导入国税、地税基本信息
	 * 
	 * @author gaotong
	 * @param sheet,taxType
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBatchImportTempBaseInfoTax(Sheet sheet,String deptName,String deptCode) throws Exception;


}
