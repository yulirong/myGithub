package com.icinfo.creditinfo.action.meeting;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.creditinfo.bean.meeting.NhFateRisk;
import com.icinfo.creditinfo.bean.meeting.NhLog;
import com.icinfo.creditinfo.service.meeting.NhFateRiskService;
import com.icinfo.creditinfo.service.meeting.NhLogService;

public class NhFateRiskAction extends HxBaseAction{

	private static final long serialVersionUID = 1L;
	
	private NhFateRiskService nhFateRiskService;
	
	private String firname;
	
	private String secname;
	private List<NhFateRisk> nhFateRiskList;
	private NhFateRisk nhFateRisk;
	private NhLog nhLog;
	private NhLogService nhLogService;
	
	
	/**
	 * Desc:TODO
	 * 
	 * @author yulirong
	 * @return
	 * @throws Exception
	 */
	public String doGetNhFateRiskAction() throws Exception{
		Map<String, Object> qryMap = doGetRequestMap();
		nhFateRiskList = nhFateRiskService.doGetList(qryMap);
		nhLogService.doSave(doSetNhLog(nhFateRiskList));
		this.addAjaxResults("nhFateRiskList", nhFateRiskList);
		return AJAX;
	}

	private NhLog doSetNhLog(List<NhFateRisk> nhFateRiskList) {
		nhLog = new NhLog();
		nhLog.setLogObja(firname);
		nhLog.setLogObjb(secname);
		nhLog.setLogType("1");
		nhLog.setLogDate(new Date());
		if(nhFateRiskList.size()>0){
			nhLog.setLogRemark("匹配成功");
		}else{
			nhLog.setLogRemark("匹配失败");
		}
		return nhLog;
	}

	public NhFateRiskService getNhFateRiskService() {
		return nhFateRiskService;
	}

	public void setNhFateRiskService(NhFateRiskService nhFateRiskService) {
		this.nhFateRiskService = nhFateRiskService;
	}

	public String getFirname() {
		return firname;
	}

	public void setFirname(String firname) {
		this.firname = firname;
	}

	public String getSecname() {
		return secname;
	}

	public void setSecname(String secname) {
		this.secname = secname;
	}

	public List<NhFateRisk> getNhFateRiskList() {
		return nhFateRiskList;
	}

	public void setNhFateRiskList(List<NhFateRisk> nhFateRiskList) {
		this.nhFateRiskList = nhFateRiskList;
	}

	public NhFateRisk getNhFateRisk() {
		return nhFateRisk;
	}

	public void setNhFateRisk(NhFateRisk nhFateRisk) {
		this.nhFateRisk = nhFateRisk;
	}

	public NhLog getNhLog() {
		return nhLog;
	}

	public void setNhLog(NhLog nhLog) {
		this.nhLog = nhLog;
	}

	public NhLogService getNhLogService() {
		return nhLogService;
	}

	public void setNhLogService(NhLogService nhLogService) {
		this.nhLogService = nhLogService;
	}


}
