/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.temptaxpay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.creditinfo.bean.upload.temptaxpay.TempTaxPay;
import com.icinfo.creditinfo.dao.upload.temptaxpay.TempTaxPayDao;
import com.icinfo.creditinfo.service.upload.temptaxpay.TempTaxPayService;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
/**
 * 
 * 描述: 税费缴税 Service 实现<br>
 * @author gaotong
 * @date 2015-11-11
 */
public class TempTaxPayServiceImpl extends HxBaseServiceImpl<TempTaxPay> implements TempTaxPayService
{
    /**
     * 
     * 描述: 导入税收信息
     * @author  gaotong
     * @date 2015年11月11日 
     * @param sheet,taxType
     * @return
     * @throws Exception 
     */
	public Map<String,Object> doBatchImportTempTaxPay(Sheet sheet,String deptName,String deptCode) throws Exception{
		List<TempTaxPay> tempTaxPayList=new ArrayList<TempTaxPay>();
		if("ZF330682002".equals(deptCode)||"ZF330682001".equals(deptCode)){//地税或国税
			Row rowTitle = sheet.getRow(0);//标题行
			int i = 1;
			Row row = sheet.getRow(i);//创建ROW
			int rowNum = sheet.getLastRowNum();
			if (row == null) {
				return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
			}
			try{
				while(i <= rowNum){
					TempTaxPay tempTaxPay=new TempTaxPay();
					if (ExcelFormVerification.isBlankCell(row.getCell(0)))
						return UpfileMsgInfo.errMsgInfo(i+1, "企业名称为空", "");
					if(!ExcelFormVerification.isBlankCell(row.getCell(3))&&!ExcelFormVerification.isValidNumber(row.getCell(3))){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(3).toString()+"数字格式错误", "");
					}
					if(!ExcelFormVerification.isBlankCell(row.getCell(4))&&!ExcelFormVerification.isValidDate(row.getCell(4))){
						return UpfileMsgInfo.errMsgInfo(i+1,rowTitle.getCell(4).toString()+"日期格式错误", "");
					}
					if(!ExcelFormVerification.isBlankCell(row.getCell(5))&&!ExcelFormVerification.isValidDate(row.getCell(5))){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(5).toString()+"日期格式错误", "");
					}
					if(!ExcelFormVerification.isBlankCell(row.getCell(6))&&!ExcelFormVerification.isValidDate(row.getCell(6))){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(6).toString()+"日期格式错误", "");
					}
					tempTaxPay.setEntName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));//企业名称
					tempTaxPay.setTaxRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(1)));//税务登记证
					tempTaxPay.setTaxType(ExcelFormVerification.parseCellValueToString(row.getCell(2)));//税种
					tempTaxPay.setTaxAmount(ExcelFormVerification.parseCellValueToNumericString(row.getCell(3)));//税额
					tempTaxPay.setTaxPeriod(ExcelFormVerification.parseDateCellToDate(row.getCell(4)));//税款所属起始日期
					tempTaxPay.setTaxEndPeriod(ExcelFormVerification.parseDateCellToDate(row.getCell(5)));//税款所属终止日期
					tempTaxPay.setTaxPayDate(ExcelFormVerification.parseDateCellToDate(row.getCell(6)));//入库日起
					tempTaxPay.setImportFrom(deptName);
					tempTaxPay.setImportDate(new Date());
					tempTaxPay.setCorpid("");
					tempTaxPayList.add(tempTaxPay);
					i++;
					row = sheet.getRow(i);
				}
			}catch(Exception e){
				return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");
			}
		}else{
			return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");    
		}
		doGetTempTaxPayDao().insertBatch(tempTaxPayList);
		return UpfileMsgInfo.sucMsgInfo(tempTaxPayList.size(), true);

	}

	public TempTaxPayDao doGetTempTaxPayDao()
	{
		return (TempTaxPayDao)hxBaseDao;
	}
}
