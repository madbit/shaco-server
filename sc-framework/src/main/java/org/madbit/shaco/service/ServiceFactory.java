package org.madbit.shaco.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;		
	}
	
	public AddressBookService getAddressBookService() {
		return applicationContext.getBean(AddressBookService.class);
	}
	
	public UserRegistrationService getUserRegistrationService() {
		return applicationContext.getBean(UserRegistrationService.class);
	}
}
