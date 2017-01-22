package com.icinfo.creditinfo.action.search;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.creditinfo.bean.biz.crcreditdms.CrCreditDms;
import com.icinfo.creditinfo.bean.biz.crentbaseinfo.CrEntBaseInfo;
import com.icinfo.creditinfo.bean.biz.crhistoryrecords.CrHistoryRecords;
import com.icinfo.creditinfo.bean.biz.crreportconinfo.CrReportConInfo;
import com.icinfo.creditinfo.bean.biz.crristdetail.CrRistDetail;
import com.icinfo.creditinfo.bean.biz.crristindex.CrRistIndex;
import com.icinfo.creditinfo.bean.biz.hzqytzf.HzQytzf;
import com.icinfo.creditinfo.lucence.common.AppConInfo;
import com.icinfo.creditinfo.lucence.common.NameResponse;
import com.icinfo.creditinfo.lucence.common.PathUtil;
import com.icinfo.creditinfo.service.biz.crcaseinfo.CrCaseInfoService;
import com.icinfo.creditinfo.service.biz.crcreditdms.CrCreditDmsService;
import com.icinfo.creditinfo.service.biz.crelecpay.CrElecPayService;
import com.icinfo.creditinfo.service.biz.crentbaseinfo.CrEntBaseInfoService;
import com.icinfo.creditinfo.service.biz.crgaspay.CrGasPayService;
import com.icinfo.creditinfo.service.biz.crhistoryrecords.CrHistoryRecordsService;
import com.icinfo.creditinfo.service.biz.crreportconinfo.CrReportConInfoService;
import com.icinfo.creditinfo.service.biz.crristdetail.CrRistDetailService;
import com.icinfo.creditinfo.service.biz.crristindex.CrRistIndexService;
import com.icinfo.creditinfo.service.biz.crwaterpay.CrWaterPayService;
import com.icinfo.creditinfo.service.biz.hzqytzf.HzQytzfService;
import com.icinfo.creditinfo.service.search.AppSearchService;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.common.HxConstants;
import com.icinfo.plugin.common.HxDateUtil;


/** 
 * 描述: 企业基本信息<br>
 * 
 * @author gqf
 * @date 2015年10月14日  
 */
public class AppSearchAction extends HxBaseAction{
	
	private static final long serialVersionUID = 4680940064199272335L;

//	private  static Logger log = Logger.getLogger(AppSearchAction.class);
	
	private AppSearchService appSearchService;
	
	private String searchParam;//查询参数
	
	private String searchType = "";//检索方式
	
	private String corpid;//内部序号
	
	private NameResponse nameResponse;//查询结果
	
	private String regloc;//注册地址
	
	private CrEntBaseInfo crEntBaseInfo;//企业基本信息
	private String employeeCount;//企业员工人数
	private CrCreditDms crCreditDms;
	private String biggestShareholder="";//企业最大股东
	
	private CrEntBaseInfoService crEntBaseInfoService;
	private HzQytzfService hzQytzfService;
	private CrCreditDmsService crCreditDmsService;
	
	private CrHistoryRecordsService crHistoryRecordsService;
	
	private CrRistIndex crRistIndex;
	private CrRistIndexService crRistIndexService;
	private CrRistDetailService crRistDetailService;
	private Integer creditRate;
	private CrRistDetail crRistDetail;
	
	private List<CrRistDetail> ristList;
	private CrCaseInfoService crCaseInfoService;
	private String trial;
	private String execute;
	private CrReportConInfoService crReportConInfoService;
	private CrReportConInfo crReportConInfo;
	private String  entName;
	
	//水气电资源类型
	private String publicSourceType;
	private CrElecPayService crElecPayService;
	private CrWaterPayService crWaterPayService;
	private CrGasPayService crGasPayService;
	
