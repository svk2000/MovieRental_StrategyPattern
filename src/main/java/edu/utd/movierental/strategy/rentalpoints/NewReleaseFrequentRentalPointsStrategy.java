package edu.utd.movierental.strategy.rentalpoints;

import edu.utd.movierental.models.Customer;
import edu.utd.movierental.models.Rental;

public class NewReleaseFrequentRentalPointsStrategy implements  FrequentRentalPointsStrategy {

    private static NewReleaseFrequentRentalPointsStrategy newReleaseFrequentRentalPointsStrategy = null;

    private NewReleaseFrequentRentalPointsStrategy()
    { }

    public static NewReleaseFrequentRentalPointsStrategy getInstance()
    {
        if (newReleaseFrequentRentalPointsStrategy == null)
            newReleaseFrequentRentalPointsStrategy = new NewReleaseFrequentRentalPointsStrategy();

        return newReleaseFrequentRentalPointsStrategy;
    }

    @Override
    public int computeRentalPoints(int frequentRenterPoints, Rental rental){

        if(rental.getDaysRented() > 1) {
            ++frequentRenterPoints ;
        }
        return ++frequentRenterPoints;
    }
}
