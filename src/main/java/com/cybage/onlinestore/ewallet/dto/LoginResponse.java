package com.cybage.onlinestore.ewallet.dto;

import java.io.Serializable;

public class LoginResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Integer status;
	private String error_desc;
	private Integer error_code;

	public LoginResponse() {
		super();
	}

	public LoginResponse(String username, String password, Integer status, String error_desc, Integer error_code) {
		super();
		this.username = username;
		this.password = password;
		this.status = status;
		this.error_desc = error_desc;
		this.error_code = error_code;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
