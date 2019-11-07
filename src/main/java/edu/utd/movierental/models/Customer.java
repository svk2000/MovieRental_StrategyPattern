package edu.utd.movierental.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();
    private int frequentRenterPoints = 0;

    private Statement statement;

    public Customer (String name) {
        this.name = name;
        this.statement = new Statement(this);
    }
    
    public void addRental(Rental rental) {

        rentals.add(rental);
    }

    
    public String getName() {
        return this.name;
    }

    @XmlElement(name = "statement")
    public Statement getStatement() {
        return  this.statement;
    }

    public int getFrequentRenterPoints() {

        this.frequentRenterPoints = 0;
        for (Rental rental: this.getRentals()) {
            this.frequentRenterPoints += rental.computeRentalPoints(this.frequentRenterPoints);
        }
        return this.frequentRenterPoints;
    }

    public void setFrequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints = frequentRenterPoints;
    }

    @XmlElement(name = "rentals")
    public List<Rental> getRentals() {
        return this.rentals;
    }
    

}