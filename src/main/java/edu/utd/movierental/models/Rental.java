package edu.utd.movierental.models;

import edu.utd.movierental.strategy.DefaultFrequentRentalPointsStrategy;
import edu.utd.movierental.strategy.FrequentRentalPointsStrategy;
import edu.utd.movierental.strategy.PricingStrategy;
import edu.utd.movierental.strategy.RegularMoviePricingStrategy;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rental {
    private Movie movie;
    private int daysRented;
    private int rentalPoints = 0;
    private Customer customer;
    private  PricingStrategy pricingStrategy;
    private FrequentRentalPointsStrategy frequentRentalPointsStrategy;
    
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.customer = customer;
        this.pricingStrategy =  new RegularMoviePricingStrategy();
        this.frequentRentalPointsStrategy = new DefaultFrequentRentalPointsStrategy();
    }

    public Rental(Movie movie, int daysRented, PricingStrategy pricingStrategy, FrequentRentalPointsStrategy frequentRentalPointsStrategy) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.pricingStrategy =  pricingStrategy;
        this.frequentRentalPointsStrategy = frequentRentalPointsStrategy;
    }

    public int getDaysRented() {
        return daysRented;
    }
    
    public Movie getMovie() {
        return movie;
    }

    public double computeRentalPrice() {
        return this.pricingStrategy.computeRentalPrice(this);
    };

    public int computeRentalPoints(int frequentRenterPoints) {
        return this.frequentRentalPointsStrategy.computeRentalPoints(frequentRenterPoints, this);
    }
}