	public String doCreateIndexJSONAction() {
		System.out.println("******开始创建索引******");
		long time1 = System.currentTimeMillis();
		// **********创建索引开始**********
		try {
			String rootPath = PathUtil.getRealCreateIndexPath();
			if(StringUtils.isNotBlank(rootPath)){
				// 先删除当天所需索引文件夹的索引
				boolean bln = PathUtil.DeleteFolder(rootPath);
				// 创建新索引
				if (bln) {
					appSearchService.doCreateIndex(rootPath);
				}
			}
			this.addAjaxResults("indexResult", "true");
		} catch (Exception e) {
			e.printStackTrace();
			this.addAjaxResults("indexResult", "false");
		}
		// **********创建索引结束**********

		long time2 = System.currentTimeMillis();
		System.out.println("综合查询索引创建一共花了" + (time2 - time1) + "时间");
		System.out.println("******结束创建索引******");
		return AJAX;
	}

	/**
	 * 描述：获取查询结果-Lucene
	 * 
	 * @author zhuyong
	 * @date 2015-10-19
	 * @return
	 * @throws Exception
	 */
	public String doGetAppSearchListAction() throws Exception{
		String rootPath = PathUtil.getRealSearchIndexPath();// 获取索引路径
		if (StringUtils.isNotBlank(rootPath)) {
			nameResponse = appSearchService.doGetAppConInfoResult(searchParam.trim(),searchType,
					rootPath, HxConstants.QUERY_PAGESIZE,
					HxConstants.QUERY_CURRENTPAGE, HxConstants.QUERY_TOTALSIZE);
		}
		return SUCCESS;
	}
	
	
	/**
	 * 描述：获取关系网络查询结果-Lucene
	 * 
	 * @author yulirong
	 * @date 2015-10-29
	 * @return
	 * @throws Exception
	 */
	public String doGetRelationalNetSearchListAction() throws Exception{
		String rootPath = PathUtil.getRealSearchIndexPath();// 获取索引路径
		if (StringUtils.isNotBlank(rootPath)) {
			nameResponse = appSearchService.doGetAppConInfoResult(searchParam,searchType,
					rootPath, HxConstants.QUERY_PAGESIZE,
					HxConstants.QUERY_CURRENTPAGE, HxConstants.QUERY_TOTALSIZE);
		}
		return SUCCESS;
	}
	/**
	 * 描述：获取提示
	 * 
	 * @author zhuyong
	 * @date 2015-10-20
	 * @return
	 * @throws Exception
	 */
	public String doGetAutoCompleteJsonAction() throws Exception{
		if(StringUtils.isBlank(searchParam)){
			this.addAjaxResults("list", null);
			return AJAX;
		}
		String rootPath = PathUtil.getRealSearchIndexPath();// 获取索引路径
		if (StringUtils.isNotBlank(rootPath)) {
			nameResponse = appSearchService.doGetAppConInfoResult(searchParam.trim(),searchType,
					rootPath, HxConstants.QUERY_PAGESIZE,
					HxConstants.QUERY_CURRENTPAGE, HxConstants.QUERY_TOTALSIZE);
		}
		if(nameResponse==null||nameResponse.getAppConInfoList()==null||nameResponse.getAppConInfoList().size()==0){
			List<AppConInfo> nullList = new ArrayList<AppConInfo>();
			AppConInfo nullInfo = new AppConInfo();
			nullInfo.setName("无匹配企业");
			nullInfo.setCorpid("-1");
			nullList.add(nullInfo);
			this.addAjaxResults("list", nullList);
			return AJAX;
		}
		this.addAjaxResults("list", nameResponse.getAppConInfoList());
		return AJAX;
	}
	
