package org.madbit.shaco.database.hiberate;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.madbit.shaco.database.IRegistrationRequestRepository;
import org.madbit.shaco.database.model.RegistrationRequest;
import org.springframework.transaction.annotation.Transactional;

public class HibernateRegistrationRequestRepository extends HibernateAbstractRepository implements IRegistrationRequestRepository {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
//	@PersistenceContext
//	EntityManager entityManager;

	@Transactional
	public void insertProvisioningRequest(RegistrationRequest request) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(request);
			session.flush();
		} catch (HibernateException e) {
			logger.error(e.getMessage());
		}
	}

	@Transactional
	public void deleteProvisioningRequest(long registrationId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "delete from RegistrationRequest where registrationId = :registrationId";
		Query query = session.createQuery(sql);
		query.setLong("registrationId", registrationId);
		
		try {
			query.executeUpdate();		
		} catch (HibernateException e) {
			logger.error(e.getMessage());
		}
	}

	@Transactional(readOnly=true)
	public RegistrationRequest findProvisioningRequestByCode(int registrationCode, String msisdn) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from RegistrationRequest where registrationCode = :registrationCode and msisdn = :msisdn and expiration >= :now";
		Query query = session.createQuery(sql);
		query.setInteger("registrationCode", registrationCode);
		query.setString("msisdn", msisdn);
		query.setDate("now", new Date());
		
		RegistrationRequest provisioningRequest = null;
		try {
			provisioningRequest = (RegistrationRequest) query.uniqueResult();			
		} catch (HibernateException e) {
			logger.error(e.getMessage());
		}
		
		return provisioningRequest;
	}

}
