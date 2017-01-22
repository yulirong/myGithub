package com.icinfo.creditinfo.action.upload;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;

import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.creditinfo.bean.biz.crimporthis.CrImportHis;
import com.icinfo.creditinfo.bean.sys.sysuser.SysUser;
import com.icinfo.creditinfo.service.biz.crimporthis.CrImportHisService;
import com.icinfo.creditinfo.service.upload.tempbaseinfocourt.TempBaseInfoCourtService;
import com.icinfo.creditinfo.service.upload.tempbaseinfotax.TempBaseInfoTaxService;
import com.icinfo.creditinfo.service.upload.tempcasetrial.TempCaseTrialService;
import com.icinfo.creditinfo.service.upload.tempelecpay.TempElecPayService;
import com.icinfo.creditinfo.service.upload.tempelecpayarrear.TempElecPayArrearService;
import com.icinfo.creditinfo.service.upload.tempexecutecase.TempExecuteCaseService;
import com.icinfo.creditinfo.service.upload.tempexpimpamount.TempExpImpAmountService;
import com.icinfo.creditinfo.service.upload.tempgaspay.TempGasPayService;
import com.icinfo.creditinfo.service.upload.temphousesequestrate.TempHouseSequestrateService;
import com.icinfo.creditinfo.service.upload.templandsequestrate.TempLandSequestrateService;
import com.icinfo.creditinfo.service.upload.templicense.TempLicenseService;
import com.icinfo.creditinfo.service.upload.tempmates.TempMatesService;
import com.icinfo.creditinfo.service.upload.tempmortgagereg.TempMortgageRegService;
import com.icinfo.creditinfo.service.upload.tempmortgagesewagedischargeright.TempMortgageSewageDischargeRightService;
import com.icinfo.creditinfo.service.upload.temppolicepunish.TempPolicePunishService;
import com.icinfo.creditinfo.service.upload.temppunish.TempPunishService;
import com.icinfo.creditinfo.service.upload.tempsocialsecurity.TempSocialSecurityService;
import com.icinfo.creditinfo.service.upload.temptaxpay.TempTaxPayService;
import com.icinfo.creditinfo.service.upload.temptaxpayarrear.TempTaxPayArrearService;
import com.icinfo.creditinfo.service.upload.temptaxreportlocal.TempTaxReportLocalService;
import com.icinfo.creditinfo.service.upload.tempwaterpay.TempWaterPayService;
import com.icinfo.creditinfo.service.upload.tempwaterpayarrear.TempWaterPayArrearService;
import com.icinfo.creditinfo.service.upload.tempwatersewagedischargepay.TempWaterSewageDischargePayService;
import com.icinfo.creditinfo.service.upload.tempwatersewagedischargepayarrear.TempWaterSewageDischargePayArrearService;
import com.icinfo.plugin.common.HxConstants;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.common.ProUtil;
/**
 * 描述：表格上传
 * 
 * @author zhuyong
 * @date 2015-11-10
 */
public class UploadAction extends HxBaseAction{

	private static final long serialVersionUID = 1L;
	private File importfile;
	private String templateName;
	private String fileName;
	private ByteArrayInputStream excelInputStream;
	//文件名
	private String importfileFileName;
	//历史
	private CrImportHisService crImportHisService;
	
