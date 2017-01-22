/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempbaseinfotax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.creditinfo.bean.upload.tempbaseinfotax.TempBaseInfoTax;
import com.icinfo.creditinfo.dao.upload.tempbaseinfotax.TempBaseInfoTaxDao;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.tempbaseinfotax.TempBaseInfoTaxService;
/**
 * 
 * 描述: 企业基本信息 Service 实现<br>
 * @author gaotong
 * @date 2015-11-11
 */
public class TempBaseInfoTaxServiceImpl extends HxBaseServiceImpl<TempBaseInfoTax> implements TempBaseInfoTaxService
{
	public TempBaseInfoTaxDao doGetTempBaseInfoTaxDao()
	{
		return (TempBaseInfoTaxDao)hxBaseDao;
	}
	public Map<String,Object> doBatchImportTempBaseInfoTax(Sheet sheet,
			String deptName,String deptCode) throws Exception {
		List<TempBaseInfoTax> tempBaseInfoTaxList=new ArrayList<TempBaseInfoTax>();
		List<String> entNameList = new ArrayList<String>();
		Row rowTitle = sheet.getRow(0);//标题行
		int i = 1;
		Row row = sheet.getRow(i);//创建ROW
		int rowNum = sheet.getLastRowNum();
		if (row == null) {
			return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
		}
			try{
				while(i <= rowNum){
					TempBaseInfoTax tempBaseInfoTax=new TempBaseInfoTax();
					if("ZF330682002".equals(deptCode)){//地税
						if (ExcelFormVerification.isBlankCell(row.getCell(0)))
							return UpfileMsgInfo.errMsgInfo(i+1, "企业名称为空", "");
						tempBaseInfoTax.setEntName(row.getCell(0).toString());//企业名称
						if (entNameList.contains(tempBaseInfoTax.getEntName())) {
							return UpfileMsgInfo.errMsgInfo(i+1, "企业名称重复", "");
						}
						if(!ExcelFormVerification.isBlankCell(row.getCell(5))&&!ExcelFormVerification.isValidDate(row.getCell(5))){
							return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(5).toString()+"日期格式错误", "");
						}
					
						if(ExcelFormVerification.isBlankCell(row.getCell(9))){
							return UpfileMsgInfo.errMsgInfo(i+1, "证件号为空", "");
						}
						
						if(!ExcelFormVerification.isBlankCell(row.getCell(10))&&!ExcelFormVerification.isValidNumber(row.getCell(10))){
							return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(10).toString()+"数字格式错误", "");
						}
						tempBaseInfoTax.setTaxRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(1)));//税务登记证
						tempBaseInfoTax.setRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(2)));//工商注册号
						tempBaseInfoTax.setOrgRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(3)));//组织结构代码证
						tempBaseInfoTax.setSiNo(ExcelFormVerification.parseCellValueToString(row.getCell(4)));//税务内部编码
						tempBaseInfoTax.setEstDate(ExcelFormVerification.parseDateCellToDate(row.getCell(5)));//成立日期
						tempBaseInfoTax.setEntLoc(ExcelFormVerification.parseCellValueToString(row.getCell(6)));//经营地点
						tempBaseInfoTax.setLegRep(ExcelFormVerification.parseCellValueToString(row.getCell(7)));//法定代表人
						tempBaseInfoTax.setCertType(ExcelFormVerification.parseCellValueToString(row.getCell(8)));//证件类型
						tempBaseInfoTax.setCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(9)));//证件号
						tempBaseInfoTax.setRegCap(ExcelFormVerification.parseCellValueToBigDecimal(row.getCell(10)));//注册资本
						tempBaseInfoTax.setUnscCode(ExcelFormVerification.parseCellValueToString(row.getCell(11)));//统一信用代码
						tempBaseInfoTax.setImportFrom(deptName);
						tempBaseInfoTax.setImportDate(new Date());
						tempBaseInfoTax.setCorpid("");
					}else if("ZF330682001".equals(deptCode)){//国税
						if (ExcelFormVerification.isBlankCell(row.getCell(0)))
							return UpfileMsgInfo.errMsgInfo(i+1, "企业名称为空", "");
						tempBaseInfoTax.setEntName(row.getCell(0).toString());//企业名称
						if (entNameList.contains(tempBaseInfoTax.getEntName())) {
							return UpfileMsgInfo.errMsgInfo(i+1, "企业名称重复", "");
						}
						if(!ExcelFormVerification.isBlankCell(row.getCell(4))&&!ExcelFormVerification.isValidDate(row.getCell(4))){
							return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(4).toString()+"日期格式错误", "");
						}
						if(ExcelFormVerification.isBlankCell(row.getCell(8))){
							return UpfileMsgInfo.errMsgInfo(i+1, "证件号为空", "");
						}
						if(!ExcelFormVerification.isBlankCell(row.getCell(9))&&!ExcelFormVerification.isValidNumber(row.getCell(9))){
							return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(9).toString()+"数字格式错误", "");
						}
						tempBaseInfoTax.setTaxRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(1)));//税务登记证
						tempBaseInfoTax.setRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(2)));//工商注册号
						tempBaseInfoTax.setOrgRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(3)));//组织结构代码证
						tempBaseInfoTax.setEstDate(ExcelFormVerification.parseDateCellToDate(row.getCell(4)));//成立日期
						tempBaseInfoTax.setEntLoc(ExcelFormVerification.parseCellValueToString(row.getCell(5)));//经营地点
						tempBaseInfoTax.setLegRep(ExcelFormVerification.parseCellValueToString(row.getCell(6)));//法定代表人
						tempBaseInfoTax.setCertType(ExcelFormVerification.parseCellValueToString(row.getCell(7)));//证件类型
						tempBaseInfoTax.setCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(8)));//证件号
						tempBaseInfoTax.setRegCap(ExcelFormVerification.parseCellValueToBigDecimal(row.getCell(9)));//注册资本
						tempBaseInfoTax.setUnscCode(ExcelFormVerification.parseCellValueToString(row.getCell(10)));//统一信用代码
						tempBaseInfoTax.setImportFrom(deptName);
						tempBaseInfoTax.setImportDate(new Date());
						tempBaseInfoTax.setCorpid("");
					}else{
						return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");
					}
					tempBaseInfoTaxList.add(tempBaseInfoTax);
					entNameList.add(tempBaseInfoTax.getEntName());
					i++;
					row = sheet.getRow(i);
				} 
			} catch (Exception e) {
				return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");

			} 
		doGetTempBaseInfoTaxDao().insertBatch(tempBaseInfoTaxList);
		return UpfileMsgInfo.sucMsgInfo(tempBaseInfoTaxList.size(), true);
	}
}
