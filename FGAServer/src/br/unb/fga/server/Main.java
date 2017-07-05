package br.unb.fga.server;

import java.util.Scanner;

import javax.persistence.EntityManager;

import br.unb.fga.das.UserDAO;
import br.unb.fga.server.model.Delegate;

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

			// TODO: tem que fazer uma lógica aqui pra ter outro menu, para as operações
			switch (op) {
				case -1:
					printCRUDOptions();
					transactionEvt.finish();
					return;
				case 1:
					Delegate delegate = createDelegate();
					userDAO.create(delegate);
					readDelegate(manager);
				default:
					break;
			}

			transactionEvt.done();
		}
	}

	private static void printOptions() {
		System.out.println("Selecione uma opção:");
		System.out.println("1 - Delegado");
		System.out.println("2 - Prisioneiro");
		System.out.println("3 - Arma");
		System.out.println("4 - Cela");
		System.out.println("5 - Algema");
		System.out.println("6 - Alocar Recursos");
	}
	
	private static void printCRUDOptions() {
		System.out.println("Selecione uma operação:");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Buscar");
		System.out.println("3 - Editar");
		System.out.println("4 - Remover");
		System.out.println("5 - Listar");
	}

	public static Delegate createDelegate() {
		reader = new Scanner(System.in);

		Delegate delegate = new Delegate();

		System.out.println("Número do distintivo:");
		delegate.setRegistration(reader.nextLine());
		
		System.out.println("Nome:");
		delegate.setName(reader.nextLine());
		
		System.out.println("Delegacia:");
		delegate.setDepartment(reader.nextLine());

		return delegate;
	}
	
	public static Delegate readDelegate(EntityManager manager){
		reader = new Scanner(System.in);

		Delegate delegate = new Delegate();

		System.out.println("Número do id:");
		long id = reader.nextLong();
		
		delegate = manager.find(Delegate.class, id);
		
		return delegate;
	}
}
