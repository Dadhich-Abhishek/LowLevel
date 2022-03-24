import controller.AdminController;
import controller.UserController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Driver {
    static Logger log = Logger.getLogger(Driver.class.getName());
    public static void main(String[] args){
        log.info("Application Started");

        AdminController adminController = new AdminController();
        UserController userController = new UserController();

        List<String> types = new ArrayList<>();
        types.add("car");
        types.add("BIKE");
        types.add("van");
        log.info(String.valueOf(adminController.addBranch("B1", types)));
        log.info(String.valueOf(adminController.addVehicle("B1", "car", "V1", 500)));
        log.info(String.valueOf(adminController.addVehicle("B1", "car", "V2", 1000)));
        log.info(String.valueOf(adminController.addVehicle("B1", "BIKE", "V3", 250)));
        log.info(String.valueOf(adminController.addVehicle("B1", "bike", "V4", 300)));
        log.info(String.valueOf(adminController.addVehicle("B1", "bus", "V5", 2500)));

        log.info(String.valueOf(userController.book("B1", "Van", 1, 5)));
        log.info(String.valueOf(userController.book("B1", "car", 1, 3)));
        log.info(String.valueOf(userController.book("B1", "bike", 2, 3)));
        log.info(String.valueOf(userController.book("B1", "bike", 2, 5)));

        userController.display("B1", 1,5);
    }
}
