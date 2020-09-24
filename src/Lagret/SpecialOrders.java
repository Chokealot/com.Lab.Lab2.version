package Lagret;

public class SpecialOrders extends Pallet {
    private static int max_weight = 1200;
    private int reqSpace;
    private int value;
    private boolean confirmed = false;

    public SpecialOrders(String date, String destination, int weight, int orderId, int reqSpace, int value, boolean confirmed) {
        super(date, destination, weight, orderId);
        this.reqSpace = reqSpace;
        this.value = value;
        this.confirmed = confirmed;
    }

    public static boolean checkWeight(int weight, boolean exit)    {
        System.out.println("Checking weight...");
        if (weight > max_weight)   {
            System.out.println("Weight checked! - Denied");
            System.out.println("Maximum weight is 1200 kg");
            System.out.println("Aborting order creation...");
            System.out.println("Returning to Main Menu");
            exit = false;
            return exit;
        }
        else System.out.println("Weight checked! - Accepted");
        exit = true;
        return exit;
    }
    public static int calculateSPace(int weight)    {
        weight = weight/100;
        if (weight < 1) {
            weight = 2;
        }
        return weight;
    }

    public static void addOrder()  {
        boolean exit = true;
        do {
            sc.nextLine();
            System.out.println("--------------------\nEnter date:");
            String date = sc.nextLine();
            System.out.println("Enter destination:");
            String destination = sc.nextLine();
            System.out.println("Enter weight");
            int weight = sc.nextInt();
            System.out.println("Enter order value:");
            int value = sc.nextInt();
            int reqSpace = calculateSPace(weight);
            exit = checkWeight(weight, exit);
            boolean confirmed = false;
            SpecialOrders specialorders = new SpecialOrders(date, destination, weight, Storage.generateId(), reqSpace, value, confirmed);
            Storage.specialInventory.add(0, specialorders);
            exit = false;
        } while (exit);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public int getStorage_space() {
        return super.getStorage_space();
    }

    @Override
    public void setStorage_space(int storage_space) {
        super.setStorage_space(storage_space);
    }

    @Override
    public int getOrderId() {
        return super.getOrderId();
    }

    @Override
    public void setOrderId(int orderId) {
        super.setOrderId(orderId);
    }

    @Override
    public int getWeight() {
        return super.getWeight();
    }

    @Override
    public void setWeight(int weight) {
        super.setWeight(weight);
    }

    @Override
    public String getDate() {
        return super.getDate();
    }

    @Override
    public void setDate(String date) {
        super.setDate(date);
    }

    @Override
    public String getDestination() {
        return super.getDestination();
    }

    @Override
    public void setDestination(String destination) {
        super.setDestination(destination);
    }

    public static int getMax_weight() {
        return max_weight;
    }

    public static void setMax_weight(int max_weight) {
        SpecialOrders.max_weight = max_weight;
    }

    public int getReqSpace() {
        return reqSpace;
    }

    public void setReqSpace(int reqSpace) {
        this.reqSpace = reqSpace;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
