package com.cybage.onlinestore.ewallet.facade;

import com.cybage.onlinestore.ewallet.dto.EwalletCreditBalData;
import com.cybage.onlinestore.ewallet.dto.EwalletCreditBalResponse;
import com.cybage.onlinestore.ewallet.dto.EwalletUserData;
import com.cybage.onlinestore.ewallet.dto.EwalletUserResponse;
import com.cybage.onlinestore.ewallet.dto.LoginData;
import com.cybage.onlinestore.ewallet.dto.LoginResponse;

public interface EwalletFacade {
	LoginResponse validateUser(LoginData loginData);

	EwalletUserResponse createUser(EwalletUserData userdata);

	EwalletUserResponse updateUser(EwalletUserData userdata);

	EwalletCreditBalResponse creditBalance(EwalletCreditBalData creditBalData);

	EwalletUserData getUser();
}
