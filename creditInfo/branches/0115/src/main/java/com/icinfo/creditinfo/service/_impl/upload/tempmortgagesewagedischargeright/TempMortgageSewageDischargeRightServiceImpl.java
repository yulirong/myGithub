/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempmortgagesewagedischargeright;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import com.icinfo.creditinfo.bean.upload.tempmortgagesewagedischargeright.TempMortgageSewageDischargeRight;
import com.icinfo.creditinfo.dao.upload.tempmortgagesewagedischargeright.TempMortgageSewageDischargeRightDao;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.tempmortgagesewagedischargeright.TempMortgageSewageDischargeRightService;
/**
 * 
 * 描述: 环保排污权抵押 Service 实现<br>
 * @author gaotong
 * @date 2015-11-12
 */
public class TempMortgageSewageDischargeRightServiceImpl extends HxBaseServiceImpl<TempMortgageSewageDischargeRight> implements TempMortgageSewageDischargeRightService
{
	

	public TempMortgageSewageDischargeRightDao doGetTempMortgageSewageDischargeRightDao()
	{
		return (TempMortgageSewageDischargeRightDao)hxBaseDao;
	}
	/**
     * 
     * 描述: 排污权抵押
     * @author yulirong
     * @date 2015年12月23日 
     * @param sheet
     * @return
     * @throws Exception
     */
	public Map<String, Object> doBatchImportTempMortgageSewageDischargeRightInfo(HSSFSheet sheet,String depName,String depCode) throws Exception{
		List<TempMortgageSewageDischargeRight> tempMortgageSewageDischargeRightList = new ArrayList<TempMortgageSewageDischargeRight>();
		HSSFRow rowTitle = sheet.getRow(0);
		int i = 1;
		Row row = sheet.getRow(i);// 创建ROW
		int rowNum = sheet.getLastRowNum();
		
		try {
			if("ZF330682009".equals(depCode)){//环保局
				if (row == null) {
					return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
				}
				while (i <= rowNum) {
					if(row.getCell(0) == null || row.getCell(0).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(0)+"不能为空", "");
					if(row.getCell(1) == null || row.getCell(1).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(1)+"不能为空", "");
					if(row.getCell(2) == null || row.getCell(2).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2)+"不能为空", "");
					if(row.getCell(3) != null && !ExcelFormVerification.isValidNumber(row.getCell(3)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(3)+"数字格式不对", "");
					if(row.getCell(4) != null && !ExcelFormVerification.isValidNumber(row.getCell(4)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(4)+"数字格式不对", "");
					if(row.getCell(5) != null && !ExcelFormVerification.isValidNumber(row.getCell(5)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(5)+"数字格式不对", "");
					if(row.getCell(9) != null && !ExcelFormVerification.isValidDate(row.getCell(9)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(9)+"日期格式不对", "");
					TempMortgageSewageDischargeRight tempMortgageSewageDischargeRight = doSetTempMortgageSewageDischargeRight(depName, row);
					i++;
					row = sheet.getRow(i);
					tempMortgageSewageDischargeRightList.add(tempMortgageSewageDischargeRight);
				}
			}
			else{
				return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");
			}
			
		} catch (Exception e) {
			return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误","");
		}
		doGetTempMortgageSewageDischargeRightDao().insertBatch(tempMortgageSewageDischargeRightList);
		return UpfileMsgInfo.sucMsgInfo(tempMortgageSewageDischargeRightList.size(), true);
	}
	/**
	 * 
	 * @param depName
	 * @param row
	 * @return
	 */
	private TempMortgageSewageDischargeRight doSetTempMortgageSewageDischargeRight(String depName, Row row) {
		TempMortgageSewageDischargeRight tempMortgageSewageDischargeRight = new TempMortgageSewageDischargeRight();
		tempMortgageSewageDischargeRight.setMortgagorName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));//抵押人名称
		tempMortgageSewageDischargeRight.setMortgageeName(ExcelFormVerification.parseCellValueToString(row.getCell(1)));//抵押权人名称
		tempMortgageSewageDischargeRight.setGuaranty(ExcelFormVerification.parseCellValueToString(row.getCell(2)));//抵押物名称
		tempMortgageSewageDischargeRight.setMortgageWastewaterAmount(ExcelFormVerification.parseCellValueToBigDecimal(row.getCell(3)));//抵押废水数量（吨/日）
		tempMortgageSewageDischargeRight.setMortgageSo2Amount(ExcelFormVerification.parseCellValueToBigDecimal(row.getCell(4)));//抵押二氧化硫数量（吨/年）
		tempMortgageSewageDischargeRight.setMortgageNoAmount(ExcelFormVerification.parseCellValueToBigDecimal(row.getCell(5)));//抵押氮氧化物数量（吨/年）
		tempMortgageSewageDischargeRight.setGuarantyNo(ExcelFormVerification.parseCellValueToString(row.getCell(6)));//抵押物权证编号
		tempMortgageSewageDischargeRight.setDebtPayDate(ExcelFormVerification.parseCellValueToString(row.getCell(7)));//债务人履行债务期限（起止时间）
		tempMortgageSewageDischargeRight.setRegOrg(ExcelFormVerification.parseCellValueToString(row.getCell(8)));//登记机关
		tempMortgageSewageDischargeRight.setRegDate(ExcelFormVerification.parseDateCellToDate(row.getCell(9)));//登记时间
		tempMortgageSewageDischargeRight.setOrgCode(ExcelFormVerification.parseCellValueToString(row.getCell(10)));//抵押人组织机构代码
		tempMortgageSewageDischargeRight.setUnscCode(ExcelFormVerification.parseCellValueToString(row.getCell(11)));//抵押人统一信用代码
		tempMortgageSewageDischargeRight.setImportFrom(depName);
		tempMortgageSewageDischargeRight.setImportDate(new Date());
		return tempMortgageSewageDischargeRight;
	}
}
