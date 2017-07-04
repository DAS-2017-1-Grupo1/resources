package br.unb.fga.das;

import javax.persistence.EntityManager;

public abstract class DAO<E> {

	private EntityManager entityManager;

	public DAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void create(E entity) {
		this.entityManager.persist(entity);
	}

	public void update(E entity) {
		this.entityManager.merge(entity);
	}

	public abstract void delete(Object key);

	public abstract E read(Object key);

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
