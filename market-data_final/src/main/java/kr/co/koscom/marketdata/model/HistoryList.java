package kr.co.koscom.marketdata.model;

import java.io.Serializable;

public class HistoryList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2189327144266777124L;

	private String isuSrtCd;
	private String isuCd;
	private String isuKorNm;
	private String isuKorAbbr;
	
	private History[] hisLists;
	
	public String getIsuSrtCd() {
		return isuSrtCd;
	}
	public void setIsuSrtCd(String isuSrtCd) {
		this.isuSrtCd = isuSrtCd;
	}
	public String getIsuCd() {
		return isuCd;
	}
	public void setIsuCd(String isuCd) {
		this.isuCd = isuCd;
	}
	public String getIsuKorNm() {
		return isuKorNm;
	}
	public void setIsuKorNm(String isuKorNm) {
		this.isuKorNm = isuKorNm;
	}
	public String getIsuKorAbbr() {
		return isuKorAbbr;
	}
	public void setIsuKorAbbr(String isuKorAbbr) {
		this.isuKorAbbr = isuKorAbbr;
	}

	public History[] getHisLists() {
		return hisLists;
	}

	public void setHisLists(History[] hisLists) {
		this.hisLists = hisLists;
	}
	
	
}