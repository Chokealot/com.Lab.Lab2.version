package Lagret;

import java.util.Scanner;

public class Pallet {
    public static Scanner sc = new Scanner(System.in);

    private static int max_weight = 250;
    private int storage_space = 2;
    private int orderId;
    private int weight;
    private String date, destination;

    public Pallet(String date, String destination, int weight, int orderId) {
        this.date = date;
        this.destination = destination;
        this.weight = weight;
        this.orderId = orderId;
    }

    public static int getMax_weight() {
        return max_weight;
    }

    public static void setMax_weight(int max_weight) {
        Pallet.max_weight = max_weight;
    }

    public int getStorage_space() {
        return storage_space;
    }

    public void setStorage_space(int storage_space) {
        this.storage_space = storage_space;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
