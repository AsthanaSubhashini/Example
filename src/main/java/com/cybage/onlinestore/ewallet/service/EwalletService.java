package com.cybage.onlinestore.ewallet.service;

import com.cybage.onlinestore.ewallet.dto.EwalletCreditBalData;
import com.cybage.onlinestore.ewallet.dto.EwalletCreditBalResponse;
import com.cybage.onlinestore.ewallet.dto.EwalletUserData;
import com.cybage.onlinestore.ewallet.dto.EwalletUserResponse;
import com.cybage.onlinestore.ewallet.dto.LoginData;
import com.cybage.onlinestore.ewallet.dto.LoginResponse;
import com.cybage.onlinestore.ewallet.model.EwalletUser;

public interface EwalletService {

	LoginResponse validateUser(LoginData loginData);

	EwalletUserResponse createUser(EwalletUserData userData);

	EwalletUserResponse updateUser(EwalletUserData userData);

	EwalletUser getUser(String uid);

	EwalletCreditBalResponse creditBalance(EwalletCreditBalData creditBalData);

}
