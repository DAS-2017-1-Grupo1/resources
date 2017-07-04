package br.unb.fga.server;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unb.fga.server.model.Professor;
import javassist.tools.reflect.Reflection;

public class Main {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("fgaserver");

	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Scanner reader = new Scanner(System.in);
		int opcao = -1;
		while(opcao != 0) {
			System.out.println("---\tMENU\t---\n");
			System.out.println("1 - Professor\n");
			opcao = reader.nextInt();

			switch(opcao) {
				case 1:
					System.out.println("1 - Cadastrar\n");
					System.out.println("2 - Editar\n");
					System.out.println("3 - Remover\n");
					System.out.println("4 - Listar\n");
					opcao = reader.nextInt();

					reader.nextLine();

					switch(opcao) {
						case 1:
							Professor professor = new Professor();
							System.out.println("Matrícula:");
							professor.setRegistration(reader.nextLine());
							System.out.println("Nome:");
							professor.setName(reader.nextLine());
							System.out.println("Email:");
							professor.setEmail(reader.nextLine());
							System.out.println("Idade:");
							professor.setAge(reader.nextInt());

							entityManager.getTransaction().begin();
							entityManager.persist(professor);
							entityManager.getTransaction().commit();
							entityManager.close();
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;
					}
					break;
			}
		}

		reader.close();
	}
}
