package kr.co.koscom.marketdata.model;

import java.io.Serializable;

public class IssueList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3709060458148561474L;
	
	private String trdDd;
	private String mktEndTm;
	private Issue[] isuLists;
	
	public String getTrdDd() {
		return trdDd;
	}
	public void setTrdDd(String trdDd) {
		this.trdDd = trdDd;
	}
	public String getMktEndTm() {
		return mktEndTm;
	}
	public void setMktEndTm(String mktEndTm) {
		this.mktEndTm = mktEndTm;
	}
	public Issue[] getIsuLists() {
		return isuLists;
	}
	public void setIsuLists(Issue[] isuLists) {
		this.isuLists = isuLists;
	}
	
	

}