	//行政许可
	private TempLicenseService tempLicenseService;
	//行政处罚
	private TempPunishService tempPunishService;
	//进出口量
	private TempExpImpAmountService tempExpImpAmountService;
	//审理案件
	private TempCaseTrialService tempCaseTrialService;
	//执行案件
	private TempExecuteCaseService tempExecuteCaseService;
	//社保信息
	private TempSocialSecurityService tempSocialSecurityService;
	//污水排放量
	private TempWaterSewageDischargePayService tempWaterSewageDischargePayService;
	//污水排放量欠费
	private TempWaterSewageDischargePayArrearService tempWaterSewageDischargePayArrearService;
	//水费
	private TempWaterPayService tempWaterPayService;
	//水费欠费
	private TempWaterPayArrearService tempWaterPayArrearService;
	//用气量
	private TempGasPayService tempGasPayService;
	//房产查封
	private TempHouseSequestrateService tempHouseSequestrateService;
	//企业基本信息
	private TempBaseInfoTaxService tempBaseInfoTaxService;
	//税收
	private TempTaxPayService tempTaxPayService;
	//欠税
	private TempTaxPayArrearService tempTaxPayArrearService;
	//财务报表
	private TempTaxReportLocalService tempTaxReportLocalService;
	//欠费
	private TempElecPayArrearService tempElecPayArrearService;
	//电费
	private TempElecPayService tempElecPayService;
	//当事人基本情况
	private TempBaseInfoCourtService tempBaseInfoCourtService;
	//基本信息
	private TempMatesService tempMatesService;
	//抵押登记
	private TempMortgageRegService tempMortgageRegService;
	//排污权抵押
	private TempMortgageSewageDischargeRightService tempMortgageSewageDischargeRightService;
	//土地查封
	private TempLandSequestrateService tempLandSequestrateService;
	//失信执行人
	//用户信息
	//案件信息
	private TempPolicePunishService tempPolicePunishService;
	
	/**
	 * 描述：进入上传页面
	 * @author 马亚伟
	 * @date 2015-11-14
	 * @return
	 * @throws Exception
	 */
	public String doEnUploadAction() throws Exception{
		SysUser sysuser=(SysUser) doGetSession(HxConstants.SESSION_USER);
		ResourceBundle bundle = ResourceBundle.getBundle("depCodeExcelPath");
		String filenameStr="";
		try{
			filenameStr = bundle.getString(sysuser.getDepCode());
			String[] excelName = filenameStr.split("\\.");
			String dateStr = HxDateUtil.getCurrentDate().replace("-", "");
			this.addJstlResults("templateName", excelName[0]+dateStr+"."+excelName[1]);
		}catch(Exception e){
			this.addJstlResults("templateName","none");
		}
		return SUCCESS;
	}
	
	/**
	 * 描述：下载模板
	 * @author 马亚伟
	 * @date 2015-11-15
	 * @return
	 * @throws Exception
	 */
	public String doDownloadTemplateAction() throws Exception{
		
		SysUser sysuser=(SysUser) doGetSession(HxConstants.SESSION_USER);
		ResourceBundle bundle = ResourceBundle.getBundle("depCodeExcelPath");  
		String filenameStr =""; 
		try{
			filenameStr = bundle.getString(sysuser.getDepCode());
		}catch(Exception e){
			return NONE;
		}
		String realPath = doGetRealPath()+"template/"+filenameStr;//模板文件
		ByteArrayOutputStream xls = new ByteArrayOutputStream(); 
		new HSSFWorkbook(new FileInputStream(new File(realPath))).write(xls);
		xls.flush();
		excelInputStream = new ByteArrayInputStream(xls.toByteArray());
		fileName = doBuildFileName(filenameStr);
		fileName = new String(fileName.getBytes(), "ISO8859-1");
		return SUCCESS;
	}
	
