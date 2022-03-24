package service;

import commons.Helper;
import exceptions.BranchNotFound;
import exceptions.DuplicateBranch;
import exceptions.DuplicateVehicle;
import model.Branch;
import model.RentalApp;
import model.Vehicle;
import utility.VehicleType;

import java.util.List;
import java.util.logging.Logger;

public class AdminService {
    static Logger log = Logger.getLogger(AdminService.class.getName());
    private final Helper helper;

    public AdminService(){
        helper = new Helper();
    }


    public synchronized boolean addBranch(RentalApp app, String branchId, List<String> vehiclesTypes) throws DuplicateBranch {
        if (helper.verifyBranch(branchId)){
            throw new DuplicateBranch(branchId);
        }
        Branch branch = new Branch(branchId, helper.getVehicleTypeList(vehiclesTypes) );
        helper.addBranch(app, branch);

        return true;
    }

    public synchronized boolean addVehicle(String branchId, String vtype, String vehicleId, int price) throws Exception{
        if (helper.verifyVehicle(vehicleId)){
            throw new DuplicateVehicle(vehicleId);
        }
        if (!helper.verifyBranch(branchId)){
            throw new BranchNotFound(branchId);
        }

        VehicleType type = helper.getVehicleType(vtype);
        Branch branch = helper.getBranch(branchId);

        if (!branch.isValidVehicle(type) ){
            log.info("Not a Valid Vehicle Type for this branch: " + branchId);
            return false;
        }

        Vehicle vehicle = new Vehicle(vehicleId, type, price);
        helper.addVehicle(branch, vehicle);

        return true;
    }

}
