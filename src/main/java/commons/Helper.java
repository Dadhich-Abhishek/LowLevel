package commons;

import dao.Branches;
import dao.Vehicles;
import exceptions.UnknownVehicle;
import model.Branch;
import model.RentalApp;
import model.Vehicle;
import utility.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public boolean verifyBranch(String branchId){
        return Branches.getInstance().exists(branchId);
    }
    public boolean verifyVehicle(String vehicleId) throws Exception{
        return Vehicles.getInstance().exists(vehicleId);
    }
    public boolean verifyDates(int start, int end) throws Exception{
        return start < end ;

    }

    public VehicleType getVehicleType(String vtype) throws Exception{
        vtype = vtype.toUpperCase();
        VehicleType type;
        try{
            return VehicleType.valueOf(vtype);
        }
        catch (Exception e){
            throw new UnknownVehicle(vtype);
        }
    }

    public List<VehicleType> getVehicleTypeList(List<String> types){
        List<VehicleType> vehicleTypes = new ArrayList<>();
        for (String type: types){
            type = type.toUpperCase();
            vehicleTypes.add(VehicleType.valueOf(type));
        }
        return vehicleTypes;
    }

    public Branch getBranch(String branchId){
        return Branches.getInstance().getBranch(branchId);
    }

    public Vehicle getVehicle(String vehicleId){
        return Vehicles.getInstance().getVehcile(vehicleId);
    }
    public void addBranch(RentalApp app, Branch branch){
        app.addBranch(branch.getBranchId());
        Branches.getInstance().addBranch(branch);
    }
    public void addVehicle(Branch branch, Vehicle vehicle){
        branch.addVehicle(vehicle.getVehicleId());
        Vehicles.getInstance().addVehicle(vehicle);
    }

}
