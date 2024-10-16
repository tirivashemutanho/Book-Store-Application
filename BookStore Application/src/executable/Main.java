package executable;

import accounts.Administrator;
import accounts.Customer;
import inventory.Book;
import inventory.Fiction;
import inventory.NonFiction;
import inventory.Mystery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Book> bookInventory = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize administrator and customers
        Administrator admin = new Administrator("John", "Doe", "123 Admin Street", "555-1234", "admin", "adminRole", "password");
        Customer customer = new Customer("Jane", "Smith", "456 Customer Lane", "555-5678");

        // Initialize book categories and add books to inventory
        Fiction fiction = new Fiction();
        NonFiction nonFiction = new NonFiction();
        Mystery mystery = new Mystery();

        bookInventory.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99, "123456789", 5));
        bookInventory.add(new Book("Sapiens", "Yuval Noah Harari", 15.50, "987654321", 3));
        bookInventory.add(new Book("Sherlock Holmes", "Arthur Conan Doyle", 8.99, "112233445", 4));

        // Shopping Cart
        Cart cart = new Cart();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Online Bookstore!");

        while (true) {
            System.out.println("\n1. Browse Books\n2. Add Book to Cart\n3. View Cart\n4. Purchase Books\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    browseBooks();
                    break;
                case 2:
                    System.out.println("Enter the title of the book to add to cart:");
                    String title = scanner.nextLine();
                    Book bookToAdd = findBookByTitle(title);
                    if (bookToAdd != null) {
                        cart.addBookToCart(bookToAdd);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    viewCart(cart);
                    break;
                case 4:
                    purchaseBooks(cart, customer);
                    break;
                case 5:
                    System.out.println("Thank you for visiting the bookstore!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void browseBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : bookInventory) {
            System.out.println(book);
        }
    }

    private static Book findBookByTitle(String title) {
        for (Book book : bookInventory) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    private static void viewCart(Cart cart) {
        System.out.println("\nBooks in Cart:");
        for (Book book : cart.getBooksInCart()) {
            System.out.println(book);
        }
    }

    private static void purchaseBooks(Cart cart, Customer customer) {
        for (Book book : cart.getBooksInCart()) {
            customer.purchaseBook(book);
        }
        System.out.println("Books purchased! Current credit points: " + customer.getCreditPoints());
        cart.getBooksInCart().clear(); // Empty cart after purchase
    }
}
