package service;

import commons.Helper;
import exceptions.BranchNotFound;
import exceptions.InvalidDate;
import model.BookingInfo;
import model.Branch;
import model.Vehicle;
import utility.VehicleType;

import java.util.logging.Logger;

public class BookingService {
    static Logger log = Logger.getLogger(BookingService.class.getName());
    private final Helper helper;

    public BookingService(){
        helper = new Helper();
    }

    public synchronized BookingInfo bookCab(String branchId, String vtype, int start, int end) throws Exception{
        if (!helper.verifyBranch(branchId)) throw new BranchNotFound(branchId);
        if (!helper.verifyDates(start, end)) throw new InvalidDate();

        Branch branch = helper.getBranch(branchId);
        VehicleType type = helper.getVehicleType(vtype);

        //find any available vehicle with given requirement
        Vehicle vehicle = null;
        for(String id: branch.getVehicles()){
            Vehicle vehicleTemp = helper.getVehicle(id);
            if (vehicleTemp.getType() != type) continue;
            if (vehicleTemp.getBookings().size() == 0) {
                vehicle = vehicleTemp;
                break;
            }
            for (BookingInfo bookingInfo : vehicleTemp.getBookings()){
                if (bookingInfo.getFrom()>end ||  start > bookingInfo.getTo()) {
                    vehicle = vehicleTemp;
                    log.info("found vehicle :" + vehicleTemp.getVehicleId());
                    break;
                }
            }
            if (vehicle == vehicleTemp){
                break;
            }
        }

        BookingInfo bookingInfo = null;
        if (vehicle == null) {
            log.info("No Vehicles Available in this booking slot");
        }
        else {
            bookingInfo = new BookingInfo(vehicle, branch, start, end, false);
            vehicle.addBooking(bookingInfo);
        }
        return bookingInfo;
    }
}
