package br.unb.fga.server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unb.fga.server.model.Professor;

public class Main {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("fgaserver");

	public static void main(String[] args) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Professor p = new Professor();
		p.setName("Fernando");
		p.setEmail("fwcruz@unb.br");
		p.setAge(60);
		entityManager.persist(p);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
