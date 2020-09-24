package Lagret;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to the Storage-app!");
        int counter = 0;
        int choice;
        do {
            System.out.println("------------------------");
            System.out.println("\tMenu");
            System.out.println("------------------------");
            System.out.println("\t1. Create new order");
            System.out.println("\t2. Show list");
            System.out.println("\t3. Storage");
            System.out.println("\t4. Search OrderID");
            System.out.println("\t5. Confirm order");
            System.out.println("\t9. Exit");

            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Creating new order...[Use Enter]");
                SpecialOrders.addOrder();
                counter++;
            }
            if (choice == 2) {
                Storage.printlist(Storage.specialInventory);
                System.out.println("--------------------");
                System.out.println("Total items in storage: " + counter);
            }
            if (choice == 3) {
                Storage.storageMenu();
            }
            if (choice == 4) {
                System.out.println("Enter orderID: ");
                int orderId = sc.nextInt();
                Storage.search(orderId);
            }
            if (choice == 5) {
                System.out.println("Enter orderID:");
                int orderID = sc.nextInt();
                Storage.confirm(orderID);
            }

            if (choice == 9) {
                System.out.println("Exiting...");
                break;
            }
        } while (9 != choice);
    }

}