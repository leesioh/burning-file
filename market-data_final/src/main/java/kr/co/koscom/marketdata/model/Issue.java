package kr.co.koscom.marketdata.model;

import java.io.Serializable;

public class Issue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -412096850703108602L;
	
	private String isuSrtCd;
	private String isuCd;
	private String isuKorNm;
	private String isuKorAbbr;
	private String map_to;
	private String idxIndUpclssCd;
	
	
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
	public String getMap_to() {
		return map_to;
	}
	public void setMap_to(String map_to) {
		this.map_to = map_to;
	}
	public String getIdxIndUpclssCd() {
		return idxIndUpclssCd;
	}
	public void setIdxIndUpclssCd(String idxIndUpclssCd) {
		this.idxIndUpclssCd = idxIndUpclssCd;
	}
	
}