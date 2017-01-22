package com.icinfo.creditinfo.bean.meeting;

import java.io.Serializable;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

public class NhLog implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String logObja;
	
	private String logObjb;
	
	private String logType;
	
	private Date logDate;
	
	private String logRemark;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogObja() {
		return logObja;
	}

	public void setLogObja(String logObja) {
		this.logObja = logObja;
	}

	public String getLogObjb() {
		return logObjb;
	}

	public void setLogObjb(String logObjb) {
		this.logObjb = logObjb;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public String getLogRemark() {
		return logRemark;
	}

	public void setLogRemark(String logRemark) {
		this.logRemark = logRemark;
	}

}
