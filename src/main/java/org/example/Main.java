package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner choice = new Scanner(System.in);
        boolean continueRunning = true;
        Library library = new Library();

        while (continueRunning) {
            System.out.println("Welcome to Alex's Java Library!\n" +
                    "How can I help you today?\n" +
                    "\n");
            System.out.println("1. Check Book Availability");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Show All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int userChoice = choice.nextInt();
            choice.nextLine();

            if (userChoice == 1) {
                library.checkBookAvailability();
            } else if (userChoice == 2) {
                library.borrowBook();
            } else if (userChoice == 3) {
                library.returnBook();
            } else if (userChoice == 4) {
                library.viewLibrary();
            } else if (userChoice == 5) {
                library.exitLibrary();
                continueRunning = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            if (continueRunning) {
                continueRunning = library.askIfContinue();
                if (!continueRunning) {
                    library.exitLibrary();
                }
            }
        }
    }
}
