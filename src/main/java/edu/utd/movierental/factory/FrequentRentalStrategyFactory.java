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
                frequentRentalPointsStrategyList.add(new DefaultFrequentRentalPointsStrategy());
                break;
            case CHILDREN_MOVIE_RENTAL:
                frequentRentalPointsStrategyList.add(new DefaultFrequentRentalPointsStrategy());
                break;
            case NEW_MOVIE_RENTAL:
                frequentRentalPointsStrategyList.add(new NewReleaseFrequentRentalPointsStrategy());
                break;
            default:
                frequentRentalPointsStrategyList.add(new NewReleaseFrequentRentalPointsStrategy());
                break;
        }

        if (rentalTypes.size() > 2) {
            frequentRentalPointsStrategyList.add(new MultipleCategoryRentalPointsStrategy());
        }

        if (customer.getAge() >= 18 && customer.getAge() <= 22 && rentalTypeCountMap.get(RentalType.NEW_MOVIE_RENTAL.name()) >= 1) {
            frequentRentalPointsStrategyList.add(new AgeRentalPointsStrategy());
        }

        return frequentRentalPointsStrategyList;
    }

}