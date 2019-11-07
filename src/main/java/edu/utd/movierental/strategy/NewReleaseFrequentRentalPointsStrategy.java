package edu.utd.movierental.strategy;

import edu.utd.movierental.models.Rental;

public class NewReleaseFrequentRentalPointsStrategy implements  FrequentRentalPointsStrategy {
    public int computeRentalPoints(int frequentRenterPoints, Rental rental){

        if(rental.getDaysRented() > 1) {
            ++frequentRenterPoints ;
        }
        return ++frequentRenterPoints;
    }
}
