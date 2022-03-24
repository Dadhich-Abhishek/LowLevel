package service;

import commons.Helper;
import exceptions.BranchNotFound;
import exceptions.InvalidDate;
import model.BookingInfo;
import model.Branch;
import model.Vehicle;

import java.util.logging.Logger;

public class DisplayService {
    static Logger log = Logger.getLogger(DisplayService.class.getName());
    private final Helper helper;

    public DisplayService(){
        helper = new Helper();
    }

    public void displayAvailableVehicle(String branchId, int start, int end) throws Exception{
        if (!helper.verifyBranch(branchId)) throw new BranchNotFound(branchId);
        if (!helper.verifyDates(start, end)) throw new InvalidDate();
        Branch branch = helper.getBranch(branchId);

        for(String vehicle_id: branch.getVehicles()){
            Vehicle vehicle = helper.getVehicle(vehicle_id);
            if (vehicle.getBookings().size() == 0) {
                log.info(vehicle_id + ", ");
            }
            for(BookingInfo bookingInfo : vehicle.getBookings()){
                if (bookingInfo.getFrom()>end ||  start > bookingInfo.getTo()){
                    log.info(vehicle_id + ", ");
                    break;
                }
            }
        }
    }

}
