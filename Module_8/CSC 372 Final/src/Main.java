import java.io.*;
import java.util.*;


public class Main {
//Creating logic to print information to a .txt file 
	public static void main(String[]args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		int nVehicles;
		System.out.println("Enter the number of vehicles to compare: "); //number of vehicles to compare
		input = br.readLine();
		while(!isInteger(input))
		{
			System.out.println("Enter the number of vehicles to compare: ");
			input = br.readLine();
		}
		nVehicles = Integer.parseInt(input);
		LinkedList<Vehicle> vehicles = new LinkedList<>();
		String make, model;
		double OD, milesDriven, galFilled;
		double mpg = 0;
		System.out.println();
		for(int i = 0; i < nVehicles; i++)
		{
			System.out.println("Vehicle " + (i + 1) + ": ");
			System.out.print("Enter the make: ");
			make = br.readLine().trim();

			System.out.print("Enter the model : ");
			model = br.readLine().trim();
		
			OD = Double.parseDouble(input); 
			System.out.print("Enter the odometer reading: ");
			input = br.readLine();
			while(!isDouble(input))
			{
				System.out.print("Enter odometer reading: ");
				input = br.readLine();
			}
			OD = Double.parseDouble(input);
			
			milesDriven = Double.parseDouble(input);
			System.out.print("Enter miles driven on tank: ");
			input = br.readLine();
			while(!isDouble(input))
			{
				System.out.print("Enter miles driven on tank: ");
				input = br.readLine();
			}
			milesDriven = Double.parseDouble(input);

			galFilled = Double.parseDouble(input);
			System.out.print("Enter the amount of fuel filled: ");
			input = br.readLine();
			while(!isDouble(input))
			{
				System.out.print("Enter the amount of fuel filled: ");
				input = br.readLine();
			}
			galFilled = Double.parseDouble(input);

			
			Vehicle vehicle = new Vehicle(make, model, mpg, OD, milesDriven, galFilled);
			vehicles.add(vehicle);
			System.out.println();
		}

		// sort the linked list in ascending order based on miles per gallon
		Collections.sort(vehicles);

		// writing all vehicle details to a file
		System.out.println("Enter a name to be printed to a .txt file");
		String fileName = br.readLine().trim();

		FileWriter fw = new FileWriter(fileName + ".txt");
		for(Vehicle vehicle : vehicles)
		{
			fw.write(vehicle.toString() + System.lineSeparator());
		}
		fw.close();
		System.out.println("Vehicle data has been successfully written to the file: " + fileName);
	}

	public static boolean isInteger(String s)
	{
		try
		{
			Integer.parseInt(s);
			return true;
		}catch(NumberFormatException e){
			System.out.println(s + " Please enter a number.");
			return false;
		}
	}

	public static boolean isDouble(String s)
	{
		try
		{
			Double.parseDouble(s);
			return true;
		}catch(NumberFormatException e){
			System.out.println(s + " is not a valid double.");
			return false;
		}
	}
}