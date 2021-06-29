
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;

/**
 * Represents a Bus in a simulation of a transportation
 * system, extending the class of Public Transport.
 * 
 * @author Aziza Mankenova
 *
 */
public class Bus extends PublicTransport{
	
	/**
	 * Constructs a bus. The ID, x and y-coordinates of two points are
	 * given in the parameters. Calls a constructor of the superclass with the
	 * given parameters.
	 * 
	 * @param ID the ID of this bus
	 * @param x1 the x-coordinate of the first point
	 * @param y1 the y-coordinate of the first point
	 * @param x2 the x-coordinate of the second point
	 * @param y2 the y-coordinate of the second point
	 */
	public Bus(int ID, double x1, double y1, double x2, double y2 ) {
		super(ID, x1, y1, x2, y2);
		
	}
	
	/**
	 * Gets price of traveling on the bus
	 * @return the price of the bus ride
	 */
	public static double getPrice() {
		return 2;
		
	}
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

