import controller.AdminController;
import controller.UserController;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ControllerTest extends TestCase {

    UserController userController;
    AdminController adminController;

    public void testControllers(){
        //todo: create invdinvidual test and mock DB/DAO classes via helper functions
        userController = new UserController();
        adminController = new AdminController();

        List<String> types = new ArrayList<>();
        types.add("car");
        types.add("BIKE");
        types.add("van");
        adminController.addBranch("B1", types);
        assertTrue(adminController.addVehicle("B1", "car", "V1", 500) );
        assertTrue(adminController.addVehicle("B1", "car", "V2", 1000) );
        assertTrue(adminController.addVehicle("B1", "BIKE", "V3", 250) );
        assertTrue(adminController.addVehicle("B1", "bike", "V4", 300) );
        assertFalse(adminController.addVehicle("B1", "bus", "V5", 2500) );

        assertTrue(userController.book("B1", "Van", 1, 5) < 0);
        assertTrue(userController.book("B1", "car", 1, 3) > 0);
        assertTrue(userController.book("B1", "bike", 2, 3) > 0);
        assertTrue(userController.book("B1", "bike", 2, 5) > 0);
    }

}
