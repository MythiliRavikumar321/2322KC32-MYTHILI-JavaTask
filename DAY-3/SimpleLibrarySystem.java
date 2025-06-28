import java.util.*;

class Book {
    int id;
    String title;
    boolean isIssued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    public String toString() {
        return id + " - " + title + (isIssued ? " (Issued)" : " (Available)");
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(int id, String title) {
        books.add(new Book(id, title));
        System.out.println("Book added: " + title);
    }

    void removeBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                books.remove(b);
                System.out.println("Book removed: " + b.title);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void issueBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued: " + b.title);
                } else {
                    System.out.println("Book already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void returnBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned: " + b.title);
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }
}

public class SimpleLibrarySystem {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBook(1, "Java Basics");
        lib.addBook(2, "Python Fundamentals");

        lib.showBooks();

        lib.issueBook(1);
        lib.returnBook(1);
        lib.removeBook(2);

        lib.showBooks();
    }
}