	/**
	 * 描述：下载模板
	 * @author 马亚伟
	 * @date 2015-11-15
	 * @param filenameStr
	 * @throws Exception
	 */
	private String doBuildFileName(String filenameStr) throws Exception {
        String[] urlSplit = filenameStr.split("\\.");
        return  urlSplit[0]+HxDateUtil.getCurrentDate2()+"."+urlSplit[1];
    }
	
	
	/**
	 * 描述：表格模板上传
	 * @author zhuyong
	 * @date 2015-11-10
	 * @return String 
	 * @throws Exception
	 */
	public String doUploadTemplateAction() throws Exception{
		
		//提示信息
		SysUser sysuser=(SysUser) doGetSession(HxConstants.SESSION_USER);
		String depName = sysuser.getDepName();
		String depCode = sysuser.getDepCode();
		StringBuffer buf = new StringBuffer();
		StringBuffer bufTip = new StringBuffer();
		buf.append("<br/><img alt='depPic' src='/images/server/upfile/deptment-pic.png'/>【所属部门】"+sysuser.getDepName());
		bufTip.append("<br/><img alt='depPic' src='/images/server/upfile/deptment-pic.png'/>【所属部门】"+sysuser.getDepName());
		
		//上传历史记录结果
		Map<String,String> sheetStateMap = new HashMap<String, String>();
		//判断是否上传是否已经上传
		Map<String, Object> qryMap = new HashMap<String, Object>();
		String impFileName = importfileFileName.substring(0, importfileFileName.indexOf('.'));
		qryMap.put("impFileName",impFileName);
		List<CrImportHis> crImportHisList = crImportHisService.doGetList(qryMap);
		if(crImportHisList!=null&&crImportHisList.size()>0){//已经上传过该文件
			for (CrImportHis crImportHis : crImportHisList) {
				String sheetName = crImportHis.getImpFileSheetName();
				if("1".equals(crImportHis.getImpStatus())){//该sheet已经上传,且成功
					sheetStateMap.put(sheetName, "1");
				}
			}
		}
		
		//sheet名称数组
		String[] sheetNamesArr = new String[]{"行政许可","行政处罚","进出口量","审理案件","执行案件","社保信息","污水排放量",
	      "污水排放量欠费","水费","水费欠费","用气量","房产查封","企业基本信息","税收","欠税","财务报表","欠费","电费",
	      "当事人基本情况","基本信息","抵押登记","排污权抵押","土地查封","案件信息"};
		
		Map<String,Integer> sheetNamesMap = new HashMap<String, Integer>();
		for (int i = 0; i < sheetNamesArr.length; i++) {
			sheetNamesMap.put(sheetNamesArr[i], i);
		}
		
		//解析sheet
		InputStream is = new FileInputStream(importfile);
		POIFSFileSystem fs = new POIFSFileSystem(is);
		HSSFWorkbook workbook = new HSSFWorkbook(fs);
	    HSSFSheet sheet=null;
	    
	    //有效文件检验
	    boolean isDepFile = isValidDepFile(depCode, workbook);
	    if(!isDepFile){
	    	bufTip.append("<br/><img alt='fail' src='/images/server/upfile/wrong-signal.png'/><span style='color:red'>【"+importfileFileName+"】为非有效文件！sheet名或数目不正确！</span>");
			this.addJstlResults("buf", bufTip);
            return SUCCESS;
	    };
	    //有效sheet数
	    int sheetCount = validSheetCount(sheetNamesArr, workbook);
	    if(sheetCount==0){//没有有效sheet
	    	bufTip.append("<br/><img alt='fail' src='/images/server/upfile/wrong-signal.png'/><span style='color:red'>【"+importfileFileName+"】没有有效sheet，不能上传！</span>");
			this.addJstlResults("buf", bufTip);
            return SUCCESS;
	    }
	    buf.append("<br/><img alt='filePic' src='/images/server/upfile/file-pic.png'/>【"+importfileFileName+"】"+"包含有效sheet数量："+ sheetCount+"个");
	    boolean uploadFileToLocalFlag = false;//是否需要将所传文件保存
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			 sheet=workbook.getSheetAt(i);
			 String sheetName = sheet.getSheetName();
			 Map<String, Object> msgInfo = new HashMap<String, Object>();
			 /*Map<String, Object> paramMap = new HashMap<String, Object>();
			 paramMap.put("sheet", sheet);
			 paramMap.put("depName", depName);
			 paramMap.put("depCode", depCode);*/
			 try{
				 
				 for (String sheetNameStr : sheetNamesArr) {
					 if(sheetNameStr.equals(sheetName)){
						 //判断该sheet是否已经上传成功
						 if("1".equals(sheetStateMap.get(sheetName))){//已经上传成功
							 buf.append("<br/><img alt='success' src='/images/server/upfile/warning-pic.png'/><span style='color:gray'>【"+sheetName+"】已成功上传，不能重复上传！</span>");
							 continue;
						 }
						 
						 //没有上传，则上传
						 switch(sheetNamesMap.get(sheetName)){
						 	
						 	case 0 : msgInfo = tempLicenseService.doBatchImportTempLicenseInfo(sheet,depName,depCode) ;break;//行政许可
						 	case 1 : msgInfo = tempPunishService.doBatchImportTempPunishInfo(sheet,depName,depCode);break;//行政处罚
						 	case 2 : msgInfo = tempExpImpAmountService.doBatchImportTempExpImpAmountInfo(sheet,depName,depCode);break;//进出口量
						 	case 3 : msgInfo = tempCaseTrialService.doBatchImportTempCaseTrialInfo(sheet,depName,depCode) ;break;//审理案件
						 	case 4 : msgInfo = tempExecuteCaseService.doBatchImportTempExecuteCaseInfo(sheet,depName,depCode) ;break;//执行案件
							case 5 : msgInfo = tempSocialSecurityService.doBatchImportTempSocialSecurityInfo(sheet,depName,depCode) ;break;//社保信息
						 	case 6 : msgInfo = tempWaterSewageDischargePayService.doBatchImportTempWaterSewageDischargePayInfo(sheet,depName,depCode) ;break;//污水排放量
						 	case 7 : msgInfo = tempWaterSewageDischargePayArrearService.doBatchImportTempWaterSewageDischargePayArrearInfo(sheet,depName,depCode) ;break;//污水排放量欠费
						 	case 8 : msgInfo = tempWaterPayService.doBatchImportTempWaterPayInfo(sheet,depName,depCode) ;break;//水费
						 	case 9 : msgInfo = tempWaterPayArrearService.doBatchImportTempWaterPayArrearInfo(sheet,depName,depCode) ;break;//水费欠费
						 	case 10 : msgInfo = tempGasPayService.doBatchImportTempGasPayInfo(sheet,depName,depCode) ;break;//用气量
						 	case 11 : msgInfo = tempHouseSequestrateService.doBatchImportTempHouseSequestrateInfo(sheet, depName,depCode);break;//房产查封
						 	case 12 : msgInfo = tempBaseInfoTaxService.doBatchImportTempBaseInfoTax(sheet, depName,depCode);break;//企业基本信息
						 	case 13 : msgInfo = tempTaxPayService.doBatchImportTempTaxPay(sheet, depName,depCode);break;//税收
						 	case 14 : msgInfo = tempTaxPayArrearService.doBatchImportTempTaxPayArrear(sheet, depName,depCode);break;//欠税
						 	case 15 : msgInfo = tempTaxReportLocalService.doBatchImportTempTaxReportLocal(sheet, depName,depCode);break;//财务报表
						 	case 16 : msgInfo = tempElecPayArrearService.doBatchImportTempElecPayArrear(sheet, depName,depCode);break;//欠费
						 	case 17 : msgInfo = tempElecPayService.doBatchImportTempElecPay(sheet, depName,depCode);break;//电费
						 	case 18 : msgInfo = tempBaseInfoCourtService.doBatchImportTempBaseInfoCourt(sheet, depName,depCode);break;//当事人基本情况
						 	case 19 : msgInfo = tempMatesService.doBatchImportTempMatesInfo(sheet, depName, depCode);break;//基本信息
						 	case 20 : msgInfo = tempMortgageRegService.doBatchImportTempMortgageRegInfo(sheet, depName,depCode);break;//抵押登记
						 	case 21 : msgInfo = tempMortgageSewageDischargeRightService.doBatchImportTempMortgageSewageDischargeRightInfo(sheet, depName,depCode);break;//排污权抵押
						 	case 22 : msgInfo = tempLandSequestrateService.doBatchImportTempLandSequestrateInfo(sheet, depName,depCode);break;//土地查封
						 	case 23 : msgInfo = tempPolicePunishService.doBatchImportTempPolicePunishInfo(sheet, depName,depCode);break;//案件信息
						 }
						 
						 if(msgInfo==null) continue;
						 if("0".equals(msgInfo.get("state"))&&"-1".equals(msgInfo.get("posRowNum"))){
			               bufTip.append("<br/><img alt='wrong' src='/images/server/upfile/wrong-signal.png'/><span style='color:red'>【"+importfileFileName+"】不能上传："+msgInfo.get("msgInfo")+"</span>");
			               this.addJstlResults("buf", bufTip);
			               return SUCCESS;
			             }
						 
						 //处理返回信息
						 if("1".equals(msgInfo.get("state"))){//上传成功
							 buf.append("<br/><img alt='success' src='/images/server/upfile/suc-signal.png'/><span style='color:green'>【"+sheetName+"】上传成功："+msgInfo.get("total")+"条</span>");
							 uploadFileToLocalFlag = true;
						 }
						 if("0".equals(msgInfo.get("state"))){//上传失败
						   if("0".equals(msgInfo.get("posRowNum"))){
								 buf.append("<br/><img alt='wrong' src='/images/server/upfile/wrong-signal.png'/><span style='color:red'>【"+sheetName+"】上传失败："+msgInfo.get("msgInfo")+"</span>");
							 }else {
								 buf.append("<br/><img alt='wrong' src='/images/server/upfile/wrong-signal.png'/><span style='color:red'>【"+sheetName+"】上传失败：第"+msgInfo.get("posRowNum")+"行"+msgInfo.get("msgInfo")+"</span>");
							 }
						 }
						//历史记录
						 doSaveCrImportHis(sysuser, impFileName,sheetName, msgInfo,"");
						 
					 } 
				 }
				 
			 }catch(Exception e){
				 buf.append("<br/><img alt='fail' src='/images/server/upfile/wrong-signal.png'/><span style='color:red'>【"+sheetName+"】上传失败！</span>");
				 e.printStackTrace();
			 }

		 }
		//上传文件到本地
		if(uploadFileToLocalFlag) doUploadFileToLocal(importfileFileName, importfile);
		
