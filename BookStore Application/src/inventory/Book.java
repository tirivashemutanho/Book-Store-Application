package inventory;

import java.util.UUID;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private double price;
    private String isbn;
    private int quantity;

    public Book(String title, String author, double price, String isbn, int quantity) {
        this.bookId = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ", Price: $" + price + ")";
    }
}
