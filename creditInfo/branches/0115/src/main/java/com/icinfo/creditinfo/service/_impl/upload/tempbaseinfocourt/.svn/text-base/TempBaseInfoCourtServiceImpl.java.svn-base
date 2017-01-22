/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempbaseinfocourt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.creditinfo.bean.upload.tempbaseinfocourt.TempBaseInfoCourt;
import com.icinfo.creditinfo.dao.upload.tempbaseinfocourt.TempBaseInfoCourtDao;
import com.icinfo.creditinfo.service.upload.tempbaseinfocourt.TempBaseInfoCourtService;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
/**
 * 
 * 描述: 法院当然人基本情况表 Service 实现<br>
 * @author gaotong
 * @date 2015-11-12
 */
public class TempBaseInfoCourtServiceImpl extends HxBaseServiceImpl<TempBaseInfoCourt> implements TempBaseInfoCourtService
{
	
	/**
	 * 描述：导入法院基本信息
	 * 
	 * @author gaotong
	 * @param sheet
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBatchImportTempBaseInfoCourt(Sheet sheet,String deptName,String deptCode) throws Exception{
		List<TempBaseInfoCourt> tempBaseInfoCourtList=new ArrayList<TempBaseInfoCourt>();
		List<String> caseNoList=new ArrayList<String>();
		if("ZF330682006".equals(deptCode)){//法院
			Row rowTitle = sheet.getRow(0);//标题行
			int i=1;
			Row row = sheet.getRow(i);//创建ROW
			int rowNum = sheet.getLastRowNum();
			if (row == null) {
				return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
			}
			try{
				while(i<=rowNum) {
				TempBaseInfoCourt tempBaseInfoCourt=new TempBaseInfoCourt();	
				if (ExcelFormVerification.isBlankCell(row.getCell(0)))
					return UpfileMsgInfo.errMsgInfo(i+1, "案号为空", "");
				tempBaseInfoCourt.setCaseNo(row.getCell(0).toString());//案号
				if(caseNoList.contains(tempBaseInfoCourt.getCaseNo())){
					return UpfileMsgInfo.errMsgInfo(i+1, "案号重复", "");
				}
				
				if(!ExcelFormVerification.isBlankCell(row.getCell(10))&&!ExcelFormVerification.isValidDate(row.getCell(10))){
					return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(10).toString()+"日期格式错误", "");
				}
				tempBaseInfoCourt.setPartyType(ExcelFormVerification.parseCellValueToString(row.getCell(1)));//当事人类型
				tempBaseInfoCourt.setLegStatus(ExcelFormVerification.parseCellValueToString(row.getCell(2)));//诉讼地位
				tempBaseInfoCourt.setPartyName(ExcelFormVerification.parseCellValueToString(row.getCell(3)));//当事人名称
				tempBaseInfoCourt.setCertType(ExcelFormVerification.parseCellValueToString(row.getCell(4)));//证件类型
				tempBaseInfoCourt.setCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(5)));//证件号
				tempBaseInfoCourt.setEntType(ExcelFormVerification.parseCellValueToString(row.getCell(6)));//单位类型
				tempBaseInfoCourt.setAddr(ExcelFormVerification.parseCellValueToString(row.getCell(7)));//地址
				tempBaseInfoCourt.setTel(ExcelFormVerification.parseCellValueToString(row.getCell(8)));//联系电话
				tempBaseInfoCourt.setGender(ExcelFormVerification.parseCellValueToString(row.getCell(9)));//性别
				tempBaseInfoCourt.setBirth(ExcelFormVerification.parseDateCellToDate(row.getCell(10)));//出生日期
				tempBaseInfoCourt.setNationality(ExcelFormVerification.parseCellValueToString(row.getCell(11)));//国籍
				tempBaseInfoCourt.setNation(ExcelFormVerification.parseCellValueToString(row.getCell(12)));//民族
				tempBaseInfoCourt.setEdu(ExcelFormVerification.parseCellValueToString(row.getCell(13)));//文化程度
				tempBaseInfoCourt.setProfession(ExcelFormVerification.parseCellValueToString(row.getCell(14)));//职业
				tempBaseInfoCourt.setLegRepName(ExcelFormVerification.parseCellValueToString(row.getCell(15)));//法定代表人名称
				tempBaseInfoCourt.setLegRepCertType(ExcelFormVerification.parseCellValueToString(row.getCell(16)));//法定代表人证件类型
				tempBaseInfoCourt.setLegRepCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(17)));//法定代表人证件号
				tempBaseInfoCourt.setZipCode("");
				tempBaseInfoCourt.setOrgCode("");
				tempBaseInfoCourt.setImportFrom(deptName);
				tempBaseInfoCourt.setImportDate(new Date());
				i++;
				row = sheet.getRow(i);
				tempBaseInfoCourtList.add(tempBaseInfoCourt);
				caseNoList.add(tempBaseInfoCourt.getCaseNo());
			    }
			}catch(Exception e){
				return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误","");
			}
		}else{
			return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");
		}	
		doGetTempBaseInfoCourtDao().insertBatch(tempBaseInfoCourtList);
		return UpfileMsgInfo.sucMsgInfo(tempBaseInfoCourtList.size(), true);
	}

	public TempBaseInfoCourtDao doGetTempBaseInfoCourtDao()
	{
		return (TempBaseInfoCourtDao)hxBaseDao;
	}
}
