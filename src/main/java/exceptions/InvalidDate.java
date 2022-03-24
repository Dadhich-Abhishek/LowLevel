package exceptions;

import java.util.logging.Logger;

public class InvalidDate extends Exception{
    static Logger log = Logger.getLogger(DuplicateVehicle.class.getName());

    public InvalidDate() {
        log.warning("Invalid Start/End Date");
    }
}
