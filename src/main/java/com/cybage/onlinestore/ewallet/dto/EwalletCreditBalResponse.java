package com.cybage.onlinestore.ewallet.dto;

import java.io.Serializable;

public class EwalletCreditBalResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vendorId;
	private Integer customerId;
	private String cardNumber;
	private Integer txnId;
	private Integer orderId;
	private String timeStamp;
	private float txnAmount;
	private String currencyType;
	private Integer status;
	private String error_desc;
	private Integer error_code;

	public EwalletCreditBalResponse() {
		super();
	}

	

	public EwalletCreditBalResponse(String vendorId, Integer customerId, String cardNumber, Integer txnId,
			Integer orderId, String timeStamp, float txnAmount, String currencyType, Integer status, String error_desc,
			Integer error_code) {
		super();
		this.vendorId = vendorId;
		this.customerId = customerId;
		this.cardNumber = cardNumber;
		this.txnId = txnId;
		this.orderId = orderId;
		this.timeStamp = timeStamp;
		this.txnAmount = txnAmount;
		this.currencyType = currencyType;
		this.status = status;
		this.error_desc = error_desc;
		this.error_code = error_code;
	}



	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
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

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError_desc() {
		return error_desc;
	}

	public void setError_desc(String error_desc) {
		this.error_desc = error_desc;
	}

	public Integer getError_code() {
		return error_code;
	}

	public void setError_code(Integer error_code) {
		this.error_code = error_code;
	}



	public String getCardNumber() {
		return cardNumber;
	}



	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

}
