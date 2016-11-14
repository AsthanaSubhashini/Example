package com.cybage.onlinestore.ewallet.dto;

import java.io.Serializable;

public class EwalletCreditBalData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer customerId;
	private String cardNumber;
	private Integer txnId;
	private String adminUser;
	private String timeStamp;
	private float txnAmount;
	private String currencyType;

	public EwalletCreditBalData() {
		super();
	}

	public EwalletCreditBalData(Integer customerId, String cardNumber, Integer txnId, String adminUser,
			String timeStamp, float txnAmount, String currencyType) {
		super();
		this.customerId = customerId;
		this.cardNumber = cardNumber;
		this.txnId = txnId;
		this.adminUser = adminUser;
		this.timeStamp = timeStamp;
		this.txnAmount = txnAmount;
		this.currencyType = currencyType;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getTxnId() {
		return txnId;
	}

	public void setTxnId(Integer txnId) {
		this.txnId = txnId;
	}

	public String getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public float getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(float txnAmount) {
		this.txnAmount = txnAmount;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

}
