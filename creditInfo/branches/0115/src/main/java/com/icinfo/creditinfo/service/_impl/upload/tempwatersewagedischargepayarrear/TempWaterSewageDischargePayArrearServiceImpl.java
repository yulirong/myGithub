/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempwatersewagedischargepayarrear;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.icinfo.creditinfo.bean.upload.tempwatersewagedischargepayarrear.TempWaterSewageDischargePayArrear;
import com.icinfo.creditinfo.dao.upload.tempwatersewagedischargepayarrear.TempWaterSewageDischargePayArrearDao;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.tempwatersewagedischargepayarrear.TempWaterSewageDischargePayArrearService;
/**
 * 
 * 描述: 污水排放量欠费 Service 实现<br>
 * @author liyafeng
 * @date 2015-11-12
 */
public class TempWaterSewageDischargePayArrearServiceImpl extends HxBaseServiceImpl<TempWaterSewageDischargePayArrear> implements TempWaterSewageDischargePayArrearService
{
	

	public TempWaterSewageDischargePayArrearDao doGetTempWaterSewageDischargePayArrearDao()
	{
		return (TempWaterSewageDischargePayArrearDao)hxBaseDao;
	}
    /**
     * 
     * 描述: 导入污水排放量欠费信息
     * @author  LiYaFeng
     * @date 2015年11月12日 
     * @param sheet
     * @return
     * @throws Exception
     */
	@Override
	public Map<String, Object> doBatchImportTempWaterSewageDischargePayArrearInfo(
			HSSFSheet sheet,String deptName,String depCode) throws Exception {
		List<TempWaterSewageDischargePayArrear> tempWaterSewageDischargePayArrearList=new ArrayList<TempWaterSewageDischargePayArrear>();
		Row rowTitle = sheet.getRow(0);
		int i = 1;
		try {
		  if("ZF330682026".equals(depCode)){//水务集团
			    Row row = sheet.getRow(i);// 创建ROW
			    int rowNum = sheet.getLastRowNum();
			    if (row == null) {
			      return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
			    }
			    while (row != null && i <= rowNum) {
			    	
			      if(ExcelFormVerification.isBlankCell(row.getCell(0))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(0).toString()+"为空", "");
			      if(ExcelFormVerification.isBlankCell(row.getCell(2))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2).toString()+"为空", "");
			      if(!ExcelFormVerification.isBlankCell(row.getCell(2))&&!ExcelFormVerification.isValidDate(row.getCell(2))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2).toString()+"格式不正确", "");
			      if(!ExcelFormVerification.isBlankCell(row.getCell(3))&&!ExcelFormVerification.isValidNumber(row.getCell(3))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(3).toString()+"格式不正确", "");
		
			      TempWaterSewageDischargePayArrear tempWaterSewageDischargePayArrear=new TempWaterSewageDischargePayArrear();
			      tempWaterSewageDischargePayArrear.setEntName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));
			      tempWaterSewageDischargePayArrear.setLoc(ExcelFormVerification.parseCellValueToString(row.getCell(1)));
			      tempWaterSewageDischargePayArrear.setPayArrearPeriod(ExcelFormVerification.parseDateCellToString(row.getCell(2), "yyyy-MM-dd"));
			      tempWaterSewageDischargePayArrear.setPayArrearAmount(ExcelFormVerification.parseCellValueToBigDecimal(row.getCell(3)));
			      tempWaterSewageDischargePayArrear.setOrgCode(ExcelFormVerification.parseCellValueToString(row.getCell(4)));
			      tempWaterSewageDischargePayArrear.setUnscCode(ExcelFormVerification.parseCellValueToString(row.getCell(5)));
			      tempWaterSewageDischargePayArrear.setImportFrom(deptName);
			      tempWaterSewageDischargePayArrear.setImportDate(new Date());
			      tempWaterSewageDischargePayArrear.setCorpid("");
			      i++;
			      row = sheet.getRow(i);
			      tempWaterSewageDischargePayArrearList.add(tempWaterSewageDischargePayArrear);
			    }
	        
	      }else{
	        return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件","");
	      }
		  
		} catch (Exception e) {
			return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");
		}
		List<String> resultList = doGetTempWaterSewageDischargePayArrearDao().insertBatch(tempWaterSewageDischargePayArrearList);
		if(resultList.size()!=0)
			return UpfileMsgInfo.sucMsgInfo(resultList.size(), true);
		else
			return UpfileMsgInfo.sucMsgInfo(0,false);
	}
}
