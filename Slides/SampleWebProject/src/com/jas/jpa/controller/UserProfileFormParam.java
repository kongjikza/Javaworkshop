package com.jas.jpa.controller;

public class UserProfileFormParam implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String street1;
	private String street2;
	private int provinceId;
	private int zipCode;
	private int educationInstituteId;
	private String educationQualification;
	private int educationFromYear;
	private int educationToYear;
	private String jobPosition;
	private int jobFromYear;
	private int jobToYear;
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("userName=" + userName);
		builder.append(", password=" + password);
		builder.append(", firstName=" + firstName);
		builder.append(", lastName=" + lastName);
		builder.append(", email=" + email);
		builder.append(", street1=" + street1);
		builder.append(", street2=" + street2);
		builder.append(", provinceId=" + provinceId);
		builder.append(", zipCode=" + zipCode);
		builder.append(", educationInstituteId=" + educationInstituteId);
		builder.append(", educationQualification=" + educationQualification);
		builder.append(", educationFromYear=" + educationFromYear);
		builder.append(", educationToYear=" + educationToYear);
		builder.append(", jobPosition=" + jobPosition);
		builder.append(", jobFromYear=" + jobFromYear);
		builder.append(", jobToYear=" + jobToYear);
		
		return builder.toString();
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public int getEducationInstituteId() {
		return educationInstituteId;
	}
	public void setEducationInstituteId(int educationInstituteId) {
		this.educationInstituteId = educationInstituteId;
	}
	public String getEducationQualification() {
		return educationQualification;
	}
	public void setEducationQualification(String educationQualification) {
		this.educationQualification = educationQualification;
	}
	public int getEducationFromYear() {
		return educationFromYear;
	}
	public void setEducationFromYear(int educationFromYear) {
		this.educationFromYear = educationFromYear;
	}
	public int getEducationToYear() {
		return educationToYear;
	}
	public void setEducationToYear(int educationToYear) {
		this.educationToYear = educationToYear;
	}
	public String getJobPosition() {
		return jobPosition;
	}
	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}
	public int getJobFromYear() {
		return jobFromYear;
	}
	public void setJobFromYear(int jobFromYear) {
		this.jobFromYear = jobFromYear;
	}
	public int getJobToYear() {
		return jobToYear;
	}
	public void setJobToYear(int jobToYear) {
		this.jobToYear = jobToYear;
	}
}
