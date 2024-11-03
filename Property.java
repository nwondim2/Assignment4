
public class Property {
	
	// Attributes
	private String propertyName;
	private String city;
	private double rent;
	private String owner;
	private Plot plot;
	
	// Constructors
	public Property() {
        this.propertyName = "";
        this.city = "";
        this.rent = 0.0;
        this.owner = "";
        this.plot = new Plot();
    }
	
	public Property(String propertyName, String city, double rent, String owner){
		this.setPropertyName(propertyName);
		this.setCity(city);
		this.setRentAmount(rent);
		this.setOwner(owner);
		this.plot = new Plot();
	}
	
	// Copier
	public Property(Property otherProperty) {
		this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rent = otherProperty.rent;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot);
	}
	
	public Property(String propertyName, String city, double rent, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
        this.city = city;
        this.rent = rent;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
	}
	
	// Getters and Setters
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRentAmount() {
		return rent;
	}

	public void setRentAmount(double rent) {
		this.rent = rent;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	// Methods
	@Override
	public String toString() {
		return propertyName + "," + city + "," + owner + "," + rent;
	}
}
