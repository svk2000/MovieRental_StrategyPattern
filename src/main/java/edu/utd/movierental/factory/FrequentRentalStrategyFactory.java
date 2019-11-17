package edu.utd.movierental.factory;

import edu.utd.movierental.models.Customer;
import edu.utd.movierental.models.Rental;
import edu.utd.movierental.strategy.rentalpoints.*;
import edu.utd.movierental.utils.RentalType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequentRentalStrategyFactory {
    public static List<FrequentRentalPointsStrategy> getStrategy(Rental rental, Customer customer){
        List<FrequentRentalPointsStrategy> frequentRentalPointsStrategyList = new ArrayList<FrequentRentalPointsStrategy>();
        List<RentalType> rentalTypes = customer.getRentals().stream().map(Rental::getRentalType).collect(Collectors.toList());
        Map<String, Long> rentalTypeCountMap = rentalTypes.stream().collect(Collectors.groupingBy(RentalType::name,Collectors.counting()));
        List<RentalType> distinctRentalTypes = customer.getRentals().stream().map(Rental::getRentalType).distinct().collect(Collectors.toList());

        switch (rental.getRentalType()) {
            case REGULAR_MOVIE_RENTAL:
                frequentRentalPointsStrategyList.add(DefaultFrequentRentalPointsStrategy.getInstance());
                break;
            case CHILDREN_MOVIE_RENTAL:
                frequentRentalPointsStrategyList.add(DefaultFrequentRentalPointsStrategy.getInstance());
                break;
            case NEW_MOVIE_RENTAL:
                frequentRentalPointsStrategyList.add(NewReleaseFrequentRentalPointsStrategy.getInstance());
                break;
            default:
                frequentRentalPointsStrategyList.add(DefaultFrequentRentalPointsStrategy.getInstance());
                break;
        }

        if (rentalTypes.size() > 2 && customer.getRentals().indexOf(rental) == 0) {
            frequentRentalPointsStrategyList.add(DoubleRegularRentalPointsStrategy.getInstance());
        }

        if (customer.getAge() >= 18 && customer.getAge() <= 22
                && rentalTypeCountMap.get(RentalType.NEW_MOVIE_RENTAL.name()) >= 1
                && customer.getRentals().indexOf(rental) == 0) {
            frequentRentalPointsStrategyList.add(DoubleRegularRentalPointsStrategy.getInstance());
        }

        return frequentRentalPointsStrategyList;
    }

}