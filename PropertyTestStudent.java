import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyTestStudent {
    private Property propertyOne, propertyTwo;

    @BeforeEach
    public void setUp() {
        propertyOne = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank");
        propertyTwo = new Property("Property XYZ", "Bethesda", 3100.00, "Chase Bank", 2, 2, 5, 5);
    }

    @AfterEach
    public void tearDown() {
        propertyOne = propertyTwo = null;
    }

    @Test
    public void testConstructor() {
        assertEquals("Property ABC", propertyOne.getPropertyName());
        assertEquals("Rockville", propertyOne.getCity());
        assertEquals(2450.00, propertyOne.getRentAmount());
        assertEquals("Wells Fargo Bank", propertyOne.getOwner());
    }

    @Test
    public void testGetPlot() {
        assertEquals(0, propertyOne.getPlot().getX());
        assertEquals(2, propertyTwo.getPlot().getX());
    }

    @Test
    public void testToString() {
        assertEquals("Property ABC,Rockville,Wells Fargo Bank,2450.0", propertyOne.toString());
    }
}
