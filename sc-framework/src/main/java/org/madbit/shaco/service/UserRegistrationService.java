package org.madbit.shaco.service;

import java.util.Calendar;
import java.util.Random;

import org.apache.log4j.Logger;
import org.madbit.shaco.database.IRegistrationRequestRepository;
import org.madbit.shaco.database.RepositoryFactory;
import org.madbit.shaco.database.model.RegistrationRequest;
import org.madbit.shaco.utils.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private RepositoryFactory repositoryFactory;

	public void createNewUser(String msisdn) {
		logger.info("Service called for MSISDN " + msisdn);
		IRegistrationRequestRepository registrationRepository = repositoryFactory.getRegistrationRepository();
		RegistrationRequest provisioning = new RegistrationRequest();

		// Generate user token
		//		BigInteger token = TokenGenerator.generateId();
		//		logger.debug(token.longValue() + " " + token.toString());


		int userToken = TokenGenerator.generateIntId();

		// Calculate expiration date
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, 1);

		// Calculate the registration code
		Random r = new Random();
		int regCode = r.nextInt(99999);

		provisioning.setMsisdn(msisdn);
		provisioning.setRegistrationCode(regCode);
		provisioning.setUserToken(userToken);
		provisioning.setExpiration(c.getTime());
		registrationRepository.insertProvisioningRequest(provisioning);

	}

	public boolean confirmRegistrationCode(int registrationCode, String msisdn) {
		logger.info("Service called for registrationCode " + registrationCode + " and MSISDN " + msisdn);
		IRegistrationRequestRepository registrationRepository = repositoryFactory.getRegistrationRepository();
		RegistrationRequest registrationRequest = new RegistrationRequest();

		registrationRequest = registrationRepository.findProvisioningRequestByCode(registrationCode, msisdn);
		if(registrationRequest == null) {
			logger.debug("Registration code " + registrationCode + " not confirmed ");
			return false;
		} else {
			logger.debug("Registration code " + registrationCode + " not confirmed ");
			registrationRepository.deleteProvisioningRequest(registrationRequest.getRegistrationId());
			logger.debug("Corresponding registration request removed");
			return true;
		}
	}
}
