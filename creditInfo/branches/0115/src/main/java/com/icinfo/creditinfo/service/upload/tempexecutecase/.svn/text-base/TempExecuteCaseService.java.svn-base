/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.tempexecutecase;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.creditinfo.bean.upload.tempexecutecase.TempExecuteCase;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 法院执行案件 Service 接口<br>
 * @author gaotong
 * @date 2015-11-12
 */
public interface TempExecuteCaseService extends HxBaseService<TempExecuteCase>{
	
	/**
	 * 描述：导入执行案件
	 * 
	 * @author gaotong
	 * @param sheet ,depName
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	public Map<String, Object> doBatchImportTempExecuteCaseInfo(
			HSSFSheet sheet, String depName,String depCode) throws Exception;

}
