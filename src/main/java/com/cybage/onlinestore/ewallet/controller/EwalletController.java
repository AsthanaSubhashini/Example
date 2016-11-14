package com.cybage.onlinestore.ewallet.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cybage.onlinestore.ewallet.constants.EwalletConstants;
import com.cybage.onlinestore.ewallet.dto.EwalletCreditBalData;
import com.cybage.onlinestore.ewallet.dto.EwalletCreditBalResponse;
import com.cybage.onlinestore.ewallet.dto.EwalletUserData;
import com.cybage.onlinestore.ewallet.dto.EwalletUserResponse;
import com.cybage.onlinestore.ewallet.dto.LoginData;
import com.cybage.onlinestore.ewallet.dto.LoginResponse;
import com.cybage.onlinestore.ewallet.facade.EwalletFacade;

@Controller
public class EwalletController {
	private static Logger LOG = Logger.getLogger(EwalletController.class.getName());

	@Autowired
	private EwalletFacade ewalletFacade;

	// Handler method for getting Login page
	@RequestMapping(value = "/")
	public String getLoginForm(final Model model) {
		LOG.info("Login Form invoked");
		model.addAttribute("loginData", new LoginData());
		// return EwalletConstants.LOGIN_PAGE;
		return EwalletConstants.LOGIN_PAGE;
	}

	// Handler method for Login
	@RequestMapping(value = "loginValidate", method = RequestMethod.POST)
	public String validateLogin(@Valid @ModelAttribute("loginData") final LoginData loginData,
			final BindingResult result, final Model model) {
		LOG.info("### username: " + loginData.getUsername());
		if (result.hasErrors()) {
			model.addAttribute("message", "Please enter data in proper format");
			return EwalletConstants.LOGIN_PAGE;
		}

		LOG.info("Login Validation invoked");
		final LoginResponse loginResponse = ewalletFacade.validateUser(loginData);
		final Integer status = loginResponse.getStatus();

		if (status.intValue() == 0) {
			return EwalletConstants.INDEX_PAGE;
		}
		model.addAttribute("message", "Username or Password is incorrect");
		return EwalletConstants.LOGIN_PAGE;
	}

	// Handler Method to render Create User View
	@RequestMapping(value = "/create")
	public String createUserView(final Model model) {
		model.addAttribute("isCreate", "yes");
		model.addAttribute("ewalletUserData", new EwalletUserData());
		return EwalletConstants.EDIT_USER;
	}

	// Handler Method to Create User
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute("ewalletUserData") final EwalletUserData userData,
			final BindingResult result, final Model model) {
		System.out.println("####" + userData.getActiveDays());

		if (result.hasErrors()) {
			model.addAttribute("message", "Please enter data in proper format");
			return EwalletConstants.EDIT_USER;
		}

		final EwalletUserResponse userResponse = ewalletFacade.createUser(userData);
		final Integer status = userResponse.getStatus();
		System.out.println("#### status: " + status);

		if (status.intValue() == 0) {
			model.addAttribute("message", "New User Created");
			return EwalletConstants.INDEX_PAGE;
		}

		model.addAttribute("message", userResponse.getError_desc());
		model.addAttribute("ewalletUserData", new EwalletUserData());

		return EwalletConstants.EDIT_USER;
	}

	// Handler Method to render Update User View
	@RequestMapping(value = "/update")
	public String updateUserView(final Model model) {
		model.addAttribute("isUpdate", "yes");
		model.addAttribute("ewalletUserData", ewalletFacade.getUser());
		return EwalletConstants.EDIT_USER;
	}

	// Handler Method to Update User View
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute("ewalletUserData") final EwalletUserData userData,
			final BindingResult result, final Model model) {
		System.out.println("####" + userData.getActiveDays());

		if (result.hasErrors()) {
			model.addAttribute("message", "Please enter data in proper format");
			return EwalletConstants.EDIT_USER;
		}

		final EwalletUserResponse userResponse = ewalletFacade.updateUser(userData);
		final Integer status = userResponse.getStatus();
		System.out.println("#### status: " + status);

		if (status.intValue() == 0) {
			model.addAttribute("message", "User data updated");
			return EwalletConstants.INDEX_PAGE;
		}

		model.addAttribute("message", userResponse.getError_desc());
		model.addAttribute("ewalletUserData", ewalletFacade.getUser());

		return EwalletConstants.EDIT_USER;
	}

	// Handler Method to render Credit Balance View
	@RequestMapping(value = "/creditbal")
	public String creditBalView(final Model model) {
		model.addAttribute("ewalletCreditBalData", new EwalletCreditBalData());
		return EwalletConstants.CREDIT_BAL;
	}

	// Handler Method to Credit Balance
	@RequestMapping(value = "/creditbalance", method = RequestMethod.POST)
	public String creditBalance(@Valid @ModelAttribute("ewalletCreditBalData") final EwalletCreditBalData creditBalData,
			final BindingResult result, final Model model) {
		if (result.hasErrors()) {
			model.addAttribute("message", "Please enter data in proper format");
			return EwalletConstants.CREDIT_BAL;
		}

		final EwalletCreditBalResponse userResponse = ewalletFacade.creditBalance(creditBalData);
		final Integer status = userResponse.getStatus();
		System.out.println("####Staus: " + status);

		if (status.intValue() == 0) {
			EwalletUserData user = ewalletFacade.getUser();
			
			model.addAttribute("message", "Balance Credited Successfully. Updated Balance is Rs." + (user.getbBalance()+ creditBalData.getTxnAmount()));
			
			return EwalletConstants.INDEX_PAGE;
		}

		model.addAttribute("message", userResponse.getError_desc());
		model.addAttribute("ewalletCreditBalData", creditBalData);
		return EwalletConstants.CREDIT_BAL;
	}

}
