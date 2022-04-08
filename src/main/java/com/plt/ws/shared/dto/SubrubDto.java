package com.plt.ws.shared.dto;

import java.io.Serializable;

public class SubrubDto implements Serializable{
	private static final long serialVersionUID = 6835192601898364280L;
	
	private String id;

	private String subrubName;

	private String zipCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubrubName() {
		return subrubName;
	}

	public void setSubrubName(String subrubName) {
		this.subrubName = subrubName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
