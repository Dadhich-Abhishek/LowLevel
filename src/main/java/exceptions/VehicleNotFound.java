package exceptions;

import java.util.logging.Logger;

public class VehicleNotFound extends Exception{
    static Logger log = Logger.getLogger(VehicleNotFound.class.getName());

    public VehicleNotFound(String vehicleId) {
        log.warning("Branch Not Found: " + vehicleId);
    }
}
