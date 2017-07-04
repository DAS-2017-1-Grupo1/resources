package br.unb.fga.server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unb.fga.server.model.Professor;
import br.unb.fga.server.model.Student;

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
		Student s = new Student();
		s.setEmail("teste");
		entityManager.persist(p);
		entityManager.persist(s);
		entityManager.getTransaction().commit();
		entityManager.close();

	}
}
