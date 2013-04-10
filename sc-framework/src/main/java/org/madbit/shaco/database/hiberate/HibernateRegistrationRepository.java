package org.madbit.shaco.database.hiberate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.madbit.shaco.database.IRegistrationRepository;
import org.madbit.shaco.database.model.ProvisioningRequest;
import org.springframework.transaction.annotation.Transactional;

public class HibernateRegistrationRepository extends HibernateAbstractRepository implements IRegistrationRepository {
	
//	@PersistenceContext
//	EntityManager entityManager;

	@Transactional
	public void insertRegistration(ProvisioningRequest registration) {
		Session session = sessionFactory.openSession();
		try {
			session.save(registration);
			session.flush();
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
	}

	@Transactional
	public void deleteRegistration(ProvisioningRequest registration) {
		// TODO Auto-generated method stub

	}

	public ProvisioningRequest findRegistrationByCode(int registrationCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
