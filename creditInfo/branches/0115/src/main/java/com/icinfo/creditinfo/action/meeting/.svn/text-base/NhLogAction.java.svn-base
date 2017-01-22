package com.icinfo.creditinfo.action.meeting;


import java.util.List;

import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.creditinfo.bean.meeting.NhLog;
import com.icinfo.creditinfo.service.meeting.NhLogService;

public class NhLogAction extends HxBaseAction{
	
	private static final long serialVersionUID = 1L;
	
	private NhLogService nhLogService;
	private List<NhLog> nhLogList;
	
	/**
	 * Desc:TODO
	 * 
	 * @author yulirong
	 * @return
	 * @throws Exception
	 */
	public String doGetNhLogAction() throws Exception{
		nhLogList = nhLogService.doGetList(null);
		return SUCCESS;
	}

	public NhLogService getNhLogService() {
		return nhLogService;
	}

	public void setNhLogService(NhLogService nhLogService) {
		this.nhLogService = nhLogService;
	}

	public List<NhLog> getNhLogList() {
		return nhLogList;
	}

	public void setNhLogList(List<NhLog> nhLogList) {
		this.nhLogList = nhLogList;
	}

	
}