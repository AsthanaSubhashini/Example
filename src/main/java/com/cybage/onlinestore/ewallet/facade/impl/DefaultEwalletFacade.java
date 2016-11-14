package com.cybage.onlinestore.ewallet.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cybage.onlinestore.ewallet.dto.EwalletCreditBalData;
import com.cybage.onlinestore.ewallet.dto.EwalletCreditBalResponse;
import com.cybage.onlinestore.ewallet.dto.EwalletUserData;
import com.cybage.onlinestore.ewallet.dto.EwalletUserResponse;
import com.cybage.onlinestore.ewallet.dto.LoginData;
import com.cybage.onlinestore.ewallet.dto.LoginResponse;
import com.cybage.onlinestore.ewallet.facade.EwalletFacade;
import com.cybage.onlinestore.ewallet.model.EwalletUser;
import com.cybage.onlinestore.ewallet.service.EwalletService;

@Component
public class DefaultEwalletFacade implements EwalletFacade{
	@Autowired
	private EwalletService ewalletService;
//	private Converter<EwalletUser, EwalletUserData> ewalletUserConverter;

	@Override
	public LoginResponse validateUser(final LoginData loginData) {
		return ewalletService.validateUser(loginData);
	}

	@Override
	public EwalletUserResponse createUser(final EwalletUserData userData) {
		return ewalletService.createUser(userData);
	}

	@Override
	public EwalletUserResponse updateUser(final EwalletUserData userData) {
		return ewalletService.updateUser(userData);
	}

	@Override
	public EwalletUserData getUser() {
//		return ewalletUserConverter.convert(ewalletService.getUser("123"));
		EwalletUser source = ewalletService.getUser("123");
		EwalletUserData target = new EwalletUserData();
				
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setOrganization(source.getOrganization());
		target.setPassword(source.getPassword());
		target.setCustomerId(source.getCustomerId());
		target.setCardNumber(source.getCardNumber());
		target.setbBalance(source.getbBalance());
		target.setActiveStatus(source.getActiveStatus());
		target.setEmailId(source.getEmailId());
		target.setMobileNo(source.getMobileNo());
		target.setActiveDays(source.getActiveDays());
		
		return target ;
	}
	
	@Override
	public EwalletCreditBalResponse creditBalance(final EwalletCreditBalData creditBalData)
	{
		return ewalletService.creditBalance(creditBalData);
	}
}
