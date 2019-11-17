# MovieRental_StrategyPattern

DESIGN
We have created below three strategies for Movie Rental Project
§ Rental Pricing Strategy:
We have created this strategy to calculate rental pricing based on the rental
category (Regular Vs New Vs Children). Following are the classes to compute pricing
§ Rental Frequent Renter Points Strategy:
We have created this strategy to calculate frequent renter point based on the
rental category (Regular Vs New Vs Children) and based on the conditions mentioned below. Following are the classes to compute rental points
  Þ DefaultFrequentRentalPointsStrategy: For Regular & Children rental categories
Þ NewReleaseFrequentRentalPointsStrategy: For New Release Rental Category
Þ DoubleRegularRentalPointsStrategy: This strategy is for doubling renter points for below conditions
o The first new frequent rental point computation gives double regular points to any customer who is renting more than two types of categories
o The first new frequent rental point computation gives double regular points to any customer who is 18-22 and renting one or multiple new release movies.
§ Transaction Pricing Strategy:
We have created this strategy to apply promotions at the transaction level and calculate price accordingly.
 • PATTERNS IMPLEMENTED
We have implemented following patterns in this project
§ Factory pattern: This factory is implemented in below classes to provide
list of strategies to perform in Rental & Transaction classes
 Þ FrequentRentalStrategyFactory: This factory will provide list of strategies during calculation of frequent renter points for a given rental. In few scenarios, we will have multiple strategies based on scenario
  (Eg: NewReleaseFrequentRentalPointsStrategy & DoubleRegularRentalPointsStrategy)
 2
Þ FrequentRenterPointsTransactionStrategy: This strategy provides free rental if customer has more than 10 frequent renter points in a transaction
 § Singleton pattern: This pattern is implemented in all rental and transaction strategy classes to provide same instance during strategy execution
§ Strategy pattern: This pattern is implemented for calculation of rental price, frequent renter points and transaction amount

§ Composite pattern: We have implemented this pattern to execute multiple strategies during renter point calculation
Eg: Calculating regular rental points on rental along with doubling the renter points based on following conditions
o The first new frequent rental point computation gives double regular points to any customer who is renting more than two types of categories
o The first new frequent rental point computation gives double regular points to any customer who is 18-22 and renting one or multiple new release movies.
• TEST RESULTS Execute command:
java -cp $JAR_PATH edu.utd.movierental.MovieRentalApplication
Scenario 1: Testing Doubling Rental Points when customer rented more than two different categories <Customer>
<Name&Age> John Smith( Age: 25) </Name&Age> <Rentals>
<Rental>
<Movie> Toy Story </Movie>
<Rental_Category> CHILDREN_MOVIE_RENTAL </Rental_Category>
<Days_Rented> 1 </Days_Rented> <Renter_Points> 3 </Renter_Points> <Rental_Price> 1.5 </Rental_Price>
</Rental> <Rental>
<Movie> Star Wars </Movie>
<Rental_Category> NEW_MOVIE_RENTAL </Rental_Category> <Days_Rented> 3 </Days_Rented>
<Renter_Points> 2 </Renter_Points>
<Rental_Price> 9.0 </Rental_Price>
</Rental> <Rental>
<Movie> Mission Impossible </Movie>
<Rental_Category> REGULAR_MOVIE_RENTAL </Rental_Category>
<Days_Rented> 4 </Days_Rented> <Renter_Points> 1 </Renter_Points> <Rental_Price> 5.0 </Rental_Price>
</Rental> </Rentals>
3

