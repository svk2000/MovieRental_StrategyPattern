package edu.utd.movierental.strategy.pricing;

import edu.utd.movierental.models.Rental;

public class NewMovieRentalPricingStrategy implements RentalPricingStrategy {

    public static final double PER_DIEM_PRICE = 3;

    private static NewMovieRentalPricingStrategy newMovieRentalPricingStrategy = null;

    private NewMovieRentalPricingStrategy()
    { }

    public static NewMovieRentalPricingStrategy getInstance()
    {
        if (newMovieRentalPricingStrategy == null)
            newMovieRentalPricingStrategy = new NewMovieRentalPricingStrategy();

        return newMovieRentalPricingStrategy;
    }

    @Override
    public double computeRentalPrice(Rental rental) {
        double rentalPrice = 0;
        rentalPrice += rental.getDaysRented() * PER_DIEM_PRICE;
        return rentalPrice;
    }
}
