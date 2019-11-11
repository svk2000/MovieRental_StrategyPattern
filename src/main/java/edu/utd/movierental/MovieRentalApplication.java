package edu.utd.movierental;

import edu.utd.movierental.models.*;
import edu.utd.movierental.utils.RentalType;

import javax.xml.bind.*;

public class MovieRentalApplication {

    public static void main(String[] args) throws JAXBException {
        Customer customer = new Customer("John Smith", 20);
        Transaction transaction = new Transaction(customer);
        customer.addRental(new Rental(new Movie("Toy Story"), 1, RentalType.CHILDREN_MOVIE_RENTAL));
        customer.addRental(new Rental(new Movie("Star Wars"), 3, RentalType.NEW_MOVIE_RENTAL));
        customer.addRental(new Rental(new Movie("Mission Impossible"), 4, RentalType.REGULAR_MOVIE_RENTAL));
        transaction.processTransaction();
        System.out.println(transaction.printTransactionAsXML());
    }

}