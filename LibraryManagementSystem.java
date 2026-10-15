import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean issued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Status: " +
                (issued ? "Issued" : "Available"));
        System.out.println("-------------------------");
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static Book findBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                return b;
            }
        }
        return null;
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = Integer.parseInt(sc.nextLine());

        if (findBook(id) != null) {
            System.out.println("Book ID already exists!");
            return;
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        for (Book b : books) {
            b.display();
        }
    }

    static void searchBook() {
        System.out.print("Enter Book ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Book b = findBook(id);

        if (b != null) {
            b.display();
        } else {
            System.out.println("Book not found!");
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = Integer.parseInt(sc.nextLine());

        Book b = findBook(id);

        if (b == null) {
            System.out.println("Book not found!");
        } else if (b.issued) {
            System.out.println("Book is already issued!");
        } else {
            b.issued = true;
            System.out.println("Book issued successfully!");
        }
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = Integer.parseInt(sc.nextLine());

        Book b = findBook(id);

        if (b == null) {
            System.out.println("Book not found!");
        } else if (!b.issued) {
            System.out.println("Book was not issued!");
        } else {
            b.issued = false;
            System.out.println("Book returned successfully!");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        displayBooks();
                        break;
                    case 3:
                        searchBook();
                        break;
                    case 4:
                        issueBook();
                        break;
                    case 5:
                        returnBook();
                        break;
                    case 6:
                        System.out.println("Thank you!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }
}