	/**
	 * 描述：进入企业详情页面
	 * 
	 * @author yulirong
	 * @date 2015-10-20
	 * @return
	 * @throws Exception
	 */
	public String doEnEntBaseInfoAction() throws Exception{
		if (StringUtils.isNotBlank(corpid)&&corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		if(StringUtils.isBlank(corpid)){return ERROR;}
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		crEntBaseInfo = crEntBaseInfoService.doGetById(corpid);
		if(crEntBaseInfo==null){
			return ERROR;
		}
		qryMap.put("dmsEntTrade", crEntBaseInfo.getEntRealTrade());
		crCreditDms  =crCreditDmsService.doGetById(corpid);//获取企业信用评分
		if(crCreditDms!=null){
		crCreditDms.setAvgDmsScore(crCreditDmsService.getAvgScoreListByTrade(qryMap).getAvgDmsScore());}
		qryMap.put("theStartTime",HxDateUtil.getNowMonthStartDate());
		creditRate = crRistDetailService.doGetTotal(qryMap);//获取企业风险提示总数
		ristList = crRistDetailService.doGetList(qryMap);//获取企业
		crReportConInfo = crReportConInfoService.doGetById(corpid);//获取企业认缴实缴
		if(crReportConInfo.getActCon()!=null&&crReportConInfo.getPayCon()!=null&&!crReportConInfo.getPayCon().equals(BigDecimal.ZERO)){
		crReportConInfo.setPercen((crReportConInfo.getActCon().divide(crReportConInfo.getPayCon(),2,BigDecimal.ROUND_HALF_UP)).doubleValue()*100);
		}else{crReportConInfo.setPercen((double) 0);}
		qryMap.put("tableFlag", "案件审理");//司法信息
		trial = crCaseInfoService.doGetTotal(qryMap)>0?"有":"无";
		qryMap.put("tableFlag", "案件执行");
		execute = crCaseInfoService.doGetTotal(qryMap)>0?"有":"无";
		//浏览记录
		doGetCrHistoryRecords(crEntBaseInfo);
		
		return SUCCESS;
	}
	
	/**
	 * 描述：进入详情页面
	 * 
	 * @author yulirong
	 * @date 2015-11-3
	 * @return
	 * @throws Exception
	 */
	public String doShowEntBaseInfoAction() throws Exception{
		if (StringUtils.isNotBlank(corpid) && corpid.length() < 32) {
			corpid = AESEUtil.encryptContext(corpid);
		}
		return SUCCESS;
	}
	
	/**
	 * 描述：进入信用报告页面
	 * 
	 * @author gaotong
	 * @date 2015-10-20
	 * @return
	 * @throws Exception
	 */
	public String doEnCreditReportAction() throws Exception{
		if (StringUtils.isNotBlank(corpid) && corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		crCreditDms  =crCreditDmsService.doGetById(corpid);
		if(crCreditDms==null){
			corpid=AESEUtil.encryptContext(corpid);
			return NONE;
		}
		crEntBaseInfo = crEntBaseInfoService.doGetById(corpid);
		List<HzQytzf> tzf=hzQytzfService.doSelectHzQytzfListByCorpid(corpid);
		corpid=AESEUtil.encryptContext(corpid);
		for (HzQytzf hzQytzf : tzf) 
			biggestShareholder+=hzQytzf.getQymc()+" ";
		return SUCCESS;
	}
	/**
	 * 描述：进入地图页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	public String doEnRegLocMapAction() throws Exception{
		return SUCCESS;
	}
	
	/**
	 * 描述：进入关系网详情页面
	 * 
	 * @author yulirong
	 * @date 2015-10-30
	 * @return
	 * @throws Exception
	 */
	public String doEnRelationalNetAction() throws Exception{
		if (StringUtils.isNotBlank(corpid) && corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		crEntBaseInfo = crEntBaseInfoService.doGetById(corpid);
		qryMap.put("dmsEntTrade", crEntBaseInfo.getEntRealTrade());
		crCreditDms  =crCreditDmsService.doGetById(corpid);//获取企业信用评分
		if(crCreditDms!=null){
		crCreditDms.setAvgDmsScore(crCreditDmsService.getAvgScoreListByTrade(qryMap).getAvgDmsScore());}
		qryMap.put("theStartTime",HxDateUtil.getNowMonthStartDate());
	    creditRate = crRistDetailService.doGetTotal(qryMap);//获取企业风险提示总数
		return SUCCESS;
	}
	/**
	 * 描述：获取浏览记录实体
	 * 
	 * @author yulirong
	 * @date 2015-11-19
	 * @return
	 * @throws Exception
	 */
	private void doGetCrHistoryRecords(CrEntBaseInfo crEntBaseInfo) throws Exception{
		if(crEntBaseInfo!=null && StringUtils.isNotBlank(crEntBaseInfo.getCorpid())){
			CrHistoryRecords crHistoryRecords = new CrHistoryRecords();
			crHistoryRecords.setHisCorpid(crEntBaseInfo.getCorpid());
			crHistoryRecords.setHisEntName(crEntBaseInfo.getEntName());
			crHistoryRecords.setHisLegRep(crEntBaseInfo.getEntLepRep());
			crHistoryRecords.setHisOptTime(new Date());
			crHistoryRecords.setHisRegNo(crEntBaseInfo.getEntRegNo());
			crHistoryRecords.setHisRegOrg(crEntBaseInfo.getEntRegOrg());
			crHistoryRecords.setHisUserId(doGetSysUser().getId());
			crHistoryRecordsService.doSave(crHistoryRecords);
		}
	}
	
	/**
	 * 描述：跳转水气电资源
	 * @author MaYawei
	 * @date 2015-12-09
	 * @return
	 * @throws Exception
	 */
	public  String doEnWaterGasElecResAction() throws Exception{
		if (StringUtils.isNotBlank(corpid) && corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		crEntBaseInfo = crEntBaseInfoService.doGetById(corpid);
		qryMap.put("dmsEntTrade", crEntBaseInfo.getEntRealTrade());
		crCreditDms  =crCreditDmsService.doGetById(corpid);//获取企业信用评分
		if(crCreditDms!=null){
		crCreditDms.setAvgDmsScore(crCreditDmsService.getAvgScoreListByTrade(qryMap).getAvgDmsScore());}
		qryMap.put("theStartTime",HxDateUtil.getNowMonthStartDate());
	    creditRate = crRistDetailService.doGetTotal(qryMap);//获取企业风险提示总数
		return SUCCESS;
	}
	
	/**
	 * 描述：获取水气电资源
	 * @author MaYawei
	 * @date 2015-12-09
	 * @return
	 * @throws Exception
	 */
	public  String doReadWaterGasElecResJSONAction() throws Exception{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		JSONObject waterGasElecResJson = new JSONObject();
		if (StringUtils.isNotBlank(corpid) && corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		qryMap.put("corpid", corpid);
		if(publicSourceType!=null){
			if("elec".equals(publicSourceType)){
				//获得用电量信息
				waterGasElecResJson = crElecPayService.doGetAnalyElecPayList(qryMap);
			}else if("water".equals(publicSourceType)){
				//获取用水量信息
				waterGasElecResJson = crWaterPayService.doGetAnalyWaterPayList(qryMap);
			}else if("gas".equals(publicSourceType)){
				//获取用气量信息
				waterGasElecResJson = crGasPayService.doGetAnalyGasPayList(qryMap);
			}
		}
		this.addAjaxResults("dataMap",waterGasElecResJson);
		return AJAX;
	}
	
	
	public String getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(String employeeCount) {
		this.employeeCount = employeeCount;
	}
	public String getBiggestShareholder() {
		return biggestShareholder;
	}

	public void setBiggestShareholder(String biggestShareholder) {
		this.biggestShareholder = biggestShareholder;
	}

	public HzQytzfService getHzQytzfService() {
		return hzQytzfService;
	}

	public void setHzQytzfService(HzQytzfService hzQytzfService) {
		this.hzQytzfService = hzQytzfService;
	}

	public AppSearchService getAppSearchService() {
		return appSearchService;
	}

	public void setAppSearchService(AppSearchService appSearchService) {
		this.appSearchService = appSearchService;
	}

	public String getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(String searchParam) {
		this.searchParam = searchParam;
	}

	public NameResponse getNameResponse() {
		return nameResponse;
	}
	public void setNameResponse(NameResponse nameResponse) {
		this.nameResponse = nameResponse;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public CrEntBaseInfo getCrEntBaseInfo() {
		return crEntBaseInfo;
	}

	public void setCrEntBaseInfo(CrEntBaseInfo crEntBaseInfo) {
		this.crEntBaseInfo = crEntBaseInfo;
	}

	public CrEntBaseInfoService getCrEntBaseInfoService() {
		return crEntBaseInfoService;
	}

	public void setCrEntBaseInfoService(CrEntBaseInfoService crEntBaseInfoService) {
		this.crEntBaseInfoService = crEntBaseInfoService;
	}

	public String getRegloc() {
		return regloc;
	}

	public void setRegloc(String regloc) {
		this.regloc = regloc;
	}

	public CrCreditDms getCrCreditDms() {
		return crCreditDms;
	}

	public void setCrCreditDms(CrCreditDms crCreditDms) {
		this.crCreditDms = crCreditDms;
	}

	public CrCreditDmsService getCrCreditDmsService() {
		return crCreditDmsService;
	}

	public void setCrCreditDmsService(CrCreditDmsService crCreditDmsService) {
		this.crCreditDmsService = crCreditDmsService;
	}

	public CrHistoryRecordsService getCrHistoryRecordsService() {
		return crHistoryRecordsService;
	}

	public void setCrHistoryRecordsService(
			CrHistoryRecordsService crHistoryRecordsService) {
		this.crHistoryRecordsService = crHistoryRecordsService;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public CrRistIndex getCrRistIndex() {
		return crRistIndex;
	}

	public void setCrRistIndex(CrRistIndex crRistIndex) {
		this.crRistIndex = crRistIndex;
	}

	public CrRistIndexService getCrRistIndexService() {
		return crRistIndexService;
	}

	public void setCrRistIndexService(CrRistIndexService crRistIndexService) {
		this.crRistIndexService = crRistIndexService;
	}

	public CrRistDetailService getCrRistDetailService() {
		return crRistDetailService;
	}

	public void setCrRistDetailService(CrRistDetailService crRistDetailService) {
		this.crRistDetailService = crRistDetailService;
	}

	public Integer getCreditRate() {
		return creditRate;
	}

	public void setCreditRate(Integer creditRate) {
		this.creditRate = creditRate;
	}

	public List<CrRistDetail> getRistList() {
		return ristList;
	}

	public void setRistList(List<CrRistDetail> ristList) {
		this.ristList = ristList;
	}

	public CrCaseInfoService getCrCaseInfoService() {
		return crCaseInfoService;
	}

	public void setCrCaseInfoService(CrCaseInfoService crCaseInfoService) {
		this.crCaseInfoService = crCaseInfoService;
	}

	public String getTrial() {
		return trial;
	}

	public void setTrial(String trial) {
		this.trial = trial;
	}

	public String getExecute() {
		return execute;
	}

	public void setExecute(String execute) {
		this.execute = execute;
	}

	public CrReportConInfoService getCrReportConInfoService() {
		return crReportConInfoService;
	}

	public void setCrReportConInfoService(
			CrReportConInfoService crReportConInfoService) {
		this.crReportConInfoService = crReportConInfoService;
	}

	public CrReportConInfo getCrReportConInfo() {
		return crReportConInfo;
	}

	public void setCrReportConInfo(CrReportConInfo crReportConInfo) {
		this.crReportConInfo = crReportConInfo;
	}

	public CrRistDetail getCrRistDetail() {
		return crRistDetail;
	}

	public void setCrRistDetail(CrRistDetail crRistDetail) {
		this.crRistDetail = crRistDetail;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getPublicSourceType() {
		return publicSourceType;
	}

	public void setPublicSourceType(String publicSourceType) {
		this.publicSourceType = publicSourceType;
	}

	public CrElecPayService getCrElecPayService() {
		return crElecPayService;
	}

	public void setCrElecPayService(CrElecPayService crElecPayService) {
		this.crElecPayService = crElecPayService;
	}

	public CrWaterPayService getCrWaterPayService() {
		return crWaterPayService;
	}

	public void setCrWaterPayService(CrWaterPayService crWaterPayService) {
		this.crWaterPayService = crWaterPayService;
	}

	public CrGasPayService getCrGasPayService() {
		return crGasPayService;
	}

	public void setCrGasPayService(CrGasPayService crGasPayService) {
		this.crGasPayService = crGasPayService;
	}
    
	
}
