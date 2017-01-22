/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempgaspay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.icinfo.creditinfo.bean.upload.tempgaspay.TempGasPay;
import com.icinfo.creditinfo.bean.upload.templicense.TempLicense;
import com.icinfo.creditinfo.dao.upload.tempgaspay.TempGasPayDao;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.tempgaspay.TempGasPayService;
/**
 * 
 * 描述: 天然气费用 Service 实现<br>
 * @author liyafeng
 * @date 2015-11-12
 */
public class TempGasPayServiceImpl extends HxBaseServiceImpl<TempGasPay> implements TempGasPayService
{
	

	public TempGasPayDao doGetTempGasPayDao()
	{
		return (TempGasPayDao)hxBaseDao;
	}
    /**
     * 
     * 描述: 导入天然气信息
     * @author  LiYaFeng
     * @date 2015年11月12日 
     * @param sheet
     * @return
     * @throws Exception
     */
	@Override
	public Map<String, Object> doBatchImportTempGasPayInfo(HSSFSheet sheet,String deptName,String depCode) throws Exception {
		List<TempGasPay> tempGasPayList=new ArrayList<TempGasPay>();
		Row rowTitle = sheet.getRow(0);
		int i = 1;
		try {
		  if("ZF330682027".equals(depCode)){//天然气公司
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
		    	if(!ExcelFormVerification.isBlankCell(row.getCell(5))&&!ExcelFormVerification.isValidNumber(row.getCell(5))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(5).toString()+"格式不正确", "");
		    	if(!ExcelFormVerification.isBlankCell(row.getCell(6))&&!ExcelFormVerification.isValidNumber(row.getCell(6))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(6).toString()+"格式不正确", "");
		    	if(!ExcelFormVerification.isBlankCell(row.getCell(7))&&!ExcelFormVerification.isValidNumber(row.getCell(7))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(7).toString()+"格式不正确", "");
		    	if(!ExcelFormVerification.isBlankCell(row.getCell(8))&&!ExcelFormVerification.isValidNumber(row.getCell(8))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(8).toString()+"格式不正确", "");
		    	if(!ExcelFormVerification.isBlankCell(row.getCell(14))&&!ExcelFormVerification.isValidNumber(row.getCell(14))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(14).toString()+"格式不正确", "");
		    	
		    	TempGasPay tempGasPay=new TempGasPay();
		    	tempGasPay.setEntName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));
		    	tempGasPay.setBalanceDateStart(ExcelFormVerification.parseDateCellToDate(row.getCell(1)));
		    	tempGasPay.setBalanceDateEnd(ExcelFormVerification.parseDateCellToDate(row.getCell(2)));
		    	tempGasPay.setSupplyType(ExcelFormVerification.parseCellValueToString(row.getCell(3)));
		    	tempGasPay.setMeterReadingDate(ExcelFormVerification.parseCellValueToString(row.getCell(4)));//二月五日
		    	tempGasPay.setPreviousDegree(ExcelFormVerification.parseCellValueToNumericString(row.getCell(5)));	
		    	tempGasPay.setPresentDegree(ExcelFormVerification.parseCellValueToNumericString(row.getCell(6)));
		    	tempGasPay.setDegree(ExcelFormVerification.parseCellValueToNumericString(row.getCell(7)));
		    	tempGasPay.setPresentAmount(ExcelFormVerification.parseCellValueToNumericString(row.getCell(8)));
		    	tempGasPay.setGasPrice(ExcelFormVerification.parseCellValueToString(row.getCell(9)));
		    	tempGasPay.setPayable(ExcelFormVerification.parseCellValueToNumericString(row.getCell(10)));
		    	tempGasPay.setPaid(ExcelFormVerification.parseCellValueToNumericString(row.getCell(11)));
		    	tempGasPay.setPrepayments(ExcelFormVerification.parseCellValueToNumericString(row.getCell(12)));
		    	tempGasPay.setPenalty(ExcelFormVerification.parseCellValueToNumericString(row.getCell(13)));
		    	tempGasPay.setPayableAmount(ExcelFormVerification.parseCellValueToNumericString(row.getCell(14)));
		    	tempGasPay.setOrgCode(ExcelFormVerification.parseCellValueToString(row.getCell(15)));
		    	tempGasPay.setUnscCode(ExcelFormVerification.parseCellValueToString(row.getCell(16)));
		    	tempGasPay.setImportFrom(deptName);
		    	tempGasPay.setImportDate(new Date());
		    	tempGasPay.setCorpid("");
		    	i++;
		    	row = sheet.getRow(i);
		    	tempGasPayList.add(tempGasPay);
		    }
		    
		  }else{
		    return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件","");
		  }
		} catch (Exception e) {
			return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");
		} 
		  List<String> resultList = doGetTempGasPayDao().insertBatch(tempGasPayList);
		  if(resultList.size()!=0)
				return UpfileMsgInfo.sucMsgInfo(resultList.size(), true);
			else
				return UpfileMsgInfo.sucMsgInfo(0,false);
	}
}
