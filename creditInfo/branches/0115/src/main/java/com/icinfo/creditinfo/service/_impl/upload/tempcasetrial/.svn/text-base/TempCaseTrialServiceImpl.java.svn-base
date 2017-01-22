/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempcasetrial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.icinfo.creditinfo.bean.upload.tempcasetrial.TempCaseTrial;
import com.icinfo.creditinfo.dao.upload.tempcasetrial.TempCaseTrialDao;
import com.icinfo.creditinfo.service.upload.tempcasetrial.TempCaseTrialService;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
/**
 * 
 * 描述: 法院案件审理 Service 实现<br>
 * @author gaotong
 * @date 2015-11-12
 */
public class TempCaseTrialServiceImpl extends HxBaseServiceImpl<TempCaseTrial> implements TempCaseTrialService
{
	
	/**
	 * 描述：导入审理案件
	 * 
	 * @author gaotong
	 * @param sheet
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBatchImportTempCaseTrialInfo(HSSFSheet sheet,
			String depName,String depCode) throws Exception{
		List<TempCaseTrial> tempCaseTrialList=new ArrayList<TempCaseTrial>();
		HSSFRow rowTitle = sheet.getRow(0);
		int i=1;
		
		try {
		  if("ZF330682006".equals(depCode)){//法院
		    Row row = sheet.getRow(i);//创建ROW
		    int rowNum = sheet.getLastRowNum();
		    if (row == null) {
		      return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
		    }
		    while(i<=rowNum){
		      
		      if(ExcelFormVerification.isBlankCell(row.getCell(0))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(0).toString()+"为空", "");
		      if(ExcelFormVerification.isBlankCell(row.getCell(2))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2).toString()+"为空", "");
		      if(!ExcelFormVerification.isBlankCell(row.getCell(3))&&!ExcelFormVerification.isValidDate(row.getCell(3))) return UpfileMsgInfo.errMsgInfo(i+1,rowTitle.getCell(3).toString()+"格式不正确", "");
		      if(ExcelFormVerification.isBlankCell(row.getCell(4))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(4).toString()+"为空", "");
		      if(ExcelFormVerification.isBlankCell(row.getCell(5))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(5).toString()+"为空", "");
		      if(ExcelFormVerification.isBlankCell(row.getCell(10))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(10).toString()+"为空", "");
		      
		      TempCaseTrial tempCaseTrial=new TempCaseTrial();
		      tempCaseTrial.setCaseNo(ExcelFormVerification.parseCellValueToString(row.getCell(0)));
		      tempCaseTrial.setCaseState(ExcelFormVerification.parseCellValueToString(row.getCell(1)));
		      tempCaseTrial.setPartyName(ExcelFormVerification.parseCellValueToString(row.getCell(2)));
		      tempCaseTrial.setCaseStartDate(ExcelFormVerification.parseDateCellToDate(row.getCell(3)));
		      tempCaseTrial.setOrgName(ExcelFormVerification.parseCellValueToString(row.getCell(4)));
		      tempCaseTrial.setUndertaker(ExcelFormVerification.parseCellValueToString(row.getCell(5)));
		      tempCaseTrial.setCaseCloseDate(ExcelFormVerification.parseDateCellToDate(row.getCell(6)));
		      tempCaseTrial.setCaseCloseWay(ExcelFormVerification.parseCellValueToString(row.getCell(7)));
		      tempCaseTrial.setCaseResult(ExcelFormVerification.parseCellValueToString(row.getCell(8)));
		      tempCaseTrial.setCaseValidDate(ExcelFormVerification.parseDateCellToDate(row.getCell(9)));
		      tempCaseTrial.setCaseReason(ExcelFormVerification.parseCellValueToString(row.getCell(10)));
		      tempCaseTrial.setCaseMoney(ExcelFormVerification.parseCellValueToNumericString(row.getCell(11)));
		      tempCaseTrial.setCaseStartPeople("");
		      tempCaseTrial.setCaseResultExplain("");
		      tempCaseTrial.setImportFrom(depName);
		      tempCaseTrial.setImportDate(new Date());
		      tempCaseTrialList.add(tempCaseTrial);
		      i++;
		      row = sheet.getRow(i);
		    } 
		  }else{
		    return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件","");
		  }
		}catch(Exception e){
			return UpfileMsgInfo.errMsgInfo(i, "数据格式错误","");
		}
		//导入并返回结果
		List<String> resultList = doGetTempCaseTrialDao().insertBatch(tempCaseTrialList);
		if(resultList.size()!=0)
			return UpfileMsgInfo.sucMsgInfo(resultList.size(), true);
		else
			return UpfileMsgInfo.sucMsgInfo(0,false);
	}

	public TempCaseTrialDao doGetTempCaseTrialDao()
	{
		return (TempCaseTrialDao)hxBaseDao;
	}
}
