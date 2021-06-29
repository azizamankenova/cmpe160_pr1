
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE


package locations;

import java.util.*;
import passengers.*;

/**
 * Represents a location in a simulation of a transportation system. A location has
 * 5 fields: its ID, x and y-coordinates, and lists of all previous and current
 * passengers.
 * 
 * 
 * @author Aziza Mankenova
 *
 */
public class Location {
	/**
	 * ID of the location
	 */
	private int ID;
	/**
	 * x-coordinate of the location
	 */
	private double locationX;
	/**
	 * y-coordinate of the location
	 */
	private double locationY;
	/**
	 * An ArrayList of all the previous passengers in this location, keeps track of every passenger who has visited
	 */
	private ArrayList<Passenger> history; 
	/**
	 * An ArrayList of all the current passengers in this location, keeps track of the passengers currently here
	 */
	private ArrayList<Passenger> current;

	/**
	 * Constructs a new Location. The ID, x and y-coordinates are given in the
	 * parameters. It instantiates the history and current ArrayLists of passengers.
	 * 
	 * @param ID        the ID of the location
	 * @param locationX x-coordinate of the location
	 * @param locationY y-coordinate of the location
	 */
	public Location(int ID, double locationX, double locationY) {
		this.setID(ID);
		this.setLocationX(locationX);
		this.setLocationY(locationY);
		this.history = new ArrayList<Passenger>();
		this.current = new ArrayList<Passenger>();

	}

	/**
	 * Gets the ID
	 * 
	 * @return the ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Sets the ID
	 * 
	 * @param ID the ID to set
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

	/**
	 * Gets the x-coordinate of this location
	 * 
	 * @return the x-coordinate
	 */

	public double getLocationX() {
		return locationX;
	}

	/**
	 * Sets the x-coordinate of this location
	 * 
	 * @param locationX the x-coordinate to set
	 */
	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}

	/**
	 * Gets the y-coordinate of this location
	 * 
	 * @return the y-coordinate
	 */

	public double getLocationY() {
		return locationY;
	}

	/**
	 * Sets the x-coordinate of this location
	 * 
	 * @param locationY the y-coordinate to set
	 */
	public void setLocationY(double locationY) {
		this.locationY = locationY;
	}

	/**
	 * Calculates the distance between this location and the other location
	 * 
	 * @param other another Location
	 * @return the distance between two locations(points)
	 */
	public double getDistance(Location other) {
		double x = this.locationX - other.getLocationX();
		double y = this.locationY - other.getLocationY();
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * Adds a passenger into the current ArrayList and into the history, if it does
	 * not contain it already.
	 * 
	 * @param p an incoming passenger
	 */
	public void incomingPassenger(Passenger p) {
		if(!getCurrent().contains(p)) {
			getCurrent().add(p);
		}
		if (!getHistory().contains(p)) {
			getHistory().add(p);
		}
	}

	/**
	 * Removes a passenger from the current ArrayList
	 * 
	 * @param p an outgoing passenger
	 */
	public void outgoingPassenger(Passenger p) {

		getCurrent().remove(p);
	}

	/**
	 * Gets the current list of passengers as an ArrayList
	 * 
	 * @return the current ArrayList
	 */
	public ArrayList<Passenger> getCurrent() {
		return current;
	}

	/**
	 * Gets the history list of passengers as an ArrayList
	 * 
	 * @return the history ArrayList
	 */
	
	public ArrayList<Passenger> getHistory() {
		return history;
	}

}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
