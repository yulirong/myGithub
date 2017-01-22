/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-10
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.templicense;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.icinfo.creditinfo.bean.upload.templicense.TempLicense;
import com.icinfo.creditinfo.dao.upload.templicense.TempLicenseDao;
import com.icinfo.creditinfo.service.upload.templicense.TempLicenseService;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;

/**
 * 
 * 描述: 行政许可 Service 实现<br>
 * 
 * @author liyafeng
 * @date 2015-11-10
 */
public class TempLicenseServiceImpl extends HxBaseServiceImpl<TempLicense> implements TempLicenseService {

	public TempLicenseDao doGetTempLicenseDao() {
		return (TempLicenseDao) hxBaseDao;
	}

	/**
	 * 
	 * 描述: 导入行政许可信息
	 * 
	 * @author LiYaFeng
	 * @date 2015年11月10日
	 * @return
	 */
	@Override
	public Map<String, Object> doBatchImportTempLicenseInfo(HSSFSheet sheet,String deptName,String deptCode) throws Exception {
		List<TempLicense> tempLicenseList = new ArrayList<TempLicense>();
		/*List<String> entNameList = new ArrayList<String>();*/
		HSSFRow rowTitle = sheet.getRow(0);//标题行
		if(!ExcelFormVerification.isValidLicence(rowTitle)){
			return UpfileMsgInfo.errMsgInfo(0, "行政许可表头错误", "");
		}
		if("ZF330682008".equals(deptCode)||"ZF330682024".equals(deptCode)||"ZF330682017".equals(deptCode)||"ZF330682009".equals(deptCode)||"ZF330682018".equals(deptCode)||"ZF330682013".equals(deptCode)||"ZF330682015".equals(deptCode)
				||"ZF330682021".equals(deptCode)||"ZF330682023".equals(deptCode)||"ZF330682022".equals(deptCode)||"ZF330682007".equals(deptCode)||"ZF330682010".equals(deptCode)||"ZF330682019".equals(deptCode)||"ZF330682016".equals(deptCode)){
			int i = 1;
			Row row = sheet.getRow(i);// 创建ROW
			int rowNum = sheet.getLastRowNum();
			if (row == null) {
				return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
			}
			try {
				while (row != null && i <= rowNum) {
					TempLicense tempLicense = new TempLicense();
					if (ExcelFormVerification.isBlankCell(row.getCell(0)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(0).toString()+"为空", "");
					tempLicense.setEntName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));//企业名称
					/*if (entNameList.contains(tempLicense.getEntName())) {
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(0).toString()+"重复", "");
					}*/
					if(!ExcelFormVerification.isBlankCell(row.getCell(5))&&!ExcelFormVerification.isValidDate(row.getCell(5))){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(5).toString()+"日期格式错误", "");
					}
					if(!ExcelFormVerification.isBlankCell(row.getCell(6))&&!ExcelFormVerification.isValidDate(row.getCell(6))){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(6).toString()+"日期格式错误", "");
					}
					tempLicense.setRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(1)));//工商注册号
					tempLicense.setLicOrgName(ExcelFormVerification.parseCellValueToString(row.getCell(2)));//许可机关
					tempLicense.setLicDocNo(ExcelFormVerification.parseCellValueToString(row.getCell(3)));//许可文件编号
					tempLicense.setLicDocName(ExcelFormVerification.parseCellValueToString(row.getCell(4)));//许可文件名称
					tempLicense.setLicValidFrom(ExcelFormVerification.parseDateCellToDate(row.getCell(5)));//许可有效期限自
					tempLicense.setLicValidTo(ExcelFormVerification.parseDateCellToDate(row.getCell(6)));//许可有效期限至
					tempLicense.setLicContent(ExcelFormVerification.parseCellValueToString(row.getCell(7)));//许可内容
					tempLicense.setState(ExcelFormVerification.parseCellValueToString(row.getCell(8)));//状态
					tempLicense.setOrgCode(ExcelFormVerification.parseCellValueToString(row.getCell(9)));//组织机构代码
					tempLicense.setUnscCode(ExcelFormVerification.parseCellValueToString(row.getCell(10)));//统一信用代码代码
					tempLicense.setImportFrom(deptName);
					tempLicense.setImportDate(new Date());
					tempLicense.setCorpid("");
					i++;
					row = sheet.getRow(i);
					tempLicenseList.add(tempLicense);
					/*entNameList.add(tempLicense.getEntName());*/
				}
			} catch (Exception e) {
				return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");
	
			}
		}else{
			return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");
		}
		doGetTempLicenseDao().insertBatch(tempLicenseList);
		return UpfileMsgInfo.sucMsgInfo(tempLicenseList.size(), true);
	}
}
