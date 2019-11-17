package edu.utd.movierental.factory;

import edu.utd.movierental.models.Rental;
import edu.utd.movierental.strategy.pricing.ChildrenMovieRentalPricingStrategy;
import edu.utd.movierental.strategy.pricing.NewMovieRentalPricingStrategy;
import edu.utd.movierental.strategy.pricing.RegularMovieRentalPricingStrategy;
import edu.utd.movierental.strategy.pricing.RentalPricingStrategy;
import edu.utd.movierental.strategy.rentalpoints.DefaultFrequentRentalPointsStrategy;
import edu.utd.movierental.strategy.rentalpoints.FrequentRentalPointsStrategy;
import edu.utd.movierental.strategy.rentalpoints.NewReleaseFrequentRentalPointsStrategy;

public class RentalPricingStrategyFactory {
    public static RentalPricingStrategy getStrategy(Rental rental){
        RentalPricingStrategy rentalPricingStrategy = null;

        switch (rental.getRentalType()) {
            case REGULAR_MOVIE_RENTAL:
                rentalPricingStrategy = RegularMovieRentalPricingStrategy.getInstance();
                break;
            case CHILDREN_MOVIE_RENTAL:
                rentalPricingStrategy = ChildrenMovieRentalPricingStrategy.getInstance();
                break;
            case NEW_MOVIE_RENTAL:
                rentalPricingStrategy = NewMovieRentalPricingStrategy.getInstance();
                break;
            default:
                rentalPricingStrategy = RegularMovieRentalPricingStrategy.getInstance();
                break;
        }
        return rentalPricingStrategy;
    }
}
