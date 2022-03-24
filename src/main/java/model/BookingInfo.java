package model;

import java.util.Date;
import java.util.logging.Logger;

public class BookingInfo {
    private Vehicle vehicle;
    private Branch branch;
    private int from;
    private int to;
    private boolean paid;
    private int price;
    static Logger log = Logger.getLogger(Branch.class.getName());

    public BookingInfo(Vehicle vehicle, Branch branch, int from, int to, boolean paid) {
        this.vehicle = vehicle;
        this.branch = branch;
        this.from = from;
        this.to = to;
        this.paid = paid;
    }
    public void setPrice(int price){
        this.price = price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Branch getBranch() {
        return branch;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public boolean isPaid() {
        return paid;
    }

    public int getPrice() {
        return price;
    }
}
