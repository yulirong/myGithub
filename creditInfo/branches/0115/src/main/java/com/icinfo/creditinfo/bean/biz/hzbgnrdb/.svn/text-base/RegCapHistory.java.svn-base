package com.icinfo.creditinfo.bean.biz.hzbgnrdb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 描述：资本历史
 * 
 * @author zhuyong
 */
public class RegCapHistory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private BigDecimal weight;

	private List<RegCapItem> evolution;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public List<RegCapItem> getEvolution() {
		return evolution;
	}

	public void setEvolution(List<RegCapItem> evolution) {
		this.evolution = evolution;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
}
