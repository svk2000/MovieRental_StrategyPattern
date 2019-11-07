package edu.utd.movierental.strategy;

import edu.utd.movierental.models.Rental;

public class DefaultFrequentRentalPointsStrategy implements  FrequentRentalPointsStrategy {
    public int computeRentalPoints(int frequentRenterPoints ,Rental rental) {
        return ++frequentRenterPoints;
    }
}
