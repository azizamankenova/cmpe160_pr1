
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE


package vehicles;

public class Train extends PublicTransport{
	
	/**
	 * Constructs a train. The ID, x and y-coordinates of two points are
	 * given in the parameters. Calls a constructor of the superclass with the
	 * given parameters.
	 * 
	 * @param ID the ID of this bus
	 * @param x1 the x-coordinate of the first point
	 * @param y1 the y-coordinate of the first point
	 * @param x2 the x-coordinate of the second point
	 * @param y2 the y-coordinate of the second point
	 * 
	 */
	public Train(int ID, double x1, double y1, double x2, double y2 ) {
		super(ID, x1, y1, x2, y2);
		
	}
	
	/**
	 * Gets the price of train ride. Train charges per stop. If the distance
	 * traveled is less than the half distance between two stops, nothing is 
	 * charged, otherwise it rounds up the number of stops and multiplies it
	 * by 5(cost of traveling one stop)
	 * 
	 * @param distance the distance to travel by train
	 * @return price for the train ride
	 */
	public static double getPrice(double distance) {
		if(distance<7.5) {
			return 0;
		}
		else {
			return 5 * Math.round(distance/15);
		}
	} 
	
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

