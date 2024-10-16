package executable;

import inventory.Book;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Book> booksInCart;

    public Cart() {
        this.booksInCart = new ArrayList<>();
    }

    public void addBookToCart(Book book) {
        if (book.getQuantity() > 0) {
            booksInCart.add(book);
            book.reduceQuantity();
            System.out.println(book.getTitle() + " added to cart.");
        } else {
            System.out.println(book.getTitle() + " is out of stock.");
        }
    }

    public void removeBookFromCart(Book book) {
        booksInCart.remove(book);
        System.out.println(book.getTitle() + " removed from cart.");
    }

    public List<Book> getBooksInCart() {
        return booksInCart;
    }
}
