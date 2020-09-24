package Lagret;

import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public static Scanner sc = new Scanner(System.in);

    private static int  items = 0;
    private static int space = 300;
    public static ArrayList<Pallet> inventory = new ArrayList<>();
    public static ArrayList<SpecialOrders>  specialInventory = new ArrayList<>();
    public static ArrayList<Integer> IdCheck = new ArrayList<>();


    public Storage(int space, int items) {
        this.space = space;
        this.items = items;
    }
    public static void storageMenu()    {
        boolean exit = false;
        do {
            System.out.println("---------------------");
            System.out.println("Storage menu: ");
            System.out.println("\t1. Check storage");
            System.out.println("\t2. Show orderlist");
            System.out.println("\t3. Edit storage");
            System.out.println("\t4. Clear storage");
            System.out.println("\t9. Exit");

            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("---------------------");
                System.out.println("Maximum Storage: 300");
                System.out.println("Current Storage: " + space);
                System.out.println("[Total items: " + items + "]");
            }
            if (choice == 2) {
                printlist(specialInventory);
            }
            if (choice == 9) {
                System.out.println("Returning to menu...");
                exit = true;
                return;
            }
        }while(!exit);
    }

    public static int generateId() {
        int id = (int) (1 + 9999 * Math.random());
        checkID(id);
        return id;
    }

    public static int checkID(int id) {
        if (IdCheck.isEmpty()) {
            IdCheck.add(0, id);
        }
        else {
            for (int x = 0; x < IdCheck.size(); x++) {
                if (IdCheck.get(x) == id) {
                    System.out.println("Trying another ID...");
                    int temp = generateId();
                    checkID(temp);
                    break;
                }
            }
        }
        System.out.println("ID found");
        return id;
    }
    public static void confirm(int orderId)    {
        boolean check = false;
        int index = 0;
        for (int x = 0; x < specialInventory.size(); x++) {
            if (orderId == specialInventory.get(x).getOrderId()) {
                check = true;
                index = x;
                break;
            }
        }
        if (check)  {
            System.out.println("|OrderID matched|");
            printSearch(index);
        }
        else {
            System.out.println("|No match|");
            return;
        }

        System.out.println("Confirm order [ID-"+specialInventory.get(index).getOrderId()+"]");
        System.out.println("1. Confirm order\t2. Exit");
        int choice3 = sc.nextInt();
        if (choice3==1) {
            specialInventory.get(index).setConfirmed(true);
            System.out.println("Order confirmed!");
        }
        else {
            System.out.println("Order has not been confirmed....");
            System.out.println("Returning to Main Menu");
        }
    }

    public static void printlist(ArrayList<SpecialOrders> specialOrders)    {
        for(int x=0; x<specialInventory.size(); x++)  {
            System.out.println("-------------------------");
            System.out.println("Order [SO-"+specialInventory.get(x).getOrderId()+"]");
            System.out.println("Destination: "+specialInventory.get(x).getDestination());
            System.out.println("Delivery received: "+specialInventory.get(x).getDate());
            System.out.println("Weight: "+specialInventory.get(x).getWeight()+"Kg");
            System.out.println("Value: "+specialInventory.get(x).getValue());
            System.out.println("Required storage space: "+specialInventory.get(x).getReqSpace());
        }
    }
    public static void searchEdit(int index)    {
        boolean exit = false;
        do {
            System.out.println("----------------------------");
            System.out.println("Edit menu: ");
            System.out.println("1. Date\t2. Destination\t3. Weight\t4. Value \t9. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter new Date:");
                    String date = sc.nextLine();
                    specialInventory.get(index).setDate(date);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter new Destination:");
                    String destination = sc.nextLine();
                    specialInventory.get(index).setDestination(destination);
                    break;
                case 3:
                    System.out.println("Enter new Weight:");
                    int weight = sc.nextInt();
                    specialInventory.get(index).setWeight(weight);
                    break;
                case 4:
                    System.out.println("Enter new Value:");
                    int value = sc.nextInt();
                    specialInventory.get(index).setValue(value);
                case 9:
                    System.out.println("Exiting...");
                    exit = true;
                    return;
            }
        }while(!exit);
    }

    public static void search(int orderId) {
        boolean check = false;
        int index = 0;
        for (int x = 0; x < specialInventory.size(); x++) {
            if (orderId == specialInventory.get(x).getOrderId()) {
                check = true;
                index = x;
                break;
            }
        }
        if (check)  {
            System.out.println("|OrderID matched|");
            printSearch(index);

            System.out.println("Do you want to edit search?\n1. Yes\t2. No");
            int choice2 = sc.nextInt();
            if(choice2 == 1) {
                searchEdit(index);
            }
        }
        else System.out.println("|No match|");
    }

    public static void printSearch(int x)    {
        System.out.println("-------------------------");
        System.out.println("Order ["+specialInventory.get(x).getOrderId()+"]");
        System.out.println("Destination: "+specialInventory.get(x).getDestination());
        System.out.println("Delivery received: "+specialInventory.get(x).getDate());
        System.out.println("Weight: "+specialInventory.get(x).getWeight()+"Kg");
        System.out.println("Value: "+specialInventory.get(x).getValue());
        System.out.println("Confirmed: "+specialInventory.get(x).isConfirmed());
    }

    public static int getItems() {
        return items;
    }

    public static void setItems(int items) {
        Storage.items = items;
    }

    public static int getSpace() {
        return space;
    }

    public static void setSpace(int space) {
        Storage.space = space;
    }

    public static ArrayList<Pallet> getInventory() {
        return inventory;
    }

    public static void setInventory(ArrayList<Pallet> inventory) {
        Storage.inventory = inventory;
    }
}
