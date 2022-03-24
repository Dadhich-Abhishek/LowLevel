package controller;

import model.RentalApp;
import service.AdminService;

import java.util.List;
import java.util.logging.Logger;

public class AdminController {
    AdminService adminService;
    RentalApp rentalApp;
    static Logger log = Logger.getLogger(AdminController.class.getName());

    public AdminController(){
        adminService = new AdminService();
        rentalApp = new RentalApp("Service");
    }

    public boolean addBranch(String branch_id, List<String> vehiclesTypes){
        boolean success;
        try{
            success = adminService.addBranch(rentalApp, branch_id, vehiclesTypes);
        }
        catch(Exception e){
            log.info(e.getMessage());
            success = false;
        }
        return success;
    }
    public boolean addVehicle(String branch_id, String type, String vehicle_id, int price){
        boolean success;
        try{
            success = adminService.addVehicle(branch_id, type,  vehicle_id, price);
        }
        catch(Exception e){
            log.info(e.getMessage());
            success = false;
        }
        return success;
    }

}
