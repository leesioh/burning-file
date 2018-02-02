package kr.co.koscom.marketdata.model;

import java.io.Serializable;

public class MasterInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8231010009163652264L;

	private String isuKorAbbrv;
	private double per;
	private double pbr;
	private String idxIndUpclssCd;
	private String isuSrtCd;
	

	public String getIsuKorAbbrv() {
		return isuKorAbbrv;
	}
	public void setIsuKorAbbrv(String isuKorAbbrv) {
		this.isuKorAbbrv = isuKorAbbrv;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	}
	public double getPbr() {
		return pbr;
	}
	public void setPbr(double pbr) {
		this.pbr = pbr;
	}
	public String getIdxIndUpclssCd() {
		return idxIndUpclssCd;
	}
	public void setIdxIndUpclssCd(String idxIndUpclssCd) {
		this.idxIndUpclssCd = idxIndUpclssCd;
	}
	public String getIsuSrtCd() {
		return isuSrtCd;
	}
	public void setIsuSrtCd(String isuSrtCd) {
		this.isuSrtCd = isuSrtCd;
	}
}
	
