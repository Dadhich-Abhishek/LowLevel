package service;

import commons.Strategy1;
import commons.Strategy2;
import dao.Vehicles;
import model.*;

import java.util.logging.Logger;

public class PricingService {
    static Logger log = Logger.getLogger(PricingService.class.getName());

    public int getPrice(BookingInfo bookingInfo){
        Branch branch = bookingInfo.getBranch();
        PricingStrategy strategy;
        int booked = 0, available = 0;
        int start = bookingInfo.getFrom();
        int end = bookingInfo.getTo();
        for(String vehicle_id: branch.getVehicles()){
            Vehicle vehicle = Vehicles.getInstance().getVehcile(vehicle_id);
            available++;
            for (BookingInfo b: vehicle.getBookings()){
                if (!(b.getFrom()>end ||  start > b.getTo())){
                    booked++;
                    break;
                }
            }
        }
        if ((booked*100)/available > 80) strategy = new Strategy2();
        else strategy = new Strategy1();
        bookingInfo.setPrice(strategy.getPrice(bookingInfo.getVehicle()));
        return bookingInfo.getPrice();
    }
}
