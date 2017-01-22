/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.tempbaseinfocourt;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.creditinfo.bean.upload.tempbaseinfocourt.TempBaseInfoCourt;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 法院当然人基本情况表 Service 接口<br>
 * @author gaotong
 * @date 2015-11-12
 */
public interface TempBaseInfoCourtService extends HxBaseService<TempBaseInfoCourt>{
	
	/**
	 * 描述：导入法院基本信息
	 * 
	 * @author gaotong
	 * @param sheet
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBatchImportTempBaseInfoCourt(Sheet sheet,String deptName,String deptCode) throws Exception;

}
