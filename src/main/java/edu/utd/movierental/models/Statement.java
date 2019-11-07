package edu.utd.movierental.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Statement {
    private Customer customer;

    private double statementDueAmount = 0;

    private String statementResult;

    public Statement( Customer customer) {
        this.customer = customer;
    }

    public double getStatementDueAmount() {
        return statementDueAmount;
    }

    public String getStatementResult() {
        return statementResult;
    }

    public String printStatementAsXML() {
        StringBuilder statementResultXML = new StringBuilder();
        statementResultXML.append("<Customer> " + this.customer.getName() + " </Customer>\n");
        statementResultXML.append("<Rentals>\n");
        for(Rental rental : this.customer.getRentals()) {
            statementResultXML.append("\t<Rental>\n\t\t<Movie> " + rental.getMovie().getTitle() + " </Movie>\n\t\t<Days_Rented> "
            + rental.getDaysRented() + " </Days_Rented>\n\t\t<Rental_Price> " + rental.computeRentalPrice() + " </Rental_Price>\n\t</Rental>\n");
        }
        statementResultXML.append("</Rentals>\n");
        statementResultXML.append("<Statement_Due_Amount> " + this.computeStatementDueAmount() + " </Statement_Due_Amount>\n");
        statementResultXML.append("<Frequent_Renter_Points> " + this.customer.getFrequentRenterPoints() + " </Frequent_Renter_Points>\n");
        return statementResultXML.toString();
    }

    public String printStatement() {

        StringBuilder statementResult = new StringBuilder();
        statementResult.append(this.printStatementHeader());
        this.computeStatementDueAmount();
        for (Rental rental : this.customer.getRentals()) {
            // show figures for this rental
            statementResult.append(this.printRentalItem(rental));
        }

       statementResult.append(this.printStatementFooter());
        this.statementResult = statementResult.toString();
        return this.statementResult;
    }

    private double computeStatementDueAmount() {
        for (Rental rental : this.customer.getRentals()) {
            this.statementDueAmount += rental.computeRentalPrice();
        }
        return this.statementDueAmount;
    }

    private String printStatementHeader() {
        return "Rental Record for " + this.customer.getName() + "\n";
    }

    private String printRentalItem(Rental rental) {
        return "\t" + rental.getMovie().getTitle() +
                "\t" + String.valueOf(rental.computeRentalPrice()) + "\n";
    }

    private String printStatementFooter() {
        return "Amount owed is " + String.valueOf(this.statementDueAmount) + "\n" +
                "You earned " + String.valueOf(this.customer.getFrequentRenterPoints()) +
                " frequent renter points";
    }
}
