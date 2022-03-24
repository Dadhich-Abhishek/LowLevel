package service;

import model.Vehicle;

public interface PricingStrategy {
    public int getPrice(Vehicle vehicle);
}
