public class ManagementCompany {
	
	// Attributes
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_DEPTH = 10;
	public static final int MGMT_WIDTH = 10;
	
    private String name;
    private String taxId;
    private double managementFeePercentage;
    private Property[] properties;
    private int numberOfProperties;
    private Plot plot;

    // Constructors
    public ManagementCompany() {
        this.name = "";
        this.taxId = "";
        this.managementFeePercentage = 0;
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }
    
    public ManagementCompany(String name, String taxId, double managementFeePercentage) {
        this();
        this.name = name;
        this.taxId = taxId;
        this.managementFeePercentage = managementFeePercentage;
    }
    
    public ManagementCompany(String name, String taxId, double managementFeePercentage, int x, int y, int width, int depth) {
        this(name, taxId, managementFeePercentage);
        this.plot = new Plot(x, y, width, depth);
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.name, otherCompany.taxId, otherCompany.managementFeePercentage, otherCompany.plot.getX(), otherCompany.plot.getY(), otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
            this.addProperty(new Property(otherCompany.properties[i]));
        }
    }

    // Getters and Setters
    public int addProperty(String propertyName, String city, double rent, String owner) {
        return addProperty(new Property(propertyName, city, rent, owner));
    }

    public int addProperty(String propertyName, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(propertyName, city, rent, owner, x, y, width, depth));
    }

    public int addProperty(Property property) {
        if (property == null) {
            return -2;
        }
        if (isPropertiesFull()) {
            return -1;
        }
        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }
        properties[numberOfProperties++] = property;
        return numberOfProperties - 1;
    }
    
    public void removeLastProperty() {
    	if(numberOfProperties > 0) {
    		numberOfProperties--;
    		properties[numberOfProperties] = null;
    	}
    }
    
    public boolean isPropertiesFull() {
        return numberOfProperties >= properties.length;
    }

    public int getPropertiesCount() {
        return numberOfProperties;
    }

    public double getTotalRent() {
        double totalRent = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) {
            return null;
        }
        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    public boolean isManagementFeeValid() {
        return managementFeePercentage >= 0 && managementFeePercentage <= 100;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getTaxID() {
        return taxId;
    }

    public Property[] getProperties() {
        return properties;
    }

    
    public double getManagementFeePercentage() {
        return managementFeePercentage;
    }

    public Plot getPlot() {
        return plot;
    }

    
    @Override
    public String toString() {
    	String result = "List of the properties for " + name + ", taxID: " + taxId;
    	result += "\n______________________________________________________\n";
    	for(int i = 0; i < numberOfProperties; i++) {
    		result += "" + properties[i].toString() + "\n";
    	}
    	result += "______________________________________________________\n";
    	result += "\n total management Fee: " + (getTotalRent() * getManagementFeePercentage() / 100);
    	return result;
    }
}
