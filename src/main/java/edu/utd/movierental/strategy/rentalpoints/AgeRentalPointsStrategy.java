package edu.utd.movierental.strategy.rentalpoints;

import edu.utd.movierental.models.Customer;
import edu.utd.movierental.models.Rental;
import edu.utd.movierental.strategy.rentalpoints.FrequentRentalPointsStrategy;

public class AgeRentalPointsStrategy implements FrequentRentalPointsStrategy {
    public int computeRentalPoints(int regularRenterPoints, Rental rental, Customer customer) {

        if (customer.getRentals().indexOf(rental) == 0) {
            regularRenterPoints = regularRenterPoints * 2;
        } else {
            regularRenterPoints = 0;
        }
        return regularRenterPoints;
    }
}
