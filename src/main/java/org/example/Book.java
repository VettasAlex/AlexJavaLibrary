package org.example;

public class Book {
    public static String[] books = {
            "The Art of War",
            "Harry Potter",
            "1984",
            "Animal Farm",
            "The Art of Marketing",
            "Eragon"
    };

    public static boolean[] availability = {true, true, false, true, true, true};

    public static void viewLibrary() {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i] + " - " + (availability[i] ? "Available" : "Not Available"));
        }
    }

    public static void changeAvailability(int index, boolean availabilityStatus) {
        if (index >= 0 && index < availability.length) {
            availability[index] = availabilityStatus;
        } else {
            System.out.println("Invalid book index.");
        }
    }

    // Books to Index
    public static int findBookIndex(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].equalsIgnoreCase(title)) { //ignores case differences :)
                return i;
            }
        }
        return -1;
    }
}