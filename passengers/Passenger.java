
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package passengers;


import interfaces.*;
import locations.*;
import vehicles.*;
/**
 * Represents a Passenger in a simulation of a transportation
 * system. It implements ownCar and usePublicTransport interfaces.
 * 
 * @author Aziza Mankenova
 */
public class Passenger implements ownCar, usePublicTransport{
	/**
	 * the ID of the passenger
	 */
	protected int ID;
	/**
	 * whether a passenger has the driving license or not
	 */
	protected boolean hasDriversLicense;
	/**
	 * balance of the passenger’s travel card balance
	 */
	protected double cardBalance;
	/**
	 * car that belongs to a passenger
	 */
	protected Car car;
	/**
	 * current location of the passenger
	 */
	protected Location currentLocation;

	
	/**
	 * Constructs a new passenger. The ID, hasDriversLicense and a location are
	 * given in the parameters. Records a passenger as an incoming passenger 
	 * for the location.
	 * 
	 * @param ID passenger's ID
	 * @param hasDriversLicense whether or not a passenger has driving license
	 * @param l the Location
	 */
	public Passenger(int ID, boolean hasDriversLicense, Location l) {
		this.setID(ID);
		this.setHasDriversLicense(hasDriversLicense);
		this.setCurrentLocation(l);
		this.currentLocation.incomingPassenger(this);
	
	}
	
	/**
	 * Constructs a new passenger. The ID, a location and fuel consumption
	 * rate of the car are given in the parameters. Sets hasDriversLicense 
	 * as true. Records a passenger as an incoming passenger for the location.
	 * Instantiates a car with a passenger's ID and fuel consumption rate. 
	 * 
	 * @param ID passenger's ID
	 * @param l the location
	 * @param fuelConsumption fuel consumption rate of the car
	 */
	public Passenger(int ID, Location l, double fuelConsumption) {
		this.setID(ID);
		this.setHasDriversLicense(true);
		this.setCurrentLocation(l);
		car = new Car(ID, fuelConsumption);
		this.currentLocation.incomingPassenger(this);
		
		 
	}
	
	
	
	/**
	 * Checks if this passenger can ride the given public transport to the 
	 * desirable location and then let the passenger ride it. If the 
	 * public transport can move between the current location and the 
	 * final location and the card balance is enough to ride the specific 
	 * public transport, then the passenger can travel from current location 
	 * to the final and the current location is updated
	 * 
	 */
	public void ride(PublicTransport p, Location l) {
		if(p.canRide(currentLocation, l)) {
			if(p instanceof Bus && this.cardBalance >= Bus.getPrice()*busDiscount() ){
				this.cardBalance = this.cardBalance - Bus.getPrice()*busDiscount();
				this.currentLocation.outgoingPassenger(this);
				l.incomingPassenger(this);
				this.currentLocation = l;
				
			}
			else if(p instanceof Train && this.cardBalance >= trainDiscount()*Train.getPrice(currentLocation.getDistance(l))){
				this.cardBalance = this.cardBalance - trainDiscount()*Train.getPrice(currentLocation.getDistance(l));
				this.currentLocation.outgoingPassenger(this);
				l.incomingPassenger(this);
				this.currentLocation = l;
				
			}
		}
		 
	}
	
	
	/**
	 * Checks if this passenger can drive form one location to
	 * another and then let the passenger travel. If the 
	 * passenger owns a car and the fuel amount is enough to drive to
	 * the specific location, then the passenger can travel from current location 
	 * to the final and the current location is updated
	 */
	public void drive(Location l) {
		if(this.isHasDriversLicense() && this.car != null && car.getFuelAmount() >= car.getFuelConsumption()*currentLocation.getDistance(l)) {
			this.currentLocation.outgoingPassenger(this);
			l.incomingPassenger(this);
			car.setFuelAmount(car.getFuelAmount() - car.getFuelConsumption()*currentLocation.getDistance(l));
			this.currentLocation = l;
			
		}
		
	}
	/**
	 * Gives the percent of discount on the bus for this passenger
	 * 
	 * @return the busDiscount
	 */
	public double busDiscount() {
		return 1;
	}
	/**
	 * Gives the percent of discount on the train for this passenger
	 * 
	 * @return the train discount
	 */
	public double trainDiscount() {
		return 1;
	}
	
	/**
	 * Refuels the car. The amount  is given as the parameter.
	 * 
	 * @param amount the amount to be refueled
	 */
	public void refuel(double amount) {
		this.car.refuel(amount);
	}
	
	/**
	 * Purchases a car for this passenger. The fuel consumption rate of a 
	 * new car is given as the parameter. The hasDriversLicense
	 * is set as true.
	 * 
	 * @param fuelConsumption the The fuel consumption rate of the car
	 */
	public void purchaseCar(double fuelConsumption) {
		car = new Car(this.ID, fuelConsumption);
		this.hasDriversLicense = true;
	}
	
	/**
	 * Refills a card of this passenger. The amount to be added
	 * is given as a parameter.
	 * 
	 * @param amount the amount to be refilled 
	 */
	public void refillCard(double amount) {
		this.cardBalance = this.cardBalance + amount;
	}

	/**
	 * Gets the ID of the passenger
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Sets the ID of the passenger
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Tells if this passenger has a driving license or not
	 * @return the hasDriversLicense
	 */
	public boolean isHasDriversLicense() {
		return hasDriversLicense;
	}

	/**
	 * Sets the driving license of this passenger
	 * @param hasDriversLicense the hasDriversLicense to set
	 */
	public void setHasDriversLicense(boolean hasDriversLicense) {
		this.hasDriversLicense = hasDriversLicense;
	}

	/**
	 * Gets the cards balance of this passenger
	 * @return the cardBalance
	 */
	public double getCardBalance() {
		return cardBalance;
	}

	/**
	 * Sets the card balance of this passenger
	 * @param cardBalance the cardBalance to set
	 */
	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}

	/**
	 * Gets the car of this passenger
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * Sets the car of this passenger
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}

	/**
	 * Get the current location of this passenger
	 * @return the currentLocation
	 */
	public Location getCurrentLocation() {
		return currentLocation;
	}

	/**
	 * Sets the current location of this passenger 
	 * @param currentLocation the currentLocation to set
	 */
	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	
		
}
	




//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

