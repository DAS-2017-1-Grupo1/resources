package br.unb.fga.server;

import javax.persistence.EntityManager;

public class TransactionEvent {
	private EntityManager entityManager;
	
	public TransactionEvent(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void start() {
		this.entityManager.getTransaction().begin();
	}
	
	public void done() {
		entityManager.getTransaction().commit();
	}

	public void finish() {
		entityManager.close();
	}
}
