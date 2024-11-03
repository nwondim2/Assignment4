import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagementCompanyTestStudent {
    private ManagementCompany managementCo;
    private Property propertyOne, propertyTwo;

    @BeforeEach
    public void setUp() {
        managementCo = new ManagementCompany("Railey", "555555555", 6);
        propertyOne = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson", 2, 5, 2, 2);
        propertyTwo = new Property("Sunny Apartments", "Bethesda", 1500.0, "Jane Doe", 3, 6, 3, 3);
    }

    @AfterEach
    public void tearDown() {
        managementCo = null;
        propertyOne = propertyTwo = null;
    }

    @Test
    public void testAddProperty() {
        propertyOne = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson", 2, 5, 2, 2);
        propertyTwo = new Property("Sunny Apartments", "Bethesda", 1500.0, "Jane Doe", 6, 6, 2, 2);
        
        assertEquals(0, managementCo.addProperty(propertyOne));
        assertEquals(1, managementCo.addProperty(propertyTwo));
    }


    @Test
    public void testGetPropertiesCount() {
    	propertyOne = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson", 2, 5, 2, 2);
        propertyTwo = new Property("Sunny Apartments", "Bethesda", 1500.0, "Jane Doe", 6, 6, 2, 2);
    	
        managementCo.addProperty(propertyOne);
        assertEquals(1, managementCo.getPropertiesCount());
        managementCo.addProperty(propertyTwo);
        assertEquals(2, managementCo.getPropertiesCount());
    }

    @Test
    public void testToString() {
        managementCo.addProperty(propertyOne);
        String expectedString = "List of the properties for Railey, taxID: 555555555\n" +
                                "______________________________________________________\n" +
                                "Sunsational,Beckman,BillyBob Wilson,2613.0\n" +
                                "______________________________________________________\n" +
                                "\n" +
                                " total management Fee: 156.78";
        assertEquals(expectedString, managementCo.toString());
    }
}
