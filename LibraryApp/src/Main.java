import models.Book;
import models.Library;
import utils.InputHelper;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Search for a Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            int choice = InputHelper.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    String title = InputHelper.getStringInput("Enter book title: ");
                    String author = InputHelper.getStringInput("Enter book author: ");
                    int year = InputHelper.getIntInput("Enter publication year: ");
                    library.addBook(new Book(title, author, year));
                    break;

                case 2:
                    String searchTitle = InputHelper.getStringInput("Enter book title to search: ");
                    library.searchBook(searchTitle);
                    break;

                case 3:
                    library.displayBooks();
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}