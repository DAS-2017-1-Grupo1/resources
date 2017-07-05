package br.unb.fga.das.handler;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unb.fga.das.model.Allocation;
import br.unb.fga.das.model.Resource;
import br.unb.fga.das.model.User;

public class Allocator {
	
	public EntityManager entityManager;
	
	public Allocator(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public List<Allocation> getAllBy(User user) {
		Query query = entityManager
				.createQuery("SELECT a from " + Allocation.class.getSimpleName() 
						+ " a WHERE a.registration=:registration");
		query.setParameter("registration", user.getRegistration());

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Allocation> getAllBy(Resource resource) {
		Query query = entityManager
				.createQuery("SELECT a from " + Allocation.class.getSimpleName() 
						+ " a WHERE a.patrimonyCode=:patrimonyCode");
		query.setParameter("patrimonyCode", resource.getPatrimonyCode());

		return query.getResultList();
	}
	
	public void create(Allocation allocation) {
		entityManager.persist(allocation);
	}
}
