package edu.utd.movierental;

import edu.utd.movierental.models.*;
import edu.utd.movierental.utils.RentalType;

import javax.xml.bind.*;

public class MovieRentalApplication {

    public static void main(String[] args) throws JAXBException {
        // Test Case - 1
        Customer customer = new Customer("John Smith", 25);
        Transaction transaction = new Transaction(customer);
        customer.addRental(new Rental(new Movie("Toy Story"), 1, RentalType.CHILDREN_MOVIE_RENTAL));
        customer.addRental(new Rental(new Movie("Star Wars"), 3, RentalType.NEW_MOVIE_RENTAL));
        customer.addRental(new Rental(new Movie("Mission Impossible"), 4, RentalType.REGULAR_MOVIE_RENTAL));
        transaction.processTransaction();
        System.out.println("Scenario 1: Testing Doubling Rental Points when customer rented more than two different categories ");
        System.out.println(transaction.printTransactionAsXML());
        // Test Case - 2
        customer = new Customer("Zack", 20);
        transaction = new Transaction(customer);
        customer.addRental(new Rental(new Movie("Toy Story"), 1, RentalType.CHILDREN_MOVIE_RENTAL));
        customer.addRental(new Rental(new Movie("Star Wars"), 3, RentalType.NEW_MOVIE_RENTAL));
        transaction.processTransaction();
        System.out.println("Scenario 2:Testing Doubling Rental Points for first Rental when customer age is between 18-22 & Renting at least one new release movie ");
        System.out.println(transaction.printTransactionAsXML());

        // Test Case - 3
        customer = new Customer("Tom", 21);
        transaction = new Transaction(customer);
        customer.addRental(new Rental(new Movie("Toy Story"), 1, RentalType.CHILDREN_MOVIE_RENTAL));
        customer.addRental(new Rental(new Movie("Star Wars"), 3, RentalType.NEW_MOVIE_RENTAL));
        customer.addRental(new Rental(new Movie("Mission Impossible"), 4, RentalType.REGULAR_MOVIE_RENTAL));
        transaction.processTransaction();
        System.out.println("Scenario 3:(Scenario 1) & (Scenario 2)");
        System.out.println(transaction.printTransactionAsXML());

        // Test Case - 4
        customer = new Customer("Tom", 21);
        transaction = new Transaction(customer);
        customer.addRental(new Rental(new Movie("Toy Story"), 1, RentalType.CHILDREN_MOVIE_RENTAL));
        customer.addRental(new Rental(new Movie("Frozen"), 1, RentalType.CHILDREN_MOVIE_RENTAL));
        customer.addRental(new Rental(new Movie("Star Wars"), 3, RentalType.NEW_MOVIE_RENTAL));
        customer.addRental(new Rental(new Movie("Avengers"), 1, RentalType.NEW_MOVIE_RENTAL));
        customer.addRental(new Rental(new Movie("Mission Impossible"), 4, RentalType.REGULAR_MOVIE_RENTAL));
        transaction.processTransaction();
        System.out.println("Scenario 4: (Scenario 1) & (Scenario 2) & Testing Free rental when there are 10 or more frequent renter points");
        System.out.println(transaction.printTransactionAsXML());
    }

}