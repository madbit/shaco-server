package org.madbit.shaco.database;

import org.madbit.shaco.database.hiberate.HibernateRegistrationRequestRepository;
import org.madbit.shaco.database.hiberate.HibernateUserRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class RepositoryFactory implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	public IRegistrationRequestRepository getRegistrationRepository() {
		return applicationContext.getBean(HibernateRegistrationRequestRepository.class);
	}
	
	public IUserRepository getUserRepository() {
		return applicationContext.getBean(HibernateUserRepository.class);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
