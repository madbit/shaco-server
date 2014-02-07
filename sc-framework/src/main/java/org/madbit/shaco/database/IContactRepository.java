package org.madbit.shaco.database;

import java.util.List;

import org.madbit.shaco.database.model.Contact;
import org.madbit.shaco.database.model.User;

public interface IContactRepository {
	
	public void createContact(Contact contact);
	public List<Contact> getContats(User user);

}
