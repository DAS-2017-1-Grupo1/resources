package br.unb.fga.server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerCreator {
	private final EntityManagerFactory entityManagerFactory;

	public EntityManagerCreator() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("fgaserver");
	}

	public EntityManager create() {
		return entityManagerFactory.createEntityManager();
	}
}
