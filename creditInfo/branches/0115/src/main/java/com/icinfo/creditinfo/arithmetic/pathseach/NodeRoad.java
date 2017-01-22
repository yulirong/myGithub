package com.icinfo.creditinfo.arithmetic.pathseach;


public class NodeRoad implements Cloneable{
	public NodeRoad(String begin,String end) {
		this.begin = begin;
		this.end = end;
	}
	private String begin;
	private String end;
	public String toString() {
		return begin + "->" + end;
	}
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	//节点相同
	public boolean equals(Object obj) {
		NodeRoad r = (NodeRoad)obj;
		if(this.getBegin().equals(r.getBegin()) && this.getEnd().equals(r.getEnd())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
