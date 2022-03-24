package exceptions;

import utility.VehicleType;

import java.util.logging.Logger;

public class UnknownVehicle extends Exception{
    static Logger log = Logger.getLogger(UnknownVehicle.class.getName());

    public UnknownVehicle(String type) {
        log.warning("unknown Vehicle Type: " + type);
    }
}
