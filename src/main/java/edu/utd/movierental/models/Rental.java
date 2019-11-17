package edu.utd.movierental.models;

import edu.utd.movierental.factory.FrequentRentalStrategyFactory;
import edu.utd.movierental.factory.RentalPricingStrategyFactory;
import edu.utd.movierental.strategy.rentalpoints.FrequentRentalPointsStrategy;
import edu.utd.movierental.strategy.pricing.RentalPricingStrategy;
import edu.utd.movierental.utils.RentalType;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Rental {
    private Movie movie;
    private int daysRented;
    private int rentalPoints;
    private double rentalPrice;
    private RentalType rentalType;

    public Rental(Movie movie, int daysRented, RentalType rentalType) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.rentalType = rentalType;
        this.rentalPoints = 0;
    }

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setRentalPrice( double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public double getRentalPrice() {
        return this.rentalPrice;
    }

    public void setRentalPoints( int rentalPoints) {
        this.rentalPoints = rentalPoints;
    }

    public int getRentalPoints() {
        return this.rentalPoints;
    }

    public RentalType getRentalType() {
        return rentalType;
    }

    public double computeRentalPrice() {
        this.rentalPrice = RentalPricingStrategyFactory.getStrategy(this).computeRentalPrice(this);
        return this.rentalPrice;
    };

    public int computeRentalPoints(Customer customer) {
        List<FrequentRentalPointsStrategy> rentalPointsStrategies = FrequentRentalStrategyFactory.getStrategy(this, customer);
        int regularRentalPoints = 0;
        this.rentalPoints = 0;
        for (FrequentRentalPointsStrategy rentalPointsStrategy : rentalPointsStrategies) {
            if (rentalPointsStrategies.indexOf(rentalPointsStrategy) == 0) {
                regularRentalPoints = rentalPointsStrategy.computeRentalPoints(this.rentalPoints, this);
                this.rentalPoints = regularRentalPoints;
            } else {
                this.rentalPoints+= rentalPointsStrategy.computeRentalPoints(regularRentalPoints, this);
            }
        }
        return this.rentalPoints;
    }
}