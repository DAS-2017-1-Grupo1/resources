package br.unb.fga.server;

import java.util.Scanner;

import javax.persistence.EntityManager;

import br.unb.fga.das.UserDAO;
import br.unb.fga.server.model.Professor;

public class Main {

	private static EntityManagerCreator creator = new EntityManagerCreator();
	private static Scanner reader;

	public static void main(String[] args) {
		EntityManager manager = creator.create();
		TransactionEvent transactionEvt = new TransactionEvent(manager);

		UserDAO userDAO = new UserDAO(manager);

		while (true) {
			reader = new Scanner(System.in);

			printOptions();

			transactionEvt.start();

			int op = reader.nextInt();

			switch (op) {
			case -1:
				transactionEvt.finish();
				return;
			case 1:
				Professor p = createProfessor();
				userDAO.create(p);
			default:
				break;
			}

			transactionEvt.done();
		}
	}

	private static void printOptions() {
		System.out.println("Type your option:");
		System.out.println("1 - Register a professor");
	}

	public static Professor createProfessor() {
		reader = new Scanner(System.in);

		Professor p = new Professor();
		
		System.out.println("Type your name");
		p.setName(reader.nextLine());

		System.out.println("Type your registration");
		p.setRegistration(reader.nextLine());

		System.out.println("Type your email");
		p.setEmail(reader.nextLine());

		System.out.println("Type your age");
		p.setAge(reader.nextInt());

		return p;
	}
}
