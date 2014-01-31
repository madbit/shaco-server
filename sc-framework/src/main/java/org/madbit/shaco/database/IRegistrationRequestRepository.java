package org.madbit.shaco.database;

import org.madbit.shaco.database.model.RegistrationRequest;

public interface IRegistrationRequestRepository {

	public void insertProvisioningRequest(RegistrationRequest request);
	public void deleteProvisioningRequest(long registrationId);
	public RegistrationRequest findProvisioningRequestByCode(int registrationCode, String msisdn);
}
