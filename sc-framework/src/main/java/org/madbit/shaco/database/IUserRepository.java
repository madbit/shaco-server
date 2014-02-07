package org.madbit.shaco.database;

import org.madbit.shaco.database.model.User;

public interface IUserRepository {

	public void createUser(User user);
	public User findUser(long userId);
	public void deleteUser(User user);
}
