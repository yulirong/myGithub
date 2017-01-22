/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2016-01-08
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.temppolicepunish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.icinfo.creditinfo.bean.upload.temppolicepunish.TempPolicePunish;
import com.icinfo.creditinfo.dao.upload.temppolicepunish.TempPolicePunishDao;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.temppolicepunish.TempPolicePunishService;
/**
 * 
 * 描述: 案件信息 Service 实现<br>
 * @author liyafeng
 * @date 2016-01-08
 */
public class TempPolicePunishServiceImpl extends HxBaseServiceImpl<TempPolicePunish> implements TempPolicePunishService
{
	

	public TempPolicePunishDao doGetTempPolicePunishDao()
	{
		return (TempPolicePunishDao)hxBaseDao;
	}

	@Override
	public Map<String, Object> doBatchImportTempPolicePunishInfo(HSSFSheet sheet, String depName, String depCode)
			throws Exception {
		
		List<TempPolicePunish> tempPolicePunishList = new ArrayList<TempPolicePunish>();
		HSSFRow rowTitle = sheet.getRow(0);//标题行
		if("ZF330682004".equals(depCode)){
			int i = 1;
			Row row = sheet.getRow(i);// 创建ROW
			int rowNum = sheet.getLastRowNum();
			if (row == null) {
				return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
			}
			try {
				while (row != null && i <= rowNum) {
					TempPolicePunish tempPolicePunish = new TempPolicePunish();
					if (row.getCell(0) == null||row.getCell(0).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(0).toString()+"为空", "");
					if(ExcelFormVerification.isBlankCell(row.getCell(3))){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(3).toString()+"为空", "");
					}
					if(ExcelFormVerification.isBlankCell(row.getCell(10))){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(10).toString()+"为空", "");
					}
					tempPolicePunish.setSysNo(ExcelFormVerification.parseCellValueToString(row.getCell(0)));
					tempPolicePunish.setSusName(ExcelFormVerification.parseCellValueToString(row.getCell(1)));
					tempPolicePunish.setName(ExcelFormVerification.parseCellValueToString(row.getCell(1)));
					tempPolicePunish.setCertType(ExcelFormVerification.parseCellValueToString(row.getCell(2)));
					tempPolicePunish.setCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(3)));
					tempPolicePunish.setIdNo(ExcelFormVerification.parseCellValueToString(row.getCell(3)));
					tempPolicePunish.setProcessName(ExcelFormVerification.parseCellValueToString(row.getCell(4)));
					tempPolicePunish.setReason(ExcelFormVerification.parseCellValueToString(row.getCell(5)));
					tempPolicePunish.setJdswh(ExcelFormVerification.parseCellValueToString(row.getCell(6)));
					tempPolicePunish.setExecuteDate(ExcelFormVerification.parseCellValueToString(row.getCell(7)));
					tempPolicePunish.setExecuteEndDate(ExcelFormVerification.parseCellValueToString(row.getCell(8)));
					tempPolicePunish.setExecuteAddr(ExcelFormVerification.parseCellValueToString(row.getCell(9)));
					tempPolicePunish.setCaseNo(ExcelFormVerification.parseCellValueToString(row.getCell(10)));
					tempPolicePunish.setCaseName(ExcelFormVerification.parseCellValueToString(row.getCell(11)));
					tempPolicePunish.setBadw(ExcelFormVerification.parseCellValueToString(row.getCell(12)));
					tempPolicePunish.setImportFrom(depName);
					tempPolicePunish.setImportDate(new Date());
					i++;
					row = sheet.getRow(i);
					tempPolicePunishList.add(tempPolicePunish);
				}
			} catch (Exception e) {
				return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");
	
			}
		}else{
			return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");
		}
		doGetTempPolicePunishDao().insertBatch(tempPolicePunishList);
		return UpfileMsgInfo.sucMsgInfo(tempPolicePunishList.size(), true);
	}
}
