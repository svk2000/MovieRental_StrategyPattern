package edu.utd.movierental.strategy.pricing;

import edu.utd.movierental.models.Rental;

public class ChildrenMovieRentalPricingStrategy implements RentalPricingStrategy {

    public static final double PER_DIEM_PRICE = 1.5;
    public static final int DAYS_LIMIT = 3;
    public  static  final double DEFAULT_RENTAL_PRICE = 1.5;

    private static ChildrenMovieRentalPricingStrategy childrenMovieRentalPricingStrategy = null;

    private ChildrenMovieRentalPricingStrategy()
    { }

    public static ChildrenMovieRentalPricingStrategy getInstance()
    {
        if (childrenMovieRentalPricingStrategy == null)
            childrenMovieRentalPricingStrategy = new ChildrenMovieRentalPricingStrategy();

        return childrenMovieRentalPricingStrategy;
    }

    @Override
    public double computeRentalPrice(Rental rental) {
        double rentalPrice = 0;
        rentalPrice += this.DEFAULT_RENTAL_PRICE;
        if (rental.getDaysRented() > this.DAYS_LIMIT) {
            rentalPrice += (rental.getDaysRented() - this.DAYS_LIMIT) * this.PER_DIEM_PRICE;
        }
        return rentalPrice;
    }
}
