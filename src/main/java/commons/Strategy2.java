package commons;

import model.Vehicle;
import service.PricingStrategy;

public class Strategy2 implements PricingStrategy {
    @Override
    public int getPrice(Vehicle vehicle) {
        int price = vehicle.getPrice() + vehicle.getPrice()/10;
        return price;
    }
}
