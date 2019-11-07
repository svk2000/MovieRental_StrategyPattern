package edu.utd.movierental.strategy;

import edu.utd.movierental.models.Customer;
import edu.utd.movierental.models.Rental;

public interface FrequentRentalPointsStrategy {

    public int computeRentalPoints(int frequenterRenterPoints, Rental rental);
}
