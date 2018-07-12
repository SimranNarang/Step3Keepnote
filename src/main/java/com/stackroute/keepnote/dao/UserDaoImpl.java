package com.stackroute.keepnote.dao;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.keepnote.exception.UserNotFoundException;
import com.stackroute.keepnote.model.User;

/*
 * This class is implementing the UserDAO interface. This class has to be annotated with 
 * @Repository annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, 
 * thus clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
@Repository
@Transactional
public class UserDaoImpl implements UserDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.(Use
	 * constructor-based autowiring.
	 */
	private SessionFactory sessionFactory;

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Create a new user
	 */

	public boolean registerUser(User user) {

		sessionFactory.getCurrentSession().save(user);
		sessionFactory.getCurrentSession().flush();
		return true;
	}

	/*
	 * Update an existing user
	 */

	public boolean updateUser(User user) {
		sessionFactory.getCurrentSession().clear();
		sessionFactory.getCurrentSession().update(user);
		sessionFactory.getCurrentSession().flush();
		return true;
	}

	/*
	 * Retrieve details of a specific user
	 */
	public User getUserById(String UserId) {
		User user = sessionFactory.getCurrentSession().get(User.class, UserId);
		sessionFactory.getCurrentSession().flush();
		return user;
	}

	/*
	 * validate an user
	 */

	public boolean validateUser(String userId, String password) throws UserNotFoundException {
		String hql = "FROM User WHERE userId = :userId AND userPassword = :password";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("userId", userId);
		query.setParameter("password",password);
		try {
		User user = (User)query.getSingleResult();
		}catch(Exception e){
			throw new UserNotFoundException("User Not Found");
		}
		return true;
		
	}

	/*
	 * Remove an existing user
	 */
	public boolean deleteUser(String userId) {
		if(getUserById(userId)==null) {
			return false;
		}
		sessionFactory.getCurrentSession().delete(getUserById(userId));
		sessionFactory.getCurrentSession().flush();
		return true;

	}

}
