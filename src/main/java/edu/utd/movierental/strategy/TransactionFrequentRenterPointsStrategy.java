package edu.utd.movierental.strategy;

import edu.utd.movierental.models.Customer;

public interface TransactionFrequentRenterPointsStrategy {

    public int computeRentalPoints(int frequentRenterPoints, Customer customer);

}
