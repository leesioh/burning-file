package kr.co.koscom.marketdata.model;

import java.io.Serializable;

public class History implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6895638366906673917L;

	private String trdPrc;
	private String opnprc;
	private String hgprc;
	
	public String getTrdPrc() {
		return trdPrc;
	}
	public void setTrdPrc(String trdPrc) {
		this.trdPrc = trdPrc;
	}
	public String getOpnprc() {
		return opnprc;
	}
	public void setOpnprc(String opnprc) {
		this.opnprc = opnprc;
	}
	public String getHgprc() {
		return hgprc;
	}
	public void setHgprc(String hgprc) {
		this.hgprc = hgprc;
	}

	
	
}