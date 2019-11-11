package edu.utd.movierental.strategy.pricing;

import edu.utd.movierental.models.Rental;

public class RegularMovieRentalPricingStrategy implements RentalPricingStrategy {

    public static final double PER_DIEM_PRICE = 1.5;
    public static final int DAYS_LIMIT = 2;
    public  static  final double BASE_RENTAL_PRICE = 2;

    public double computeRentalPrice(Rental rental) {
        double rentalPrice = 0;
        rentalPrice += this.BASE_RENTAL_PRICE;
        if (rental.getDaysRented() > this.DAYS_LIMIT) {
            rentalPrice += (rental.getDaysRented() - this.DAYS_LIMIT) * this.PER_DIEM_PRICE;
        }
        return rentalPrice;
    }
}
