/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempwatersewagedischargepay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.facebook.presto.jdbc.internal.jackson.annotation.JsonFormat.Value;
import com.icinfo.creditinfo.bean.upload.tempwatersewagedischargepay.TempWaterSewageDischargePay;
import com.icinfo.creditinfo.dao.upload.tempwatersewagedischargepay.TempWaterSewageDischargePayDao;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.tempwatersewagedischargepay.TempWaterSewageDischargePayService;
/**
 * 
 * 描述: 污水排放量 Service 实现<br>
 * @author liyafeng
 * @date 2015-11-12
 */
public class TempWaterSewageDischargePayServiceImpl extends HxBaseServiceImpl<TempWaterSewageDischargePay> implements TempWaterSewageDischargePayService
{
	

	public TempWaterSewageDischargePayDao doGetTempWaterSewageDischargePayDao()
	{
		return (TempWaterSewageDischargePayDao)hxBaseDao;
	}
    /**
     * 
     * 描述: 导入污水排放量信息
     * @author  LiYaFeng
     * @date 2015年11月12日 
     * @param sheet
     * @return
     * @throws Exception
     */
	@Override
	public Map<String, Object> doBatchImportTempWaterSewageDischargePayInfo(HSSFSheet sheet,String deptName,String depCode)
			throws Exception {
		List<TempWaterSewageDischargePay> tempWaterSewageDischargePayList=new ArrayList<TempWaterSewageDischargePay>();
		Row rowTitle = sheet.getRow(0);
		int i = 1;
		try {
		  if("ZF330682026".equals(depCode)){//水务集体
		    Row row = sheet.getRow(i);// 创建ROW
		    int rowNum = sheet.getLastRowNum();
		    if (row == null) {
		      return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
		    }
		    while (row != null && i <= rowNum) {
		    	
				if(ExcelFormVerification.isBlankCell(row.getCell(0))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(0).toString()+"为空", "");
				if(ExcelFormVerification.isBlankCell(row.getCell(1))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(1).toString()+"为空", "");
				if(!ExcelFormVerification.isBlankCell(row.getCell(1))&&!ExcelFormVerification.isValidDate(row.getCell(1))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(1).toString()+"格式不正确", "");
				if(ExcelFormVerification.isBlankCell(row.getCell(2))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2).toString()+"为空", "");
				if(!ExcelFormVerification.isBlankCell(row.getCell(2))&&!ExcelFormVerification.isValidDate(row.getCell(2))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2).toString()+"格式不正确", "");
				if(!ExcelFormVerification.isBlankCell(row.getCell(3))&&!ExcelFormVerification.isValidNumber(row.getCell(3))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(3).toString()+"格式不正确", "");
				if(!ExcelFormVerification.isBlankCell(row.getCell(4))&&!ExcelFormVerification.isValidNumber(row.getCell(4))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(4).toString()+"格式不正确", "");
				if(ExcelFormVerification.isBlankCell(row.getCell(5))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(5).toString()+"为空", "");
				if(!ExcelFormVerification.isBlankCell(row.getCell(5))&&!ExcelFormVerification.isValidDate(row.getCell(5))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(5).toString()+"格式不正确", "");
				if(!ExcelFormVerification.isBlankCell(row.getCell(6))&&!ExcelFormVerification.isValidNumber(row.getCell(6))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(6).toString()+"格式不正确", "");
				 
				TempWaterSewageDischargePay tempWaterSewageDischargePay=new TempWaterSewageDischargePay();
				tempWaterSewageDischargePay.setEntName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));
				tempWaterSewageDischargePay.setMeterReadingDate(ExcelFormVerification.parseDateCellToDate(row.getCell(1)));
				tempWaterSewageDischargePay.setSewageDisPeriod(ExcelFormVerification.parseDateCellToDate(row.getCell(2)));
				tempWaterSewageDischargePay.setSewageDisAmount(ExcelFormVerification.parseCellValueToNumericString(row.getCell(3)));
				tempWaterSewageDischargePay.setSewageDisMoney(ExcelFormVerification.parseCellValueToNumericString(row.getCell(4)));
				tempWaterSewageDischargePay.setPayDate(ExcelFormVerification.parseDateCellToDate(row.getCell(5)));	
				tempWaterSewageDischargePay.setPayMoney(ExcelFormVerification.parseCellValueToNumericString(row.getCell(6)));
				tempWaterSewageDischargePay.setOrgCode(ExcelFormVerification.parseCellValueToString(row.getCell(7)));
				tempWaterSewageDischargePay.setUnscCode(ExcelFormVerification.parseCellValueToString(row.getCell(8)));
				tempWaterSewageDischargePay.setImportFrom(deptName);
				tempWaterSewageDischargePay.setImportDate(new Date());
				tempWaterSewageDischargePay.setCorpid("");
				i++;
				row = sheet.getRow(i);
				tempWaterSewageDischargePayList.add(tempWaterSewageDischargePay);
		    }
        
	      }else{
	        return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件","");
	      }
		  
		} catch (Exception e) {
			return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误","");
		}
		  List<String> resultList = doGetTempWaterSewageDischargePayDao().insertBatch(tempWaterSewageDischargePayList);
		  if(resultList.size()!=0)
				return UpfileMsgInfo.sucMsgInfo(resultList.size(), true);
			else
				return UpfileMsgInfo.sucMsgInfo(0,false);
	}
}
