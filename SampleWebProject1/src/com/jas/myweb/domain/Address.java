package com.jas.myweb.domain;



import javax.xml.bind.annotation.XmlRootElement;


public class Address implements java.io.Serializable {
	private static final long serialVersionUID = 1234567890L;
	private String street1;
	private	String street2;
	private	String city;
	private	String province;
	private int zipCode;
		
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		

}
