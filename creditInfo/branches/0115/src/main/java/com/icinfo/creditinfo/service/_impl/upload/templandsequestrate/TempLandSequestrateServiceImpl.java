/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-12-22
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.templandsequestrate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.icinfo.creditinfo.bean.upload.templandsequestrate.TempLandSequestrate;
import com.icinfo.creditinfo.dao.upload.templandsequestrate.TempLandSequestrateDao;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.templandsequestrate.TempLandSequestrateService;
/**
 * 
 * 描述: 土地查封 Service 实现<br>
 * @author yulirong
 * @date 2015-12-22
 */
public class TempLandSequestrateServiceImpl extends HxBaseServiceImpl<TempLandSequestrate> implements TempLandSequestrateService
{
	

	public TempLandSequestrateDao doGetTempLandSequestrateDao()
	{
		return (TempLandSequestrateDao)hxBaseDao;
	}
	 /**
     * 
     * 描述: 土地查封
     * @author yulirong
     * @date 2015年12月23日 
     * @param sheet
     * @return
     * @throws Exception
     */
	public Map<String, Object> doBatchImportTempLandSequestrateInfo(HSSFSheet sheet,String depName,String depCode) throws Exception{
		List<TempLandSequestrate>  tempLandSequestrateList = new ArrayList<TempLandSequestrate>();
		HSSFRow rowTitle = sheet.getRow(0);
		int i = 1;
		Row row = sheet.getRow(i);// 创建ROW
		int rowNum = sheet.getLastRowNum();
		
		try {
			if("ZF330682005".equals(depCode)){
				if (row == null) {
					return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
				}
				while (i <= rowNum) {
					if(row.getCell(0) == null || row.getCell(0).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1,rowTitle.getCell(0).toString()+"不能为空", "");
					if(row.getCell(1) == null || row.getCell(1).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1,rowTitle.getCell(1).toString()+"不能为空", "");
					if(row.getCell(2) == null || row.getCell(2).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1,rowTitle.getCell(2).toString()+"不能为空", "");
					if(row.getCell(3) == null || row.getCell(3).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1,rowTitle.getCell(3).toString()+"不能为空", "");
					if(row.getCell(7)!=null&&!row.getCell(7).toString().contains("至"))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2)+" 格式错误（2015/1/1至2015/2/2）","");
					/*if (row.getCell(7) != null && !ExcelFormVerification.isValidDate(row.getCell(7)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(7).toString()+"日期格式错误", "");
					if (row.getCell(8) != null && !ExcelFormVerification.isValidDate(row.getCell(8)))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(8).toString()+"日期格式错误", "");*/
					if(!ExcelFormVerification.isAssignLenStr(row.getCell(5), 100))
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(5)+"超过数据库限定长度","");
					TempLandSequestrate tempLandSequestrate = doSetTempLandSequestrate(depName, row);
					i++;
					row = sheet.getRow(i);
					tempLandSequestrateList.add(tempLandSequestrate);
				}
			}
			else{
				return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件","");
			}
		} catch (Exception e) {
			return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");
		}
		doGetTempLandSequestrateDao().insertBatch(tempLandSequestrateList);
		return UpfileMsgInfo.sucMsgInfo(tempLandSequestrateList.size(), true);
	}
	private TempLandSequestrate doSetTempLandSequestrate(String depName, Row row) {
		TempLandSequestrate tempLandSequestrate = new TempLandSequestrate();
		tempLandSequestrate.setSequestrateNo(ExcelFormVerification.parseCellValueToString(row.getCell(0)));//查封文号
		tempLandSequestrate.setSequestrateLoc(ExcelFormVerification.parseCellValueToString(row.getCell(1)));//查封土地坐落
		tempLandSequestrate.setSequestrateCourt(ExcelFormVerification.parseCellValueToString(row.getCell(2)));//查封法院
		tempLandSequestrate.setPropertyOwner(ExcelFormVerification.parseCellValueToString(row.getCell(3)));//权利人名称
		tempLandSequestrate.setPropertyOwnerCertType(ExcelFormVerification.parseCellValueToString(row.getCell(4)));//权利人证件类型
		tempLandSequestrate.setPropertyOwnerCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(5)));//权利人证件号码
		tempLandSequestrate.setLandNo(ExcelFormVerification.parseCellValueToString(row.getCell(6)));//土地证号
		tempLandSequestrate.setSequestrateDateFrom(row.getCell(7) == null ? null : HxDateUtil.stringToDate(row.getCell(7).toString().split("至")[0], "yyyy-MM-dd"));//查封期限起
		tempLandSequestrate.setSequestrateDateTo(row.getCell(7) == null ? null : HxDateUtil.stringToDate(row.getCell(7).toString().split("至")[1], "yyyy-MM-dd"));//查封期限至
		tempLandSequestrate.setImportFrom(depName);
		tempLandSequestrate.setImportDate(new Date());
		return tempLandSequestrate;
	}
}
