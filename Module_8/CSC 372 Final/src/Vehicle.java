
public class Vehicle implements Comparable<Vehicle>{
	private String make, model;
	private double mpg, milesDriven, galFilled, OD;

	public Vehicle()
	{
		this.make = "";
		this.model = "";
		this.mpg = 0;
		this.milesDriven = 0;
		this.galFilled = 0;
		this.OD = 0;
		
	}

	public Vehicle(String make, String model, double mpg, double OD, double milesDriven, double galFilled)

	{
		this.make = make;
		this.model = model;
		this.milesDriven = milesDriven;
		this.galFilled = galFilled;
		this.OD = OD;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public double getMPG() {
		mpg = milesDriven/galFilled; // calculation for MPG
		return mpg;
	}
	
	public double getMilesDriven() {
		return milesDriven;
	}
	
	public double getGalFilled() {
		return galFilled;
	}
	
	public double getOD() {
		return OD;
	}
	
	
	

	//@Override
	public int compareTo(Vehicle o) { //sorts mpg in ascending order
		int comp = (int)o.getMPG();
		if(this.mpg > comp)
			return 1;
		else if(this.mpg == comp)
			return 0;
		else
			return -1;
	}

	@Override
	public String toString()
	{
		System.out.println();
			return("Make: " + getMake() + ", Model: " + getModel() + ", MPG: " + getMPG() + " Odometer Reading: " + getOD() 
		+ " mi");
	}

}
