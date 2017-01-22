/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-10
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.temppunish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.creditinfo.bean.upload.temppunish.TempPunish;
import com.icinfo.creditinfo.dao.upload.temppunish.TempPunishDao;
import com.icinfo.creditinfo.service.upload.temppunish.TempPunishService;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
/**
 * 
 * 描述: 行政处罚 Service 实现<br>
 * @author gaotong
 * @date 2015-11-10
 */
public class TempPunishServiceImpl extends HxBaseServiceImpl<TempPunish> implements TempPunishService
{
	public Map<String,Object> doBatchImportTempPunishInfo(Sheet sheet,String deptName,String deptCode) throws Exception{
		List<TempPunish> tempLicenseList=new ArrayList<TempPunish>();
		List<String> docNoList=new ArrayList<String>();
		Row rowTitle = sheet.getRow(0);//标题行
		if(!ExcelFormVerification.isValidPunish(rowTitle)){
			return UpfileMsgInfo.errMsgInfo(0, "行政处罚表头错误", "");
		}
		if("ZF330682008".equals(deptCode)||"ZF330682024".equals(deptCode)||"ZF330682016".equals(deptCode)||"ZF330682017".equals(deptCode)||"ZF330682014".equals(deptCode)||"ZF330682009".equals(deptCode)||"ZF330682018".equals(deptCode)||"ZF330682013".equals(deptCode)
				||"ZF330682019".equals(deptCode)||"ZF330682020".equals(deptCode)||"ZF330682015".equals(deptCode)||"ZF330682021".equals(deptCode)||"ZF330682023".equals(deptCode)||"ZF330682022".equals(deptCode)||"ZF330682007".equals(deptCode)||"ZF330682010".equals(deptCode)
		  ){
			int i = 1;
			Row row = sheet.getRow(i);// 创建ROW
			int rowNum = sheet.getLastRowNum();
			if (row == null) {
				return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
			}
			try{
				while(i <= rowNum){
					TempPunish tempPunish=new TempPunish();
					/*if (row.getCell(0) == null||row.getCell(0).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1, "所属地区行政区划编码为空", "");*/
					if (ExcelFormVerification.isBlankCell(row.getCell(4)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(4).toString()+"为空", "");
					tempPunish.setPunDocno(ExcelFormVerification.parseCellValueToString(row.getCell(4)));//行政处罚决定书文号
					if(docNoList.contains(tempPunish.getPunDocno())){
						return UpfileMsgInfo.errMsgInfo(i+1, "行政处罚决定书文号重复", "");
					}
					if(!ExcelFormVerification.isBlankCell(row.getCell(16))&&!ExcelFormVerification.isValidDate(row.getCell(16))){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(16).toString()+"日期格式错误", "");
					}
					if(!ExcelFormVerification.isBlankCell(row.getCell(19))&&!ExcelFormVerification.isValidNumber(row.getCell(19))){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(19).toString()+"数字格式错误", "");
					}
					tempPunish.setAreaCode(ExcelFormVerification.parseCellValueToString(row.getCell(0)));//所属地区行政区划编码
					tempPunish.setPunRegionName(ExcelFormVerification.parseCellValueToString(row.getCell(1)));//所属地区名称
					tempPunish.setPunOrgName(ExcelFormVerification.parseCellValueToString(row.getCell(2)));//执法部门名称
					tempPunish.setPunOrgId(ExcelFormVerification.parseCellValueToString(row.getCell(3)));//执法部门组织编码
					tempPunish.setPunCaseName(ExcelFormVerification.parseCellValueToString(row.getCell(5)));//案件名称
					tempPunish.setPunishedType(ExcelFormVerification.parseCellValueToString(row.getCell(6)));//被处罚对象类别
					tempPunish.setPunishedName(ExcelFormVerification.parseCellValueToString(row.getCell(7)));//被处罚对象名称
					tempPunish.setPunishedCertType(ExcelFormVerification.parseCellValueToString(row.getCell(8)));//被处罚对象证件类型
					tempPunish.setPunishedCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(9)));//被处罚对象证件号码
					tempPunish.setPunishedLegRep(ExcelFormVerification.parseCellValueToString(row.getCell(10)));//被处罚单位法定代表人姓名
					tempPunish.setPunishedLegRepCertType(ExcelFormVerification.parseCellValueToString(row.getCell(11)));//被处罚单位法定代表人证件类型
					tempPunish.setPunishedLegRepCertno(ExcelFormVerification.parseCellValueToString(row.getCell(12)));//被处罚单位法定代表人证件号
					tempPunish.setPunItemName(ExcelFormVerification.parseCellValueToString(row.getCell(13)));//行政处罚权力事项名称
					tempPunish.setPunItemId(ExcelFormVerification.parseCellValueToString(row.getCell(14)));//权力内部编码（权力事项唯一码）
					tempPunish.setPunAbstract(ExcelFormVerification.parseCellValueToString(row.getCell(15)));//对外公开的行政处罚决定书全文或摘要
					tempPunish.setPunDate(ExcelFormVerification.parseDateCellToDate(row.getCell(16)));//作出行政处罚的日期
					tempPunish.setPunState(ExcelFormVerification.parseCellValueToString(row.getCell(17)));//状态标记
					tempPunish.setPunCancel(ExcelFormVerification.parseCellValueToString(row.getCell(18)));//撤销处罚的原因说明
					tempPunish.setCaseMoney(ExcelFormVerification.parseCellValueToNumericString(row.getCell(19)));//涉案金额
					tempPunish.setImportFrom(deptName);
					tempPunish.setImportDate(new Date());
					tempPunish.setCorpid("");
					tempLicenseList.add(tempPunish);
					docNoList.add(tempPunish.getPunDocno());
					i++;
					row = sheet.getRow(i);
				}
			}catch(Exception e){
				return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");
			}
		}else{
			return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");
		}
		doGetTempPunishDao().insertBatch(tempLicenseList);
		return UpfileMsgInfo.sucMsgInfo(tempLicenseList.size(), true);
	}

	public TempPunishDao doGetTempPunishDao()
	{
		return (TempPunishDao)hxBaseDao;
	}
}
