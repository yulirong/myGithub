/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.tempexpimpamount;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.creditinfo.bean.upload.tempexpimpamount.TempExpImpAmount;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 进出口量 Service 接口<br>
 * @author liyafeng
 * @date 2015-11-11
 */
public interface TempExpImpAmountService extends HxBaseService<TempExpImpAmount>{
    /**
     * 
     * 描述: 导入进出口量
     * @author LiYaFeng
     * @date 2015年11月11日 
     * @param sheet
     * @return
     * @throws Exception
     */
	public Map<String, Object> doBatchImportTempExpImpAmountInfo(HSSFSheet sheet,String deptName,String deptCode) throws Exception;
	

}
