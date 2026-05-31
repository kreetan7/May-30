import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> books = new ArrayList<>();

        int choice = 0;

        System.out.println("Library Book Tracker");

        while (choice != 5) {
            System.out.println();
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 5.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter book title: ");
                String book = scanner.nextLine();

                if (book.trim().isEmpty()) {
                    System.out.println("Book title cannot be empty.");
                } else {
                    books.add(book);
                    System.out.println("Book added.");
                }
            } else if (choice == 2) {
                if (books.isEmpty()) {
                    System.out.println("No books in the library.");
                } else {
                    System.out.println("Books:");
                    for (int i = 0; i < books.size(); i++) {
                        System.out.println((i + 1) + ". " + books.get(i));
                    }
                }
            } else if (choice == 3) {
                System.out.print("Enter book title to search: ");
                String search = scanner.nextLine();

                boolean found = false;

                for (String book : books) {
                    if (book.equalsIgnoreCase(search)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    System.out.println("Book found.");
                } else {
                    System.out.println("Book not found.");
                }
            } else if (choice == 4) {
                if (books.isEmpty()) {
                    System.out.println("No books to remove.");
                } else {
                    System.out.print("Enter book number to remove: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid book number.");
                        scanner.nextLine();
                        continue;
                    }

                    int bookNumber = scanner.nextInt();
                    scanner.nextLine();

                    if (bookNumber >= 1 && bookNumber <= books.size()) {
                        books.remove(bookNumber - 1);
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("Book number not found.");
                    }
                }
            } else if (choice == 5) {
                System.out.println("Goodbye.");
            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
