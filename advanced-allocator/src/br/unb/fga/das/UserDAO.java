package br.unb.fga.das;

import javax.persistence.EntityManager;

import br.unb.fga.das.model.User;

public class UserDAO extends DAO<User> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public void delete(Class c, Object key) {
		Object target = getEntityManager().find(c, key);
		c.cast(target);
		getEntityManager().remove(target);
	}

	public User read(Class c, Object key) {
		return getEntityManager().find(c, key);
	}
	
	public void delete(Object key) {
		User target = getEntityManager().find(User.class, key);
		getEntityManager().remove(target);
	}

	public User read(Object key) {
		return getEntityManager().find(User.class, key);
	}
}
