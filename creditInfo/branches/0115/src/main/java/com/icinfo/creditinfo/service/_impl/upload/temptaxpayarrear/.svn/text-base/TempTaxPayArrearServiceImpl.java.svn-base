/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.temptaxpayarrear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.creditinfo.bean.upload.temptaxpayarrear.TempTaxPayArrear;
import com.icinfo.creditinfo.dao.upload.temptaxpayarrear.TempTaxPayArrearDao;
import com.icinfo.creditinfo.service.upload.temptaxpayarrear.TempTaxPayArrearService;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
/**
 * 
 * 描述: 税费欠税 Service 实现<br>
 * @author gaotong
 * @date 2015-11-11
 */
public class TempTaxPayArrearServiceImpl extends HxBaseServiceImpl<TempTaxPayArrear> implements TempTaxPayArrearService
{
	
    /**
     * 
     * 描述: 导入欠税信息
     * @author  gaotong
     * @date 2015年11月11日 
     * @param sheet,taxType
     * @return
     * @throws Exception 
     */
	public Map<String,Object> doBatchImportTempTaxPayArrear(Sheet sheet,String deptName,String deptCode) throws Exception{
		List<TempTaxPayArrear> tempTaxPayArrearList=new ArrayList<TempTaxPayArrear>();
		if("ZF330682002".equals(deptCode)||"ZF330682001".equals(deptCode)){//地税或国税
			sheet=ExcelFormVerification.getFullCellSheet((HSSFSheet) sheet);
			Row rowTitle = sheet.getRow(0);//标题行
			int i = 1;
			Row row = sheet.getRow(i);//创建ROW
			int rowNum = sheet.getLastRowNum();
			if (row == null) {
				return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
			}
			try{
				while(i <= rowNum) {
					TempTaxPayArrear tempTaxPayArrear=new TempTaxPayArrear();
					/*if (ExcelFormVerification.isBlankCell(row.getCell(0)))
						return UpfileMsgInfo.errMsgInfo(i+1, "企业名称为空", "");*/
					if(!ExcelFormVerification.isBlankCell(row.getCell(3))&&!ExcelFormVerification.isValidNumber(row.getCell(3))){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(3).toString()+"数字格式错误", "");
					}
					if(!ExcelFormVerification.isBlankCell(row.getCell(4))&&!row.getCell(4).toString().contains("——")){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(4).toString()+"格式为yyyy-MM-dd——yyyy-MM-dd", "");
					}
					if(!ExcelFormVerification.isBlankCell(row.getCell(4))&&!ExcelFormVerification.isStringToDate(row.getCell(4).toString().split("——")[0])){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(4).toString()+"——前日期格式错误", "");
					}
					if(!ExcelFormVerification.isBlankCell(row.getCell(4))&&!ExcelFormVerification.isStringToDate(row.getCell(4).toString().split("——")[1])){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(4).toString()+"——后日期格式错误", "");
					}
					tempTaxPayArrear.setEntName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));//企业名称
					tempTaxPayArrear.setTaxRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(1)));//税务登记证
					tempTaxPayArrear.setTaxarrearType(ExcelFormVerification.parseCellValueToString(row.getCell(2)));//欠税税种
					tempTaxPayArrear.setTaxarrearBalance(ExcelFormVerification.parseCellValueToNumericString(row.getCell(3)));//欠税余额
					tempTaxPayArrear.setTaxarrearPeriod(row.getCell(4)==null?null:HxDateUtil.stringToDate(row.getCell(4).toString().split("——")[0], "yyyy-MM-dd"));//欠税所属期
					tempTaxPayArrear.setImportFrom(deptName);
					tempTaxPayArrear.setImportDate(new Date());
					tempTaxPayArrear.setCorpid("");
					tempTaxPayArrear.setTaxarrearPeriodTo(row.getCell(4)==null?null:HxDateUtil.stringToDate(row.getCell(4).toString().split("——")[1], "yyyy-MM-dd"));
					tempTaxPayArrearList.add(tempTaxPayArrear);
					i++;
					row = sheet.getRow(i);
				} 
			}catch(Exception e){
				return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");
			}
		}else{
			return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");
		}	
		doGetTempTaxPayArrearDao().insertBatch(tempTaxPayArrearList);
		return UpfileMsgInfo.sucMsgInfo(tempTaxPayArrearList.size(), true);
	}
	public TempTaxPayArrearDao doGetTempTaxPayArrearDao()
	{
		return (TempTaxPayArrearDao)hxBaseDao;
	}
	
}
