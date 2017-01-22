/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-12-24
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempmates;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.icinfo.creditinfo.bean.upload.tempbaseinfozhijian.TempBaseInfoZhijian;
import com.icinfo.creditinfo.bean.upload.tempmates.TempMates;
import com.icinfo.creditinfo.dao.upload.tempmates.TempMatesDao;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.tempbaseinfozhijian.TempBaseInfoZhijianService;
import com.icinfo.creditinfo.service.upload.tempmates.TempMatesService;

/**
 * 
 * 描述: 民政局 Service 实现<br>
 * 
 * @author yulirong
 * @date 2015-12-24
 */
public class TempMatesServiceImpl extends HxBaseServiceImpl<TempMates>
		implements TempMatesService {
	private TempBaseInfoZhijianService tempBaseInfoZhijianService;

	public TempMatesDao doGetTempMatesDao() {
		return (TempMatesDao) hxBaseDao;
	}

	/**
	 * 
	 * 描述: 导入基本信息
	 * 
	 * @author yulirong
	 * @date 2015年12月25日
	 * @param sheet
	 * @return
	 */
	public Map<String, Object> doBatchImportTempMatesInfo(HSSFSheet sheet,
			String depName, String depCode) throws Exception {
		List<TempMates> tempMatesList = new ArrayList<TempMates>();
		List<String> certNoList = new ArrayList<String>();
		List<TempBaseInfoZhijian> tempBaseInfoZhijianList = new ArrayList<TempBaseInfoZhijian>();
		HSSFRow rowTitle = sheet.getRow(0);
		int i = 1;
		Row row = sheet.getRow(i);// 创建ROW
		int rowNum = sheet.getLastRowNum();

		if ("ZF330682032".equals(depCode)) {// 民政局
			try {
				if (row == null) {
					return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
				}
				while (i <= rowNum) {
					if (row.getCell(0) == null || row.getCell(0).toString().equals("")) {
						return UpfileMsgInfo.errMsgInfo(i + 1, rowTitle.getCell(0) + "不能为空", "");
					}
					if (row.getCell(2) == null || row.getCell(2).toString().equals("")) {
						return UpfileMsgInfo.errMsgInfo(i + 1, rowTitle.getCell(2) + "不能为空", "");
					}
					if (certNoList.contains(row.getCell(2).toString())) {
						return UpfileMsgInfo.errMsgInfo(i + 1, rowTitle.getCell(2) + "与前面重复", "");
					}
					if (!ExcelFormVerification.isAssignLenStr(row.getCell(2), 20)) {
						return UpfileMsgInfo.errMsgInfo(i + 1, rowTitle.getCell(2) + "超过数据库限定长度", "");
					}
					if (!ExcelFormVerification.isAssignLenStr(row.getCell(3), 16)) {
						return UpfileMsgInfo.errMsgInfo(i + 1, rowTitle.getCell(3) + "超过数据库限定长度", "");
					}
					if (!ExcelFormVerification.isAssignLenStr(row.getCell(7), 20)) {
						return UpfileMsgInfo.errMsgInfo(i + 1, rowTitle.getCell(7) + "超过数据库限定长度", "");
					}
					TempMates tempMates = doSetTempMates(depName, row);
					i++;
					row = sheet.getRow(i);
					tempMatesList.add(tempMates);
					certNoList.add(tempMates.getManNo());
				}
			} catch (Exception e) {
				return UpfileMsgInfo.errMsgInfo(i + 1, "数据格式错误", "");
			}
			doGetTempMatesDao().insertBatch(tempMatesList);
			return UpfileMsgInfo.sucMsgInfo(tempMatesList.size(), true);
		} else if ("ZF330682010".equals(depCode)) {// 质监局
			try {
				if (row == null) {
					return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
				}
				while (i <= rowNum) {
					if (row.getCell(0) == null || row.getCell(0).toString().equals("")) {
						return UpfileMsgInfo.errMsgInfo(i + 1, rowTitle.getCell(0) + "不能为空", "");
					}
					if (row.getCell(2) == null || row.getCell(2).toString().equals("")) {
						return UpfileMsgInfo.errMsgInfo(i + 1, rowTitle.getCell(2) + "不能为空", "");
					}
					if (row.getCell(3) != null && !ExcelFormVerification.isValidDate(row.getCell(3)))
						return UpfileMsgInfo.errMsgInfo(i + 1, rowTitle.getCell(3).toString() + "日期格式不对", "");
					if (row.getCell(8) != null && !ExcelFormVerification.isValidNumber(row.getCell(8))) {
						return UpfileMsgInfo.errMsgInfo(i + 1,rowTitle.getCell(8) + "数字格式不对", "");
					}
					if (!ExcelFormVerification.isAssignLenStr(row.getCell(7), 100)) {
						return UpfileMsgInfo.errMsgInfo(i + 1, rowTitle.getCell(7) + "超过数据库限定长度", "");
					}
					TempBaseInfoZhijian tempBaseInfoZhijian = doSetTempBaseInfoZhijian(depName, row);
					i++;
					row = sheet.getRow(i);
					tempBaseInfoZhijianList.add(tempBaseInfoZhijian);
				}
			} catch (Exception e) {
				return UpfileMsgInfo.errMsgInfo(i + 1, "数据格式错误", "");
			}
			tempBaseInfoZhijianService.doSaveBatch(tempBaseInfoZhijianList);
			return UpfileMsgInfo.sucMsgInfo(tempBaseInfoZhijianList.size(),true);
		} else {
			return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");
		}

	}

	private TempBaseInfoZhijian doSetTempBaseInfoZhijian(String depName, Row row) {
		TempBaseInfoZhijian tempBaseInfoZhijian = new TempBaseInfoZhijian();
		tempBaseInfoZhijian.setEntName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));// 企业名称
		tempBaseInfoZhijian.setRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(1)));// 工商注册号
		tempBaseInfoZhijian.setOrgRegNo(ExcelFormVerification.parseCellValueToString(row.getCell(2)));// 组织机构代码
		tempBaseInfoZhijian.setEstDate(ExcelFormVerification.parseDateCellToDate(row.getCell(3)));// 成立日期
		tempBaseInfoZhijian.setEntLoc(ExcelFormVerification.parseCellValueToString(row.getCell(4)));// 经营地点
		tempBaseInfoZhijian.setLegRep(ExcelFormVerification.parseCellValueToString(row.getCell(5)));// 法定代表人
		tempBaseInfoZhijian.setCertType(ExcelFormVerification.parseCellValueToString(row.getCell(6)));// 证件类型
		tempBaseInfoZhijian.setCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(7)));// 证件号
		tempBaseInfoZhijian.setRegCap(ExcelFormVerification.parseCellValueToString(row.getCell(8)));// 注册资本
		tempBaseInfoZhijian.setCurrency(ExcelFormVerification.parseCellValueToString(row.getCell(9)));// 货币币种
		tempBaseInfoZhijian.setUnscCode(ExcelFormVerification.parseCellValueToString(row.getCell(10)));// 统一信用代码
		tempBaseInfoZhijian.setImportFrom(depName);
		tempBaseInfoZhijian.setImportDate(new Date());
		return tempBaseInfoZhijian;
	}

	private TempMates doSetTempMates(String depName, Row row) {
		TempMates tempMates = new TempMates();
		tempMates.setManName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));// 姓名
		tempMates.setManType(ExcelFormVerification.parseCellValueToString(row.getCell(1)));// 证件类型
		tempMates.setManNo(ExcelFormVerification.parseCellValueToString(row.getCell(2)));// 证件号
		tempMates.setManTel(ExcelFormVerification.parseCellValueToString(row.getCell(3)));// 电话
		tempMates.setManAddress(ExcelFormVerification.parseCellValueToString(row.getCell(4)));// 地址
		tempMates.setMatesName(ExcelFormVerification.parseCellValueToString(row.getCell(5)));// 配偶姓名
		tempMates.setMatesType(ExcelFormVerification.parseCellValueToString(row.getCell(6)));// 配偶证件类型
		tempMates.setMatesNo(ExcelFormVerification.parseCellValueToString(row.getCell(7)));// 配偶证件号
		tempMates.setMarriage(ExcelFormVerification.parseCellValueToString(row.getCell(8)));// 婚姻状况
		tempMates.setImportFrom(depName);
		tempMates.setImportDate(new Date());
		return tempMates;
	}

	public TempBaseInfoZhijianService getTempBaseInfoZhijianService() {
		return tempBaseInfoZhijianService;
	}

	public void setTempBaseInfoZhijianService(
			TempBaseInfoZhijianService tempBaseInfoZhijianService) {
		this.tempBaseInfoZhijianService = tempBaseInfoZhijianService;
	}

}
