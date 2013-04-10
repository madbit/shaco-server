package org.madbit.shaco.database;

import org.madbit.shaco.database.model.ProvisioningRequest;

public interface IRegistrationRepository {

	public void insertRegistration(ProvisioningRequest registration);
	public void deleteRegistration(ProvisioningRequest registration);
	public ProvisioningRequest findRegistrationByCode(int registrationCode);
}
