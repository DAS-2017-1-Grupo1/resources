package br.unb.fga.das;

import javax.persistence.EntityManager;

import br.unb.fga.das.model.Resource;
import br.unb.fga.das.model.User;

public class ResourceDAO extends DAO<Resource> {

	public ResourceDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public void delete(Object key) {
		Resource resource = getEntityManager().find(Resource.class, key);
		getEntityManager().remove(resource);
	}

	@Override
	public Resource read(Object key) {
		return getEntityManager().find(Resource.class, key);
	}
	
	public void delete(Class c, Object key) {
		Object target = getEntityManager().find(c, key);
		c.cast(target);
		getEntityManager().remove(target);
	}

	public Resource read(Class c, Object key) {
		return getEntityManager().find(c, key);
	}
}
