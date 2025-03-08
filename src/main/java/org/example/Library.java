package org.example;

import java.util.Scanner;

public class Library {

    private Scanner choice;

    public Library() {
        choice = new Scanner(System.in);
    }

    // userChoice == 1
    public void checkBookAvailability() {
        System.out.print("Enter book title to check availability: ");
        String titleToCheck = choice.nextLine();
        int index = Book.findBookIndex(titleToCheck);
        if (index != -1) {
            System.out.println(titleToCheck + " is " + (Book.availability[index] ? "Available" : "Not Available"));
            if (Book.availability[index]) {
                System.out.print("Would you like to rent it? (yes/no): ");
                String rentChoice = choice.nextLine();
                if (rentChoice.equalsIgnoreCase("yes")) {
                    Book.changeAvailability(index, false);
                    System.out.println("You have successfully rented: " + titleToCheck);
                } else {
                    System.out.println("I guess you wanted to test our library...");
                }
            }
        } else {
            System.out.println("Book not found in the library.");
        }
    }
    // userChoice == 2
    public void borrowBook() {
        System.out.print("Enter book title to borrow: ");
        String title = choice.nextLine();
        int index = Book.findBookIndex(title);
        if (index != -1) {
            Book.changeAvailability(index, false);
            System.out.println("You have successfully borrowed: " + title);
        } else {
            System.out.println("We don't have this book, but we'll look into it! :)");
        }
    }
    //userChoice == 3
    public void returnBook() {
        System.out.print("Enter book title to return: ");
        String title1 = choice.nextLine();
        int index = Book.findBookIndex(title1);
        if (index != -1) {
            if (!Book.availability[index]) {
                Book.changeAvailability(index, true);
                System.out.println("You have successfully returned: " + title1);
            } else {
                System.out.println("This book is already in the library.");
            }
        } else {
            System.out.println("You probably rented it from another library! :P");
        }
    }
    //userChoice == 4
    public void viewLibrary() {
        Book.viewLibrary();
    }

    public boolean askIfContinue() {
        System.out.print("Would you like to do anything else? (yes/no): ");
        String answer = choice.nextLine();
        return answer.equalsIgnoreCase("yes");
    }

    //userChoice == 5
    public void exitLibrary() {
        System.out.println("Thank you for using the library system.");
    }
}

