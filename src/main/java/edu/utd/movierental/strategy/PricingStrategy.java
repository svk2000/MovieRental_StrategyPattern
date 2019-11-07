package edu.utd.movierental.strategy;

import edu.utd.movierental.models.Rental;

public interface PricingStrategy {
    public double computeRentalPrice(Rental rental);
}
