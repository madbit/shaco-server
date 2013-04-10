package org.madbit.shaco.service;

import org.madbit.shaco.database.IRegistrationRepository;
import org.madbit.shaco.database.RepositoryFactory;
import org.madbit.shaco.database.model.ProvisioningRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewUserService {
	
	@Autowired
	private RepositoryFactory repositoryFactory;

	public void createNewUser(String msisdn) {
		
		IRegistrationRepository registrationRepository = repositoryFactory.getRegistrationRepository();
		ProvisioningRequest registration = new ProvisioningRequest();
		registration.setMsisdn(msisdn);
		registration.setRegistrationCode(123);
		registrationRepository.insertRegistration(registration);
		
	}
}
