package edu.utd.movierental.strategy.rentalpoints;

import edu.utd.movierental.models.Customer;
import edu.utd.movierental.models.Rental;

public class NewReleaseFrequentRentalPointsStrategy implements  FrequentRentalPointsStrategy {
    public int computeRentalPoints(int frequentRenterPoints, Rental rental, Customer customer){

        if(rental.getDaysRented() > 1) {
            ++frequentRenterPoints ;
        }
        return ++frequentRenterPoints;
    }
}
