package edu.utd.movierental.strategy.transaction;

import edu.utd.movierental.models.Customer;
import edu.utd.movierental.models.Rental;

public class FrequentRenterPointsTransactionStrategy implements  TransactionPricingStrategy{
    @Override
    public double computeTransactionAmount(Customer customer) {
        if (customer.getFrequentRenterPoints() > 10) {
            customer.getRentals().get(0).setRentalPrice(0);
        }
        return customer.getRentals().stream().mapToDouble(Rental::getRentalPrice).sum();
    }
}
