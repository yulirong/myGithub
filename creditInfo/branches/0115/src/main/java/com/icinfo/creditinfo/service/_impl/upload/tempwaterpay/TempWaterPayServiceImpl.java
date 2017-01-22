/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempwaterpay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.icinfo.creditinfo.bean.upload.tempwaterpay.TempWaterPay;
import com.icinfo.creditinfo.dao.upload.tempwaterpay.TempWaterPayDao;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.tempwaterpay.TempWaterPayService;
/**
 * 
 * 描述: 水费 Service 实现<br>
 * @author liyafeng
 * @date 2015-11-12
 */
public class TempWaterPayServiceImpl extends HxBaseServiceImpl<TempWaterPay> implements TempWaterPayService
{
	

	public TempWaterPayDao doGetTempWaterPayDao()
	{
		return (TempWaterPayDao)hxBaseDao;
	}
    /**
     * 
     * 描述:导入水费信息
     * @author  yulirong
     * @date 2015年12月23日 
     * @param sheet
     * @return Map<String, Object>
     * @throws Exception
     */
	@Override
	public Map<String, Object> doBatchImportTempWaterPayInfo(HSSFSheet sheet,String deptName,String depCode) throws Exception {
		List<TempWaterPay> tempWaterPayList=new ArrayList<TempWaterPay>();
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
		    	
		    	if(row.getCell(0)==null) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(0).toString()+"为空", "");
		    	if(row.getCell(1)==null) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(1).toString()+"为空", "");
		    	if(row.getCell(2)==null) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2).toString()+"为空", "");
		    	if(row.getCell(4)==null) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(4).toString()+"为空", "");
		    	if(!ExcelFormVerification.isValidDate(row.getCell(4))) 
		    		return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(4).toString()+"格式不正确", "");
		    	if(row.getCell(5)!=null&&!ExcelFormVerification.isValidDate(row.getCell(5))) 
		    		return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(5).toString()+"格式不正确", "");
		    	if(row.getCell(6)!=null&&!ExcelFormVerification.isValidNumber(row.getCell(6))) 
		    		return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(6).toString()+"格式不正确", "");
		    	if(row.getCell(7)!=null&&!ExcelFormVerification.isValidNumber(row.getCell(7))) 
		    		return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(7).toString()+"格式不正确", "");
		    	if(row.getCell(8)==null) 
		    		return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(8).toString()+"为空", "");
		    	if(!ExcelFormVerification.isBlankCell(row.getCell(8)) && !ExcelFormVerification.isValidDate(row.getCell(8))) 
		    		return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(8).toString()+"格式不正确", "");
		    	if(!ExcelFormVerification.isBlankCell(row.getCell(9)) && !ExcelFormVerification.isValidNumber(row.getCell(9))) 
		    		return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(9).toString()+"格式不正确", "");
		    	
		    	TempWaterPay tempWaterPay = doSetTempWaterPay(deptName, row);
			    i++;
			    row = sheet.getRow(i);
			    tempWaterPayList.add(tempWaterPay);
		    }
		    
		  }else{
		    return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件","");
		  }
		} catch (Exception e) {
			return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误","");
		}

		List<String> resultList = doGetTempWaterPayDao().insertBatch(tempWaterPayList);
		 if(resultList.size()!=0)
				return UpfileMsgInfo.sucMsgInfo(resultList.size(), true);
			else
				return UpfileMsgInfo.sucMsgInfo(0,false);
	}
	
	/**
	 * 
	 * @param deptName
	 * @param row
	 * @return
	 */
	private TempWaterPay doSetTempWaterPay(String deptName, Row row) {
		TempWaterPay tempWaterPay=new TempWaterPay();
		tempWaterPay.setEntName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));
		tempWaterPay.setEntLoc(ExcelFormVerification.parseCellValueToString(row.getCell(1)));
		tempWaterPay.setWaterNo(ExcelFormVerification.parseCellValueToString(row.getCell(2)));
		tempWaterPay.setUserType(ExcelFormVerification.parseCellValueToString(row.getCell(3)));
		tempWaterPay.setRecordDate(ExcelFormVerification.parseDateCellToDate(row.getCell(4)));
		tempWaterPay.setWaterPeriod(ExcelFormVerification.parseDateCellToString(row.getCell(5), "yyyy年MM月"));	
		tempWaterPay.setWaterConsumption(ExcelFormVerification.parseCellValueToNumericString(row.getCell(6)));
		tempWaterPay.setWaterPayAmount(ExcelFormVerification.parseCellValueToBigDecimal(row.getCell(7)));
		tempWaterPay.setPayDate(ExcelFormVerification.parseDateCellToDate(row.getCell(8)));
		tempWaterPay.setPayAmount(ExcelFormVerification.parseCellValueToBigDecimal(row.getCell(9)));
		tempWaterPay.setOrgCode(ExcelFormVerification.parseCellValueToString(row.getCell(10)));
		tempWaterPay.setUnscCode(ExcelFormVerification.parseCellValueToString(row.getCell(11)));
		tempWaterPay.setImportFrom(deptName);
		tempWaterPay.setImportDate(new Date());
		tempWaterPay.setCorpid("");
		return tempWaterPay;
	}
}
