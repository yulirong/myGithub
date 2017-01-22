/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.temphousesequestrate;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.creditinfo.bean.upload.temphousesequestrate.TempHouseSequestrate;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 房产查封 Service 接口<br>
 * 
 * @author liyafeng
 * @date 2015-11-11
 */
public interface TempHouseSequestrateService extends HxBaseService<TempHouseSequestrate> {
	/**
	 * 
	 * 描述: 导入房产查封信息 .
	 * 
	 * @author LiYaFeng
	 * @date 2015年11月11日
	 * @param sheet
	 * @return
	 */
	public Map<String,Object> doBatchImportTempHouseSequestrateInfo(HSSFSheet sheet,String depName,String depCode)throws Exception ;

}
