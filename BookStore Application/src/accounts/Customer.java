package accounts;

import inventory.Book;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private int creditPoints;
    private List<Book> purchasedBooks;

    public Customer(String firstName, String lastName, String address, String phone) {
        super(firstName, lastName, address, phone);
        this.creditPoints = 0;
        this.purchasedBooks = new ArrayList<>();
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void addCreditPoints(int points) {
        this.creditPoints += points;
    }

    public void purchaseBook(Book book) {
        this.purchasedBooks.add(book);
        this.creditPoints += 10; // Add points for each purchase
    }

    public List<Book> getPurchasedBooks() {
        return purchasedBooks;
    }
}
