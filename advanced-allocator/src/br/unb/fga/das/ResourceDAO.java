package br.unb.fga.das;

import javax.persistence.EntityManager;

import br.unb.fga.das.model.Resource;

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

}
