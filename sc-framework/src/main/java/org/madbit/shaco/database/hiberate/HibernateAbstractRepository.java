package org.madbit.shaco.database.hiberate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class HibernateAbstractRepository<T> {
	
	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(T entity) {
		sessionFactory.getCurrentSession().save(entity);
	}
}
