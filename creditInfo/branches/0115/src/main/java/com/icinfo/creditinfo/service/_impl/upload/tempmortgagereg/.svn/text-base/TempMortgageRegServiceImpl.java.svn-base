/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempmortgagereg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.icinfo.creditinfo.bean.upload.tempmortgagereg.TempMortgageReg;
import com.icinfo.creditinfo.dao.upload.tempmortgagereg.TempMortgageRegDao;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.tempmortgagereg.TempMortgageRegService;
/**
 * 
 * 描述: 抵押登记 Service 实现<br>
 * @author gaotong
 * @date 2015-11-12
 */
public class TempMortgageRegServiceImpl extends HxBaseServiceImpl<TempMortgageReg> implements TempMortgageRegService
{
	

	public TempMortgageRegDao doGetTempMortgageRegDao()
	{
		return (TempMortgageRegDao)hxBaseDao;
	}
	
	/**
     * 
     * 描述: 抵押登记
     * @author yulirong
     * @date 2015年12月22日 
     * @param sheet
     * @return
     * @throws Exception
     */
	public Map<String, Object> doBatchImportTempMortgageRegInfo(HSSFSheet sheet,String depName,String depCode) throws Exception{
		List<TempMortgageReg> tempMortgageRegList = new ArrayList<TempMortgageReg>();
		HSSFRow rowTitle = sheet.getRow(0);
		int i = 1;
		Row row = sheet.getRow(i);// 创建ROW
		int rowNum = sheet.getLastRowNum();
		if (row == null) {
			return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
		}
		try {
			if("ZF330682028".equals(depCode)){//公证处
				while (i <= rowNum) {
					if(row.getCell(1) != null && !ExcelFormVerification.isValidDate(row.getCell(1)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(1)+"日期格式错误", "");
					/*if(row.getCell(2) == null || row.getCell(2).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2).toString()+"不能为空", "");*/
					if(row.getCell(6) != null && !ExcelFormVerification.isValidDate(row.getCell(6)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(6)+"日期格式错误", "");
					if(row.getCell(7) != null && !ExcelFormVerification.isValidDate(row.getCell(7)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(7)+"日期格式错误", "");
					if(row.getCell(8) == null || row.getCell(8).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(8).toString()+"不能为空", "");
					if(row.getCell(12) == null || row.getCell(12).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(12).toString()+"不能为空", "");
					if(row.getCell(16) != null && !ExcelFormVerification.isValidNumber(row.getCell(16)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(16)+"数字类型错误", "");
					if(!ExcelFormVerification.isAssignLenStr(row.getCell(10), 100))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(10)+"超过数据库限定长度","");
					if(!ExcelFormVerification.isAssignLenStr(row.getCell(14), 100))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(14)+"超过数据库限定长度","");
					TempMortgageReg tempMortgageReg = doSetTempMortgageReg(depName, row);
					i++;
					row = sheet.getRow(i);
					tempMortgageRegList.add(tempMortgageReg);
				}
			}
			else if("ZF330682005".equals(depCode)){//国土资源局
				while (i <= rowNum) {
					if(row.getCell(0) !=null && !ExcelFormVerification.isValidDate(row.getCell(0)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(0)+"日期格式错误","");
					if(row.getCell(2)!=null&&!row.getCell(2).toString().contains("至"))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2)+" 格式错误（2015/1/1至2015/2/2）","");
					if(row.getCell(10) != null && !ExcelFormVerification.isValidNumber(row.getCell(10)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(10)+"数字格式错误","");
					if(row.getCell(11) != null && !ExcelFormVerification.isValidNumber(row.getCell(11)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(11)+"数字格式错误","");
					if(!ExcelFormVerification.isAssignLenStr(row.getCell(5), 100))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(5)+"超过数据库限定长度","");
					if(!ExcelFormVerification.isAssignLenStr(row.getCell(9), 100))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(9)+"超过数据库限定长度","");
					TempMortgageReg tempMortgageReg = doSetTempMortgageRegForGtzyj(depName, row);
					i++;
					row = sheet.getRow(i);
					tempMortgageRegList.add(tempMortgageReg);
				}
			}else{
				return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");
			}
			
		}catch (Exception e) {
			return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误","");
		}
		doGetTempMortgageRegDao().insertBatch(tempMortgageRegList);
		return UpfileMsgInfo.sucMsgInfo(tempMortgageRegList.size(), true);
	}

	private TempMortgageReg doSetTempMortgageRegForGtzyj(String depName, Row row) {
		TempMortgageReg tempMortgageReg = new TempMortgageReg();
		tempMortgageReg.setMortgageRegDate(ExcelFormVerification.parseDateCellToDate(row.getCell(0)));//抵押登记日期
		tempMortgageReg.setMortgageCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(1)));//抵押证编号
		tempMortgageReg.setDebtPayFrom(row.getCell(2) == null ? null : HxDateUtil.stringToDate(row.getCell(2).toString().split("至")[0], "yyyy-MM-dd"));//债务人履行债务期限起
		tempMortgageReg.setDebtPayTo(row.getCell(2) == null ? null : HxDateUtil.stringToDate(row.getCell(2).toString().split("至")[1], "yyyy-MM-dd"));//债务人履行债务期限止
		tempMortgageReg.setMortgagorName(ExcelFormVerification.parseCellValueToString(row.getCell(3)));//抵押人名称
		
