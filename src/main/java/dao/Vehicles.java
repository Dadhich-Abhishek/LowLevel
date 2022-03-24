package dao;

import model.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Vehicles {
    Map<String, Vehicle> vehicleMap;
    public static Vehicles instance = null;
    static Logger log = Logger.getLogger(Vehicles.class.getName());

    public static Vehicles getInstance() {
        if (instance == null) instance = new Vehicles();
        return instance;
    }
    private Vehicles() {
        vehicleMap = new HashMap<>();
    }

    public synchronized void addVehicle(Vehicle vehicle){
        log.info("Vehicle: " + vehicle.getVehicleId() + " is added");
        vehicleMap.put(vehicle.getVehicleId(), vehicle);
    }
    public synchronized void removeVehicle(Vehicle vehicle){
        vehicleMap.remove(vehicle.getVehicleId());
    }
    public synchronized Vehicle getVehcile(String vehicle_id){
        return vehicleMap.get(vehicle_id);
    }
    public synchronized boolean exists(String branchId){
        return vehicleMap.containsKey(branchId);
    }
}
