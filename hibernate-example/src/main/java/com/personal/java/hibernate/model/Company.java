package com.personal.java.hibernate.model;

import java.io.Serializable;

public class Company implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String CompanyName;
	private int id;
	
	
	public Company(String companyName) {
		super();
		CompanyName = companyName;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
