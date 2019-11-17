package edu.utd.movierental.models;

import edu.utd.movierental.factory.TransactionPricingStrategyFactory;
import edu.utd.movierental.strategy.transaction.FrequentRenterPointsTransactionStrategy;
import edu.utd.movierental.strategy.transaction.TransactionPricingStrategy;

public class Transaction {
    private  Customer customer;
    private double transactionAmount = 0;

    public Transaction (Customer customer) {
        this.customer = customer;
    }

    public void processTransaction() {
        int frequentRenterPoints = 0;
        this.transactionAmount = 0;
        for (Rental rental: this.customer.getRentals()){
            frequentRenterPoints += rental.computeRentalPoints(this.customer);
            rental.computeRentalPrice();
        }
        this.customer.setFrequentRenterPoints(frequentRenterPoints);
        this.transactionAmount = TransactionPricingStrategyFactory.getStrategy().computeTransactionAmount(this.customer);
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public String printTransactionAsXML() {
        StringBuilder transactionXML = new StringBuilder();
        transactionXML.append("<Customer>\n");
        transactionXML.append("<Name&Age> " + this.customer.getName() + "( Age: "+this.customer.getAge()+ ") </Name&Age>\n");
        transactionXML.append("<Rentals>\n");
        for(Rental rental : this.customer.getRentals()) {
            transactionXML.append("\t<Rental>\n\t\t<Movie> " + rental.getMovie().getTitle()+ " </Movie>\n\t\t<Rental_Category> " + rental.getRentalType().name()
                    + " </Rental_Category>\n\t\t<Days_Rented> "
                    + rental.getDaysRented() + " </Days_Rented>\n\t\t<Renter_Points> "
                    +rental.getRentalPoints() + " </Renter_Points>\n\t\t<Rental_Price> " + rental.getRentalPrice() + " </Rental_Price>\n\t</Rental>\n");
        }
        transactionXML.append("</Rentals>\n");
        transactionXML.append("<Transaction_Amount> " + this.getTransactionAmount() + " </Transaction_Amount>\n");
        transactionXML.append("<Frequent_Renter_Points> " + this.customer.getFrequentRenterPoints() + " </Frequent_Renter_Points>\n");
        transactionXML.append("</Customer>\n");
        return transactionXML.toString();
    }
}