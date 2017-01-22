/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempexecutecase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import com.icinfo.creditinfo.bean.upload.tempexecutecase.TempExecuteCase;
import com.icinfo.creditinfo.dao.upload.tempexecutecase.TempExecuteCaseDao;
import com.icinfo.creditinfo.service.upload.tempexecutecase.TempExecuteCaseService;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
/**
 * 
 * 描述: 法院执行案件 Service 实现<br>
 * @author gaotong
 * @date 2015-11-12
 */
public class TempExecuteCaseServiceImpl extends HxBaseServiceImpl<TempExecuteCase> implements TempExecuteCaseService
{
	/**
	 * 描述：导入执行案件
	 * @author MaYawei
	 * @date 2015-12-22
	 * @param sheet , depName
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> doBatchImportTempExecuteCaseInfo(
			HSSFSheet sheet, String depName,String depCode) throws Exception {
		List<TempExecuteCase> tempExecuteCaseList=new ArrayList<TempExecuteCase>();
		HSSFRow rowTitle = sheet.getRow(0);//标题行
		int i=1;
		try{
		  if("ZF330682006".equals(depCode)){//法院
		    Row row = sheet.getRow(i);//获取ROW
		    int rowNum = sheet.getLastRowNum();
		    if (row == null) {
		      return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
		    }
		    
		    while(i<=rowNum) {
		    	
		      if(ExcelFormVerification.isBlankCell(row.getCell(0))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(0).toString()+"为空", "");				
		      if(ExcelFormVerification.isBlankCell(row.getCell(1))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(1).toString()+"为空", "");
		      //if(ExcelFormVerification.isBlankCell(row.getCell(2))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2).toString()+"为空", "");
		      if(!ExcelFormVerification.isBlankCell(row.getCell(2))&&!ExcelFormVerification.isValidNumber(row.getCell(2)))  return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2).toString()+"格式不正确", "");
		      //if(ExcelFormVerification.isBlankCell(row.getCell(3))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(3).toString()+"为空", "");
		      if(!ExcelFormVerification.isBlankCell(row.getCell(3))&&!ExcelFormVerification.isValidNumber(row.getCell(3)))  return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(3).toString()+"格式不正确", "");
		      //if(ExcelFormVerification.isBlankCell(row.getCell(4))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(4).toString()+"为空", "");
		      //if(ExcelFormVerification.isBlankCell(row.getCell(5))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(5).toString()+"为空", "");
		      //if(ExcelFormVerification.isBlankCell(row.getCell(7))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(7).toString()+"为空", "");
		      if(!ExcelFormVerification.isBlankCell(row.getCell(12))&&!ExcelFormVerification.isValidDate(row.getCell(12))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(12).toString()+"格式不正确", "");
		      if(!ExcelFormVerification.isBlankCell(row.getCell(14))&&!ExcelFormVerification.isValidDate(row.getCell(14))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(14).toString()+"格式不正确", "");
		      if(!ExcelFormVerification.isBlankCell(row.getCell(15))&&!ExcelFormVerification.isValidDate(row.getCell(15))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(15).toString()+"格式不正确", "");
		      if(!ExcelFormVerification.isBlankCell(row.getCell(20))&&!ExcelFormVerification.isValidNumber(row.getCell(20))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(20).toString()+"格式不正确", "");
		      if(!ExcelFormVerification.isBlankCell(row.getCell(21))&&!ExcelFormVerification.isValidNumber(row.getCell(21))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(21).toString()+"格式不正确", "");
		      if(!ExcelFormVerification.isBlankCell(row.getCell(22))&&!ExcelFormVerification.isValidDate(row.getCell(22))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(22).toString()+"格式不正确", "");
		      if(!ExcelFormVerification.isBlankCell(row.getCell(27))&&!ExcelFormVerification.isValidDate(row.getCell(27))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(27).toString()+"格式不正确", "");
		      if(!ExcelFormVerification.isBlankCell(row.getCell(28))&&!ExcelFormVerification.isValidDate(row.getCell(28))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(28).toString()+"格式不正确", "");
		      
		      TempExecuteCase tempExecuteCase=new TempExecuteCase();
		      tempExecuteCase.setCaseNatrue(ExcelFormVerification.parseCellValueToString(row.getCell(0)));
		      tempExecuteCase.setCaseSource(ExcelFormVerification.parseCellValueToString(row.getCell(1)));
		      tempExecuteCase.setObject(ExcelFormVerification.parseCellValueToNumericString(row.getCell(2)));
		      tempExecuteCase.setExecuteFee(ExcelFormVerification.parseCellValueToNumericString(row.getCell(3)));
		      tempExecuteCase.setPreTrialCourt(ExcelFormVerification.parseCellValueToString(row.getCell(4)));
		      tempExecuteCase.setEffectiveJudgmentNo(ExcelFormVerification.parseCellValueToString(row.getCell(5)));
		      tempExecuteCase.setTrialJudge(ExcelFormVerification.parseCellValueToString(row.getCell(6)));
		      tempExecuteCase.setCaseState(ExcelFormVerification.parseCellValueToString(row.getCell(7)));
		      tempExecuteCase.setExecuteApplyName(ExcelFormVerification.parseCellValueToString(row.getCell(8)));
		      tempExecuteCase.setExecutedName(ExcelFormVerification.parseCellValueToString(row.getCell(9)));
		      tempExecuteCase.setUndertakeDepart(ExcelFormVerification.parseCellValueToString(row.getCell(10)));
		      tempExecuteCase.setUndertaker(ExcelFormVerification.parseCellValueToString(row.getCell(11)));
		      tempExecuteCase.setDivisionalDate(ExcelFormVerification.parseDateCellToDate(row.getCell(12)));
		      tempExecuteCase.setDivisionalPeople(ExcelFormVerification.parseCellValueToString(row.getCell(13)));
		      tempExecuteCase.setBulletinClosingDate(ExcelFormVerification.parseDateCellToDate(row.getCell(14)));
		      tempExecuteCase.setClosingDate(ExcelFormVerification.parseDateCellToDate(row.getCell(15)));
		      tempExecuteCase.setClosingType(ExcelFormVerification.parseCellValueToString(row.getCell(16)));
		      tempExecuteCase.setDetailedClosingType(ExcelFormVerification.parseCellValueToString(row.getCell(17)));
		      tempExecuteCase.setShouldExecuteObject(ExcelFormVerification.parseCellValueToNumericString(row.getCell(18)));
		      tempExecuteCase.setExecutedObject(ExcelFormVerification.parseCellValueToNumericString(row.getCell(19)));
		      tempExecuteCase.setLimitDays(ExcelFormVerification.parseCellValueToNumericString(row.getCell(20)));
		      tempExecuteCase.setExecuteDays(ExcelFormVerification.parseCellValueToNumericString(row.getCell(21)));
		      tempExecuteCase.setFileDate(ExcelFormVerification.parseDateCellToDate(row.getCell(22)));
		      tempExecuteCase.setFilePeople(ExcelFormVerification.parseCellValueToString(row.getCell(23)));
		      tempExecuteCase.setCaseNo(ExcelFormVerification.parseCellValueToString(row.getCell(24)));
		      tempExecuteCase.setFirstCaseNo(ExcelFormVerification.parseCellValueToString(row.getCell(25)));
		      tempExecuteCase.setRegister(ExcelFormVerification.parseCellValueToString(row.getCell(26)));
		      tempExecuteCase.setCaseStartDate(ExcelFormVerification.parseDateCellToDate(row.getCell(27)));
		      tempExecuteCase.setReceiptDate(ExcelFormVerification.parseDateCellToDate(row.getCell(28)));
		      tempExecuteCase.setExecuteBasis(ExcelFormVerification.parseCellValueToString(row.getCell(29)));
		      tempExecuteCase.setCaseCause(ExcelFormVerification.parseCellValueToString(row.getCell(30)));
		      tempExecuteCase.setRealCaseCause(ExcelFormVerification.parseCellValueToString(row.getCell(31)));
		      tempExecuteCase.setFileSignedPeople(ExcelFormVerification.parseCellValueToString(row.getCell(32)));
		      tempExecuteCase.setRetentionTime(ExcelFormVerification.parseCellValueToString(row.getCell(33)));
		      tempExecuteCase.setFileItems(ExcelFormVerification.parseCellValueToString(row.getCell(34)));
		      tempExecuteCase.setRecoverResult(ExcelFormVerification.parseCellValueToString(row.getCell(35)));
		      tempExecuteCase.setPartyName(ExcelFormVerification.parseCellValueToString(row.getCell(36)));
		      tempExecuteCase.setExecuteStatus(ExcelFormVerification.parseCellValueToString(row.getCell(37)));
		      tempExecuteCase.setIdNo(ExcelFormVerification.parseCellValueToString(row.getCell(38)));
		      tempExecuteCase.setEntCode(ExcelFormVerification.parseCellValueToString(row.getCell(39)));
		      tempExecuteCase.setLegRep(ExcelFormVerification.parseCellValueToString(row.getCell(40)));
		      tempExecuteCase.setLoc(ExcelFormVerification.parseCellValueToString(row.getCell(41)));
		      tempExecuteCase.setTel(ExcelFormVerification.parseCellValueToString(row.getCell(42)));
		      tempExecuteCase.setDocumentNo(ExcelFormVerification.parseCellValueToString(row.getCell(43)));
		      
		      tempExecuteCase.setImportFrom(depName);
		      tempExecuteCase.setImportDate(new Date());
		      tempExecuteCase.setCorpid("");
		      i++;
		      row = sheet.getRow(i);
		      tempExecuteCaseList.add(tempExecuteCase);
		    }
		    
		  }else{
		    return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件","");
		  }
		}catch(Exception e){
			return UpfileMsgInfo.errMsgInfo(i, "数据格式错误","");
		}
		List<String> resultList = doGetTempExecuteCaseDao().insertBatch(tempExecuteCaseList);
		if(resultList.size()!=0)
			return UpfileMsgInfo.sucMsgInfo(resultList.size(), true);
		else
			return UpfileMsgInfo.sucMsgInfo(0,false);
	}
	public TempExecuteCaseDao doGetTempExecuteCaseDao()
	{
		return (TempExecuteCaseDao)hxBaseDao;
	}
}
