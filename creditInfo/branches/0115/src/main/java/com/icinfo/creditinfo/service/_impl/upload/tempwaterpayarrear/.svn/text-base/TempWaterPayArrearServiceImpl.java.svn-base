/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempwaterpayarrear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.icinfo.creditinfo.bean.upload.tempwaterpayarrear.TempWaterPayArrear;
import com.icinfo.creditinfo.dao.upload.tempwaterpayarrear.TempWaterPayArrearDao;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.tempwaterpayarrear.TempWaterPayArrearService;
/**
 * 
 * 描述: 水费欠费 Service 实现<br>
 * @author liyafeng
 * @date 2015-11-12
 */
public class TempWaterPayArrearServiceImpl extends HxBaseServiceImpl<TempWaterPayArrear> implements TempWaterPayArrearService
{
	

	public TempWaterPayArrearDao doGetTempWaterPayArrearDao()
	{
		return (TempWaterPayArrearDao)hxBaseDao;
	}
    /**
     * 
     * 描述: 导入水费欠费信息
     * @author  LiYaFeng
     * @date 2015年11月12日 
     * @param sheet
     * @return
     * @throws Exception
     */
	@Override
	public Map<String, Object> doBatchImportTempWaterPayArrearInfo(HSSFSheet sheet,String deptName,String depCode) throws Exception {
		List<TempWaterPayArrear>  tempWaterPayArrearList=new ArrayList<TempWaterPayArrear>();
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
		    	if(ExcelFormVerification.isBlankCell(row.getCell(4))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(4).toString()+"为空", "");
		    	if(!ExcelFormVerification.isBlankCell(row.getCell(4))&&!ExcelFormVerification.isValidDate(row.getCell(4))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(4).toString()+"格式不正确", "");
		    	if(!ExcelFormVerification.isBlankCell(row.getCell(5))&&!ExcelFormVerification.isValidNumber(row.getCell(5))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(5).toString()+"格式不正确", "");
		    	
		    	TempWaterPayArrear tempWaterPayArrear=new TempWaterPayArrear();
		    	tempWaterPayArrear.setEntName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));
		    	tempWaterPayArrear.setRegNo("");
		    	tempWaterPayArrear.setEntLoc(ExcelFormVerification.parseCellValueToString(row.getCell(1)));
		    	tempWaterPayArrear.setWaterNo(ExcelFormVerification.parseCellValueToString(row.getCell(2)));
		    	tempWaterPayArrear.setUserType(ExcelFormVerification.parseCellValueToString(row.getCell(3)));
		    	tempWaterPayArrear.setArrearPeriod(ExcelFormVerification.parseDateCellToDate(row.getCell(4)));
		    	tempWaterPayArrear.setArrearBalance(ExcelFormVerification.parseCellValueToNumericString(row.getCell(5)));	
		    	tempWaterPayArrear.setOrgCode(ExcelFormVerification.parseCellValueToString(row.getCell(6)));
		    	tempWaterPayArrear.setUnscCode(ExcelFormVerification.parseCellValueToString(row.getCell(7)));
		    	tempWaterPayArrear.setImportFrom(deptName);
		    	tempWaterPayArrear.setImportDate(new Date());
		    	tempWaterPayArrear.setCorpid("");
		    	i++;
		    	row = sheet.getRow(i);
		    	tempWaterPayArrearList.add(tempWaterPayArrear);
		    }
		    
		  }else{
		   return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件","");
		  }
		} catch (Exception e) {
			return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");
		}
		  List<String> resultList = doGetTempWaterPayArrearDao().insertBatch(tempWaterPayArrearList);
		  if(resultList.size()!=0)
				return UpfileMsgInfo.sucMsgInfo(resultList.size(), true);
			else
				return UpfileMsgInfo.sucMsgInfo(0,false);
	}
}
