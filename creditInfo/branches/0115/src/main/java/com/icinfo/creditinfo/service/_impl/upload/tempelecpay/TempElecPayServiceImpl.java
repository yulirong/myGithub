/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempelecpay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.creditinfo.bean.upload.tempelecpay.TempElecPay;
import com.icinfo.creditinfo.bean.upload.templicense.TempLicense;
import com.icinfo.creditinfo.dao.upload.tempelecpay.TempElecPayDao;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.tempelecpay.TempElecPayService;
/**
 * 
 * 描述: 电力电费 Service 实现<br>
 * @author gaotong
 * @date 2015-11-12
 */
public class TempElecPayServiceImpl extends HxBaseServiceImpl<TempElecPay> implements TempElecPayService
{
	/**
	 * 描述：导入电力电费
	 * 
	 * @author gaotong
	 * @param sheet
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBatchImportTempElecPay(Sheet sheet,String deptName,String deptCode) throws Exception{
		List<TempElecPay> tempElecPayList=new ArrayList<TempElecPay>();
		/*List<String> elecNoList=new ArrayList<String>();*/
		if("ZF330682025".equals(deptCode)){
			Row rowTitle = sheet.getRow(0);//标题行
			int i=1;
			Row row = sheet.getRow(i);//创建ROW
			int rowNum = sheet.getLastRowNum();
			if (row == null) {
				return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
			}
			try {
				while(i<=rowNum){
				TempElecPay tempElecPay=new TempElecPay();
				if (ExcelFormVerification.isBlankCell(row.getCell(0)))
					return UpfileMsgInfo.errMsgInfo(i+1, "企业名称为空", "");
				if(ExcelFormVerification.isBlankCell(row.getCell(3))){
					return UpfileMsgInfo.errMsgInfo(i+1, "电力户号为空", "");
				}
				/*if(elecNoList.contains(tempElecPay.getElecNo())){
					return UpfileMsgInfo.errMsgInfo(i+1, "电力户号重复", "");
				}*/
				if(!ExcelFormVerification.isBlankCell(row.getCell(5))&&!ExcelFormVerification.isValidDate(row.getCell(5))){
					return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(5).toString()+"日期格式错误", "");
				}
				
				if(!ExcelFormVerification.isBlankCell(row.getCell(7))&&!ExcelFormVerification.isValidNumber(row.getCell(7))){
					return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(7).toString()+"数字格式错误", "");
				}
				
				if(!ExcelFormVerification.isBlankCell(row.getCell(8))&&!ExcelFormVerification.isValidNumber(row.getCell(8))){
					return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(8).toString()+"数字格式错误", "");
				}
				
				if(!ExcelFormVerification.isBlankCell(row.getCell(10))&&!ExcelFormVerification.isValidNumber(row.getCell(10))){
					return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(10).toString()+"数字格式错误", "");
				}
				tempElecPay.setEntName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));//企业名称
				tempElecPay.setRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(1)));//工商注册号
				tempElecPay.setEntLoc(ExcelFormVerification.parseCellValueToString(row.getCell(2)));//经营地点
				tempElecPay.setElecNo(ExcelFormVerification.parseCellValueToString(row.getCell(3)));//电力户号
				tempElecPay.setUserType(ExcelFormVerification.parseCellValueToString(row.getCell(4)));//用户类型
				tempElecPay.setRecordDate(ExcelFormVerification.parseDateCellToString(row.getCell(5)));//抄表时间
				tempElecPay.setElecPeriod(ExcelFormVerification.parseCellValueToString(row.getCell(6)));//用电所属期
				tempElecPay.setElecConsumption(ExcelFormVerification.parseCellValueToNumericString(row.getCell(7)));//用电量
				tempElecPay.setElecPayAmount(ExcelFormVerification.parseCellValueToNumericString(row.getCell(8)));//用电金额
				tempElecPay.setPayDate(ExcelFormVerification.parseCellValueToString(row.getCell(9)));//缴费日期
				tempElecPay.setPayAmount(ExcelFormVerification.parseCellValueToNumericString(row.getCell(10)));//缴费金额
				tempElecPay.setOrgCode(ExcelFormVerification.parseCellValueToString(row.getCell(11)));//组织机构代码
				tempElecPay.setUnscCode(ExcelFormVerification.parseCellValueToString(row.getCell(12)));//统一信用代码
				tempElecPay.setImportFrom(deptName);
				tempElecPay.setImportDate(new Date());
				tempElecPay.setCorpid("");
				i++;
				row = sheet.getRow(i);
				tempElecPayList.add(tempElecPay);
				/*elecNoList.add(tempElecPay.getElecNo());*/
				}
			} catch (Exception e) {
				return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");
			} 
		}else{
			return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");
		}	
		doGetTempElecPayDao().insertBatch(tempElecPayList);
		return UpfileMsgInfo.sucMsgInfo(tempElecPayList.size(), true);
	}


	public TempElecPayDao doGetTempElecPayDao()
	{
		return (TempElecPayDao)hxBaseDao;
	}
}
