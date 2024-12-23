public class Book {
	private String title;
	private String author;
	private String isbn;
	private boolean available;

	public Book(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.available = true;
	}

	public void displayDetailes() {
		String detailes = "Título: " + this.title + ", " + "autor: " + this.author + ", isbn: " + this.isbn + ", disponível para empréstimo: " + this.available;
		System.out.println(detailes);
	}

	public void lend() {
		this.available = false;
	}

	public void givBack() {
		this.available = true;
	}

	public boolean isAvailable() {
		return available;
	}

	public String getIsbn() {
		return isbn;
	}

}
