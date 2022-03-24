package commons;

import model.Vehicle;
import service.PricingStrategy;

public class Strategy1 implements PricingStrategy {
    @Override
    public int getPrice(Vehicle vehicle) {
        return vehicle.getPrice();
    }
}
