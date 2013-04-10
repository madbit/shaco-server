package org.madbit.shaco.database.hiberate;

import org.hibernate.SessionFactory;

public abstract class HibernateAbstractRepository {
	
	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
