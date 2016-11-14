package com.cybage.onlinestore.ewallet.dto;

import java.io.Serializable;

public class EwalletUserData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String organization;
	private String password;
	private Integer customerId;
	private String cardNumber;
	private Double bBalance;
	private String activeStatus;
	private String emailId;
	private Long mobileNo;
	private String ActiveDays;

	public EwalletUserData() {
		super();
	}

	public EwalletUserData(String firstName, String lastName, String organization, String password, Integer customerId,
			String cardNumber, Double bBalance, String activeStatus, String emailId, Long mobileNo, String activeDays) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.organization = organization;
		this.password = password;
		this.customerId = customerId;
		this.cardNumber = cardNumber;
		this.bBalance = bBalance;
		this.activeStatus = activeStatus;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		ActiveDays = activeDays;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
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

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getActiveDays() {
		return ActiveDays;
	}

	public void setActiveDays(String activeDays) {
		ActiveDays = activeDays;
	}

	public Double getbBalance() {
		return bBalance;
	}

	public void setbBalance(Double bBalance) {
		this.bBalance = bBalance;
	}

}
