
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE



package passengers;

import interfaces.*;
import locations.Location;

/**
 * Represents a discounted passenger in a simulation of a transportation
 * system. Extends the Passenger class.
 * 
 * @author Aziza Mankenova
 *
 */
public class DiscountedPassenger extends Passenger implements ownCar, usePublicTransport {
	/**
	 * the percentage of discount on the bus
	 */
	private final static double busDiscount = 0.5;
	/**
	 * the percentage of discount on the train
	 */
	private final static double trainDiscount = 0.8;
	
	/**
	 * Constructs a discounted passenger. The ID, hasDriversLicense and a location are
	 * given in the parameters. Calls a constructor of the superclass with the
	 * given parameters.
	 * 
	 * @param ID passenger's ID
	 * @param hasDriversLicense whether or not a passenger has driving license
	 * @param l the Location
	 */
	public DiscountedPassenger(int ID, boolean hasDriversLicense, Location l) {
		super(ID, hasDriversLicense, l );
	}
	/**
	 * Constructs a discounted passenger. The ID, a location and fuel consumption
	 * rate of the car are given in the parameters. Calls the constructor of the
	 * superclass with the given parameters. 
	 * 
	 * @param ID passenger's ID
	 * @param l the location 
	 * @param fuelConsumption the fuel consumption rate of the car
	 */
	public DiscountedPassenger(int ID, Location l, double fuelConsumption) {
		super(ID, l, fuelConsumption);
	}
		
	/**
	 * Overrides the superclass method, gives the percent of discount on the bus for this passenger
	 * @return the discount for the bus
	 */
	public double busDiscount() {
		return busDiscount;
	}
	/**
	 * Overrides the superclass method, gives the percent of discount on the train for this passenger
	 * @return the discount for the train
	 */
	public double trainDiscount() {
		return trainDiscount;
	}
	
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

