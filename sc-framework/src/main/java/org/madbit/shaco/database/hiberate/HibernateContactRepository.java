package org.madbit.shaco.database.hiberate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.madbit.shaco.database.IContactRepository;
import org.madbit.shaco.database.model.Contact;
import org.madbit.shaco.database.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HibernateContactRepository extends HibernateAbstractRepository<Contact> implements IContactRepository {

	@Transactional
	public void createContact(Contact contact) {
		super.save(contact);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Contact> getContats(User user) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Contact.class);
		criteria.add(Restrictions.eq("user", user));
		
		List<Contact> contacts = criteria.list();

		return contacts;
	}

}
