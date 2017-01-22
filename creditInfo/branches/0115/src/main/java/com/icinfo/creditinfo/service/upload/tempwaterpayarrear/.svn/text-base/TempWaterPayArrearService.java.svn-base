/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.tempwaterpayarrear;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.creditinfo.bean.upload.tempwaterpayarrear.TempWaterPayArrear;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 水费欠费 Service 接口<br>
 * @author liyafeng
 * @date 2015-11-12
 */
public interface TempWaterPayArrearService extends HxBaseService<TempWaterPayArrear>{
    /**
     * 
     * 描述: 导入水费欠费信息
     * @author LiYaFeng
     * @date 2015年11月12日 
     * @param sheet
     * @return
     */
	public  Map<String, Object> doBatchImportTempWaterPayArrearInfo(HSSFSheet sheet,String deptName,String depCode) throws Exception;
	

}
