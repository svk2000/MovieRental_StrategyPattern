package edu.utd.movierental.strategy;

import edu.utd.movierental.models.Customer;

public class AgeRentalPointsStrategy implements  TransactionFrequentRenterPointsStrategy{
    public int computeRentalPoints(int frequentRenterPoints, Customer customer) {
        return frequentRenterPoints;
    }
}
