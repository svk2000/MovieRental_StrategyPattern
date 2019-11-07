package edu.utd.movierental.strategy;

import edu.utd.movierental.models.Rental;

public class NewMoviePricingStrategy implements PricingStrategy {

    public static final double PER_DIEM_PRICE = 3;

    public double computeRentalPrice(Rental rental) {
        double rentalPrice = 0;
        rentalPrice += rental.getDaysRented() * PER_DIEM_PRICE;
        return rentalPrice;
    }
}
