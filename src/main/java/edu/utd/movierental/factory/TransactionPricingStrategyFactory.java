package edu.utd.movierental.factory;

import edu.utd.movierental.strategy.transaction.FrequentRenterPointsTransactionStrategy;
import edu.utd.movierental.strategy.transaction.TransactionPricingStrategy;

public class TransactionPricingStrategyFactory {
    public static TransactionPricingStrategy getStrategy(){
        TransactionPricingStrategy transactionPricingStrategy = null;
        transactionPricingStrategy = FrequentRenterPointsTransactionStrategy.getInstance();
        return transactionPricingStrategy;
    }
}
