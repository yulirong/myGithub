package com.icinfo.creditinfo.hxservice.dto.crelecpay;


import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class CrElecPayDTO {

	private String entName;
	private String regNo;
	private String elecNo;
	private String elecPeriod;
	private String elecConsumption;
	private String importFrom;
	private Date importDate;
    private String entOrgRegNo;
	private String arrearBalance;

	
	@XmlElement
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	@XmlElement
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	@XmlElement
	public String getElecNo() {
		return elecNo;
	}
	public void setElecNo(String elecNo) {
		this.elecNo = elecNo;
	}
	@XmlElement
	public String getElecPeriod() {
		return elecPeriod;
	}
	public void setElecPeriod(String elecPeriod) {
		this.elecPeriod = elecPeriod;
	}
	@XmlElement
	public String getElecConsumption() {
		return elecConsumption;
	}
	public void setElecConsumption(String elecConsumption) {
		this.elecConsumption = elecConsumption;
	}
	@XmlElement
	public String getImportFrom() {
		return importFrom;
	}
	public void setImportFrom(String importFrom) {
		this.importFrom = importFrom;
	}
	@XmlElement
	public Date getImportDate() {
		return importDate;
	}
	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}
	public String getEntOrgRegNo() {
		return entOrgRegNo;
	}
	public void setEntOrgRegNo(String entOrgRegNo) {
		this.entOrgRegNo = entOrgRegNo;
	}
	public String getArrearBalance() {
		return arrearBalance;
	}
	public void setArrearBalance(String arrearBalance) {
		this.arrearBalance = arrearBalance;
	}
	
	
}
