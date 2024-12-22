import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static final Library LIBRARY = new Library();
	private static final Scanner INPUT = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Olá! Esse é o seu gerenciador de catálogo de livros e clientes da biblioteca.");
		boolean newAction = false;
		String name;
		int id;
		int option = 0;

		do {
			System.out.println("Para continuar, escolha uma das opções:");
			displayMenu();

			try {
				option = INPUT.nextInt();
				INPUT.nextLine();

				switch (option) {
					case 1:
						System.out.println("Insira o nome do cliente:");
						name = INPUT.nextLine();
						System.out.println("Agora insira o id:");
						id = INPUT.nextInt();
						User user = new User(name, id);
						LIBRARY.registerUser(user);
						break;
					case 2:
						System.out.println("Insira o título do livro:");
						String title = INPUT.nextLine();
						System.out.println("Nome do autor:");
						name = INPUT.nextLine();
						System.out.println("ISBN:");
						String isbn = INPUT.nextLine();
						Book book = new Book(title, name, isbn);
						LIBRARY.registerBook(book);
						break;
					case 3:
						System.out.println("Insira o ISBN do livro:");
						isbn = INPUT.nextLine();
						System.out.println("Insira o id do usuário:");
						id = INPUT.nextInt();
						LIBRARY.lendBook(isbn, id);
						break;
					case 4:
						System.out.println("Insira o ISBN do livro:");
						isbn = INPUT.nextLine();
						System.out.println("Insira o id do usuário:");
						id = INPUT.nextInt();
						LIBRARY.returnBook(isbn, id);
						break;
					case 5:
						System.out.println("Esses são os livros disponíveis para empréstimo:");
						LIBRARY.displayAvailableBooks();
						break;
					case 6:
						LIBRARY.displayUsers();
						break;
					default:
						System.out.println("Opção inválida");
						break;
				}

				System.out.println("Deseja fazer mais algum registro? (Digite 1 para continuar, 0 para sair.)");
				option = INPUT.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("Ops! Esse campo requer que seja inserido um número");
			} catch (Exception exception) {
				System.out.println("Ops! Algo inesperado aconteceu por aqui: " + exception.getMessage());
			}

			newAction = false;

			if (option == 1) {
				newAction = true;
			} else {
				while (!newAction) {
					System.out.println("A opção que você digitou não é válida. Digite 1 para continuar ou 0 para sair do programa");
					option = INPUT.nextInt();

					if (option == 1 || option == 0) {
						newAction = true;
					}

				}

				newAction = (option == 1);
			}

		} while (newAction);

	}

	private static void displayMenu() {
		String menu = """
				1 - Cadastrar novo cliente;
				2 - Registrar novo livro;
				3 - Realizar novo empréstimo;
				4 - Registrar nova devolução de empréstimo;
				5 - Exibir lista de livros disponíveis para empréstimo;
				6 - Exibir lista de clientes cadastrados.
				""";

		System.out.println(menu);
	}


}