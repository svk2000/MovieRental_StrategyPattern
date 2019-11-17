package edu.utd.movierental.strategy.rentalpoints;

import edu.utd.movierental.models.Customer;
import edu.utd.movierental.models.Rental;
import edu.utd.movierental.strategy.rentalpoints.FrequentRentalPointsStrategy;

public class DoubleRegularRentalPointsStrategy implements FrequentRentalPointsStrategy {

    private static DoubleRegularRentalPointsStrategy doubleRegularRentalPointsStrategy = null;

    private DoubleRegularRentalPointsStrategy()
    { }

    public static DoubleRegularRentalPointsStrategy getInstance()
    {
        if (doubleRegularRentalPointsStrategy == null)
            doubleRegularRentalPointsStrategy = new DoubleRegularRentalPointsStrategy();

        return doubleRegularRentalPointsStrategy;
    }

    @Override
    public int computeRentalPoints(int regularRenterPoints, Rental rental) {
        return regularRenterPoints * 2;
    }
}
