package model;

import utility.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Branch {

    private String branchId;
    private List<String> vehicles;
    private List<VehicleType> vehicleTypes;
    static Logger log = Logger.getLogger(Branch.class.getName());

    public Branch(String id, List<VehicleType> types){
        branchId = id;
        vehicles = new ArrayList<>();
        vehicleTypes = types;
    }


    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void addVehicle(String vehicle) {
        vehicles.add(vehicle);
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public boolean isValidVehicle(VehicleType type){
        for(VehicleType v: this.getVehicleTypes()){
            if (v == type){
                return true;
            }
        }
        return false;
    }

}
