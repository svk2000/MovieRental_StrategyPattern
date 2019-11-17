package edu.utd.movierental.strategy.rentalpoints;

import edu.utd.movierental.models.Customer;
import edu.utd.movierental.models.Rental;

public class DefaultFrequentRentalPointsStrategy implements  FrequentRentalPointsStrategy {

    private static DefaultFrequentRentalPointsStrategy defaultFrequentRentalPointsStrategy = null;

    private DefaultFrequentRentalPointsStrategy()
    { }

    public static DefaultFrequentRentalPointsStrategy getInstance()
    {
        if (defaultFrequentRentalPointsStrategy == null)
            defaultFrequentRentalPointsStrategy = new DefaultFrequentRentalPointsStrategy();

        return defaultFrequentRentalPointsStrategy;
    }

    @Override
    public int computeRentalPoints(int frequentRenterPoints , Rental rental) {

        return ++frequentRenterPoints;
    }
}