4
<Transaction_Amount> 15.5 </Transaction_Amount> <Frequent_Renter_Points> 6 </Frequent_Renter_Points> </Customer>
Scenario 2: Testing Doubling Rental Points for first Rental when customer age is between 18-22 & Renting at least one new release movie
<Customer>
<Name&Age> Zack( Age: 20) </Name&Age> <Rentals>
<Rental>
<Movie> Toy Story </Movie>
<Rental_Category> CHILDREN_MOVIE_RENTAL </Rental_Category>
<Days_Rented> 1 </Days_Rented> <Renter_Points> 3 </Renter_Points> <Rental_Price> 1.5 </Rental_Price>
</Rental> <Rental>
<Movie> Star Wars </Movie>
<Rental_Category> NEW_MOVIE_RENTAL </Rental_Category> <Days_Rented> 3 </Days_Rented>
<Renter_Points> 2 </Renter_Points>
<Rental_Price> 9.0 </Rental_Price>
</Rental> </Rentals>
<Transaction_Amount> 10.5 </Transaction_Amount> <Frequent_Renter_Points> 5 </Frequent_Renter_Points> </Customer>
Scenario 3: (Scenario 1) & (Scenario 2) <Customer>
<Name&Age> Tom( Age: 21) </Name&Age> <Rentals>
<Rental>
<Movie> Toy Story </Movie>
<Rental_Category> CHILDREN_MOVIE_RENTAL </Rental_Category>
<Days_Rented> 1 </Days_Rented> <Renter_Points> 5 </Renter_Points> <Rental_Price> 1.5 </Rental_Price>
</Rental> <Rental>
<Movie> Star Wars </Movie>
<Rental_Category> NEW_MOVIE_RENTAL </Rental_Category> <Days_Rented> 3 </Days_Rented>
<Renter_Points> 2 </Renter_Points>

5
<Rental_Price> 9.0 </Rental_Price> </Rental>
<Rental>
<Movie> Mission Impossible </Movie> <Rental_Category> REGULAR_MOVIE_RENTAL
</Rental_Category>
<Days_Rented> 4 </Days_Rented>
<Renter_Points> 1 </Renter_Points>
<Rental_Price> 5.0 </Rental_Price> </Rental>
</Rentals>
<Transaction_Amount> 15.5 </Transaction_Amount> <Frequent_Renter_Points> 8 </Frequent_Renter_Points> </Customer>
Scenario 4: (Scenario 1) & (Scenario 2) & Testing Free rental when there are 10 or more frequent renter points
<Customer>
<Name&Age> Tom( Age: 21) </Name&Age> <Rentals>
<Rental>
<Movie> Toy Story </Movie>
<Rental_Category> CHILDREN_MOVIE_RENTAL </Rental_Category>
<Days_Rented> 1 </Days_Rented> <Renter_Points> 5 </Renter_Points> <Rental_Price> 0.0 </Rental_Price>
</Rental> <Rental>
<Movie> Frozen </Movie>
<Rental_Category> CHILDREN_MOVIE_RENTAL </Rental_Category>
<Days_Rented> 1 </Days_Rented> <Renter_Points> 1 </Renter_Points> <Rental_Price> 1.5 </Rental_Price>
</Rental> <Rental>
<Movie> Star Wars </Movie>
<Rental_Category> NEW_MOVIE_RENTAL </Rental_Category> <Days_Rented> 3 </Days_Rented>
<Renter_Points> 2 </Renter_Points>
<Rental_Price> 9.0 </Rental_Price>
</Rental> <Rental>
<Movie> Avengers </Movie>
<Rental_Category> NEW_MOVIE_RENTAL </Rental_Category>

6
<Days_Rented> 1 </Days_Rented> <Renter_Points> 1 </Renter_Points> <Rental_Price> 3.0 </Rental_Price>
</Rental> <Rental>
<Movie> Mission Impossible </Movie>
<Rental_Category> REGULAR_MOVIE_RENTAL </Rental_Category>
<Days_Rented> 4 </Days_Rented> <Renter_Points> 1 </Renter_Points> <Rental_Price> 5.0 </Rental_Price>
</Rental> </Rentals>
<Transaction_Amount> 18.5 </Transaction_Amount> <Frequent_Renter_Points> 10 </Frequent_Renter_Points> </Customer>
