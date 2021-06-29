
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package passengers;

import interfaces.*;
import locations.Location;
/**
 * Represents a standard passenger in a simulation of a transportation
 * system. Extends the Passenger class.
 * 
 * @author Aziza Mankenova
 *
 */
public class StandardPassenger extends Passenger implements ownCar, usePublicTransport {
	/**
	 * Constructs a standard passenger. The ID, hasDriversLicense and a location are
	 * given in the parameters. Calls a constructor of the superclass with the
	 * given parameters.
	 * 
	 * @param ID passenger's ID
	 * @param hasDriversLicense whether or not a passenger has driving license
	 * @param l the Location
	 */

	public StandardPassenger(int ID, boolean hasDriversLicense, Location l) {
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
	public StandardPassenger(int ID, Location l, double fuelConsumption) {
		super(ID, l, fuelConsumption);
	}
	
	


}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

