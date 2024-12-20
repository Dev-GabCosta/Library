import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private int id;
	private List<Book> borrowedBooks = new ArrayList<>();

	public User(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public void displayDetailes(){
		String  detailes = "Nome: " + this.name + ", id: " + this.id;
		System.out.println(detailes);
	}

	public void addBook(Book book) {
		borrowedBooks.add(book);
	}

	public  void removeBook(Book book){
		borrowedBooks.remove(book);
	}

}
