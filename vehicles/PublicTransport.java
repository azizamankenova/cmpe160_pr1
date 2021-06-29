
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE



package vehicles;

import locations.Location;

/**
 * Represents a Public Transport a simulation of a transportation system.
 * 
 * @author Aziza Mankenova
 *
 */
public abstract class PublicTransport {

	/**
	 * the ID of this Public Transport
	 */
	protected int ID;

	/**
	 * the x-coordinate of one corner of the rectangle, which is the operating range
	 * of the transport
	 * 
	 */
	protected double x1;

	/**
	 * the y-coordinate of one corner of the rectangle, which is the operating range
	 * of the transport
	 */
	protected double y1;

	/**
	 * the x-coordinate of the second corner of the rectangle, which is the
	 * operating range of the transport
	 */
	protected double x2;

	/**
	 * the y-coordinate of the second corner of the rectangle, which is the
	 * operating range of the transport
	 */
	protected double y2;

	/**
	 * case, which determines which coordinate is given first and second
	 */
	protected int caseNo;

	/**
	 * Constructs some public transport. The ID, x and y-coordinates of two points
	 * are given in the parameters. Sets the case number according to the points
	 * given and their order
	 * 
	 * @param ID the ID of this bus
	 * @param x1 the x-coordinate of the first point
	 * @param y1 the y-coordinate of the first point
	 * @param x2 the x-coordinate of the second point
	 * @param y2 the y-coordinate of the second point
	 */
	public PublicTransport(int ID, double x1, double y1, double x2, double y2) {
		this.setID(ID);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		if (x1 == Math.min(x1, x2) && y1 == Math.min(y1, y2)) {
			caseNo = 1;
		} else if (x1 == Math.min(x1, x2) && y1 == Math.max(y1, y2)) {
			caseNo = 2;
		} else if (x1 == Math.max(x1, x2) && y1 == Math.max(y1, y2)) {
			caseNo = 3;
		} else {
			caseNo = 4;
		}
	}

	/**
	 * Determines if this vehicle can ride from one location to the other. Checks if
	 * both points are within the operating range of the vehicle
	 * 
	 * @param departure the location of departure
	 * @param arrival   the desirable location
	 * @return true,if it can ride and false, if it cannot
	 */
	public boolean canRide(Location departure, Location arrival) {
		if (caseNo == 1) {
			if (departure.getLocationX() >= this.x1 && departure.getLocationX() <= this.x2
					&& departure.getLocationY() >= this.y1 && departure.getLocationY() <= this.y2
					&& arrival.getLocationX() >= this.x1 && arrival.getLocationX() <= this.x2
					&& arrival.getLocationY() >= this.y1 && arrival.getLocationY() <= this.y2) {
				return true;
			} else {
				return false;
			}
		} else if (caseNo == 2) {
			if (departure.getLocationX() >= this.x1 && departure.getLocationX() <= this.x2
					&& departure.getLocationY() <= this.y1 && departure.getLocationY() >= this.y2
					&& arrival.getLocationX() >= this.x1 && arrival.getLocationX() <= this.x2
					&& arrival.getLocationY() <= this.y1 && arrival.getLocationY() >= this.y2) {
				return true;
			} else {
				return false;
			}
		} else if (caseNo == 3) {
			if (departure.getLocationX() <= this.x1 && departure.getLocationX() >= this.x2
					&& departure.getLocationY() <= this.y1 && departure.getLocationY() >= this.y2
					&& arrival.getLocationX() <= this.x1 && arrival.getLocationX() >= this.x2
					&& arrival.getLocationY() <= this.y1 && arrival.getLocationY() >= this.y2) {
				return true;
			} else {
				return false;
			}
		} else {
			if (departure.getLocationX() <= this.x1 && departure.getLocationX() >= this.x2
					&& departure.getLocationY() >= this.y1 && departure.getLocationY() <= this.y2
					&& arrival.getLocationX() <= this.x1 && arrival.getLocationX() >= this.x2
					&& arrival.getLocationY() >= this.y1 && arrival.getLocationY() <= this.y2) {
				return true;
			} else {
				return false;
			}
		}

	}

	/**
	 * Gets the ID of the vehicle
	 * 
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Sets the ID of the vehicle
	 * 
	 * @param ID the ID to set
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
