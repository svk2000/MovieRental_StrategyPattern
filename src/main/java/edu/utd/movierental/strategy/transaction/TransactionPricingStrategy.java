package edu.utd.movierental.strategy.transaction;

import edu.utd.movierental.models.Customer;

public interface TransactionPricingStrategy {

    public double computeTransactionAmount(Customer customer);

}