		this.addJstlResults("buf", buf);
		//this.addJstlResults("templateName", templateName);
		return SUCCESS;
	}

	/**
	 * 描述：有效的sheet数量统计
	 * @author MaYawei
	 * @date 2015-12-28
	 * @param sheetNamesArr
	 * @param workbook
	 * @return
	 */
	private int validSheetCount(String[] sheetNamesArr, HSSFWorkbook workbook) {
		StringBuffer tempStr = new StringBuffer();
	    int count = 0;
		for (String sheetName : sheetNamesArr) {
			tempStr.append(sheetName+"-");
		}
		for(int i=0;i<workbook.getNumberOfSheets();i++){
			if(tempStr.toString().contains(workbook.getSheetAt(i).getSheetName()))
				count++;
		}
		return count;
	}

	/**
	 * 描述：初步验证所传文件是否为本部门文件
	 * @author MaYawei
	 * @date 2015-12-26
	 * @param depCode 部门code
	 * @param workbook 
	 * @return boolean <br/> true:是本部门文件，false：不是本部门文件
	 */
	private boolean isValidDepFile(String depCode, HSSFWorkbook workbook) {
		//校验sheet
	    Map<String, String> depSheetInfoMap = getDepFileMap();
	    //获取当前部门sheet信息
	    String sheetInfo = depSheetInfoMap.get(depCode);
	    if(sheetInfo==null) return false;//部门没有模板
	    int sheetNum = workbook.getNumberOfSheets();//所传文档的sheets个数
	    boolean isDepFile = true;//是该部门文件
	    if(sheetInfo.contains(String.valueOf(sheetNum))){//校验sheet数量
	    	for (int i = 0;i < sheetNum; i++) {
				if(!sheetInfo.contains(workbook.getSheetAt(i).getSheetName().trim())){
					isDepFile = false;
					break;
				}
			}
	    }else{
	    	isDepFile = false;
	    };
		return isDepFile;
	}
	/**
	 * 描述：封装部门与部门模板sheet的对应关系
	 * @author MaYawei
	 * @date 2015-12-28
	 * @return Map<String, String>
	 */
	private Map<String, String> getDepFileMap() {
		Map<String, String> depSheetInfoMap = new HashMap<String, String>();
	    depSheetInfoMap.put("ZF330682009", "3-排污权抵押-行政许可-行政处罚");//环保局
	    depSheetInfoMap.put("ZF330682010", "3-基本信息-行政许可-行政处罚");//质监局
	    depSheetInfoMap.put("ZF330682011", "1-社保信息");//社保局
	    depSheetInfoMap.put("ZF330682013", "2-行政处罚-行政许可");//交通运输局
	    depSheetInfoMap.put("ZF330682014", "1-行政处罚");//海关
	    depSheetInfoMap.put("ZF330682015", "2-行政处罚-行政许可");//旅游局
	    depSheetInfoMap.put("ZF330682016", "2-行政处罚-行政许可");//发改局
	    depSheetInfoMap.put("ZF330682017", "2-行政处罚-行政许可");//规划局
	    depSheetInfoMap.put("ZF330682018", "2-行政处罚-行政许可");//建管局
	    depSheetInfoMap.put("ZF330682001", "4-企业基本信息-税收-欠税-财务报表");//国税局
	    depSheetInfoMap.put("ZF330682019", "2-行政处罚-行政许可");//经信局
	    depSheetInfoMap.put("ZF330682020", "1-行政处罚");//科技局
	    depSheetInfoMap.put("ZF330682021", "2-行政处罚-行政许可");//农林渔牧局
	    depSheetInfoMap.put("ZF330682022", "2-行政处罚-行政许可");//卫生局
	    depSheetInfoMap.put("ZF330682023", "3-进出口量-行政处罚-行政许可");//商务局
	    depSheetInfoMap.put("ZF330682024", "2-行政处罚-行政许可");//城管执法局
	    depSheetInfoMap.put("ZF330682025", "2-电费-欠费");//电力公司
	    depSheetInfoMap.put("ZF330682026", "4-水费-污水排放量-水费欠费-污水排放量欠费");//水务集团
	    depSheetInfoMap.put("ZF330682027", "2-用气量-用户信息");//天然气公司
	    depSheetInfoMap.put("ZF330682028", "1-抵押登记");//公证处
	    depSheetInfoMap.put("ZF330682002", "4-企业基本信息-税收-欠税-财务报表");//地税局
	    depSheetInfoMap.put("ZF330682032", "1-基本信息");//民政局
	    depSheetInfoMap.put("ZF330682003", "1-房产查封");//建设局
	    depSheetInfoMap.put("ZF330682004", "1-案件信息");//公安局
	    depSheetInfoMap.put("ZF330682005", "2-抵押登记-土地查封");//国土资源局
	    depSheetInfoMap.put("ZF330682006", "4-当事人基本情况-审理案件-执行案件-失信执行人");//法院
	    depSheetInfoMap.put("ZF330682007", "2-行政处罚-行政许可");//文广局
	    depSheetInfoMap.put("ZF330682008", "2-行政许可-行政处罚");//安监局
	    depSheetInfoMap.put("ZF330682004", "1-案件信息");//公安局
		return depSheetInfoMap;
	}

	/**
	 * 描述：写历史记录
	 * @author 马亚伟
	 * @date 2015-11-12
	 * @param paramSysuser 
	 * @param paramImpFileName
	 * @param paramSheetName
	 * @param paramMsgInfo
	 * @return
	 * @throws Exception
	 */
	private CrImportHis doSaveCrImportHis(SysUser paramSysuser,
			String paramImpFileName, String paramSheetName,
			Map<String, Object> paramMsgInfo,String paramImpRemark) throws Exception {
		 CrImportHis crImportHis = new CrImportHis();
		 crImportHis.setImpDate(new Date());
		 crImportHis.setImpDepart(paramSysuser.getDepName());
		 crImportHis.setImpFileName(paramImpFileName);
		 crImportHis.setImpFileSheetName(paramSheetName);
		 crImportHis.setImpFileSize((String) paramMsgInfo.get("total"));
		 crImportHis.setImpRemark(paramImpRemark);
		 crImportHis.setImpStatus((String) paramMsgInfo.get("state"));
		 crImportHis.setImpUserid(paramSysuser.getId());
		 crImportHis.setImpDeptCode(paramSysuser.getDepCode());
		 
		 crImportHisService.doSave(crImportHis);
		return crImportHis;
	}
	
	
	/**
	 * 描述：上传文件到本地
	 * @author MaYawei
	 * @date 2015-12-28
	 * @param importfileName
	 * @param imfile
	 */
	public void doUploadFileToLocal(String importfileName ,File imfile){
		
		String savePath = ProUtil.getEXCEL_BACK_PATH();
		//String savePath = "/jsp";
    	// 保存文件名
    	String targetFileNamePart = HxDateUtil.dateToString(new Date(), "yyyyMMddHHmmss")
    			+ importfileName.substring(importfileFileName.indexOf('.'));
    	String targetFileName = importfileName.substring(0, importfileFileName.indexOf('.'))+"_"+targetFileNamePart;
    	//上传目录
    	/*String targetDir = ServletActionContext.getServletContext().getRealPath(savePath) + "/uploadFile/" 
    			+ targetFileNamePart.substring(0, 8);*/
    	String targetDir = savePath + "/uploadFile/" 
    			+ targetFileNamePart.substring(0, 8);
    	File target = new File(targetDir, targetFileName);
    	try {
			FileUtils.copyFile(imfile, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public File getImportfile() {
		return importfile;
	}
	public void setImportfile(File importfile) {
		this.importfile = importfile;
	}


	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public TempLicenseService getTempLicenseService() {
		return tempLicenseService;
	}

	public TempPunishService getTempPunishService() {
		return tempPunishService;
	}

	public void setTempPunishService(TempPunishService tempPunishService) {
		this.tempPunishService = tempPunishService;
	}

	public TempBaseInfoTaxService getTempBaseInfoTaxService() {
		return tempBaseInfoTaxService;
	}

	public void setTempBaseInfoTaxService(
			TempBaseInfoTaxService tempBaseInfoTaxService) {
		this.tempBaseInfoTaxService = tempBaseInfoTaxService;
	}



	public void setTempLicenseService(TempLicenseService tempLicenseService) {
		this.tempLicenseService = tempLicenseService;
	}


	public TempHouseSequestrateService getTempHouseSequestrateService() {
		return tempHouseSequestrateService;
	}

	public TempTaxPayService getTempTaxPayService() {
		return tempTaxPayService;
	}

	public void setTempTaxPayService(TempTaxPayService tempTaxPayService) {
		this.tempTaxPayService = tempTaxPayService;
	}


	public TempTaxPayArrearService getTempTaxPayArrearService() {
		return tempTaxPayArrearService;
	}

	public void setTempTaxPayArrearService(
			TempTaxPayArrearService tempTaxPayArrearService) {
		this.tempTaxPayArrearService = tempTaxPayArrearService;
	}



	public void setTempHouseSequestrateService(TempHouseSequestrateService tempHouseSequestrateService) {
		this.tempHouseSequestrateService = tempHouseSequestrateService;
	}

	public TempMatesService getTempMatesService() {
		return tempMatesService;
	}

	public void setTempMatesService(TempMatesService tempMatesService) {
		this.tempMatesService = tempMatesService;
	}

	public TempExpImpAmountService getTempExpImpAmountService() {
		return tempExpImpAmountService;
	}

	public void setTempExpImpAmountService(TempExpImpAmountService tempExpImpAmountService) {
		this.tempExpImpAmountService = tempExpImpAmountService;
	}


	public TempTaxReportLocalService getTempTaxReportLocalService() {
		return tempTaxReportLocalService;
	}

	public void setTempTaxReportLocalService(
			TempTaxReportLocalService tempTaxReportLocalService) {
		this.tempTaxReportLocalService = tempTaxReportLocalService;
	}


	public TempSocialSecurityService getTempSocialSecurityService() {
		return tempSocialSecurityService;
	}

	public void setTempSocialSecurityService(TempSocialSecurityService tempSocialSecurityService) {
		this.tempSocialSecurityService = tempSocialSecurityService;
	}


	public String getImportfileFileName() {
		return importfileFileName;
	}

	public void setImportfileFileName(String importfileFileName) {
		this.importfileFileName = importfileFileName;
	}

	public CrImportHisService getCrImportHisService() {
		return crImportHisService;
	}

	public void setCrImportHisService(CrImportHisService crImportHisService) {
		this.crImportHisService = crImportHisService;
	}

	public TempElecPayArrearService getTempElecPayArrearService() {
		return tempElecPayArrearService;
	}

	public void setTempElecPayArrearService(
			TempElecPayArrearService tempElecPayArrearService) {
		this.tempElecPayArrearService = tempElecPayArrearService;
	}



	public TempElecPayService getTempElecPayService() {
		return tempElecPayService;
	}

	public void setTempElecPayService(TempElecPayService tempElecPayService) {
		this.tempElecPayService = tempElecPayService;
	}



	public TempBaseInfoCourtService getTempBaseInfoCourtService() {
		return tempBaseInfoCourtService;
	}

	public void setTempBaseInfoCourtService(
			TempBaseInfoCourtService tempBaseInfoCourtService) {
		this.tempBaseInfoCourtService = tempBaseInfoCourtService;
	}

	public TempCaseTrialService getTempCaseTrialService() {
		return tempCaseTrialService;
	}

	public void setTempCaseTrialService(TempCaseTrialService tempCaseTrialService) {
		this.tempCaseTrialService = tempCaseTrialService;
	}

	public TempExecuteCaseService getTempExecuteCaseService() {
		return tempExecuteCaseService;
	}

	public void setTempExecuteCaseService(
			TempExecuteCaseService tempExecuteCaseService) {
		this.tempExecuteCaseService = tempExecuteCaseService;
	}


	public TempMortgageRegService getTempMortgageRegService() {
		return tempMortgageRegService;
	}

	public void setTempMortgageRegService(
			TempMortgageRegService tempMortgageRegService) {
		this.tempMortgageRegService = tempMortgageRegService;
	}


	public TempMortgageSewageDischargeRightService getTempMortgageSewageDischargeRightService() {
		return tempMortgageSewageDischargeRightService;
	}

	public void setTempMortgageSewageDischargeRightService(
			TempMortgageSewageDischargeRightService tempMortgageSewageDischargeRightService) {
		this.tempMortgageSewageDischargeRightService = tempMortgageSewageDischargeRightService;
	}

	public ByteArrayInputStream getExcelInputStream() {
		return excelInputStream;
	}

	public void setExcelInputStream(ByteArrayInputStream excelInputStream) {
		this.excelInputStream = excelInputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public TempWaterSewageDischargePayService getTempWaterSewageDischargePayService() {
		return tempWaterSewageDischargePayService;
	}

	public void setTempWaterSewageDischargePayService(
			TempWaterSewageDischargePayService tempWaterSewageDischargePayService) {
		this.tempWaterSewageDischargePayService = tempWaterSewageDischargePayService;
	}

	public TempWaterSewageDischargePayArrearService getTempWaterSewageDischargePayArrearService() {
		return tempWaterSewageDischargePayArrearService;
	}

	public void setTempWaterSewageDischargePayArrearService(
			TempWaterSewageDischargePayArrearService tempWaterSewageDischargePayArrearService) {
		this.tempWaterSewageDischargePayArrearService = tempWaterSewageDischargePayArrearService;
	}

	public TempWaterPayService getTempWaterPayService() {
		return tempWaterPayService;
	}

	public void setTempWaterPayService(TempWaterPayService tempWaterPayService) {
		this.tempWaterPayService = tempWaterPayService;
	}

	public TempWaterPayArrearService getTempWaterPayArrearService() {
		return tempWaterPayArrearService;
	}

	public void setTempWaterPayArrearService(
			TempWaterPayArrearService tempWaterPayArrearService) {
		this.tempWaterPayArrearService = tempWaterPayArrearService;
	}

	public TempGasPayService getTempGasPayService() {
		return tempGasPayService;
	}

	public void setTempGasPayService(TempGasPayService tempGasPayService) {
		this.tempGasPayService = tempGasPayService;
	}

	public TempLandSequestrateService getTempLandSequestrateService() {
	    return tempLandSequestrateService;
	}
	
	public void setTempLandSequestrateService(TempLandSequestrateService tempLandSequestrateService) {
	    this.tempLandSequestrateService = tempLandSequestrateService;
	}
	
	public TempPolicePunishService getTempPolicePunishService() {
	    return tempPolicePunishService;
	}
	
	public void setTempPolicePunishService(TempPolicePunishService tempPolicePunishService) {
		this.tempPolicePunishService = tempPolicePunishService;
	}
   
}
