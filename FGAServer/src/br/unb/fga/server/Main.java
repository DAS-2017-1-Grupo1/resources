package br.unb.fga.server;

import java.util.Scanner;

import javax.persistence.EntityManager;

import br.unb.fga.das.ResourceDAO;
import br.unb.fga.das.UserDAO;
import br.unb.fga.das.handler.Allocator;
import br.unb.fga.server.model.AllocationImpl;
import br.unb.fga.server.model.Delegate;
import br.unb.fga.server.model.Gun;

public class Main {

	private static EntityManagerCreator creator = new EntityManagerCreator();
	private static Scanner reader;

	public static void main(String[] args) {
		EntityManager manager = creator.create();
		TransactionEvent transactionEvt = new TransactionEvent(manager);

		UserDAO userDAO = new UserDAO(manager);
		ResourceDAO resourceDAO = new ResourceDAO(manager);

		while (true) {
			reader = new Scanner(System.in);

			printOptions();

			transactionEvt.start();

			int op = reader.nextInt();

			// TODO: tem que fazer uma l�gica aqui pra ter outro menu, para as
			// opera��es
			switch (op) {
			case -1:
				printCRUDOptions();
				transactionEvt.finish();
				return;
			case 1:
				Delegate delegate = createDelegate();
				userDAO.create(delegate);
				System.out.println(readDelegate(userDAO));
				// delegate = updateDelegate(userDAO);
				// userDAO.update(delegate);
				// deleteDelegate(userDAO);
				break;
			case 3:
				Gun gun = createGun();
				resourceDAO.create(gun);
				System.out.println(readGun(resourceDAO));
				// gun = updateGun(resourceDAO);
				// deleteGun(resourceDAO);
				break;
			case 6:
				AllocationImpl allocationImpl = alloc(userDAO, resourceDAO);
				Allocator allocator = new Allocator(manager);
				allocator.create(allocationImpl);
			default:
				break;
			}

			transactionEvt.done();
		}
	}

	private static void printOptions() {
		System.out.println("Selecione uma op��o:");
		System.out.println("1 - Delegado");
		System.out.println("2 - Prisioneiro");
		System.out.println("3 - Arma");
		System.out.println("4 - Cela");
		System.out.println("5 - Algema");
		System.out.println("6 - Alocar Recursos");
	}

	private static void printCRUDOptions() {
		System.out.println("Selecione uma opera��o:");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Buscar");
		System.out.println("3 - Editar");
		System.out.println("4 - Remover");
		System.out.println("5 - Listar");
	}

	public static Delegate createDelegate() {
		reader = new Scanner(System.in);

		Delegate delegate = new Delegate();

		System.out.println("N�mero do distintivo:");
		delegate.setRegistration(reader.nextLine());

		System.out.println("Nome:");
		delegate.setName(reader.nextLine());

		System.out.println("Delegacia:");
		delegate.setDepartment(reader.nextLine());

		return delegate;
	}

	public static Delegate readDelegate(UserDAO userDAO) {
		reader = new Scanner(System.in);

		Delegate delegate = new Delegate();

		System.out.println("N�mero do id:");
		long id = reader.nextLong();

		delegate = (Delegate) userDAO.read(Delegate.class, Long.valueOf(id));

		return delegate;
	}

	public static void deleteDelegate(UserDAO userDAO) {
		reader = new Scanner(System.in);

		Delegate delegate = readDelegate(userDAO);

		userDAO.delete(Delegate.class, delegate);
	}

	public static Delegate updateDelegate(UserDAO userDAO) {
		reader = new Scanner(System.in);

		Delegate delegate = readDelegate(userDAO);

		System.out.println("N�mero do distintivo(Antigo:" + delegate.getRegistration() + "):");
		delegate.setRegistration(reader.nextLine());

		System.out.println("Nome(Antigo:" + delegate.getName() + "):");
		delegate.setName(reader.nextLine());

		System.out.println("Delegacia(Antigo:" + delegate.getDepartment() + "):");
		delegate.setDepartment(reader.nextLine());

		return delegate;
	}

	public static Gun createGun() {
		reader = new Scanner(System.in);

		Gun gun = new Gun();

		System.out.println("Nome:");
		gun.setName(reader.nextLine());
		
		System.out.println("Codigo do Patrimonio:");
		gun.setPatrimonyCode(reader.nextLong());

		System.out.println("Calibre:");
		gun.setCaliber(reader.nextLine());

		System.out.println("Capacidade do carregador:");
		gun.setMagazineCapacity(reader.nextInt());

		return gun;
	}

	public static Gun readGun(ResourceDAO resourceDAO) {
		reader = new Scanner(System.in);

		Gun gun = new Gun();

		System.out.println("N�mero do id:");
		long id = reader.nextLong();

		gun = (Gun) resourceDAO.read(Gun.class, Long.valueOf(id));

		return gun;
	}

	public static void deleteGun(ResourceDAO resourceDAO) {
		reader = new Scanner(System.in);

		Gun gun = readGun(resourceDAO);

		resourceDAO.delete(Gun.class, gun);
	}

	public static Gun updateGun(ResourceDAO resourceDAO) {
		reader = new Scanner(System.in);

		Gun gun = readGun(resourceDAO);

		System.out.println("Nome(Antigo:" + gun.getName() + "):");
		gun.setName(reader.nextLine());

		System.out.println("Calibre(Antigo:" + gun.getCaliber() + "):");
		gun.setCaliber(reader.nextLine());

		System.out.println("Capacidade do carregador(Antigo:" + gun.getMagazineCapacity() + "):");
		gun.setMagazineCapacity(reader.nextInt());

		return gun;
	}

	public static AllocationImpl alloc(UserDAO userDAO, ResourceDAO resourceDAO) {
		reader = new Scanner(System.in);

		AllocationImpl allocation = new AllocationImpl();

		System.out.println("Us�rio:");
		Delegate delegate = readDelegate(userDAO);

		System.out.println("Recurso:");
		Gun gun = readGun(resourceDAO);

		allocation.setRegistration(delegate.getRegistration());
		allocation.setPatrimonyCode(gun.getPatrimonyCode());

		return allocation;
	}
}
