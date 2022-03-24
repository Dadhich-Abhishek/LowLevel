package controller;

import model.BookingInfo;
import service.BookingService;
import service.DisplayService;
import service.PricingService;

import java.util.logging.Logger;

public class UserController {

    BookingService booker;
    DisplayService displayer;
    PricingService pricer;
    static Logger log = Logger.getLogger(UserController.class.getName());

    public UserController(){
        booker = new BookingService();
        displayer = new DisplayService();
        pricer = new PricingService();
    }

    public int book(String branchId, String type, int start, int end){
        //bookCab(String branch_id, String vtype, int start, int end
        int price =-1;
        try{
            BookingInfo bookingInfo = booker.bookCab(branchId, type, start, end);
            if (bookingInfo != null){
                price = pricer.getPrice(bookingInfo);
            }
        }
        catch (Exception e){
            log.warning(e.getMessage());
        }
        return price;
    }

    public void display(String branch_id, int start, int end){
        try {
            displayer.displayAvailableVehicle(branch_id, start, end);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }
}
