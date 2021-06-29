
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package main;

import java.util.*;
import vehicles.*;
import java.io.*;
import passengers.*;
import locations.*;

/**
 * Implements a simulation of a transportation system. The main 
 * objective is to analyze the incoming requests provided as a 
 * list of input in a txt file. Program carries out the necessary actions by
 * parsing the input file composed of the sequential traveling operations.
 * <p>
 * The main method reads an input file that is composed of sequential
 * commands related to the travel operations. It prints the passengers 
 * in the locations list in the main class with their attributes in 
 * another txt file. 
 * Main method creates 3 array lists called passengers, vehicles and locations.
 * The first location is created in (0,0) coordinates and added to locations, 
 * where the passengers always start at.
 * 
 * 
 * @author Aziza Mankenova
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {


		Scanner input = new Scanner(new File(args[0]));
		PrintStream output = new PrintStream(new File(args[1]));

		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		ArrayList<Location> locations = new ArrayList<Location>();
		ArrayList<PublicTransport> vehicles = new ArrayList<PublicTransport>();

		// Uncomment the lines below after implementing the Location class

		Location l = new Location(0, 0, 0); 
		locations.add(l);

		int operations = input.nextInt(); // operation count
		input.nextLine();
		int passengerID = -1;
		int locationID = 0;
		int vehiclesID = -1;

		for (int i = 0; i < operations; i++) {
			int action = input.nextInt();
			if (action == 1) {		// creating a passenger
				passengerID++;
				String passengerType;
				boolean hasDriversLicense;
				boolean hasCar;
				double fuelConsumption;

				passengerType = input.next();
				if (input.nextInt() == 1) {
					hasDriversLicense = true;
				} else {
					hasDriversLicense = false;
				}
				if (input.nextInt() == 0) {
					hasCar = false;
				} else {
					hasCar = true;

				}
				if (passengerType.equals("D")) {
					if (hasCar) {
						fuelConsumption = input.nextDouble();
						passengers.add(new DiscountedPassenger(passengerID, l, fuelConsumption));

					} else {
						passengers.add(new DiscountedPassenger(passengerID, hasDriversLicense, l));
					}
				} else {
					if (hasCar) {
						fuelConsumption = input.nextDouble();
						passengers.add(new StandardPassenger(passengerID, l, fuelConsumption));
					} else {
						passengers.add(new StandardPassenger(passengerID, hasDriversLicense, l));
					}
				}
			
			} else if (action == 2) { // creating a location
				locationID++;
				double x = input.nextDouble();
				double y = input.nextDouble();
				locations.add(new Location(locationID, x, y));
			}

			else if (action == 3) {// creating a public transport vehicle

				int type = input.nextInt();
				double x1 = input.nextDouble();
				double y1 = input.nextDouble();
				double x2 = input.nextDouble();
				double y2 = input.nextDouble();
				vehiclesID++;

				if (type == 1) {// 1 being the bus
					vehicles.add(new Bus(vehiclesID, x1, y1, x2, y2));
				} 
				else if(type == 2){// 2 being the Train
					vehicles.add(new Train(vehiclesID, x1, y1, x2, y2));
				}
			}

			else if (action == 4) {// passenger travels to a location
				int passID = input.nextInt();
				int passengerIndex = -1;
				int locID = input.nextInt();
				int locationIndex = 0;
				int vehicleIndex = -1;
				int transpType = input.nextInt();
				
				passengerIndex = getPassengerIndex(passengers,passID);
				
				for (int j = 0; j < locations.size(); j++) {
					if (locations.get(j).getID() == locID) {
						locationIndex = j;
						break;

					}
				}
				Location loc = locations.get(locationIndex);
				
				

				if (transpType == 3) {
					passengers.get(passengerIndex).drive(loc);
					
				} else {
					int vehicleID = input.nextInt();
					for (int j = 0; j < vehicles.size(); j++) {
						if (vehicles.get(j).getID() == vehicleID) {
							vehicleIndex = j;
							break;
						}
					}
					if (transpType == 1) {
						if (vehicles.get(vehicleIndex) instanceof Bus) {
							passengers.get(passengerIndex).ride(vehicles.get(vehicleIndex), loc);
						}
					} else {
						if (vehicles.get(vehicleIndex) instanceof Train) {
							passengers.get(passengerIndex).ride(vehicles.get(vehicleIndex), loc);
						}
					}
					
					
				}
				
		
			} else if (action == 5) {// passenger purchases a car
				int passID = input.nextInt();
				int passIndex = -1;
				double fuelConsumption = input.nextDouble();

				passIndex = getPassengerIndex(passengers, passID);
				

				passengers.get(passIndex).purchaseCar(fuelConsumption);

			} else if (action == 6) {// passenger refuels their car

				int passID = input.nextInt();
				int passIndex = -1;
				double fuelAmount = input.nextDouble();

				passIndex = getPassengerIndex(passengers, passID);
				
				if(passengers.get(passIndex).getCar() != null) {
					passengers.get(passIndex).refuel(fuelAmount);
				}
			}

			else if (action == 7) {// passengers refill their travel card

				int passID = input.nextInt();
				int passIndex = -1;
				double amount = input.nextDouble();

				passIndex = getPassengerIndex(passengers, passID);
				
				passengers.get(passIndex).refillCard(amount);
			}
		}

		input.close();

		

		for (int i = 0; i < locations.size(); i++) {
			
			String x = decimalString(locations.get(i).getLocationX());
			String y = decimalString(locations.get(i).getLocationY());
			
			output.printf("Location " + i + ": (" + x + ", " + y + ")\n");

			ArrayList<Passenger> current = locations.get(i).getCurrent();
			sorting(current);
			
			for (int j = 0; j < current.size(); j++) {
				output.print("Passenger " + current.get(j).getID() + ": ");
				if (current.get(j).getCar() != null) {
					output.printf(decimalString(current.get(j).getCar().getFuelAmount()));
				} else {
					output.printf(decimalString(current.get(j).getCardBalance()));
				}
				if(i == locations.size()-1 && j == current.size()-1) {
					output.print("");
				}
				else {
					output.print("\n");
				}
			}
			

		}
		


	}
	
	
	/**
	 * Converts a double value into a String with only two digits after the 
	 * decimal point.
	 * 
	 * @param a the double value that should be converted
	 * @return a number with only 2 digits after the decimal point
	 */
	public static String decimalString(double a) {
		String number = Double.toString(a);
		String result = number.substring(0, number.indexOf(".")+1);
		String temp = number.substring(number.indexOf("."));
		
		if(temp.length() == 2) {
			result = result + temp.charAt(1) + "0";
		}
		else if(temp.length() >= 3) {
			result = result + temp.substring(1,3);
		}
		return result;
	}
	

	/**
	 * Sorts passengers ArrayList in the ascending order of their ID
	 * @param passengers list of passengers to be sorted
	 */
	public static void sorting(ArrayList<Passenger> passengers) {
		boolean swapped = true;
		Passenger temp;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < passengers.size() - 1; i++) {
				int IDprevious = passengers.get(i).getID();
				int IDnext = passengers.get(i + 1).getID();
				if (IDprevious > IDnext) {
					temp = passengers.get(i);
					passengers.set(i, passengers.get(i + 1));
					passengers.set(i + 1, temp);
					swapped = true;
				}
			}
		}

	}

	
	 /**
	 * Gets index in the ArrayList of the desired passenger with the specified ID
	 * 
	 * @param passengers list of all the passengers
	 * @param ID         the ID of of the passenger
	 * @return the index in the of the passenger with specified ID
	 */
	public static int getPassengerIndex(ArrayList<Passenger> passengers, int ID){ 
		 int index = -1;
		 for(int i=0; i<passengers.size(); i++) { 
			 if(passengers.get(i).getID() == ID) { 
				 index = i; 
				 break; 
				 } 
			 } 
		 return index;
	 }
	  
	 
}




//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