		tempMortgageReg.setMortgagorCertType(ExcelFormVerification.parseCellValueToString(row.getCell(4)));//抵押人证件类型
		tempMortgageReg.setMortgagorCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(5)));//抵押人证件号码
		tempMortgageReg.setMortgagorAdd(ExcelFormVerification.parseCellValueToString(row.getCell(6)));//抵押人地址
		tempMortgageReg.setMortgageeName(ExcelFormVerification.parseCellValueToString(row.getCell(7)));//抵押权人名称
		tempMortgageReg.setMortgageeCertType(ExcelFormVerification.parseCellValueToString(row.getCell(8)));//抵押权人证件类型
		
		tempMortgageReg.setMortgageeCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(9)));//抵押权人证件号
		tempMortgageReg.setMortgageMoney(ExcelFormVerification.parseCellValueToNumericString(row.getCell(10)));//抵押金额
		tempMortgageReg.setLandMoney(ExcelFormVerification.parseCellValueToNumericString(row.getCell(11)));//土地价格
		tempMortgageReg.setMortgageOrder(ExcelFormVerification.parseCellValueToString(row.getCell(12)));//抵押顺序
		tempMortgageReg.setImportFrom(depName);
		tempMortgageReg.setImportDate(new Date());
		return tempMortgageReg;
	}

	private TempMortgageReg doSetTempMortgageReg(String depName, Row row) {
		TempMortgageReg tempMortgageReg = new TempMortgageReg();
		tempMortgageReg.setMortgageRegOrg(ExcelFormVerification.parseCellValueToString(row.getCell(0)));//抵押登记机关
		tempMortgageReg.setMortgageRegDate(ExcelFormVerification.parseDateCellToDate(row.getCell(1)));//抵押登记日期
		tempMortgageReg.setMortgageCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(2)));//抵押证编号
		tempMortgageReg.setMortgageContractNo(ExcelFormVerification.parseCellValueToString(row.getCell(3)));//抵押合同编号
		tempMortgageReg.setCollateralType(ExcelFormVerification.parseCellValueToString(row.getCell(4)));//抵押物类型
		
		tempMortgageReg.setMortgageGuarExtent(ExcelFormVerification.parseCellValueToString(row.getCell(5)));//抵押担保范围
		tempMortgageReg.setDebtPayFrom(ExcelFormVerification.parseDateCellToDate(row.getCell(6)));//债务人履行债务期限起始日期
		tempMortgageReg.setDebtPayTo(ExcelFormVerification.parseDateCellToDate(row.getCell(7)));//债务人履行债务期限截止日期
		tempMortgageReg.setMortgagorName(ExcelFormVerification.parseCellValueToString(row.getCell(8)));//抵押人名称
		tempMortgageReg.setMortgagorCertType(ExcelFormVerification.parseCellValueToString(row.getCell(9)));//抵押人证件类型
		
		tempMortgageReg.setMortgagorCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(10)));//抵押人证件号
		tempMortgageReg.setMortgagorLegRep(ExcelFormVerification.parseCellValueToString(row.getCell(11)));//抵押人法定代表人
		tempMortgageReg.setMortgageeName(ExcelFormVerification.parseCellValueToString(row.getCell(12)));//抵押权人名称
		tempMortgageReg.setMortgageeCertType(ExcelFormVerification.parseCellValueToString(row.getCell(13)));//抵押权人证件类型
		tempMortgageReg.setMortgageeCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(14)));//抵押权人证件号
		
		tempMortgageReg.setMortgageeLegRep(ExcelFormVerification.parseCellValueToString(row.getCell(15)));//抵押权人法定代表人
		tempMortgageReg.setGuaranteedCreditAmount(ExcelFormVerification.parseCellValueToBigDecimal(row.getCell(16)));//被担保主债权数额
		tempMortgageReg.setMortgageReason(ExcelFormVerification.parseCellValueToString(row.getCell(17)));//抵押原因
		tempMortgageReg.setGuaranteedCreditType(ExcelFormVerification.parseCellValueToString(row.getCell(18)));//被担保主债权种类
		tempMortgageReg.setGuaranteedContractType(ExcelFormVerification.parseCellValueToString(row.getCell(19)));//被担保主合同种类
		tempMortgageReg.setImportFrom(depName);
		tempMortgageReg.setImportDate(new Date());
		return tempMortgageReg;
	}
}
