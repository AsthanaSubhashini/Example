package com.cybage.onlinestore.ewallet.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.cybage.onlinestore.ewallet.dto.EwalletCreditBalData;
import com.cybage.onlinestore.ewallet.dto.EwalletCreditBalResponse;
import com.cybage.onlinestore.ewallet.dto.EwalletUserData;
import com.cybage.onlinestore.ewallet.dto.EwalletUserResponse;
import com.cybage.onlinestore.ewallet.dto.LoginData;
import com.cybage.onlinestore.ewallet.dto.LoginResponse;
import com.cybage.onlinestore.ewallet.model.EwalletUser;
import com.cybage.onlinestore.ewallet.service.EwalletService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

@Component
public class DefaultEwalletService implements EwalletService {

	private static final Logger LOG = Logger.getLogger(DefaultEwalletService.class);

	@Override
	public LoginResponse validateUser(final LoginData loginData) {
		final Client client = Client.create();
		final WebResource webResource = client.resource(getUrl("login"));

		String input = null;
		LoginResponse loginResponse = null;

		final ObjectMapper mapper = new ObjectMapper();
		try {
			input = mapper.writeValueAsString(loginData);

			final ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

			loginResponse = mapper.readValue(response.getEntity(String.class), LoginResponse.class);
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		} catch (final ClientHandlerException e) {

			e.printStackTrace();
		} catch (final UniformInterfaceException e) {

			e.printStackTrace();
		} catch (final IOException e) {

			e.printStackTrace();
		}

		return loginResponse;
	}

	@Override
	public EwalletUserResponse createUser(final EwalletUserData userData) {
		final Client client = Client.create();
		final WebResource webResource = client.resource(getUrl("createuser"));

		String input = null;
		EwalletUserResponse userResponse = null;

		final ObjectMapper mapper = new ObjectMapper();
		try {
			input = mapper.writeValueAsString(userData);

			final ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

			userResponse = mapper.readValue(response.getEntity(String.class), EwalletUserResponse.class);
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		} catch (final ClientHandlerException e) {

			e.printStackTrace();
		} catch (final UniformInterfaceException e) {

			e.printStackTrace();
		} catch (final IOException e) {

			e.printStackTrace();
		}

		return userResponse;
	}

	@Override
	public EwalletUserResponse updateUser(final EwalletUserData userData) {
		final Client client = Client.create();
		final WebResource webResource = client.resource(getUrl("updateuser"));

		String input = null;
		EwalletUserResponse userResponse = null;

		final ObjectMapper mapper = new ObjectMapper();
		try {
			input = mapper.writeValueAsString(userData);

			final ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

			userResponse = mapper.readValue(response.getEntity(String.class), EwalletUserResponse.class);
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		} catch (final ClientHandlerException e) {

			e.printStackTrace();
		} catch (final UniformInterfaceException e) {

			e.printStackTrace();
		} catch (final IOException e) {

			e.printStackTrace();
		}

		return userResponse;

	}

	@Override
	public EwalletUser getUser(final String uid) {
		final ObjectMapper mapper = new ObjectMapper();
		EwalletUser user = null;

		try {
			user = mapper.readValue(new URL(getUrl("getuser")), EwalletUser.class);
		} catch (final IOException e) {
			e.printStackTrace();
		}
		System.out.println("### " + user.getFirstName());
		return user;
	}

	private String getUrl(final String prop) {
		final Properties properties = new Properties();
		InputStream inputStream = null;
		String url = null;

		try {
			inputStream = getClass().getClassLoader().getResourceAsStream("ewallet_config.properties");
			properties.load(inputStream);
			url = properties.getProperty(prop);
		} catch (final Exception e) {
			e.printStackTrace();
		}

		return url;

	}

	@Override
	public EwalletCreditBalResponse creditBalance(final EwalletCreditBalData creditBalData) {
		final Client client = Client.create();
		final WebResource webResource = client.resource(getUrl("creditbalance"));

		String input = null;
		EwalletCreditBalResponse creditBalResponse = null;

		// generating Timestamp and unique Transaction Id
		final Timestamp currentTimestamp = new Timestamp(new Date().getTime());
		Integer transactionId = null;

		try {
			final SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			transactionId = new Integer(prng.nextInt());
			LOG.info("### Txn Id: " + transactionId);
		} catch (final NoSuchAlgorithmException e1) {

			e1.printStackTrace();
		}

		// Setting Timestamp and unique Transaction Id
		creditBalData.setTimeStamp(currentTimestamp.toString());
		creditBalData.setTxnId(transactionId);
		creditBalData.setCurrencyType("INR");

		// Call to Credit Balance API
		final ObjectMapper mapper = new ObjectMapper();
		try {
			input = mapper.writeValueAsString(creditBalData);

			final ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

			creditBalResponse = mapper.readValue(response.getEntity(String.class), EwalletCreditBalResponse.class);
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		} catch (final ClientHandlerException e) {

			e.printStackTrace();
		} catch (final UniformInterfaceException e) {

			e.printStackTrace();
		} catch (final IOException e) {

			e.printStackTrace();
		}
		LOG.info("### " + creditBalResponse.getStatus());
		
		//////////////////////////////////////////
		EwalletUser source = getUser("123");
		source.setbBalance(source.getbBalance() + creditBalData.getTxnAmount());
		
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
		updateUser(target);
		/////////////////////////////////////////
		
		return creditBalResponse;
	}
}
