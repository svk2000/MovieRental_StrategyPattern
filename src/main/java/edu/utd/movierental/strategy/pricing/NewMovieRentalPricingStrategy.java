package edu.utd.movierental.strategy.pricing;

import edu.utd.movierental.models.Rental;

public class NewMovieRentalPricingStrategy implements RentalPricingStrategy {

    public static final double PER_DIEM_PRICE = 3;

    public double computeRentalPrice(Rental rental) {
        double rentalPrice = 0;
        rentalPrice += rental.getDaysRented() * PER_DIEM_PRICE;
        return rentalPrice;
    }
}
