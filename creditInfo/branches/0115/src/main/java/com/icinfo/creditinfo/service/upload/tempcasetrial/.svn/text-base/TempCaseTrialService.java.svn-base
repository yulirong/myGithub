/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.tempcasetrial;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import com.icinfo.creditinfo.bean.upload.tempcasetrial.TempCaseTrial;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 法院案件审理 Service 接口<br>
 * @author gaotong
 * @date 2015-11-12
 */
public interface TempCaseTrialService extends HxBaseService<TempCaseTrial>{
	
	/**
	 * 描述：导入审理案件
	 * @author gaotong
	 * @date 2015-12-24
	 * @param sheet
	 * @return Map<String, Object> 
	 * @throws Exception
	 */
	public Map<String, Object> doBatchImportTempCaseTrialInfo(HSSFSheet sheet,
			String depName,String depCode) throws Exception;

}
