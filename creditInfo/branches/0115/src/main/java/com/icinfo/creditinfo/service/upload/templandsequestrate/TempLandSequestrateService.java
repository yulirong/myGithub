/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-12-22
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.templandsequestrate;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.creditinfo.bean.upload.templandsequestrate.TempLandSequestrate;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 土地查封 Service 接口<br>
 * @author yulirong
 * @date 2015-12-22
 */
public interface TempLandSequestrateService extends HxBaseService<TempLandSequestrate>{
	
	 /**
     * 
     * 描述: 土地查封
     * @author yulirong
     * @date 2015年12月23日 
     * @param sheet
     * @return
     * @throws Exception
     */
	public Map<String, Object> doBatchImportTempLandSequestrateInfo(HSSFSheet sheet,String depNmae,String depCode) throws Exception;
}
