package edu.utd.movierental.factory;

import edu.utd.movierental.models.*;
import edu.utd.movierental.strategy.ChildrenMoviePricingStrategy;
import edu.utd.movierental.strategy.DefaultFrequentRentalPointsStrategy;
import edu.utd.movierental.strategy.NewMoviePricingStrategy;
import edu.utd.movierental.utils.RentalType;

public class MovieRentalFactory {
    public static Rental getMovieRental(Movie movie, int daysRented, RentalType rentalType){
        Rental rental = null;

        switch (rentalType) {
            case REGULAR_MOVIE_RENTAL:
                rental = new Rental(movie, daysRented);
                break;
            case CHILDREN_MOVIE_RENTAL:
                rental = new Rental(movie, daysRented, new ChildrenMoviePricingStrategy(), new DefaultFrequentRentalPointsStrategy());
                break;
            case NEW_MOVIE_RENTAL:
                rental = new Rental(movie, daysRented, new NewMoviePricingStrategy(), new DefaultFrequentRentalPointsStrategy());
                break;
            default:
                rental = null;
                break;
        }
        return rental;
    }
}
