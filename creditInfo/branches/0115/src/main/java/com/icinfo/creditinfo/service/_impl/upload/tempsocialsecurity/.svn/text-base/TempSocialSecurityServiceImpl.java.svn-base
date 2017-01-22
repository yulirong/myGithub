/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempsocialsecurity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.icinfo.creditinfo.bean.upload.tempsocialsecurity.TempSocialSecurity;
import com.icinfo.creditinfo.dao.upload.tempsocialsecurity.TempSocialSecurityDao;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.tempsocialsecurity.TempSocialSecurityService;
/**
 * 
 * 描述: 社保信息 Service 实现<br>
 * @author liyafeng
 * @date 2015-11-11
 */
public class TempSocialSecurityServiceImpl extends HxBaseServiceImpl<TempSocialSecurity> implements TempSocialSecurityService
{
	

	public TempSocialSecurityDao doGetTempSocialSecurityDao()
	{
		return (TempSocialSecurityDao)hxBaseDao;
	}
    /**
     * 
     * 描述: 导入社保信息
     * @author  LiYaFeng
     * @date 2015年11月11日 
     * @param sheet
     * @return
     * @throws Exception
     */
	@Override
	public Map<String, Object> doBatchImportTempSocialSecurityInfo(HSSFSheet sheet,String deptName,String depCode) throws Exception {
		List<TempSocialSecurity> tempSocialSecurityList=new ArrayList<TempSocialSecurity>();
		Row rowTitle = sheet.getRow(0);
		int i = 1;
		try {
		  if("ZF330682011".equals(depCode)){//社保局
		    Row row = sheet.getRow(i);// 创建ROW
		    int rowNum = sheet.getLastRowNum();
		    if (row == null) {
		      return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
		    }
		    while (row != null && i <= rowNum) {
		    	
		    	if(ExcelFormVerification.isBlankCell(row.getCell(0))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(0).toString()+"为空", "");
		    	if(ExcelFormVerification.isBlankCell(row.getCell(1))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(1).toString()+"为空", "");
		    	if(ExcelFormVerification.isBlankCell(row.getCell(2))) return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2).toString()+"为空", "");
		     
		    	TempSocialSecurity tempSocialSecurity=new TempSocialSecurity();
				tempSocialSecurity.setEntName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));
				tempSocialSecurity.setSiNo(ExcelFormVerification.parseCellValueToString(row.getCell(1)));
				tempSocialSecurity.setTaxRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(2)));
				tempSocialSecurity.setSiType(ExcelFormVerification.parseCellValueToString(row.getCell(3)));
				tempSocialSecurity.setSiNumber(ExcelFormVerification.parseCellValueToString(row.getCell(4)));
				tempSocialSecurity.setSiMoney(ExcelFormVerification.parseCellValueToNumericString(row.getCell(5)));
				tempSocialSecurity.setStatisticDate(ExcelFormVerification.parseCellValueToString(row.getCell(6)));
				tempSocialSecurity.setOrgCode(ExcelFormVerification.parseCellValueToString(row.getCell(7)));
				tempSocialSecurity.setUnscCode(ExcelFormVerification.parseCellValueToString(row.getCell(8)));
				tempSocialSecurity.setRemark(null);
				tempSocialSecurity.setImportFrom(deptName);
				tempSocialSecurity.setImportDate(new Date());
				tempSocialSecurity.setCorpid(null);
				i++;
				row = sheet.getRow(i);
				tempSocialSecurityList.add(tempSocialSecurity);
		    }
		    
		  }else{
		    return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件","");
		  }
		} catch (Exception e) {
			return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");
		}
		List<String> resultList = doGetTempSocialSecurityDao().insertBatch(tempSocialSecurityList);
		if(resultList.size()!=0)
			return UpfileMsgInfo.sucMsgInfo(resultList.size(), true);
		else
			return UpfileMsgInfo.sucMsgInfo(0,false);
	}
}
