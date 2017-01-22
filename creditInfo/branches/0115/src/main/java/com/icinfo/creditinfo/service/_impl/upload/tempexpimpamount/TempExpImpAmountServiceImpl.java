/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempexpimpamount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.icinfo.creditinfo.bean.upload.tempexpimpamount.TempExpImpAmount;
import com.icinfo.creditinfo.dao.upload.tempexpimpamount.TempExpImpAmountDao;
import com.icinfo.creditinfo.service.upload.tempexpimpamount.TempExpImpAmountService;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;

/**
 * 
 * 描述: 进出口量 Service 实现<br>
 * 
 * @author liyafeng
 * @date 2015-11-11
 */
public class TempExpImpAmountServiceImpl extends HxBaseServiceImpl<TempExpImpAmount>
		implements TempExpImpAmountService {

	public TempExpImpAmountDao doGetTempExpImpAmountDao() {
		return (TempExpImpAmountDao) hxBaseDao;
	}

	/**
	 * 
	 * 描述: 导入进出口量
	 * 
	 * @author LiYaFeng
	 * @date 2015年11月11日
	 * @param sheet
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> doBatchImportTempExpImpAmountInfo(HSSFSheet sheet,String deptName,String deptCode) throws Exception {
		List<TempExpImpAmount> tempExpImpAmountList = new ArrayList<TempExpImpAmount>();
		/*List<String> entNameList = new ArrayList<String>();*/
		if("ZF330682023".equals(deptCode)){//商务局
			HSSFRow rowTitle = sheet.getRow(0);//标题行
			int i = 1;
			Row row = sheet.getRow(i);// 创建ROW
			int rowNum = sheet.getLastRowNum();
			if (row == null) {
				return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
			}
			try {
				while (i <= rowNum) {
					TempExpImpAmount tempExpImpAmount = new TempExpImpAmount();
					if (ExcelFormVerification.isBlankCell(row.getCell(0)))
						return UpfileMsgInfo.errMsgInfo(i+1, "公司名称为空", "");
					
					/*if (entNameList.contains(tempExpImpAmount.getEntName())) {
						return UpfileMsgInfo.errMsgInfo(i+1, "公司名称重复", "");
					}*/
					
					if(!ExcelFormVerification.isBlankCell(row.getCell(2))&&!ExcelFormVerification.isValidDate(row.getCell(2))){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2).toString()+"日期格式错误", "");
					}
					
					if(!ExcelFormVerification.isBlankCell(row.getCell(3))&&!ExcelFormVerification.isValidNumber(row.getCell(3))){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(3).toString()+"数字格式错误", "");
					}
					
					if(!ExcelFormVerification.isBlankCell(row.getCell(4))&&!ExcelFormVerification.isValidNumber(row.getCell(4))){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(4).toString()+"数字格式错误", "");
					}
					tempExpImpAmount.setEntName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));//企业名称
					tempExpImpAmount.setCustomsRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(1)));//海关代码
					tempExpImpAmount.setDate(ExcelFormVerification.parseDateCellToDate(row.getCell(2)) );//时间
					tempExpImpAmount.setMonthExpAmount(
							ExcelFormVerification.parseCellValueToBigDecimal(row.getCell(3)));//当月出口金额
					tempExpImpAmount.setMonthImpAmount(
							ExcelFormVerification.parseCellValueToBigDecimal(row.getCell(4)));//当月进口金额
					tempExpImpAmount.setOrgCode(ExcelFormVerification.parseCellValueToString(row.getCell(5)));//组织机构代码
					tempExpImpAmount.setUnscCode(ExcelFormVerification.parseCellValueToString(row.getCell(6)));//统一信用代码
					tempExpImpAmount.setImportFrom(deptName);
					tempExpImpAmount.setImportDate(new Date());
					tempExpImpAmount.setCorpid("");
					i++;
					row = sheet.getRow(i);
					tempExpImpAmountList.add(tempExpImpAmount);
					/*entNameList.add(tempExpImpAmount.getEntName());*/
				}
			} catch (Exception e) {
				return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");
			}
		}else{
			return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");
		}	
		doGetTempExpImpAmountDao().insertBatch(tempExpImpAmountList);
		return UpfileMsgInfo.sucMsgInfo(tempExpImpAmountList.size(), true);
	}
}
