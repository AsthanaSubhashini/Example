package com.cybage.onlinestore.ewallet.dto;

import java.io.Serializable;

public class EwalletUserResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer customerId;
	private String cardNumber;
	private Integer status;
	private String error_desc;
	private Integer error_code;

	public EwalletUserResponse() {
		super();
	}

	public EwalletUserResponse(Integer customerId, String cardNumber, Integer status, String error_desc,
			Integer error_code) {
		super();
		this.customerId = customerId;
		this.cardNumber = cardNumber;
		this.status = status;
		this.error_desc = error_desc;
		this.error_code = error_code;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
