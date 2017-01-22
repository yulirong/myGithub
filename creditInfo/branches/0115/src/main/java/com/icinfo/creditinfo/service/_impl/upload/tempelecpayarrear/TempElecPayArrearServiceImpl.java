/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempelecpayarrear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.creditinfo.bean.upload.tempelecpayarrear.TempElecPayArrear;
import com.icinfo.creditinfo.dao.upload.tempelecpayarrear.TempElecPayArrearDao;
import com.icinfo.creditinfo.service.upload.tempelecpayarrear.TempElecPayArrearService;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
/**
 * 
 * 描述: 电力欠费 Service 实现<br>
 * @author gaotong
 * @date 2015-11-12
 */
public class TempElecPayArrearServiceImpl extends HxBaseServiceImpl<TempElecPayArrear> implements TempElecPayArrearService
{
	
	/**
	 * 描述：导入电力欠费
	 * 
	 * @author gaotong
	 * @param sheet
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBatchImportTempElecPayArrear(Sheet sheet,String deptName,String deptCode) throws Exception{
		List<TempElecPayArrear> tempElecPayArrearList=new ArrayList<TempElecPayArrear>();
		/*List<String> elecNoList=new ArrayList<String>();*/
		if("ZF330682025".equals(deptCode)){
			Row rowTitle = sheet.getRow(0);//标题行
			int i=1;
			Row row = sheet.getRow(i);//创建ROW
			int rowNum = sheet.getLastRowNum();
			if (row == null) {
				return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
			}
			try{
				while(i<=rowNum){
			    TempElecPayArrear tempElecPayArrear=new TempElecPayArrear();	
				if (ExcelFormVerification.isBlankCell(row.getCell(0)))
					return UpfileMsgInfo.errMsgInfo(i+1, "企业名称为空", "");
				
				if(ExcelFormVerification.isBlankCell(row.getCell(3))){
					return UpfileMsgInfo.errMsgInfo(i+1, "电力户号为空", "");
				}
				
				/*if(elecNoList.contains(tempElecPayArrear.getElecNo())){
					return UpfileMsgInfo.errMsgInfo(i+1, "电力户号重复", "");
				}*/
				
				if(!ExcelFormVerification.isBlankCell(row.getCell(6))&&!ExcelFormVerification.isValidNumber(row.getCell(6))){
					return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(6).toString()+"数字格式错误", "");
				}
				tempElecPayArrear.setEntName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));//企业名称
				tempElecPayArrear.setRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(1)));//工商注册号
				tempElecPayArrear.setEntLoc(ExcelFormVerification.parseCellValueToString(row.getCell(2)));//经营地点
				tempElecPayArrear.setElecNo(ExcelFormVerification.parseCellValueToString(row.getCell(3)));//电力户号
				tempElecPayArrear.setUserType(ExcelFormVerification.parseCellValueToString(row.getCell(4)));//用户类型
				tempElecPayArrear.setArrearPeriod(ExcelFormVerification.parseCellValueToString(row.getCell(5)));//欠费所属期
				tempElecPayArrear.setArrearBalance(ExcelFormVerification.parseCellValueToNumericString(row.getCell(6)));//欠费余额
				tempElecPayArrear.setOrgCode(ExcelFormVerification.parseCellValueToString(row.getCell(7)));//组织机构代码
				tempElecPayArrear.setUnscCode(ExcelFormVerification.parseCellValueToString(row.getCell(8)));//统一信用代码
				tempElecPayArrear.setImportFrom(deptName);
				tempElecPayArrear.setImportDate(new Date());
				tempElecPayArrear.setCorpid("");
				i++;
				row = sheet.getRow(i);
				
				tempElecPayArrearList.add(tempElecPayArrear);
				/*elecNoList.add(tempElecPayArrear.getElecNo());*/
				} 
			}catch(Exception e){
				return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");
			}
		}else{
			return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");
		}	
		doGetTempElecPayArrearDao().insertBatch(tempElecPayArrearList);
		return UpfileMsgInfo.sucMsgInfo(tempElecPayArrearList.size(), true);	}


	public TempElecPayArrearDao doGetTempElecPayArrearDao()
	{
		return (TempElecPayArrearDao)hxBaseDao;
	}
}
