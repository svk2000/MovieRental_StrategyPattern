package edu.utd.movierental.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Customer {
    private String name;
    private int age;
    private List<Rental> rentals = new ArrayList<Rental>();
    private int frequentRenterPoints = 0;

    public Customer (String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void addRental(Rental rental) {

        rentals.add(rental);
    }

    
    public String getName() {
        return this.name;
    }

    public int getAge() { return  this.age; }

    public int getFrequentRenterPoints() {
        return this.frequentRenterPoints;
    }

    public void setFrequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public List<Rental> getRentals() {
        return this.rentals;
    }
    

}