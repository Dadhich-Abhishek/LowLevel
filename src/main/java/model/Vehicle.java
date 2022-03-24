package model;

import utility.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Vehicle {
    private String vehicleId;
    private VehicleType type;
    private List<BookingInfo> bookings;
    private int price;
    static Logger log = Logger.getLogger(Branch.class.getName());

    public Vehicle(String vehicle_id, VehicleType type, int price){
        this.vehicleId = vehicle_id;
        this.type = type;
        this.price = price;
        bookings = new ArrayList<>();
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }


    public void setBooked(List<BookingInfo> bookings) {
        this.bookings = bookings;
    }

    public List<BookingInfo> getBookings() {
        return bookings;
    }
    public void addBooking(BookingInfo bookingInfo){
        this.bookings.add(bookingInfo);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
