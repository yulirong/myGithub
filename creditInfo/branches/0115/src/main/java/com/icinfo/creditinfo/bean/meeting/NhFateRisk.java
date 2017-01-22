package com.icinfo.creditinfo.bean.meeting;

import java.io.Serializable;
import java.math.BigDecimal;

public class NhFateRisk implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private BigDecimal id;
	//人物a
	private String fateObja;
	//人物b
	private String fateObjb;
	//缘分指数
	private BigDecimal fateRisk;
	
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getFateObja() {
		return fateObja;
	}
	public void setFateObja(String fateObja) {
		this.fateObja = fateObja;
	}
	public String getFateObjb() {
		return fateObjb;
	}
	public void setFateObjb(String fateObjb) {
		this.fateObjb = fateObjb;
	}
	public BigDecimal getFateRisk() {
		return fateRisk;
	}
	public void setFateRisk(BigDecimal fateRisk) {
		this.fateRisk = fateRisk;
	}
	
}

