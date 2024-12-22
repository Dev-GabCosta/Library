import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class Library {
	private List<Book> books = new ArrayList<>();
	private List<User> users = new ArrayList<>();

	public void registerBook(Book book) {
		books.add(book);
	}

	public void registerUser(User user) {
		users.add(user);
	}

	public void lendBook(String isbn, int userId) {
		User user = null;

		for (User u : users) {

			if (u.getId() == userId) {
				user = u;
				break;
			}

		}

		if (user.displayAmountOfBooks() == 3) {
			System.out.println("Esse usuário já possui 3 livros emprestados a ele");
		}

		if (user == null) {
			System.out.println("Usuário com ID " + userId + " não encontrado.");
		}

		Book book = null;

		for (Book b : books) {

			if (b.getIsbn().equals(isbn)) {
				book = b;
				break;
			}

		}

		if (book == null) {
			System.out.println("Livro com ISBN " + isbn + " não encontrado.");
		}

		if (!book.isAvailable()) {
			System.out.println("O livro já está emprestado.");
		} else {
			book.lend();
			user.addBook(book);
			System.out.println("Livro emprestado com sucesso ao usuário com ID: " + userId);
		}

	}

	public void returnBook(String isbn, int userId) {
		Book book = null;

		for (Book b : books) {

			if (b.getIsbn().equals(isbn)) {
				book = b;
				b.givBack();
			}
		}

		for (User u : users) {

			if (u.getId() == userId) {
				u.removeBook(book);
			}
		}

	}

	public void displayAvailableBooks() {

		for (Book b : books) {

			if (b.isAvailable()) {
				b.displayDetailes();
			}

		}

	}

	public void displayUsers() {

		for (User user : users) {
			user.displayDetailes();
		}
	}

}
