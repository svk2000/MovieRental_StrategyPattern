package edu.utd.movierental.strategy.pricing;

import edu.utd.movierental.models.Rental;

public interface RentalPricingStrategy {
    public double computeRentalPrice(Rental rental);
}
