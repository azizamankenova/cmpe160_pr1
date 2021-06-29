
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE


package vehicles;


/**
 * Represents a Car in a simulation of a transportation
 * system.
 * 
 * @author Aziza Mankenova
 *
 */

public class Car{
	 /**
	 * the ID of the owner of the car
	 */
	private int ownerID;
	
	 /**
	 * the fuel amount of the car
	 */
	private double fuelAmount;
	
	 /**
	 * the fuel consumption rate of the car
	 */
	private double fuelConsumption;
	
	 /**
	 * Constructs a new car given two parameters, the ID of the owner 
	 * and the fuel consumption rate
	 * 
	 * @param ID              the ID of the owner of this car
	 * @param fuelConsumption the fuel consumption rate of this car
	 */
	public Car(int ID, double fuelConsumption) {
		  this.ownerID = ID;
		  this.setFuelConsumption(fuelConsumption);
		  this.setFuelAmount(0);
	 }
	
	
	 /**
	 * Refuels this car by the specific amount
	 * 
	 * @param amount the amount to refuel
	 */
	public void refuel(double amount) {
		 this.setFuelAmount(this.getFuelAmount() + amount);
	 }
	 
	 
	/**
	 * Gets the fuel consumption rate of this car
	 * 
	 * @return the fuel consumption rate
	 */
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	/**
	 * Sets the fuel consumption rate of this car
	 * 
	 * @param fuelConsumption the fuel consumption rate to set
	 */
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	/**
	 * Gets the owner ID of this car
	 * @return the owner ID
	 */
	  public int getOwnerID() { 
		  return ownerID; 
	  }
	 
	/**
	 * Sets the owner ID of this car
	 * @param ownerID the ownerID to set
	 */
	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}
	/**
	 * Gets the fuel amount of this car
	 * @return the fuelAmount
	 */
	public double getFuelAmount() {
		return fuelAmount;
	}
	/**
	 * Sets the fuel amount of this car
	 * @param fuelAmount the fuelAmount to set
	 */
	public void setFuelAmount(double fuelAmount) {
		this.fuelAmount = fuelAmount;
	}
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

