package org.madbit.shaco.database.hiberate;

import org.madbit.shaco.database.IUserRepository;
import org.madbit.shaco.database.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUserRepository extends HibernateAbstractRepository<User> implements IUserRepository {

	public void createUser(User user) {
		// TODO Auto-generated method stub

	}

	public User findUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

}
