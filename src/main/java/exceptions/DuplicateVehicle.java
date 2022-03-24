package exceptions;

import java.util.logging.Logger;

public class DuplicateVehicle extends Exception{
    static Logger log = Logger.getLogger(DuplicateVehicle.class.getName());

    public DuplicateVehicle(String vehicleId) {
        log.warning("A Vehicle with same name exist:" + vehicleId);
    }
}
